package com.example.monitoring.api

import com.example.monitoring.util.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import java.util.UUID
import javax.sql.DataSource

@RestController
class TrafficController {

    @Autowired
    private lateinit var dataSource: DataSource

    val list = mutableListOf<String>()

    /* 그라파나 CPU 변화 확인 */
    @GetMapping("/cpu")
    fun cpu(): String {

        var count = 0
        repeat(LOOP_VALUE) {
            count++
        }

        return "ok value = $count"
    }

    /* 그라파나 JVM 변화 확인 */
    @GetMapping("/jvm")
    fun jvm(): String {

        repeat(LOOP_VALUE) {
            list.add("JVM_UID_${UUID.randomUUID()}")
        }

        return "ok list size = ${list.size}"
    }

    /* 그라파나 데이터베이스 커넥션 변화 확인 */
    @GetMapping("/db")
    fun connection(): String {

        val connection = dataSource.getConnection()

        log.info("connection name = $connection")

        return "ok"
    }

    /* 그라파나 에러 로그 */
    @GetMapping("/error")
    fun error(): String {
        log.error("error time = ${LocalDateTime.now()}")

        return "ok"
    }

    companion object : Logger() {
        const val LOOP_VALUE = 1_000_000_000
    }

}