package top.vuhe.database.portal.controller

import com.baomidou.mybatisplus.core.metadata.IPage
import org.apache.shiro.authz.annotation.RequiresRoles
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
     * 按学号搜索成绩
     *
     * @param stuNum 学号
     * @param page 页码
     * @return 成绩信息
     */
    @RequiresRoles("Other")
    @GetMapping("/search_stu/{page}")
    fun searchScorePageByStu(
        @RequestParam("num") stuNum: String,
        @PathVariable page: Int
    ): ApiResponse<IPage<Score>> {
        val searchStdNum = if (stuNum == "") null else stuNum
        return ApiResponse.ofSuccessWithDate(
            "page",
            service.searchScorePage(page, searchStdNum, null)
        )
    }

    /**
     * 按课程号搜索成绩
     *
     * @param cozNum 课程号
     * @param page 页码
     * @return 成绩信息
     */
    @RequiresRoles("Other")
    @GetMapping("/search_coz/{page}")
    fun searchScorePagByCoz(
        @RequestParam("num") cozNum: String,
        @PathVariable page: Int
    ): ApiResponse<IPage<Score>> {
        val searchCozNum = if (cozNum == "") null else cozNum
        return ApiResponse.ofSuccessWithDate(
            "page",
            service.searchScorePage(page, null, searchCozNum)
        )
    }

    /**
     * 添加成绩
     *
     * @param score 成绩
     * @return 是否添加成功
     */
    @RequiresRoles("Admin")
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
    @RequiresRoles("Admin")
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
    @RequiresRoles("Admin")
    @DeleteMapping("/delete/{id}")
    fun deleteScore(@PathVariable id: Int): ApiResponse<*> {
        return service.deleteScore(id)
    }
}