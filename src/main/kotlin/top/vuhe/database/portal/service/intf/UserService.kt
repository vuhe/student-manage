package top.vuhe.database.portal.service.intf

import com.baomidou.mybatisplus.extension.service.IService
import top.vuhe.database.entity.User

interface UserService : IService<User> {
    /**
     * 通过 token 查找用户
     *
     * @param token token
     * @return 用户实体
     */
    fun getUserByToken(token: String): User?

}