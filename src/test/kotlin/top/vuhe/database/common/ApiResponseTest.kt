package top.vuhe.database.common

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import top.vuhe.database.common.unit.toJson

@SpringBootTest
class ApiResponseTest {
    @Test
    fun test1() {
        val a = ApiResponse.ofSuccessWithDate("test", "3333")
        print(toJson(a))
    }
}