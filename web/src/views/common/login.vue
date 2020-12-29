<template>
  <div class="site-wrapper site-page--login">
    <div class="site-content__wrapper">
      <div class="site-content">
        <div class="brand-info">
          <h2 class="brand-info__text">学生信息管理系统</h2>
          <p class="brand-info__intro">欢迎使用学生管理系统</p>
        </div>
        <div class="login-main">
          <h3 class="login-title">管理员登录</h3>
          <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()"
                   status-icon>
            <el-form-item prop="name">
              <el-input v-model="dataForm.name" placeholder="帐号"></el-input>
            </el-form-item>
            <el-form-item prop="password">
              <el-input v-model="dataForm.password" type="password" placeholder="密码"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button class="login-btn-submit" type="primary" @click="dataFormSubmit()">登录</el-button>
            </el-form-item>
          </el-form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      dataForm: {
        id: 0,
        name: '',
        password: '',
        token: '',
        role: 'Other'
      },
      dataRule: {
        name: [
          {required: true, message: '帐号不能为空', trigger: 'blur'}
        ],
        password: [
          {required: true, message: '密码不能为空', trigger: 'blur'}
        ]
      }
    }
  },
  computed: {
    username: {
      get () { return this.$store.state.user.name },
      set (val) { this.$store.commit('user/updateName', val) }
    },
    userRole: {
      get () { return this.$store.state.user.role },
      set (val) { this.$store.commit('user/updateRole', val) }
    }
  },
  methods: {
    // 提交表单
    dataFormSubmit () {
      this.$refs['dataForm'].validate((valid) => {
        if (valid) {
          this.$http({
            url: this.$http.adornUrl('/login'),
            method: 'post',
            data: this.$http.adornData({
              'id': this.dataForm.id,
              'name': this.dataForm.name,
              'password': this.dataForm.password,
              'token': this.dataForm.token,
              'role': this.dataForm.role
            })
          }).then(({data}) => {
            if (data && data.code === 200) {
              this.$cookie.set('token', data.user.token)
              this.username = data.user.name
              this.userRole = data.user.role
              this.$router.replace({name: 'home'})
            } else {
              this.$message.error(data.message)
            }
          })
        }
      })
    }
  }
}
</script>

<style lang="scss">
  .site-wrapper.site-page--login {
    position: absolute;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    background-color: rgba(38, 50, 56, .6);
    overflow: hidden;

    &:before {
      position: fixed;
      top: 0;
      left: 0;
      z-index: -1;
      width: 100%;
      height: 100%;
      content: "";
      background-image: url(../../assets/img/login_bg.jpg);
      background-size: cover;
    }

    .site-content__wrapper {
      position: absolute;
      top: 0;
      right: 0;
      bottom: 0;
      left: 0;
      padding: 0;
      margin: 0;
      overflow-x: hidden;
      overflow-y: auto;
      background-color: transparent;
    }

    .site-content {
      min-height: 100%;
      padding: 30px 500px 30px 30px;
    }

    .brand-info {
      margin: 220px 100px 0 90px;
      color: #fff;
    }

    .brand-info__text {
      margin: 0 0 22px 0;
      font-size: 48px;
      font-weight: 400;
    }

    .brand-info__intro {
      margin: 10px 0;
      font-size: 18px;
      line-height: 1.58;
      opacity: .7;
    }

    .login-main {
      position: absolute;
      top: 0;
      right: 0;
      padding: 150px 60px 180px;
      width: 470px;
      min-height: 100%;
      background-color: #fff;
    }

    .login-title {
      font-size: 16px;
    }

    .login-captcha {
      overflow: hidden;

      > img {
        width: 100%;
        cursor: pointer;
      }
    }

    .login-btn-submit {
      width: 100%;
      margin-top: 38px;
    }
  }
</style>
