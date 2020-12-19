package top.vuhe.database.common.exception

/**
 * 系统错误 枚举
 *
 * @property code 错误代码
 * @property message 错误信息
 */
enum class ExceptionEnum(val code: Int, val message: String) {
    // 系统错误
    UNKNOWN(500, "系统内部错误，请联系管理员")
}