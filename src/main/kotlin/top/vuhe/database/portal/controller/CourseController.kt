package top.vuhe.database.portal.controller

import com.baomidou.mybatisplus.core.metadata.IPage
import org.apache.shiro.authz.annotation.RequiresRoles
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import top.vuhe.database.common.ApiResponse
import top.vuhe.database.entity.Course
import top.vuhe.database.portal.service.intf.CourseService

@RestController
@RequestMapping("/api/course")
class CourseController {
    @Autowired
    private lateinit var service: CourseService

    /**
     * 默认获取列表
     *
     * @param page 页码
     * @return 课程信息
     */
    @RequiresRoles("Other")
    @GetMapping("/get/{page}")
    fun getCoursePage(@PathVariable page: Int): ApiResponse<IPage<Course>> {
        return ApiResponse.ofSuccessWithDate(
            "page",
            service.searchCoursePage(page, null)
        )
    }

    /**
     * 通过课程号搜索课程
     *
     * @param cozNum 课程好
     * @param page 页码
     * @return 课程信息
     */
    @RequiresRoles("Other")
    @GetMapping("/search/{page}")
    fun searchCoursePage(@RequestBody cozNum: String, @PathVariable page: Int): ApiResponse<IPage<Course>> {
        return ApiResponse.ofSuccessWithDate(
            "page",
            service.searchCoursePage(page, cozNum)
        )
    }

    /**
     * 添加课程
     *
     * @param course 课程
     * @return 是否添加成功
     */
    @RequiresRoles("Admin")
    @PostMapping("/add")
    fun addCourse(@RequestBody course: Course): ApiResponse<*> {
        return service.addCourse(course)
    }

    /**
     * 修改课程
     *
     * @param course 课程
     * @return 是否修改成功
     */
    @RequiresRoles("Admin")
    @PutMapping("/modify")
    fun modifyCourse(@RequestBody course: Course): ApiResponse<*> {
        return service.modifyCourse(course)
    }

    /**
     * 删除课程
     *
     * @param id 编号
     * @return 是否删除成功
     */
    @RequiresRoles("Admin")
    @DeleteMapping("/delete/{id}")
    fun deleteCourse(@PathVariable id: Int): ApiResponse<*> {
        return service.deleteCourse(id)
    }
}