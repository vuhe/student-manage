package top.vuhe.database.portal.controller

import org.apache.shiro.authz.annotation.RequiresRoles
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import top.vuhe.database.common.ApiResponse
import top.vuhe.database.entity.User
import top.vuhe.database.portal.service.intf.UserService

@RestController
@RequestMapping("/api")
class UserController {
    @Autowired
    private lateinit var service: UserService

    /**
     * 登录
     *
     * @param user 用户名和密码
     * @return 是否登录成功
     */
    @PostMapping("/login")
    fun login(@RequestBody user: User): ApiResponse<User> {
        return service.loginByUser(user)
    }

    /**
     * 检查token
     *
     * @return 检查结果
     */
    @RequiresRoles("Other")
    @GetMapping("/check_token")
    fun checkToken(): ApiResponse<*> {
        return ApiResponse.ofSuccess()
    }

    /**
     * 登出
     *
     * @return 是否登出成功
     */
    @RequiresRoles("Other")
    @PostMapping("/logout")
    fun logout(): ApiResponse<*> {
        return service.logoutByUser()
    }

}