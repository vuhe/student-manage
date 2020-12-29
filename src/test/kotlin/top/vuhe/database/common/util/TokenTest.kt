package top.vuhe.database.common.util

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TokenTest {
    @Test
    fun test() {
        println(generateValue())
        println(generateValue().length)
    }

    @Test
    fun test2() {
        println(sha256Hash("admin", "123456"))
    }

    @Test
    fun test3() {
        println(sha256Hash("201819914", "201819914"))
    }
}