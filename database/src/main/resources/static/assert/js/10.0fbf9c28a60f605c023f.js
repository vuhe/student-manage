webpackJsonp([10],{Bmp2:function(t,e){},wQTO:function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var r={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"site-wrapper site-page--login"},[a("div",{staticClass:"site-content__wrapper"},[a("div",{staticClass:"site-content"},[t._m(0),t._v(" "),a("div",{staticClass:"login-main"},[a("h3",{staticClass:"login-title"},[t._v("管理员登录")]),t._v(" "),a("el-form",{ref:"dataForm",attrs:{model:t.dataForm,rules:t.dataRule,"status-icon":""},nativeOn:{keyup:function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.dataFormSubmit()}}},[a("el-form-item",{attrs:{prop:"name"}},[a("el-input",{attrs:{placeholder:"帐号"},model:{value:t.dataForm.name,callback:function(e){t.$set(t.dataForm,"name",e)},expression:"dataForm.name"}})],1),t._v(" "),a("el-form-item",{attrs:{prop:"password"}},[a("el-input",{attrs:{type:"password",placeholder:"密码"},model:{value:t.dataForm.password,callback:function(e){t.$set(t.dataForm,"password",e)},expression:"dataForm.password"}})],1),t._v(" "),a("el-form-item",[a("el-button",{staticClass:"login-btn-submit",attrs:{type:"primary"},on:{click:function(e){return t.dataFormSubmit()}}},[t._v("登录")])],1)],1)],1)])])])},staticRenderFns:[function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"brand-info"},[e("h2",{staticClass:"brand-info__text"},[this._v("学生信息管理系统")]),this._v(" "),e("p",{staticClass:"brand-info__intro"},[this._v("欢迎使用学生管理系统")])])}]};var s=a("VU/8")({data:function(){return{dataForm:{id:0,name:"",password:"",token:"",role:"Other"},dataRule:{name:[{required:!0,message:"帐号不能为空",trigger:"blur"}],password:[{required:!0,message:"密码不能为空",trigger:"blur"}]}}},computed:{username:{get:function(){return this.$store.state.user.name},set:function(t){this.$store.commit("user/updateName",t)}},userRole:{get:function(){return this.$store.state.user.role},set:function(t){this.$store.commit("user/updateRole",t)}}},methods:{dataFormSubmit:function(){var t=this;this.$refs.dataForm.validate(function(e){e&&t.$http({url:t.$http.adornUrl("/login"),method:"post",data:t.$http.adornData({id:t.dataForm.id,name:t.dataForm.name,password:t.dataForm.password,token:t.dataForm.token,role:t.dataForm.role})}).then(function(e){var a=e.data;a&&200===a.code?(t.$cookie.set("token",a.user.token),t.username=a.user.name,t.userRole=a.user.role,t.$router.replace({name:"home"})):t.$message.error(a.message)})})}}},r,!1,function(t){a("Bmp2")},null,null);e.default=s.exports}});