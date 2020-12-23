package top.vuhe.database.common.util

import top.vuhe.database.common.exception.ExceptionEnum
import top.vuhe.database.common.exception.SystemProcessingException
import java.lang.Exception
import java.security.MessageDigest
import java.util.*

private val hexCode = "0123456789abcdef".toCharArray()

fun generateValue(): String? {
    return generateValue(UUID.randomUUID().toString())
}

private fun generateValue(param: String): String? {
    return try {
        val algorithm = MessageDigest.getInstance("MD5")
        algorithm.reset()
        algorithm.update(param.toByteArray())
        val messageDigest = algorithm.digest()
        toHexString(messageDigest)
    } catch (e: Exception) {
        throw SystemProcessingException(ExceptionEnum.TOKEN_GENERATOR_ERROR, e)
    }
}

private fun toHexString(data: ByteArray?): String? {
    if (data == null) {
        return null
    }
    val r = StringBuilder(data.size * 2)
    for (b in data) {
        r.append(hexCode[(b.toInt() shr 4) and 0xF])
        r.append(hexCode[(b.toInt() and 0xF)])
    }
    return r.toString()
}