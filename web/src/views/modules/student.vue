<template>
  <div>
    <el-form :inline="true">
      <el-form-item>
        <el-input placeholder="输入学号查询" v-model="searchNum" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getData(1)">查询/刷新</el-button>
        <el-button v-if="isAdmin" type="warning" @click="addOrUpdateBtn = true">添加学生</el-button>
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
        width="50"
        label="编号">
      </el-table-column>
      <el-table-column
        prop="stuNum"
        header-align="center"
        align="center"
        label="学号"
        width="150">
      </el-table-column>
      <el-table-column
        prop="stuName"
        header-align="center"
        align="center"
        label="姓名"
        width="150">
      </el-table-column>
      <el-table-column
        prop="stuSex"
        header-align="center"
        align="center"
        width="80"
        label="性别">
      </el-table-column>
      <el-table-column
        prop="stuBirthday"
        header-align="center"
        align="center"
        width="150"
        label="出生日期">
      </el-table-column>
      <el-table-column
        prop="stuClass"
        header-align="center"
        align="center"
        width="100"
        label="班级">
      </el-table-column>
      <el-table-column
        prop="stuProfession"
        header-align="center"
        align="center"
        width="150"
        label="专业">
      </el-table-column>
      <el-table-column
        prop="stuDepartment"
        header-align="center"
        align="center"
        width="150"
        label="系别">
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

    <student-add-or-update :end-call="getData(1)"></student-add-or-update>
  </div>
</template>

<script>
import studentAddOrUpdate from './studentAddOrUpdate'
import {dateFormat} from '../../utils'

export default {
  name: 'student',
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
      get () { return this.$store.state.common.studentAddOrUpdateBtn },
      set (val) { this.$store.commit('common/updateStudentAddOrUpdateBtn', val) }
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
    studentAddOrUpdate: studentAddOrUpdate
  },
  methods: {
    addOrUpdateHandle (id) {
      this.currId = id
      this.addOrUpdateBtn = true
    },
    getData (page) {
      this.$http({
        url: this.$http.adornUrl('/student/search/' + page),
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
            a.stuName = i.stuName
            a.stuSex = i.stuSex === 'Male' ? '男' : '女'
            a.stuBirthday = dateFormat(i.stuBirthday)
            a.stuClass = i.stuClass
            a.stuProfession = i.stuProfession
            a.stuDepartment = i.stuDepartment
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
        url: this.$http.adornUrl('/student/delete'),
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
