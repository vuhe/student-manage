package top.vuhe.database.common.exception

/**
 * 系统错误 枚举
 *
 * @property code 错误代码
 * @property message 错误信息
 */
enum class ExceptionEnum(val code: Int, val message: String) {
    // 系统错误
    UNKNOWN(500, "系统内部错误，请联系管理员"),
    DATA_ERROR(501, "系统数据错误，请联系管理员"),
    TOKEN_GENERATOR_ERROR(502, "token 生成异常"),

    // 用户错误
    INPUT_ERROR(410, "客户端发送数据错误"),
    INVALID_TOKEN(411, "非法token"),
    INVALID_USER(412, "非法用户"),
    PASSWORD_WRONG(413, "密码错误"),
    CONSTRAINT_ERROR(420, "违反数据表约束")
}