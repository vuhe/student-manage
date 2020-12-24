package top.vuhe.database.auth

import org.apache.shiro.authc.AuthenticationException
import org.apache.shiro.authc.AuthenticationToken
import org.apache.shiro.web.filter.authc.AuthenticatingFilter
import org.springframework.util.StringUtils
import org.springframework.web.bind.annotation.RequestMethod
import top.vuhe.database.common.ApiResponse
import top.vuhe.database.common.exception.ExceptionEnum
import top.vuhe.database.common.util.getOrigin
import top.vuhe.database.common.util.toJson
import java.lang.Exception
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

object OAuth2Filter : AuthenticatingFilter() {
    override fun createToken(
        request: ServletRequest?, response: ServletResponse?
    ): AuthenticationToken? {
        //获取请求token
        val token: String = getRequestToken(request as HttpServletRequest?) ?: ""

        return if (StringUtils.hasLength(token).not()) {
            null
        } else OAuth2Token(token)

    }

    override fun isAccessAllowed(
        request: ServletRequest, response: ServletResponse?, mappedValue: Any?
    ): Boolean {
        return (request as HttpServletRequest).method == RequestMethod.OPTIONS.name
    }

    override fun onAccessDenied(
        request: ServletRequest?, response: ServletResponse?
    ): Boolean {
        //获取请求token，如果token不存在，直接返回411
        val token: String = getRequestToken(request as HttpServletRequest?) ?: ""
        if (StringUtils.hasLength(token).not()) {
            val httpResponse = response as HttpServletResponse
            httpResponse.setHeader("Access-Control-Allow-Credentials", "true")
            httpResponse.setHeader("Access-Control-Allow-Origin", getOrigin())
            val json: String = toJson(
                ApiResponse.ofExceptionEnum(ExceptionEnum.INVALID_TOKEN)
            )
            httpResponse.writer.print(json)
            return false
        }

        return executeLogin(request, response)
    }

    override fun onLoginFailure(
        token: AuthenticationToken?,
        e: AuthenticationException,
        request: ServletRequest?,
        response: ServletResponse
    ): Boolean {
        val httpResponse = response as HttpServletResponse
        httpResponse.contentType = "application/json;charset=utf-8"
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true")
        httpResponse.setHeader("Access-Control-Allow-Origin", getOrigin())
        try {
            //处理登录失败的异常
            val throwable = if (e.cause == null) e else e.cause!!
            val r = ApiResponse.of(ExceptionEnum.INVALID_TOKEN.code, throwable.message ?: "")
            val json = toJson(r)
            httpResponse.writer.print(json)
        } catch (e1: Exception) {
            e1.printStackTrace()
        }
        return false
    }

    /**
     * 获取请求的token
     */
    private fun getRequestToken(httpRequest: HttpServletRequest?): String? {
        //从header中获取token
        var token = httpRequest?.getHeader("token")

        //如果header中不存在token，则从参数中获取token
        if (StringUtils.hasLength(token).not()) {
            token = httpRequest?.getParameter("token")
        }
        return token
    }

}