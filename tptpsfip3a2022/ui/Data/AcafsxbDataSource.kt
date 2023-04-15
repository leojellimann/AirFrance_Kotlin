import com.shindra.aero.tptpsfip3a2022.Data.NetworkData.NetworkLimitPlane
import com.shindra.aero.tptpsfip3a2022.ui.Data.NetworkClubPlanes
import com.shindra.aero.tptpsfip3a2022.ui.Data.NetworkSpecificPlane
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

class AcafsxbDataSource {
    private val client : HttpClient = HttpClient(OkHttp) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
        defaultRequest {
            url.host = "android-2022-5f166-default-rtdb.europe-west1.firebasedatabase.app"
            url.protocol = URLProtocol.HTTPS
            url.encodedPath = url.encodedPath
        }
    }

    suspend fun planesInfo(): NetworkClubPlanes {
        return withContext(Dispatchers.IO) {//execute the code on a different thread
            client.get("planesInfo.json").body()
        }
    }

    suspend fun specificPlanesInfo(registration: String): NetworkSpecificPlane {
        return withContext(Dispatchers.IO) {//execute the code on a different thread
            client.get("planesBalanceInputs/$registration.json").body()
        }
    }

    suspend fun limitPlanesInfo(registration: String): NetworkLimitPlane {
        return withContext(Dispatchers.IO) {//execute the code on a different thread
            client.get("planesTechnicalInfo/$registration.json").body()
        }
    }
}
