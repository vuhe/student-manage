package top.vuhe.database.common.unit

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.IOException

/**
 * Json 工具类
 * 依赖 jackson
 *
 * @author: vuhe
 */
object JsonUnit {
    val log: Logger = LoggerFactory.getLogger(JsonUnit::class.java)
    val objMapper = jacksonObjectMapper()

    /**
     * Json 字符串转化成对象
     *
     * @param T 目前类
     * @param jsonString json 字符串
     * @return 目标类
     */
    inline fun <reified T> toObj(jsonString: String): T? {
        objMapper.configure(
            DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY,
            true
        )
        try {
            return objMapper.readValue<T>(jsonString)
        } catch (e: IOException) {
            log.error("Json字符串转化成对象出错", e)
        }
        return null
    }

    /**
     * javaBean 转化成json字符串
     *
     * @param obj 对象
     * @return json字符串
     */
    fun toJson(obj: Any): String? {
        if (obj is Number || obj is Boolean || obj is String) {
            return obj.toString()
        }
        try {
            return objMapper.writeValueAsString(obj)
        } catch (e: JsonProcessingException) {
            log.error("转化成json字符串出错", e)
        }
        return null
    }
}