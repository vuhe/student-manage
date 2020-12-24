package top.vuhe.database.portal.service.impl

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import org.apache.shiro.SecurityUtils
import org.springframework.stereotype.Service
import top.vuhe.database.common.ApiResponse
import top.vuhe.database.common.exception.ExceptionEnum
import top.vuhe.database.common.util.generateValue
import top.vuhe.database.common.util.sha256Hash
import top.vuhe.database.entity.User
import top.vuhe.database.mapper.UserMapper
import top.vuhe.database.portal.service.intf.UserService

@Service("UserService")
class UserServiceImpl : ServiceImpl<UserMapper, User>(), UserService {
    override fun getUserByToken(token: String): User? {
        val queryWrapper = QueryWrapper<User>()
        queryWrapper.eq("token", token)
            .last("LIMIT 1")
        return getOne(queryWrapper) ?: null
    }

    override fun loginByUser(user: User): ApiResponse<User> {
        // 向数据库查询用户
        val queryWrapper = QueryWrapper<User>()
        queryWrapper.eq("name", user.name)
            .last("LIMIT 1")

        // 检查用户是否存在
        val checkedUser = getOne(queryWrapper)
            ?: return ApiResponse.of(
                ExceptionEnum.INVALID_USER.code,
                ExceptionEnum.INVALID_USER.message,
                "", null
            )

        // 检查密码是否正确
        if (checkedUser.password != sha256Hash(user.name, user.password)) {
            return ApiResponse.of(
                ExceptionEnum.PASSWORD_WRONG.code,
                ExceptionEnum.PASSWORD_WRONG.message,
                "", null
            )
        }

        val returnUser = checkedUser.copy(token = generateValue())

        // 更新数据库的 token
        if (updateById(returnUser).not()) {
            return ApiResponse.of(
                ExceptionEnum.UNKNOWN.code,
                ExceptionEnum.UNKNOWN.message,
                "", null
            )
        }

        return ApiResponse.ofSuccessWithDate("user", returnUser)
    }

    override fun logoutByUser(): ApiResponse<*> {
        val user = SecurityUtils.getSubject().principal as User
        val logoutUser = user.copy(token = "null")

        // 更新数据库的 token
        if (updateById(logoutUser).not()) {
            return ApiResponse.ofExceptionEnum(ExceptionEnum.UNKNOWN)
        }

        return ApiResponse.ofSuccess()
    }
}