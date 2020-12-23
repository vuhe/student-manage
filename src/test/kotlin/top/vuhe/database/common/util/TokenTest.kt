package top.vuhe.database.common.util

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TokenTest {
    @Test
    fun test() {
        println(generateValue())
        println(generateValue()?.length)
    }
}