<template>
  <aside class="site-sidebar site-sidebar--light">
    <div class="site-sidebar__inner">
      <el-menu
        :default-active="menuActiveName || 'home'"
        :collapse="false"
        :collapseTransition="false"
        class="site-sidebar__menu">
        <el-menu-item index="home" @click="$router.push({ name: 'home' })">
          <icon-svg name="shouye" class="site-sidebar__menu-icon"></icon-svg>
          <span slot="title">首页</span>
        </el-menu-item>
        <el-menu-item index="student" @click="$router.push({ name: 'student' })">
          <icon-svg name="peoples" class="site-sidebar__menu-icon"></icon-svg>
          <span slot="title">学生信息管理</span>
        </el-menu-item>
        <el-menu-item index="course" @click="$router.push({ name: 'course' })">
          <icon-svg name="menu" class="site-sidebar__menu-icon"></icon-svg>
          <span slot="title">课程信息管理</span>
        </el-menu-item>
        <el-menu-item index="score" @click="$router.push({ name: 'score' })">
          <icon-svg name="article" class="site-sidebar__menu-icon"></icon-svg>
          <span slot="title">成绩信息管理</span>
        </el-menu-item>
      </el-menu>
    </div>
  </aside>
</template>

<script>
export default {
  computed: {
    menuActiveName: {
      get () { return this.$store.state.common.menuActiveName },
      set (val) { this.$store.commit('common/updateMenuActiveName', val) }
    }
  }
}
</script>
