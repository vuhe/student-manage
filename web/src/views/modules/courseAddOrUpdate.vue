<template>
  <el-dialog
    title="添加课程信息"
    :visible.sync="addOrUpdateBtn"
    :show-close="false"
    @open="initData"
    @close="endCall">
    <el-form :model="form" :rules="dataRule" ref="form">
      <el-form-item label="课程编号" prop="cozNum" :label-width="formLabelWidth">
        <el-input v-model="form.cozNum" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="课程名称" prop="cozName" :label-width="formLabelWidth">
        <el-input v-model="form.cozName" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="课程学时" prop="cozTime" :label-width="formLabelWidth">
        <el-input type="number" v-model="form.cozTime" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="课程学分" prop="cozPoint" :label-width="formLabelWidth">
        <el-input type="number" v-model="form.cozPoint" autocomplete="off"></el-input>
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
  name: 'course-add-or-update',
  data () {
    return {
      form: {
        cozNum: '',
        cozName: '',
        cozTime: 0,
        cozPoint: 0.0
      },
      dataRule: {
        cozNum: [
          {required: true, message: '课程号不能为空', trigger: 'blur'}
        ],
        cozName: [
          {required: true, message: '课程名不能为空', trigger: 'blur'}
        ],
        cozTime: [
          {required: true, message: '学时不能为空', trigger: 'blur'}
        ],
        cozPoint: [
          {required: true, message: '学分不能为空', trigger: 'blur'}
        ]
      },
      formLabelWidth: '120px'
    }
  },
  computed: {
    addOrUpdateBtn: {
      get () { return this.$store.state.common.courseAddOrUpdateBtn },
      set (val) { this.$store.commit('common/updateCourseAddOrUpdateBtn', val) }
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
          url: this.$http.adornUrl('/course/get'),
          method: 'get',
          params: {id: this.id}
        }).then(({data}) => {
          if (data && data.code === 200) {
            this.form.cozNum = data.course.cozNum
            this.form.cozName = data.course.cozName
            this.form.cozTime = data.course.cozTime
            this.form.cozPoint = data.course.cozPoint
          } else {
            this.$message.error(data.code + ' : ' + data.message)
          }
        })
      } else {
        this.form.cozNum = ''
        this.form.cozName = ''
        this.form.cozTime = 0
        this.form.cozPoint = 0.0
      }
    },
    save () {
      this.$http({
        url: this.$http.adornUrl('/course/save'),
        method: 'post',
        data: this.$http.adornData({
          'id': this.id,
          'cozNum': this.form.cozNum,
          'cozName': this.form.cozName,
          'cozTime': this.form.cozTime,
          'cozPoint': this.form.cozPoint
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
