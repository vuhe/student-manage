export default {
  namespaced: true,
  state: {
    name: '',
    role: 'Other'
  },
  mutations: {
    updateName (state, name) {
      state.name = name
    },
    updateRole (state, role) {
      state.role = role
    }
  }
}
