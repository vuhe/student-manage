package top.vuhe.database.config

import org.apache.shiro.mgt.SecurityManager
import org.apache.shiro.session.mgt.SessionManager
import org.apache.shiro.spring.LifecycleBeanPostProcessor
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor
import org.apache.shiro.spring.web.ShiroFilterFactoryBean
import org.apache.shiro.web.mgt.DefaultWebSecurityManager
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import top.vuhe.database.auth.OAuth2Filter
import top.vuhe.database.auth.OAuth2Realm
import javax.servlet.Filter

/**
 * Shiro 配置类
 *
 * @author: vuhe
 */
@Configuration
class ShiroConfig {
    @Bean("sessionManager")
    fun sessionManager(): SessionManager? {
        val sessionManager = DefaultWebSessionManager()
        // 是否定时检查session
        sessionManager.isSessionValidationSchedulerEnabled = false
        return sessionManager
    }

    @Bean("securityManager")
    fun securityManager(
        oAuth2Realm: OAuth2Realm?, sessionManager: SessionManager?
    ): SecurityManager? {
        val securityManager = DefaultWebSecurityManager()
        securityManager.setRealm(oAuth2Realm)
        securityManager.sessionManager = sessionManager
        return securityManager
    }

    @Bean("shiroFilter")
    fun shirFilter(securityManager: SecurityManager?): ShiroFilterFactoryBean {
        val shiroFilter = ShiroFilterFactoryBean()
        shiroFilter.securityManager = securityManager

        //oauth过滤
        val filters: MutableMap<String, Filter> = HashMap()
        filters["oauth2"] = OAuth2Filter
        shiroFilter.filters = filters
        val filterMap: MutableMap<String, String> = LinkedHashMap()
        // 两个url规则都可以匹配同一个url，只执行第一个
        filterMap["/api/login"] = "anon"
        filterMap["/api/**"] = "oauth2"
        // 其余都不进行验证
        filterMap["/**"] = "anon"
        shiroFilter.filterChainDefinitionMap = filterMap
        return shiroFilter
    }

    @Bean("lifecycleBeanPostProcessor")
    fun lifecycleBeanPostProcessor(): LifecycleBeanPostProcessor? {
        return LifecycleBeanPostProcessor()
    }

    @Bean
    fun defaultAdvisorAutoProxyCreator(): DefaultAdvisorAutoProxyCreator? {
        val proxyCreator = DefaultAdvisorAutoProxyCreator()
        proxyCreator.isProxyTargetClass = true
        return proxyCreator
    }

    @Bean
    fun authorizationAttributeSourceAdvisor(
        securityManager: SecurityManager?
    ): AuthorizationAttributeSourceAdvisor? {
        val advisor = AuthorizationAttributeSourceAdvisor()
        advisor.securityManager = securityManager
        return advisor
    }
}