package ivan.diaz.dominguez.castingapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ivan.diaz.dominguez.castingapp.retrofit.*
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


class SeleccionCandidatosViewModel() : ViewModel() {
    var actors : List<Actor>? = null


    fun getActors(){

        val retrofit = Retrofit.Builder()
            .baseUrl("https://ghibliapi.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(GhibliService::class.java)
    }


}