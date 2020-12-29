package top.vuhe.database.auth

import org.apache.shiro.authc.AuthenticationToken

class OAuth2Token(
    private val token: String
) : AuthenticationToken {
    override fun getPrincipal(): String {
        return token
    }

    override fun getCredentials(): Any {
        return token
    }
}