webpackJsonp([8],{"0UoO":function(t,e,s){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var r={render:function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("el-dialog",{attrs:{title:"添加/修改学生信息",visible:t.addOrUpdateBtn,"show-close":!1},on:{"update:visible":function(e){t.addOrUpdateBtn=e},open:t.initData,close:t.endCall}},[s("el-form",{ref:"form",attrs:{model:t.form,rules:t.dataRule}},[s("el-form-item",{attrs:{label:"学生学号",prop:"stuNum","label-width":t.formLabelWidth}},[s("el-input",{attrs:{autocomplete:"off"},model:{value:t.form.stuNum,callback:function(e){t.$set(t.form,"stuNum",e)},expression:"form.stuNum"}})],1),t._v(" "),s("el-form-item",{attrs:{label:"学生姓名",prop:"stuName","label-width":t.formLabelWidth}},[s("el-input",{attrs:{autocomplete:"off"},model:{value:t.form.stuName,callback:function(e){t.$set(t.form,"stuName",e)},expression:"form.stuName"}})],1),t._v(" "),s("el-form-item",{attrs:{label:"学生性别",prop:"stuSex","label-width":t.formLabelWidth}},[s("el-select",{attrs:{placeholder:"请选择性别"},model:{value:t.form.stuSex,callback:function(e){t.$set(t.form,"stuSex",e)},expression:"form.stuSex"}},[s("el-option",{attrs:{label:"男",value:"Male"}}),t._v(" "),s("el-option",{attrs:{label:"女",value:"Female"}})],1)],1),t._v(" "),s("el-form-item",{attrs:{label:"学生生日",prop:"stuBirthday","label-width":t.formLabelWidth}},[s("el-date-picker",{attrs:{type:"date",placeholder:"请选择生日"},model:{value:t.form.stuBirthday,callback:function(e){t.$set(t.form,"stuBirthday",e)},expression:"form.stuBirthday"}})],1),t._v(" "),s("el-form-item",{attrs:{label:"学生班级",prop:"stuClass","label-width":t.formLabelWidth}},[s("el-input",{attrs:{autocomplete:"off"},model:{value:t.form.stuClass,callback:function(e){t.$set(t.form,"stuClass",e)},expression:"form.stuClass"}})],1),t._v(" "),s("el-form-item",{attrs:{label:"学生专业",prop:"stuProfession","label-width":t.formLabelWidth}},[s("el-input",{attrs:{autocomplete:"off"},model:{value:t.form.stuProfession,callback:function(e){t.$set(t.form,"stuProfession",e)},expression:"form.stuProfession"}})],1),t._v(" "),s("el-form-item",{attrs:{label:"学生系别",prop:"stuDepartment","label-width":t.formLabelWidth}},[s("el-input",{attrs:{autocomplete:"off"},model:{value:t.form.stuDepartment,callback:function(e){t.$set(t.form,"stuDepartment",e)},expression:"form.stuDepartment"}})],1)],1),t._v(" "),s("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[s("el-button",{on:{click:t.exitHandle}},[t._v("取 消")]),t._v(" "),s("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("确 定")])],1)],1)},staticRenderFns:[]};var o=s("VU/8")({name:"student-add-or-update",data:function(){return{form:{stuNum:"",stuName:"",stuSex:"",stuBirthday:"",stuClass:"",stuProfession:"",stuDepartment:""},dataRule:{stuNum:[{required:!0,message:"学号号不能为空",trigger:"blur"}],stuName:[{required:!0,message:"课程号不能为空",trigger:"blur"}],stuSex:[{required:!0,message:"成绩不能为空",trigger:"blur"}],stuBirthday:[{type:"date",required:!0,message:"生日不能为空",trigger:"blur"}],stuClass:[{required:!0,message:"班级不能为空",trigger:"blur"}],stuProfession:[{required:!0,message:"专业不能为空",trigger:"blur"}],stuDepartment:[{required:!0,message:"系别不能为空",trigger:"blur"}]},formLabelWidth:"120px"}},computed:{addOrUpdateBtn:{get:function(){return this.$store.state.common.studentAddOrUpdateBtn},set:function(t){this.$store.commit("common/updateStudentAddOrUpdateBtn",t)}},id:{get:function(){return this.$store.state.common.currModifyId},set:function(t){this.$store.commit("common/updateCurrModifyId",t)}}},methods:{initData:function(){var t=this;this.id>0?this.$http({url:this.$http.adornUrl("/student/get"),method:"get",params:{id:this.id}}).then(function(e){var s=e.data;s&&200===s.code?(t.form.stuNum=s.student.stuNum,t.form.stuName=s.student.stuName,t.form.stuSex=s.student.stuSex,t.form.stuBirthday=s.student.stuBirthday,t.form.stuClass=s.student.stuClass,t.form.stuProfession=s.student.stuProfession,t.form.stuDepartment=s.student.stuDepartment):t.$message.error(s.code+" : "+s.message)}):(this.form.stuNum="",this.form.stuName="",this.form.stuSex="",this.form.stuBirthday="",this.form.stuClass="",this.form.stuProfession="",this.form.stuDepartment="")},save:function(){var t=this;this.$http({url:this.$http.adornUrl("/student/save"),method:"post",data:this.$http.adornData({id:this.id,stuNum:this.form.stuNum,stuName:this.form.stuName,stuSex:this.form.stuSex,stuBirthday:this.form.stuBirthday,stuClass:this.form.stuClass,stuProfession:this.form.stuProfession,stuDepartment:this.form.stuDepartment})}).then(function(e){var s=e.data;s&&200===s.code||t.$message.error(s.code+" : "+s.message)}),this.exitHandle()},exitHandle:function(){this.addOrUpdateBtn=!1,this.id=0,this.$refs.form.resetFields()}},props:["endCall"]},r,!1,function(t){s("dNQg")},"data-v-37c5a063",null);e.default=o.exports},dNQg:function(t,e){}});