package ivan.diaz.dominguez.castingapp
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

import retrofit2.http.GET

object MyObject {
    val retrofitService: DataApiService by lazy { retrofit.create(DataApiService::class.java) }
}