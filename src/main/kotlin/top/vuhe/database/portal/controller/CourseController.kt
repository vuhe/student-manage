package top.vuhe.database.portal.controller

import org.springframework.web.bind.annotation.*
import top.vuhe.database.common.ApiResponse
import top.vuhe.database.entity.Course

@RestController
@RequestMapping("/api/course")
class CourseController {
    /**
     * 默认获取列表
     *
     * @param page 页码
     * @return 课程信息
     */
    @GetMapping("/get/{page}")
    fun getCoursePage(@PathVariable page: Int): ApiResponse<Course> {
        return ApiResponse.ofSuccessWithDate(
            "page",
            Course(1, " ", " ", 2, 2.0)
        )
    }

    /**
     * 通过课程号搜索课程
     *
     * @param id 课程好
     * @param page 页码
     * @return 课程信息
     */
    @GetMapping("/search/{page}")
    fun searchCoursePage(@RequestBody id: Int, @PathVariable page: Int): ApiResponse<Course> {
        return ApiResponse.ofSuccessWithDate(
            "page",
            Course(1, " ", " ", 2, 2.0)
        )
    }

    /**
     * 添加课程
     *
     * @param course 课程
     * @return 是否添加成功
     */
    @PostMapping("/add")
    fun addCourse(@RequestBody course: Course): ApiResponse<*> {
        return ApiResponse.ofSuccess()
    }

    /**
     * 修改课程
     *
     * @param course 课程
     * @return 是否修改成功
     */
    @PutMapping("/modify")
    fun modifyCourse(@RequestBody course: Course): ApiResponse<*> {
        return ApiResponse.ofSuccess()
    }

    /**
     * 删除课程
     *
     * @param id 编号
     * @return 是否删除成功
     */
    @DeleteMapping("/delete/{id}")
    fun deleteCourse(@PathVariable id: Int): ApiResponse<*> {
        return ApiResponse.ofSuccess()
    }
}