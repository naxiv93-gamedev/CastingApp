package ivan.diaz.dominguez.castingapp
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class GameViewModel : ViewModel() {
    //-------------Retrofit
    private val _status = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _status
    private val _property = MutableLiveData<MyProperty>()
    val property: LiveData<MyProperty>
        get() = _property
    private val _texto = MutableLiveData<String>()
    val texto: LiveData<String>
        get() = _texto

    private fun getEstateProperties() {
        viewModelScope.launch {
            try {
                val listResult = MyObject.retrofitService.getProperties()
                _status.value = "Success: ${listResult.size}  properties retrieved"//todos los datos
                if (listResult.isNotEmpty()) {
                    _property.value = listResult.random()//dato aleatorio
                    _texto.value = property.value.toString()
                    Log.i("Recibe:::", _texto.value.toString())
                }
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}
//---