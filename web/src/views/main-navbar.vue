<template>
  <nav class="site-navbar site-navbar--inverse">
    <div class="site-navbar__header">
      <h1 class="site-navbar__brand" @click="$router.push({ name: 'home' })">
        <a class="site-navbar__brand-lg" href="javascript:;">学生信息管理系统</a>
      </h1>
    </div>
    <div class="site-navbar__body clearfix">
      <el-menu
        class="site-navbar__menu site-navbar__menu--right"
        mode="horizontal">
        <el-menu-item class="site-navbar__avatar" index="3">
          <span class="el-dropdown-link">
              当前登陆：{{ userName }}
            </span>
          <el-button @click.native="logoutHandle()">退出</el-button>
        </el-menu-item>
      </el-menu>
    </div>
    <!-- 弹窗, 修改密码 -->
    <update-password v-if="updatePasswordVisible" ref="updatePassowrd"></update-password>
  </nav>
</template>

<script>
import { clearLoginInfo } from '@/utils'
export default {
  data () {
    return {
      updatePasswordVisible: false
    }
  },
  computed: {
    mainTabs: {
      get () { return this.$store.state.common.mainTabs },
      set (val) { this.$store.commit('common/updateMainTabs', val) }
    },
    userName: {
      get () { return this.$store.state.user.name }
    }
  },
  methods: {
    // 退出
    logoutHandle () {
      this.$confirm(`确定进行[退出]操作?`, '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$http({
          url: this.$http.adornUrl('/logout'),
          method: 'post',
          data: this.$http.adornData()
        }).then(({data}) => {
          if (data && data.code === 200) {
            clearLoginInfo()
            this.$router.push({ name: 'login' })
          }
        })
      }).catch(() => {})
    }
  }
}
</script>
