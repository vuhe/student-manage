package top.vuhe.database.portal.controller

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import top.vuhe.database.common.util.toJson
import top.vuhe.database.entity.Score

@SpringBootTest
class ScoreControllerTest {
    @Autowired
    private lateinit var controller: ScoreController

    @Test
    @Disabled
    fun search() {
        println(toJson(controller.searchScorePagByCoz("", 1)))
    }

    @Test
    @Disabled
    fun save() {
        val score = Score(1, "1", "test", "40", 60, null)
        println(toJson(controller.saveScore(score)))
    }

    @Test
    @Disabled
    fun delete() {
        println(toJson(controller.deleteScore(1)))
    }
}