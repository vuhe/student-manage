package top.vuhe.database.portal.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import top.vuhe.database.common.unit.toJson
import top.vuhe.database.entity.Student
import java.util.*

@SpringBootTest
class StudentControllerTest {
    @Autowired
    private lateinit var controller: StudentController

    @Test
    fun search() {
        println(toJson(controller.getStudentPage(1)))
        println(toJson(controller.searchStudentPage("1",1)))
    }

    @Test
    fun add() {
        val stu1 = Student(1,
            "3",
            "3",
            Student.Sex.female, Date(), "3", "3", "3")
        println(toJson(controller.addStudent(stu1)))
    }

    @Test
    fun modify() {
        val stu1 = Student(3,
            "4",
            "4",
            Student.Sex.male, Date(), "4", "3", "3")
        println(toJson(controller.modifyStudent(stu1)))
    }

    @Test
    fun delete() {
        println(toJson(controller.deleteStudent(3)))
    }
}