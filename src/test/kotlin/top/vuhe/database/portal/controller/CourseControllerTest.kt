package top.vuhe.database.portal.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import top.vuhe.database.common.unit.JsonUnit
import top.vuhe.database.entity.Course

@SpringBootTest
class CourseControllerTest {
    @Autowired
    private lateinit var controller: CourseController

    @Test
    fun search() {
        println(JsonUnit.toJson(controller.getCoursePage(1)))
        println(JsonUnit.toJson(controller.searchCoursePage("test",1)))
    }

    @Test
    fun add() {
        val course = Course(1, "test", "test", 3, 2.0)
        println(JsonUnit.toJson(controller.addCourse(course)))
    }

    @Test
    fun modify() {
        val course = Course(1, "test2", "test2", 4, 2.0)
        println(JsonUnit.toJson(controller.modifyCourse(course)))
    }

    @Test
    fun delete() {
        println(JsonUnit.toJson(controller.deleteCourse(1)))
    }
}