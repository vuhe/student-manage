package top.vuhe.database.entity

import java.util.*

/**
 * 学生实体
 *
 * @property id 主键
 * @property stuNum 学号
 * @property stuName 学生姓名
 * @property stuSex 性别
 * @property stuBirthday 生日
 * @property stuClass 班级
 * @property stuProfession 专业
 * @property stuDepartment 系别
 */
data class Student(
    val id: Int?,
    val stuNum: String,
    val stuName: String,
    val stuSex: Sex,
    val stuBirthday: Date,
    val stuClass: String,
    val stuProfession: String,
    val stuDepartment: String
) {
    enum class Sex(val value: String) {
        male("男"), female("女")
    }
}
