export default {
  namespaced: true,
  state: {
    // 页面文档可视高度(随窗口改变大小)
    documentClientHeight: 0,

    // 侧边栏, 菜单
    menuActiveName: '',

    // 添加页面状态
    studentAddOrUpdateBtn: false,
    courseAddOrUpdateBtn: false,
    scoreAddOrUpdateBtn: false,

    // 要修改的id
    currModifyId: 0
  },
  mutations: {
    updateDocumentClientHeight (state, height) {
      state.documentClientHeight = height
    },
    updateMenuActiveName (state, name) {
      state.menuActiveName = name
    },
    updateStudentAddOrUpdateBtn (state, btn) {
      state.studentAddOrUpdateBtn = btn
    },
    updateCourseAddOrUpdateBtn (state, btn) {
      state.courseAddOrUpdateBtn = btn
    },
    updateScoreAddOrUpdateBtn (state, btn) {
      state.scoreAddOrUpdateBtn = btn
    },
    updateCurrModifyId (state, id) {
      state.currModifyId = id
    }
  }
}
