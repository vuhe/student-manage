package top.vuhe.database.portal.service.impl

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import org.springframework.stereotype.Service
import top.vuhe.database.entity.Course
import top.vuhe.database.mapper.CourseMapper
import top.vuhe.database.portal.service.intf.CourseService

@Service("CourseService")
class CourseServiceImpl: ServiceImpl<CourseMapper, Course>(), CourseService {
}