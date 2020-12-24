package top.vuhe.database.portal.controller

import com.baomidou.mybatisplus.core.metadata.IPage
import org.apache.shiro.authz.annotation.RequiresRoles
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import top.vuhe.database.common.ApiResponse
import top.vuhe.database.entity.Student
import top.vuhe.database.portal.service.intf.StudentService

@RestController
@RequestMapping("/api/student")
class StudentController {
    @Autowired
    private lateinit var service: StudentService

    /**
     * 按学号搜索学生
     * 默认为全获取
     *
     * @param stuNum 学生id
     * @param page 页码
     * @return 学生信息
     */
    @RequiresRoles("Other")
    @GetMapping("/search/{page}")
    fun searchStudentPage(@RequestParam("num") stuNum: String, @PathVariable page: Int)
            : ApiResponse<IPage<Student>> {
        val searchStdNum = if (stuNum == "") null else stuNum
        return ApiResponse.ofSuccessWithDate(
            "page",
            service.searchStudentPage(page, searchStdNum)
        )
    }

    /**
     * 添加学生
     *
     * @param student 学生
     * @return 是否添加成功
     */
    @RequiresRoles("Admin")
    @PostMapping("/add")
    fun addStudent(@RequestBody student: Student): ApiResponse<*> {
        return service.addStudent(student)
    }

    /**
     * 修改学生
     *
     * @param student 学生
     * @return 是否修改成功
     */
    @RequiresRoles("Admin")
    @PutMapping("/modify")
    fun modifyStudent(@RequestBody student: Student): ApiResponse<*> {
        return service.modifyStudent(student)
    }

    /**
     * 删除学生
     *
     * @param id 学生id
     * @return 是否删除成功
     */
    @RequiresRoles("Admin")
    @DeleteMapping("/delete/{id}")
    fun deleteStudent(@PathVariable id: Int): ApiResponse<*> {
        return service.deleteStudent(id)
    }
}