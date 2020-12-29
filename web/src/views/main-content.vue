<template>
  <main class="site-content">
    <!-- 主入口标签页 e -->
    <el-card :body-style="siteContentViewHeight">
      <keep-alive>
        <router-view />
      </keep-alive>
    </el-card>
  </main>
</template>

<script>
export default {
  computed: {
    documentClientHeight: {
      get () { return this.$store.state.common.documentClientHeight }
    },
    siteContentViewHeight () {
      let height = this.documentClientHeight - 50 - 30 - 2
      return { minHeight: height + 'px' }
    }
  }
}
</script>
