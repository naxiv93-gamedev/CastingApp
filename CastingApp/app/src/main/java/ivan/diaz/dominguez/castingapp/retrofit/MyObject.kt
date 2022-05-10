//id nombre genero edad colorpelo y colorojos

data class MyProperty(
    val id: String,
    val genero: String
    val edad: String
    val colorPelo: String
    val colorOjos:String
) {
    override fun toString(): String {
        return id+" "+genero+" "+edad+" "+colorPelo+" "+colorOjos
    }
}