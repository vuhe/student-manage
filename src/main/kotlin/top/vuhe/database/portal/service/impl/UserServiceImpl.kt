package top.vuhe.database.portal.service.impl

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import org.springframework.stereotype.Service
import top.vuhe.database.entity.User
import top.vuhe.database.mapper.UserMapper
import top.vuhe.database.portal.service.intf.UserService

@Service("UserService")
class UserServiceImpl : ServiceImpl<UserMapper, User>(), UserService {
}