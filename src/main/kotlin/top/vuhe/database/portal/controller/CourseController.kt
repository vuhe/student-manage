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
     * 通过课程号搜索课程
     * 默认为全获取
     *
     * @param cozNum 课程好
     * @param page 页码
     * @return 课程信息
     */
    @RequiresRoles("Other")
    @GetMapping("/search/{page}")
    fun searchCoursePage(@RequestParam("num") cozNum: String, @PathVariable page: Int): ApiResponse<IPage<Course>> {
        val searchCozNum = if (cozNum == "") null else cozNum
        return ApiResponse.ofSuccessWithDate(
            "page",
            service.searchCoursePage(page, searchCozNum)
        )
    }

    /**
     * 获取一条课程
     *
     * @param id id
     * @return 课程
     */
    @RequiresRoles("Admin")
    @GetMapping("/get")
    fun getCourse(@RequestParam("id") id: Int): ApiResponse<Course> {
        return ApiResponse.ofSuccessWithDate("course", service.getCourse(id))
    }

    /**
     * 添加/修改课程
     *
     * @param course 课程
     * @return 是否添加/修改成功
     */
    @RequiresRoles("Admin")
    @PostMapping("/save")
    fun addCourse(@RequestBody course: Course): ApiResponse<*> {
        return service.saveCourse(course)
    }

    /**
     * 删除课程
     *
     * @param id 编号
     * @return 是否删除成功
     */
    @RequiresRoles("Admin")
    @DeleteMapping("/delete")
    fun deleteCourse(@RequestParam("id") id: Int): ApiResponse<*> {
        return service.deleteCourse(id)
    }
}