package top.vuhe.database.portal.controller

import com.baomidou.mybatisplus.core.metadata.IPage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import top.vuhe.database.common.ApiResponse
import top.vuhe.database.entity.Score
import top.vuhe.database.portal.service.intf.ScoreService

@RestController
@RequestMapping("/api/score")
class ScoreController {
    @Autowired
    private lateinit var service: ScoreService

    /**
     * 默认获取列表
     *
     * @param page 页码
     * @return 成绩信息
     */
    @GetMapping("/get/{page}")
    fun getScorePage(@PathVariable page: Int): ApiResponse<IPage<Score>> {
        // TODO-处理成绩返回值
        return ApiResponse.ofSuccessWithDate(
            "page",
            service.searchScorePage(page, null, null)
        )
    }

    /**
     * 按学号搜索成绩
     *
     * @param stuNum 学号
     * @param page 页码
     * @return 成绩信息
     */
    @GetMapping("/search_stu/{page}")
    fun searchScorePageByStu(
        @RequestBody stuNum: String,
        @PathVariable page: Int
    ): ApiResponse<IPage<Score>> {
        return ApiResponse.ofSuccessWithDate(
            "page",
            service.searchScorePage(page, stuNum, null)
        )
    }

    /**
     * 按课程号搜索成绩
     *
     * @param cozNum 课程号
     * @param page 页码
     * @return 成绩信息
     */
    @GetMapping("/search_coz/{page}")
    fun searchScorePagByCoz(
        @RequestBody cozNum: String,
        @PathVariable page: Int
    ): ApiResponse<IPage<Score>> {
        return ApiResponse.ofSuccessWithDate(
            "page",
            service.searchScorePage(page, null, cozNum)
        )
    }

    /**
     * 添加成绩
     *
     * @param score 成绩
     * @return 是否添加成功
     */
    @PostMapping("/add")
    fun addScore(@RequestBody score: Score): ApiResponse<*> {
        return service.addScore(score)
    }

    /**
     * 修改成绩
     *
     * @param score 成绩
     * @return 是否修改成功
     */
    @PutMapping("/modify")
    fun modifyScore(@RequestBody score: Score): ApiResponse<*> {
        return service.modifyScore(score)
    }

    /**
     * 删除成绩
     *
     * @param id 编号
     * @return 是否删除成功
     */
    @DeleteMapping("/delete/{id}")
    fun deleteScore(@PathVariable id: Int): ApiResponse<*> {
        return service.deleteScore(id)
    }
}