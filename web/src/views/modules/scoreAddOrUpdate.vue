<template>
  <el-dialog
    title="添加/修改成绩信息"
    :visible.sync="addOrUpdateBtn"
    :show-close="false"
    @open="initData"
    @close="endCall">
    <el-form :model="form" :rules="dataRule" ref="form">
      <el-form-item label="学生学号" prop="stuNum" :label-width="formLabelWidth">
        <el-input v-model="form.stuNum" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="课程编号" prop="cozNum" :label-width="formLabelWidth">
        <el-input v-model="form.cozNum" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="课程成绩" prop="score" :label-width="formLabelWidth">
        <el-input type="number" v-model="form.score" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="补考成绩" :label-width="formLabelWidth">
        <el-checkbox v-model="haveRetestScore">是否有补考成绩</el-checkbox>
        <el-input type="number" :disabled="!haveRetestScore" v-model="form.retestScore" autocomplete="off"></el-input>
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
  name: 'score-add-or-update',
  data () {
    return {
      form: {
        stuNum: '',
        cozNum: '',
        score: 0,
        retestScore: null
      },
      dataRule: {
        stuNum: [
          {required: true, message: '学号号不能为空', trigger: 'blur'}
        ],
        cozNum: [
          {required: true, message: '课程号不能为空', trigger: 'blur'}
        ],
        score: [
          {required: true, message: '成绩不能为空', trigger: 'blur'}
        ]
      },
      haveRetestScore: false,
      formLabelWidth: '120px'
    }
  },
  computed: {
    addOrUpdateBtn: {
      get () { return this.$store.state.common.scoreAddOrUpdateBtn },
      set (val) { this.$store.commit('common/updateScoreAddOrUpdateBtn', val) }
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
          url: this.$http.adornUrl('/score/get'),
          method: 'get',
          params: {id: this.id}
        }).then(({data}) => {
          if (data && data.code === 200) {
            this.form.stuNum = data.score.stuNum
            this.form.cozNum = data.score.cozNum
            this.form.score = data.score.score
            this.form.retestScore = data.score.retestScore
            this.haveRetestScore = this.form.retestScore != null
          } else {
            this.$message.error(data.code + ' : ' + data.message)
          }
        })
      } else {
        this.form.stuNum = ''
        this.form.cozNum = ''
        this.form.score = 0
        this.form.retestScore = null
        this.haveRetestScore = false
      }
    },
    save () {
      this.$http({
        url: this.$http.adornUrl('/score/save'),
        method: 'post',
        data: this.$http.adornData({
          'id': this.id,
          'stuNum': this.form.stuNum,
          'cozNum': this.form.cozNum,
          'score': this.form.score,
          'retestScore': this.haveRetestScore === true ? this.form.retestScore : null
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
