package top.vuhe.database.portal.service.intf

import com.baomidou.mybatisplus.extension.service.IService
import top.vuhe.database.common.ApiResponse
import top.vuhe.database.entity.User

interface UserService : IService<User> {
    /**
     * 通过 token 查找用户
     *
     * @param token token
     * @return 用户实体
     */
    fun getUserByToken(token: String): User?

    /**
     * 登录
     *
     * @param user 用户名和密码
     * @return 是否登录成功以及 token
     */
    fun loginByUser(user: User): ApiResponse<User>

    /**
     * 登出
     *
     * @return 是否登出成功
     */
    fun logoutByUser():ApiResponse<*>

}