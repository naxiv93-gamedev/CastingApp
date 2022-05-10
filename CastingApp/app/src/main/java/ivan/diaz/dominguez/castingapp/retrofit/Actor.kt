package ivan.diaz.dominguez.castingapp.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Actor (
    val id : String,
    val name: String,
    val gender : String,
    val age : Number,
    @Expose @SerializedName("eye_color") val eyeColor : String,
    @Expose @SerializedName("hair_color") val hairColor : String
)