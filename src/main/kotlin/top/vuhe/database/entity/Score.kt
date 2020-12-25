package top.vuhe.database.entity

import com.baomidou.mybatisplus.annotation.FieldStrategy
import com.baomidou.mybatisplus.annotation.TableField

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
    val id: Int?,
    val stuNum: String,
    val cozNum: String,
    val cozName: String,
    val score: Int,
    @field:TableField(
        insertStrategy = FieldStrategy.IGNORED,
        updateStrategy = FieldStrategy.IGNORED
    )
    val retestScore: Int?
)
