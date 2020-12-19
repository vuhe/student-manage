package top.vuhe.database.entity

/**
 * 用户类别
 *
 * @property id 主键
 * @property name 用户名
 * @property password 密码
 */
data class User(
    val id: Int,
    val name: String,
    val password: String
)
