package top.vuhe.database.common.exception

import org.slf4j.LoggerFactory
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import top.vuhe.database.common.ApiResponse

/**
 * 统一异常处理器
 *
 * @author vuhe
 */
@RestControllerAdvice
class SystemProcessingExceptionHandler {
    companion object {
        private val log = LoggerFactory.getLogger(SystemProcessingExceptionHandler::class.java)
    }

    /**
     * 处理自己抛出的异常
     */
    @ExceptionHandler(SystemProcessingException::class)
    fun handleMyException(e: SystemProcessingException): ApiResponse<*> {
        return ApiResponse.ofException(e)
    }

    /**
     * 处理 数据库约束 异常
     */
    @ExceptionHandler(DataIntegrityViolationException::class)
    fun handleConstraintException(e: DataIntegrityViolationException): ApiResponse<*> {
        return ApiResponse.ofExceptionEnum(ExceptionEnum.CONSTRAINT_ERROR)
    }

    /**
     * 处理 非法数据 异常
     */
    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleEmptyData(e : HttpMessageNotReadableException) : ApiResponse<*> {
        return ApiResponse.ofExceptionEnum(ExceptionEnum.INVALID_DATA)
    }

    /**
     * 其它异常拦截
     */
    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ApiResponse<*> {
        log.error(e.message, e)
        return ApiResponse.ofExceptionEnum(ExceptionEnum.UNKNOWN)
    }
}