import com.google.gson.Gson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

fun main(args: Array<String>) {

//    val peter = """{"name":"peter","age":20}"""
//    val peter = """{"name":null,"age":20}"""
    val peter = """{"age":20}"""
//    val peter = """{}"""

    useMoshi(peter)
//    useGson(peter)
}

@JsonClass(generateAdapter = true)
data class Person(
    val name: String? = "who am i",
    val age: Int?
)


private fun useMoshi(data: String) {
    val moshi: Moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()
    val jsonAdapter: JsonAdapter<Person> = moshi.adapter((Person::class.java))

    val personMoshi = jsonAdapter.fromJson(data)
    println(personMoshi)
}

private fun useGson(data: String) {
    val personGson = Gson().fromJson(data, Person::class.java)
    println(personGson)
}