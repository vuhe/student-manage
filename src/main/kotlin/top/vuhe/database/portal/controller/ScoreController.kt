package top.vuhe.database.portal.controller

import org.springframework.web.bind.annotation.*
import top.vuhe.database.common.ApiResponse
import top.vuhe.database.entity.Score

@RestController
@RequestMapping("/api/score")
class ScoreController {
    /**
     * 默认获取列表
     *
     * @param page 页码
     * @return 成绩信息
     */
    @GetMapping("/get/{page}")
    fun getScorePage(@PathVariable page: Int): ApiResponse<Score> {
        // TODO-处理成绩返回值
        return ApiResponse.ofSuccessWithDate(
            "page",
            Score(1, " ", " ", 30, 30)
        )
    }

    /**
     * 按编号搜索成绩
     *
     * @param id 编号
     * @param page 页码
     * @return 成绩信息
     */
    @GetMapping("/search/{page}")
    fun searchScorePage(@RequestBody id: Int, @PathVariable page: Int): ApiResponse<Score> {
        return ApiResponse.ofSuccessWithDate(
            "page",
            Score(1, " ", " ", 30, 30)
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
        return ApiResponse.ofSuccess()
    }

    /**
     * 修改成绩
     *
     * @param score 成绩
     * @return 是否修改成功
     */
    @PutMapping("/modify")
    fun modifyScore(@RequestBody score: Score): ApiResponse<*> {
        return ApiResponse.ofSuccess()
    }

    /**
     * 删除成绩
     *
     * @param id 编号
     * @return 是否删除成功
     */
    @DeleteMapping("/delete/{id}")
    fun deleteScore(@PathVariable id: Int): ApiResponse<*> {
        return ApiResponse.ofSuccess()
    }
}