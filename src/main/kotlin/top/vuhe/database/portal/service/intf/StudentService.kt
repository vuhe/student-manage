package top.vuhe.database.portal.service.intf

import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.service.IService
import top.vuhe.database.entity.Student

interface StudentService : IService<Student> {
    /**
     * 按学号搜索学生信息
     * 默认学号为空时，返回全部信息
     *
     * @param page 页码
     * @param stuNum 学号
     * @return 查询结果
     */
    fun searchStudentPage(page: Int, stuNum: Int?): IPage<Student>
}