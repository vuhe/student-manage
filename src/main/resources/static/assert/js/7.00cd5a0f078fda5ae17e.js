webpackJsonp([7],{S1YY:function(e,t,o){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var r={render:function(){var e=this,t=e.$createElement,o=e._self._c||t;return o("el-dialog",{attrs:{title:"添加课程信息",visible:e.addOrUpdateBtn,"show-close":!1},on:{"update:visible":function(t){e.addOrUpdateBtn=t},open:e.initData,close:e.endCall}},[o("el-form",{ref:"form",attrs:{model:e.form,rules:e.dataRule}},[o("el-form-item",{attrs:{label:"课程编号",prop:"cozNum","label-width":e.formLabelWidth}},[o("el-input",{attrs:{autocomplete:"off"},model:{value:e.form.cozNum,callback:function(t){e.$set(e.form,"cozNum",t)},expression:"form.cozNum"}})],1),e._v(" "),o("el-form-item",{attrs:{label:"课程名称",prop:"cozName","label-width":e.formLabelWidth}},[o("el-input",{attrs:{autocomplete:"off"},model:{value:e.form.cozName,callback:function(t){e.$set(e.form,"cozName",t)},expression:"form.cozName"}})],1),e._v(" "),o("el-form-item",{attrs:{label:"课程学时",prop:"cozTime","label-width":e.formLabelWidth}},[o("el-input",{attrs:{type:"number",autocomplete:"off"},model:{value:e.form.cozTime,callback:function(t){e.$set(e.form,"cozTime",t)},expression:"form.cozTime"}})],1),e._v(" "),o("el-form-item",{attrs:{label:"课程学分",prop:"cozPoint","label-width":e.formLabelWidth}},[o("el-input",{attrs:{type:"number",autocomplete:"off"},model:{value:e.form.cozPoint,callback:function(t){e.$set(e.form,"cozPoint",t)},expression:"form.cozPoint"}})],1)],1),e._v(" "),o("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[o("el-button",{on:{click:e.exitHandle}},[e._v("取 消")]),e._v(" "),o("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v("确 定")])],1)],1)},staticRenderFns:[]};var i=o("VU/8")({name:"course-add-or-update",data:function(){return{form:{cozNum:"",cozName:"",cozTime:0,cozPoint:0},dataRule:{cozNum:[{required:!0,message:"课程号不能为空",trigger:"blur"}],cozName:[{required:!0,message:"课程名不能为空",trigger:"blur"}],cozTime:[{required:!0,message:"学时不能为空",trigger:"blur"}],cozPoint:[{required:!0,message:"学分不能为空",trigger:"blur"}]},formLabelWidth:"120px"}},computed:{addOrUpdateBtn:{get:function(){return this.$store.state.common.courseAddOrUpdateBtn},set:function(e){this.$store.commit("common/updateCourseAddOrUpdateBtn",e)}},id:{get:function(){return this.$store.state.common.currModifyId},set:function(e){this.$store.commit("common/updateCurrModifyId",e)}}},methods:{initData:function(){var e=this;this.id>0?this.$http({url:this.$http.adornUrl("/course/get"),method:"get",params:{id:this.id}}).then(function(t){var o=t.data;o&&200===o.code?(e.form.cozNum=o.course.cozNum,e.form.cozName=o.course.cozName,e.form.cozTime=o.course.cozTime,e.form.cozPoint=o.course.cozPoint):e.$message.error(o.code+" : "+o.message)}):(this.form.cozNum="",this.form.cozName="",this.form.cozTime=0,this.form.cozPoint=0)},save:function(){var e=this;this.$http({url:this.$http.adornUrl("/course/save"),method:"post",data:this.$http.adornData({id:this.id,cozNum:this.form.cozNum,cozName:this.form.cozName,cozTime:this.form.cozTime,cozPoint:this.form.cozPoint})}).then(function(t){var o=t.data;o&&200===o.code||e.$message.error(o.code+" : "+o.message)}),this.exitHandle()},exitHandle:function(){this.addOrUpdateBtn=!1,this.id=0,this.$refs.form.resetFields()}},props:["endCall"]},r,!1,function(e){o("nAhI")},"data-v-825abb6c",null);t.default=i.exports},nAhI:function(e,t){}});