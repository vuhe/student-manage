package top.vuhe.database.common.util

import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import javax.servlet.http.HttpServletRequest

fun getHttpServletRequest(): HttpServletRequest {
    return (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes?)!!.request
}

fun getDomain(): String {
    val request = getHttpServletRequest()
    val url = request.requestURL
    return url.delete(url.length - request.requestURI.length, url.length).toString()
}

fun getOrigin(): String? {
    val request = getHttpServletRequest()
    return request.getHeader("Origin")
}