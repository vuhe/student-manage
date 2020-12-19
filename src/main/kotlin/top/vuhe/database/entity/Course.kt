package top.vuhe.database.entity

/**
 * 课程实体
 *
 * @property id 主键
 * @property cozNum 课程号
 * @property cozName 课程名
 * @property cozTime 学时
 * @property cozPoint 学分
 */
data class Course(
    val id: Int?,
    val cozNum: String,
    val cozName: String,
    val cozTime: Int,
    val cozPoint: Double
)
