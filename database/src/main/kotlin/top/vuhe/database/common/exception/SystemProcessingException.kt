package top.vuhe.database.common.exception

import java.lang.RuntimeException

class SystemProcessingException : RuntimeException {
    val msg: String
    val code: Int

    constructor() : super(ExceptionEnum.UNKNOWN.message) {
        this.code = 500
        this.msg = ExceptionEnum.UNKNOWN.message
    }

    constructor(eEnum: ExceptionEnum) {
        this.code = eEnum.code
        this.msg = eEnum.message
    }

    constructor(e: String) {
        this.code = 500
        this.msg = e
    }

    constructor(eEnum: ExceptionEnum, e: Throwable) : super(eEnum.message, e) {
        this.code = eEnum.code
        this.msg = eEnum.message
    }

}
