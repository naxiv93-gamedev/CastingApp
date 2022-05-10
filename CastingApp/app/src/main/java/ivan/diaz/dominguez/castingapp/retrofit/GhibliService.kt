package ivan.diaz.dominguez.castingapp.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GhibliService {
    @GET("people")
    suspend fun listActors (): List<Actor>
}