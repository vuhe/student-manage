<template>
  <div>
    <el-form :inline="true">
      <el-form-item>
        <el-input placeholder="查询序号" v-model="searchNum" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-radio-group v-model="searchType">
          <el-radio-button label="search_stu">按学号查</el-radio-button>
          <el-radio-button label="search_coz">按课程查</el-radio-button>
        </el-radio-group>
      </el-form-item>
      <el-form-item>
        <el-button @click="getData(1)">查询/刷新</el-button>
        <el-button v-if="isAdmin" type="warning" @click="addOrUpdateBtn = true">添加成绩</el-button>
      </el-form-item>
    </el-form>
    <el-table
      :data="list"
      border
      v-loading="false"
      style="width: 100%;">
      <el-table-column
        prop="id"
        header-align="center"
        align="center"
        width="100"
        label="编号">
      </el-table-column>
      <el-table-column
        prop="stuNum"
        header-align="center"
        align="center"
        label="学生学号"
        width="180">
      </el-table-column>
      <el-table-column
        prop="cozNum"
        header-align="center"
        align="center"
        label="课程号"
        width="180">
      </el-table-column>
      <el-table-column
        prop="cozName"
        header-align="center"
        align="center"
        label="课程名"
        width="180">
      </el-table-column>
      <el-table-column
        prop="score"
        header-align="center"
        align="center"
        width="150"
        label="成绩">
      </el-table-column>
      <el-table-column
        prop="retestScore"
        header-align="center"
        align="center"
        width="150"
        label="补考成绩">
      </el-table-column>
      <el-table-column
        v-if="isAdmin"
        fixed="right"
        header-align="center"
        align="center"
        width="150"
        label="操作">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="addOrUpdateHandle(scope.row.id)">修改</el-button>
          <el-button type="text" size="small" @click="deleteDate(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      :hide-on-single-page="false"
      @current-change="getData"
      :current-page="currentPage"
      :page-size="10"
      :total="total"
      layout="total, prev, pager, next">
    </el-pagination>

    <score-add-or-update :end-call="getData(1)"></score-add-or-update>
  </div>
</template>

<script>
import scoreAddOrUpdate from './scoreAddOrUpdate'

export default {
  name: 'score',
  data () {
    return {
      searchNum: '',
      searchType: 'search_stu',
      page: 0,
      pageSize: 1,
      total: 1,
      currentPage: 1,
      list: []
    }
  },
  created () {
    this.getData(1)
  },
  computed: {
    addOrUpdateBtn: {
      get () { return this.$store.state.common.scoreAddOrUpdateBtn },
      set (val) { this.$store.commit('common/updateScoreAddOrUpdateBtn', val) }
    },
    currId: {
      get () { return this.$store.state.common.currModifyId },
      set (val) { this.$store.commit('common/updateCurrModifyId', val) }
    },
    isAdmin: {
      get () { return this.$store.state.user.role === 'Admin' }
    }
  },
  components: {
    scoreAddOrUpdate: scoreAddOrUpdate
  },
  methods: {
    addOrUpdateHandle (id) {
      this.currId = id
      this.addOrUpdateBtn = true
    },
    getData (page) {
      this.$http({
        url: this.$http.adornUrl('/score/' + this.searchType + '/' + page),
        method: 'get',
        params: {num: this.searchNum}
      }).then(({data}) => {
        if (data && data.code === 200) {
          this.list = []
          this.total = data.page.total
          data.page.records.forEach((i) => {
            let a = {}
            // 数据赋值
            a.id = i.id
            a.stuNum = i.stuNum
            a.cozNum = i.cozNum
            a.cozName = i.cozName
            a.score = i.score
            a.retestScore = i.retestScore == null ? '未补考' : i.retestScore
            // 添加
            this.list.push(a)
          })
        } else {
          this.$message.error(data.code + ' : ' + data.message)
        }
      })
    },
    deleteDate (id) {
      this.$http({
        url: this.$http.adornUrl('/score/delete'),
        method: 'delete',
        params: {id: id}
      }).then(({data}) => {
        if (data && data.code === 200) {
          this.getData(this.currentPage)
        } else {
          this.$message.error(data.code + ' : ' + data.message)
        }
      })
    }
  }
}
</script>

<style scoped>

</style>
