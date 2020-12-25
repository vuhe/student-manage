<template>
  <div
    class="site-wrapper"
    v-loading.fullscreen.lock="loading"
    element-loading-text="拼命加载中">
    <template v-if="!loading">
      <main-navbar/>
      <main-sidebar/>
      <div class="site-content__wrapper" :style="{ 'min-height': documentClientHeight + 'px' }">
        <main-content/>
      </div>
    </template>
  </div>
</template>

<script>
import MainNavbar from './main-navbar'
import MainSidebar from './main-sidebar'
import MainContent from './main-content'

export default {
  data () {
    return {
      loading: true
    }
  },
  components: {
    MainNavbar,
    MainSidebar,
    MainContent
  },
  computed: {
    documentClientHeight: {
      get () {
        return this.$store.state.common.documentClientHeight
      },
      set (val) {
        this.$store.commit('common/updateDocumentClientHeight', val)
      }
    },
    userName: {
      get () {
        return this.$store.state.user.name
      },
      set (val) {
        this.$store.commit('user/updateName', val)
      }
    }
  },
  created: function () {
    this.getUserInfo()
  },
  mounted: function () {
    this.resetDocumentClientHeight()
  },
  methods: {
    // 重置窗口可视高度
    resetDocumentClientHeight () {
      this.documentClientHeight = document.documentElement['clientHeight']
      window.onresize = () => {
        this.documentClientHeight = document.documentElement['clientHeight']
      }
    },
    // 获取当前管理员信息
    getUserInfo () {
      this.$http({
        url: this.$http.adornUrl('/check_token'),
        method: 'get',
        data: this.$http.adornData({})
      }).then(({data}) => {
        if (data && data.code === 200) {
          this.loading = false
        } else {
          this.$router.push({name: 'login'})
        }
      })
    }
  }
}
</script>
<style>
  .form-input {
    width: 100px
  }
</style>
