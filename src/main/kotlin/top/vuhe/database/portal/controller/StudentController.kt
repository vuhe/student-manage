package top.vuhe.database.portal.controller

import com.baomidou.mybatisplus.core.metadata.IPage
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
     * 默认获取列表
     *
     * @param page 页码
     * @return 学生信息
     */
    @GetMapping("/get/{page}")
    fun getStudentPage(@PathVariable page: Int): ApiResponse<IPage<Student>> {
        return ApiResponse.ofSuccessWithDate(
            "page",
            service.searchStudentPage(page, null)
        )
    }

    /**
     * 按学号搜索学生
     *
     * @param stuNum 学生id
     * @param page 页码
     * @return 学生信息
     */
    @GetMapping("/search/{page}")
    fun searchStudentPage(@RequestBody stuNum: Int, @PathVariable page: Int)
            : ApiResponse<IPage<Student>> {
        // TODO-处理搜索逻辑
        return ApiResponse.ofSuccessWithDate(
            "page",
            service.searchStudentPage(page, stuNum)
        )
    }

    /**
     * 添加学生
     *
     * @param student 学生
     * @return 是否添加成功
     */
    @PostMapping("/add")
    fun addStudent(@RequestBody student: Student): ApiResponse<*> {
        return ApiResponse.ofSuccess()
    }

    /**
     * 修改学生
     *
     * @param student 学生
     * @return 是否修改成功
     */
    @PutMapping("/modify")
    fun modifyStudent(@RequestBody student: Student): ApiResponse<*> {
        return ApiResponse.ofSuccess()
    }

    /**
     * 删除学生
     *
     * @param id 学生id
     * @return 是否删除成功
     */
    @DeleteMapping("/delete/{id}")
    fun deleteStudent(@PathVariable id: Int): ApiResponse<*> {
        return ApiResponse.ofSuccess()
    }
}