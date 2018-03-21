package hello.service

import org.slf4j.LoggerFactory
import javax.inject.Singleton

/**
 */
@Singleton
class MyService1() {
    private val logger = LoggerFactory.getLogger(MyService1::class.java)

    fun foo() {
    }

    init {
        logger.debug("construct")
    }
}
