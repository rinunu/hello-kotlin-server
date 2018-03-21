package hello.controller

import hello.service.MyService1
import io.ktor.application.ApplicationCall
import io.ktor.response.respond
import javax.inject.Inject

/**
 */
class MyController2 @Inject() constructor(
        private val myService1: MyService1) {

    data class MyJson2(
            val foo: String,
            val bar: Int
    )

    suspend fun index(call: ApplicationCall) {
        myService1.foo();

        call.respond(MyJson2("foo", 1))
    }
}
