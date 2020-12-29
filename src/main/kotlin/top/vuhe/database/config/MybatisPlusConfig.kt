package top.vuhe.database.config

import com.baomidou.mybatisplus.annotation.DbType
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MybatisPlusConfig {
    /**
     * 新的分页插件, 一缓和二缓遵循 mybatis 的规则, 需要设置
     * MybatisConfiguration#useDeprecatedExecutor = false
     * 避免缓存出现问题(该属性会在旧插件移除后一同移除)
     */
    @Bean
    fun paginationInterceptor(): MybatisPlusInterceptor {
        val interceptor = MybatisPlusInterceptor()
        //分页配置
        interceptor.addInnerInterceptor(PaginationInnerInterceptor(DbType.MYSQL))
        return interceptor
    }
}