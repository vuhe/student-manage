package top.vuhe.database.entity

/**
 * 成绩实体
 *
 * @property id 主键
 * @property stuNum 学号
 * @property cozNum 课程号
 * @property score 成绩
 * @property retestScore 补考成绩
 */
data class Score(
    val id: Int,
    val stuNum: String,
    val cozNum: String,
    val score: Int,
    val retestScore: Int
)
