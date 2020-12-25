package top.vuhe.database.portal.service.impl

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import org.springframework.stereotype.Service
import top.vuhe.database.common.ApiResponse
import top.vuhe.database.common.exception.ExceptionEnum
import top.vuhe.database.common.exception.SystemProcessingException
import top.vuhe.database.entity.Score
import top.vuhe.database.mapper.ScoreMapper
import top.vuhe.database.portal.service.intf.ScoreService

@Service("ScoreService")
class ScoreServiceImpl : ServiceImpl<ScoreMapper, Score>(), ScoreService {
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
        val ans = if (score.id == 0) {
            // id 由数据库设定
            // 此处 id 置空
            save(score.copy(id = null))
        } else {
            updateById(score)
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