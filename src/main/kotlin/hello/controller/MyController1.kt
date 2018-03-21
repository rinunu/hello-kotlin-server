package hello.controller

import hello.service.MyService1
import io.ktor.application.ApplicationCall
import io.ktor.response.respond
import javax.inject.Inject

/**
 */
class MyController1 @Inject() constructor(
        private val myService1: MyService1) {

    data class MyJson1(
            val hello: String,
            val world: Int
    )

    suspend fun index(call: ApplicationCall) {
        myService1.foo();

        call.respond(MyJson1("controller 1!", 1))
    }
}
