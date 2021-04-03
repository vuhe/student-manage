package top.vuhe.database.common.util

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.*

internal val objMapper = jacksonObjectMapper()

/**
 * Json 字符串转化成对象
 *
 * @param T 目前类
 * @param jsonString json 字符串
 * @return 目标类
 */
internal inline fun <reified T> toObj(jsonString: String): T {
    objMapper.configure(
        DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY,
        true
    )
    return objMapper.readValue(jsonString)
}

/**
 * javaBean 转化成json字符串
 *
 * @param obj 对象
 * @return json字符串
 */
internal fun toJson(obj: Any): String {
    if (obj is Number || obj is Boolean || obj is String) {
        return obj.toString()
    }
    return objMapper.writeValueAsString(obj)
}