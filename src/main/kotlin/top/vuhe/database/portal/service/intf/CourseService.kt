package top.vuhe.database.portal.service.intf

import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.service.IService
import top.vuhe.database.common.ApiResponse
import top.vuhe.database.entity.Course

interface CourseService : IService<Course> {
    /**
     * 按课程号搜索课程信息
     * 默认课程号为空时，返回全部信息
     *
     * @param pageNum 页码
     * @param cozNum 课程号
     * @return 查询结果
     */
    fun searchCoursePage(pageNum: Int, cozNum: String?): IPage<Course>

    /**
     * 按 id 获取课程
     *
     * @param id id
     * @return 课程
     */
    fun getCourse(id: Int): Course

    /**
     * 添加/修改课程
     *
     * @param course 课程实体
     * @return 是否添加/修改成功
     */
    fun saveCourse(course: Course): ApiResponse<*>

    /**
     * 删除课程
     *
     * @param id 课程id
     * @return 是否删除成功
     */
    fun deleteCourse(id: Int): ApiResponse<*>
}