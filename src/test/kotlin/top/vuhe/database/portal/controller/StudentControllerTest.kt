package top.vuhe.database.portal.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import top.vuhe.database.common.unit.JsonUnit

@SpringBootTest
class StudentControllerTest {
    @Autowired
    private lateinit var studentController: StudentController

    @Test
    fun test1() {
        println(JsonUnit.toJson(studentController.getStudentPage(1)))
    }
}