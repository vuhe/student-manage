package top.vuhe.database.portal.service.intf

import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.service.IService
import top.vuhe.database.common.ApiResponse
import top.vuhe.database.entity.Score

interface ScoreService : IService<Score> {
    /**
     * 按学号、课程号搜索成绩信息
     * 默认两者为空时，返回全部信息
     *
     * @param pageNum 页码
     * @param stuNum 学号
     * @param cozNum 课程号
     * @return 查询结果
     */
    fun searchScorePage(pageNum: Int, stuNum: String?, cozNum: String?): IPage<Score>

    /**
     * 添加成绩
     *
     * @param score 成绩实体
     * @return 是否添加成功
     */
    fun addScore(score: Score): ApiResponse<*>

    /**
     * 修改成绩
     *
     * @param score 成绩实体
     * @return 是否修改成功
     */
    fun modifyScore(score: Score): ApiResponse<*>

    /**
     * 删除成绩
     *
     * @param id 成绩id
     * @return 是否删除成功
     */
    fun deleteScore(id: Int): ApiResponse<*>
}