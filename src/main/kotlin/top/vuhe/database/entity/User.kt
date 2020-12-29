package top.vuhe.database.entity

import com.baomidou.mybatisplus.annotation.FieldStrategy
import com.baomidou.mybatisplus.annotation.TableField

/**
 * 用户类别
 *
 * @property id 主键
 * @property name 用户名
 * @property password 密码
 */
data class User(
    val id: Int?,
    val name: String,
    val password: String,
    @field:TableField(
        insertStrategy = FieldStrategy.IGNORED,
        updateStrategy = FieldStrategy.IGNORED
    )
    val token: String?,
    val role: Role
) {
    enum class Role {
        Admin, Other
    }
}
