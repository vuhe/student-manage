package top.vuhe.database.portal.service.impl

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import org.springframework.stereotype.Service
import top.vuhe.database.common.ApiResponse
import top.vuhe.database.common.exception.ExceptionEnum
import top.vuhe.database.common.exception.SystemProcessingException
import top.vuhe.database.entity.Student
import top.vuhe.database.mapper.StudentMapper
import top.vuhe.database.portal.service.intf.StudentService

@Service("StudentService")
class StudentServiceImpl : ServiceImpl<StudentMapper, Student>(), StudentService {

    override fun searchStudentPage(page: Int, stuNum: String?): IPage<Student> {
        val aPage = Page<Student>(page.toLong(), 10)
        val queryWrapper = QueryWrapper<Student>()
        if (stuNum != null) {
            queryWrapper.like("stu_num", stuNum)
        }
        // 按 id 倒序排列
        queryWrapper.orderByDesc("id")
        return page(aPage, queryWrapper)
    }

    override fun getStudent(id: Int): Student {
        return getById(id)
            ?: throw SystemProcessingException(ExceptionEnum.INPUT_ERROR)
    }

    override fun saveStudent(student: Student): ApiResponse<*> {
        val ans = if (student.id == 0) {
            // id 由数据库设定
            // 此处 id 置空
            save(student.copy(id = null))
        } else {
            updateById(student)
        }

        // 检验结果
        return if (ans) {
            ApiResponse.ofSuccess()
        } else {
            ApiResponse.ofExceptionEnum(ExceptionEnum.DATA_ERROR)
        }
    }

    override fun deleteStudent(id: Int): ApiResponse<*> {
        val ans = removeById(id)
        // 检验结果
        return if (ans) {
            ApiResponse.ofSuccess()
        } else {
            ApiResponse.ofExceptionEnum(ExceptionEnum.INPUT_ERROR)
        }
    }
}