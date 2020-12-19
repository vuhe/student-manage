package top.vuhe.database.common.exception

import org.slf4j.LoggerFactory
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

    @ExceptionHandler(SystemProcessingException::class)
    fun handleMyException(e: SystemProcessingException): ApiResponse<*> {
        return ApiResponse.ofException(e)
    }

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ApiResponse<*> {
        log.error(e.message, e)
        return ApiResponse.ofExceptionEnum(ExceptionEnum.UNKNOWN)
    }
}