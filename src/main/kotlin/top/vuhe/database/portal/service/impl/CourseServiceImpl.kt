package top.vuhe.database.portal.service.impl

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import org.springframework.stereotype.Service
import top.vuhe.database.common.ApiResponse
import top.vuhe.database.common.exception.ExceptionEnum
import top.vuhe.database.common.exception.SystemProcessingException
import top.vuhe.database.entity.Course
import top.vuhe.database.mapper.CourseMapper
import top.vuhe.database.portal.service.intf.CourseService

@Service("CourseService")
class CourseServiceImpl: ServiceImpl<CourseMapper, Course>(), CourseService {
    override fun searchCoursePage(pageNum: Int, cozNum: String?): IPage<Course> {
        val page = Page<Course>(pageNum.toLong(), 10)
        val queryWrapper = QueryWrapper<Course>()
        if (cozNum != null) {
            queryWrapper.like("coz_num", cozNum)
        }
        // 按 id 倒序排列
        queryWrapper.orderByDesc("id")
        return page(page, queryWrapper)
    }

    override fun getCourse(id: Int): Course {
        return getById(id)
            ?: throw SystemProcessingException(ExceptionEnum.INPUT_ERROR)
    }

    override fun saveCourse(course: Course): ApiResponse<*> {
        val ans = if (course.id == 0) {
            // id 由数据库设定
            // 此处 id 置空
            save(course.copy(id = null))
        } else {
            updateById(course)
        }

        // 检验结果
        return if (ans) {
            ApiResponse.ofSuccess()
        } else {
            ApiResponse.ofExceptionEnum(ExceptionEnum.DATA_ERROR)
        }
    }

    override fun deleteCourse(id: Int): ApiResponse<*> {
        val ans = removeById(id)
        // 检验结果
        return if (ans) {
            ApiResponse.ofSuccess()
        } else {
            ApiResponse.ofExceptionEnum(ExceptionEnum.INPUT_ERROR)
        }
    }
}