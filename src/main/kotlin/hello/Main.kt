package hello

import com.google.inject.AbstractModule
import com.google.inject.Guice
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.locations.Locations
import java.text.DateFormat

class MainModule(private val application: Application) : AbstractModule() {
    override fun configure() {
        bind(Routes::class.java).asEagerSingleton()
        bind(Application::class.java).toInstance(application)
    }
}

/**
 * io.ktor.server.netty.DevelopmentEngine で実行してね
 */
fun Application.main() {
    val injector = Guice.createInjector(MainModule(this))
    val routes = injector.getInstance(Routes::class.java)

    install(Locations)
    install(ContentNegotiation) {
        gson {
            // Configure Gson here
            setDateFormat(DateFormat.LONG)

            // TODO 実運用では外すこと
            setPrettyPrinting()
        }
    }

    routes.setupRouting()
}
