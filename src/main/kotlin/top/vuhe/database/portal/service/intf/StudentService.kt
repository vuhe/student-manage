package top.vuhe.database.portal.service.intf

import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.service.IService
import top.vuhe.database.common.ApiResponse
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
    fun searchStudentPage(page: Int, stuNum: String?): IPage<Student>

    /**
     * 添加学生
     *
     * @param student 学生实体
     * @return 是否添加成功
     */
    fun addStudent(student: Student): ApiResponse<*>

    /**
     * 修改学生
     *
     * @param student 学生实体
     * @return 是否修改成功
     */
    fun modifyStudent(student: Student): ApiResponse<*>

    /**
     * 删除学生
     *
     * @param id 学生id
     * @return 是否删除成功
     */
    fun deleteStudent(id: Int): ApiResponse<*>
}