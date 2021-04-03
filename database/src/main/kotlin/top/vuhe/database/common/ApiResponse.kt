package top.vuhe.database.common

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import top.vuhe.database.common.exception.ExceptionEnum
import top.vuhe.database.common.exception.SystemProcessingException

@JsonSerialize(using = ApiResponseSerializer::class)
class ApiResponse<T> private constructor(
    val code: Int,
    val message: String,
    val name: String,
    val data: T?
) {
    companion object {
        fun <T> of(code: Int, message: String, name: String, data: T?): ApiResponse<T> {
            return ApiResponse(code, message, name, data)
        }

        fun of(code: Int, message: String): ApiResponse<*> {
            return of<Any>(code, message, "", null)
        }

        fun ofSuccess(): ApiResponse<*> {
            return of(200, "success")
        }

        fun <T> ofSuccessWithDate(name: String, date: T): ApiResponse<T> {
            return of(200, "success", name, date)
        }

        fun ofException(e: SystemProcessingException): ApiResponse<*> {
            return of(e.code, e.msg)
        }

        fun ofExceptionEnum(e: ExceptionEnum): ApiResponse<*> {
            return of(e.code, e.message)
        }
    }
}