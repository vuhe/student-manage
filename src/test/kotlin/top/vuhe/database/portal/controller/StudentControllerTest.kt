package top.vuhe.database.portal.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import top.vuhe.database.common.unit.JsonUnit
import top.vuhe.database.entity.Student
import java.util.*

@SpringBootTest
class StudentControllerTest {
    @Autowired
    private lateinit var studentController: StudentController

    @Test
    fun search() {
        println(JsonUnit.toJson(studentController.getStudentPage(1)))
        println(JsonUnit.toJson(studentController.searchStudentPage(1,1)))
    }

    @Test
    fun add() {
        val stu1 = Student(1,
            "3",
            "3",
            Student.Sex.female, Date(), "3", "3", "3")
        println(JsonUnit.toJson(studentController.addStudent(stu1)))
    }

    @Test
    fun modify() {
        val stu1 = Student(3,
            "4",
            "4",
            Student.Sex.male, Date(), "4", "3", "3")
        println(JsonUnit.toJson(studentController.modifyStudent(stu1)))
    }

    @Test
    fun delete() {
        println(JsonUnit.toJson(studentController.deleteStudent(3)))
    }
}