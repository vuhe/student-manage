<template>
  <el-dialog
    title="添加/修改学生信息"
    :visible.sync="addOrUpdateBtn"
    :show-close="false"
    @open="initData"
    @close="endCall">
    <el-form :model="form" :rules="dataRule" ref="form">
      <el-form-item label="学生学号" prop="stuNum" :label-width="formLabelWidth">
        <el-input v-model="form.stuNum" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="学生姓名" prop="stuName" :label-width="formLabelWidth">
        <el-input v-model="form.stuName" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="学生性别" prop="stuSex" :label-width="formLabelWidth">
        <el-select v-model="form.stuSex" placeholder="请选择性别">
          <el-option label="男" value="Male"></el-option>
          <el-option label="女" value="Female"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="学生生日" prop="stuBirthday" :label-width="formLabelWidth">
        <el-date-picker
          v-model="form.stuBirthday"
          type="date"
          placeholder="请选择生日">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="学生班级" prop="stuClass" :label-width="formLabelWidth">
        <el-input v-model="form.stuClass" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="学生专业" prop="stuProfession" :label-width="formLabelWidth">
        <el-input v-model="form.stuProfession" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="学生系别" prop="stuDepartment" :label-width="formLabelWidth">
        <el-input v-model="form.stuDepartment" autocomplete="off"></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="exitHandle">取 消</el-button>
      <el-button type="primary" @click="save">确 定</el-button>
    </div>
  </el-dialog>
</template>

<script>
export default {
  name: 'student-add-or-update',
  data () {
    return {
      form: {
        stuNum: '',
        stuName: '',
        stuSex: '',
        stuBirthday: '',
        stuClass: '',
        stuProfession: '',
        stuDepartment: ''
      },
      dataRule: {
        stuNum: [
          {required: true, message: '学号号不能为空', trigger: 'blur'}
        ],
        stuName: [
          {required: true, message: '课程号不能为空', trigger: 'blur'}
        ],
        stuSex: [
          {required: true, message: '成绩不能为空', trigger: 'blur'}
        ],
        stuBirthday: [
          {type: 'date', required: true, message: '生日不能为空', trigger: 'blur'}
        ],
        stuClass: [
          {required: true, message: '班级不能为空', trigger: 'blur'}
        ],
        stuProfession: [
          {required: true, message: '专业不能为空', trigger: 'blur'}
        ],
        stuDepartment: [
          {required: true, message: '系别不能为空', trigger: 'blur'}
        ]
      },
      formLabelWidth: '120px'
    }
  },
  computed: {
    addOrUpdateBtn: {
      get () { return this.$store.state.common.studentAddOrUpdateBtn },
      set (val) { this.$store.commit('common/updateStudentAddOrUpdateBtn', val) }
    },
    id: {
      get () { return this.$store.state.common.currModifyId },
      set (val) { this.$store.commit('common/updateCurrModifyId', val) }
    }
  },
  methods: {
    initData () {
      if (this.id > 0) {
        this.$http({
          url: this.$http.adornUrl('/student/get'),
          method: 'get',
          params: {id: this.id}
        }).then(({data}) => {
          if (data && data.code === 200) {
            this.form.stuNum = data.student.stuNum
            this.form.stuName = data.student.stuName
            this.form.stuSex = data.student.stuSex
            this.form.stuBirthday = data.student.stuBirthday
            this.form.stuClass = data.student.stuClass
            this.form.stuProfession = data.student.stuProfession
            this.form.stuDepartment = data.student.stuDepartment
          } else {
            this.$message.error(data.code + ' : ' + data.message)
          }
        })
      } else {
        this.form.stuNum = ''
        this.form.stuName = ''
        this.form.stuSex = ''
        this.form.stuBirthday = ''
        this.form.stuClass = ''
        this.form.stuProfession = ''
        this.form.stuDepartment = ''
      }
    },
    save () {
      this.$http({
        url: this.$http.adornUrl('/student/save'),
        method: 'post',
        data: this.$http.adornData({
          'id': this.id,
          'stuNum': this.form.stuNum,
          'stuName': this.form.stuName,
          'stuSex': this.form.stuSex,
          'stuBirthday': this.form.stuBirthday,
          'stuClass': this.form.stuClass,
          'stuProfession': this.form.stuProfession,
          'stuDepartment': this.form.stuDepartment
        })
      }).then(({data}) => {
        if (data && data.code === 200) {
        } else {
          this.$message.error(data.code + ' : ' + data.message)
        }
      })
      this.exitHandle()
    },
    exitHandle () {
      this.addOrUpdateBtn = false
      this.id = 0
      this.$refs['form'].resetFields()
    }
  },
  props: ['endCall']
}
</script>

<style scoped>

</style>
