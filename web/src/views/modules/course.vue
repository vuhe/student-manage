<template>
  <div>
    <el-form :inline="true">
      <el-form-item>
        <el-input placeholder="输入课程号查询" v-model="searchNum" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="reset">查询/刷新</el-button>
        <el-button v-if="isAdmin" type="warning" @click="addOrUpdateBtn = true">添加课程</el-button>
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
        prop="cozNum"
        header-align="center"
        align="center"
        label="课程号"
        width="200">
      </el-table-column>
      <el-table-column
        prop="cozName"
        header-align="center"
        align="center"
        label="课程名称"
        width="350">
      </el-table-column>
      <el-table-column
        prop="cozTime"
        header-align="center"
        align="center"
        width="150"
        label="学时">
      </el-table-column>
      <el-table-column
        prop="cozPoint"
        header-align="center"
        align="center"
        width="150"
        label="学分">
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

    <course-add-or-update :end-call="reset"></course-add-or-update>
  </div>
</template>

<script>
import courseAddOrUpdate from './courseAddOrUpdate'

export default {
  name: 'course',
  data () {
    return {
      searchNum: '',
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
      get () { return this.$store.state.common.courseAddOrUpdateBtn },
      set (val) { this.$store.commit('common/updateCourseAddOrUpdateBtn', val) }
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
    courseAddOrUpdate: courseAddOrUpdate
  },
  methods: {
    addOrUpdateHandle (id) {
      this.currId = id
      this.addOrUpdateBtn = true
    },
    reset () {
      this.currentPage = 1
      this.getData(this.currentPage)
    },
    getData (page) {
      this.$http({
        url: this.$http.adornUrl('/course/search/' + page),
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
            a.cozNum = i.cozNum
            a.cozName = i.cozName
            a.cozTime = i.cozTime
            a.cozPoint = i.cozPoint
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
        url: this.$http.adornUrl('/course/delete'),
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
