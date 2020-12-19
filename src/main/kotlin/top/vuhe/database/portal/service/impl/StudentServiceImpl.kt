package top.vuhe.database.portal.service.impl

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import org.springframework.stereotype.Service
import top.vuhe.database.entity.Student
import top.vuhe.database.mapper.StudentMapper
import top.vuhe.database.portal.service.intf.StudentService

@Service("StudentService")
class StudentServiceImpl : ServiceImpl<StudentMapper, Student>(), StudentService {

    override fun searchStudentPage(page: Int, stuNum: Int?): IPage<Student> {
        val aPage = Page<Student>(page.toLong(), 10)
        val queryWrapper = QueryWrapper<Student>()
        if (stuNum != null) {
            queryWrapper.eq("stu_num", stuNum)
        }
        // 按 id 倒序排列
        queryWrapper.orderByDesc("id")
        return baseMapper.selectPage(aPage, queryWrapper)
    }
}