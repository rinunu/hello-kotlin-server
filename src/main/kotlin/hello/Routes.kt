package hello

import hello.controller.MyController1
import hello.controller.MyController2
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.routing.get
import io.ktor.routing.routing
import javax.inject.Inject

/**
 *
 */
class Routes @Inject constructor(
        private val application: Application,
        private val myController1: MyController1,
        private val myController2: MyController2
) {
    fun setupRouting() {
        application.routing {
            get("/") {
                myController1.index(call)
            }

            get("/demo") {
                myController2.index(call)
            }
        }
    }
}
