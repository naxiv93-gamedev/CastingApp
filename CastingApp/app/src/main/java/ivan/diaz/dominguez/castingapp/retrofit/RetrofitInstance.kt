package ivan.diaz.dominguez.castingapp.retrofit

object RetrofitInstance {
    val retrofitService: GhibliService by lazy { retrofit.create(GhibliService::class.java) }
}