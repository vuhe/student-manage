package top.vuhe.database.portal.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import top.vuhe.database.common.unit.JsonUnit
import top.vuhe.database.entity.Score

@SpringBootTest
class ScoreControllerTest {
    @Autowired
    private lateinit var controller: ScoreController

    @Test
    fun search() {
        println(JsonUnit.toJson(controller.getScorePage(1)))
    }

    @Test
    fun add() {
        val score = Score(1, "1", "test", 40, 60)
        println(JsonUnit.toJson(controller.addScore(score)))
    }

    @Test
    fun modify() {
        val score = Score(1, "1", "test", 40, 90)
        println(JsonUnit.toJson(controller.modifyScore(score)))
    }

    @Test
    fun delete() {
        println(JsonUnit.toJson(controller.deleteScore(1)))
    }
}