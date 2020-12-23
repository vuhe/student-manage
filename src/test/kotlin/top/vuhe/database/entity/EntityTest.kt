package top.vuhe.database.entity

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class EntityTest {
    @Test
    fun test() {
        println(User.Role.Admin.toString())
        println(User.Role.Other.toString())
    }
}