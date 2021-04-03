package top.vuhe.database.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Mapper
import org.springframework.stereotype.Repository
import top.vuhe.database.entity.Course

/**
 * 课程 Mapper 接口
 *
 * @author: vuhe
 */
@Mapper
@Repository
interface CourseMapper : BaseMapper<Course>
