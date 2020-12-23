package top.vuhe.database.auth

import org.apache.shiro.authc.*
import org.apache.shiro.authz.AuthorizationInfo
import org.apache.shiro.authz.SimpleAuthorizationInfo
import org.apache.shiro.realm.AuthorizingRealm
import org.apache.shiro.subject.PrincipalCollection
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import top.vuhe.database.entity.User
import top.vuhe.database.portal.service.intf.UserService

@Component
class OAuth2Realm: AuthorizingRealm() {
    @Autowired
    private lateinit var userService: UserService

    override fun supports(token: AuthenticationToken?): Boolean {
        return token is OAuth2Token
    }

    /**
     * 授权(验证权限时调用)
     */
    override fun doGetAuthorizationInfo(principals: PrincipalCollection?): AuthorizationInfo? {
        val user = principals!!.primaryPrincipal as User

        //用户角色列表
        val roleSet = setOf(user.role.toString())

        val info = SimpleAuthorizationInfo()
        info.roles = roleSet
        return info
    }

    /**
     * 认证(登录时调用)
     */
    @Throws(AuthenticationException::class)
    override fun doGetAuthenticationInfo(token: AuthenticationToken): AuthenticationInfo? {
        val accessToken = token.principal as String

        // 根据accessToken，查询用户
        // 若 token 失效，抛出异常
        val user = userService.getUserByToken(accessToken)
            ?: throw IncorrectCredentialsException("内部错误！")

        return SimpleAuthenticationInfo(user, accessToken, name)
    }
}