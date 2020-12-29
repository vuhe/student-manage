package top.vuhe.database.portal.controller

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import top.vuhe.database.common.util.toJson
import top.vuhe.database.entity.Course

@SpringBootTest
class CourseControllerTest {
    @Autowired
    private lateinit var controller: CourseController

    @Test
    @Disabled
    fun search() {
        println(toJson(controller.searchCoursePage("test",1)))
    }

    @Test
    @Disabled
    fun save() {
        val course = Course(1, "test", "test", 3, 2.0)
        println(toJson(controller.saveCourse(course)))
    }

    @Test
    @Disabled
    fun delete() {
        println(toJson(controller.deleteCourse(1)))
    }
}