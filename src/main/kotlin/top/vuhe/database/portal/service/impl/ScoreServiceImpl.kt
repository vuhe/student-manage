package top.vuhe.database.portal.service.impl

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import org.springframework.stereotype.Service
import top.vuhe.database.common.ApiResponse
import top.vuhe.database.common.exception.ExceptionEnum
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

    override fun addScore(score: Score): ApiResponse<*> {
        // id 由数据库设定
        // 此处 id 置空
        val ans = save(score.copy(id = null))
        // 检验结果
        return if (ans) {
            ApiResponse.ofSuccess()
        } else {
            ApiResponse.ofExceptionEnum(ExceptionEnum.DATA_ERROR)
        }
    }

    override fun modifyScore(score: Score): ApiResponse<*> {
        val ans = updateById(score)
        // 检验结果
        return if (ans) {
            ApiResponse.ofSuccess()
        } else {
            ApiResponse.ofExceptionEnum(ExceptionEnum.INPUT_ERROR)
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