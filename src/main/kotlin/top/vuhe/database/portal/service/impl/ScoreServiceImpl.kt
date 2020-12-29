package top.vuhe.database.portal.service.impl

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import top.vuhe.database.common.ApiResponse
import top.vuhe.database.common.exception.ExceptionEnum
import top.vuhe.database.common.exception.SystemProcessingException
import top.vuhe.database.entity.Course
import top.vuhe.database.entity.Score
import top.vuhe.database.mapper.ScoreMapper
import top.vuhe.database.portal.service.intf.CourseService
import top.vuhe.database.portal.service.intf.ScoreService

@Service("ScoreService")
class ScoreServiceImpl : ServiceImpl<ScoreMapper, Score>(), ScoreService {
    @Autowired
    private lateinit var course: CourseService

    override fun searchScorePage(
        pageNum: Int,
        stuNum: String?,
        cozNum: String?
    ): IPage<Score> {
        val page = Page<Score>(pageNum.toLong(), 10)
        val queryWrapper = QueryWrapper<Score>()
        if (stuNum != null) {
            queryWrapper.like("stu_num", stuNum)
        }
        if (cozNum != null) {
            queryWrapper.like("coz_num", cozNum)
        }
        // 按 id 倒序排列
        queryWrapper.orderByDesc("id")
        return page(page, queryWrapper)
    }

    override fun getScore(id: Int): Score {
        return getById(id)
            ?: throw SystemProcessingException(ExceptionEnum.INPUT_ERROR)
    }

    override fun saveScore(score: Score): ApiResponse<*> {
        // 查课程名
        val queryWrapper = QueryWrapper<Course>()
            .eq("coz_num", score.cozNum)
            .last("LIMIT 1")
        val c = course.getOne(queryWrapper)
            ?: throw SystemProcessingException(ExceptionEnum.INPUT_ERROR)

        // 设置插入对象
        val ans = if (score.id == 0) {
            // id 由数据库设定
            // 此处 id 置空
            save(score.copy(id = null, cozName = c.cozName))
        } else {
            updateById(score.copy(cozName = c.cozName))
        }

        // 检验结果
        return if (ans) {
            ApiResponse.ofSuccess()
        } else {
            ApiResponse.ofExceptionEnum(ExceptionEnum.DATA_ERROR)
        }
    }

    override fun deleteScore(id: Int): ApiResponse<*> {
        val ans = removeById(id)
        // 检验结果
        return if (ans) {
            ApiResponse.ofSuccess()
        } else {
            ApiResponse.ofExceptionEnum(ExceptionEnum.INPUT_ERROR)
        }
    }
}