package be.technifuture.domiapp.jsonService

import com.google.gson.Gson
import java.io.InputStream

class JSONReader {

    fun read_json(input: InputStream){

        val size: Int = input.available()
        val buffer = ByteArray(size)
        input.read(buffer)
        val jsonString = String(buffer)

        var json : String? = null

        val apiData = Gson().fromJson(jsonString, ExtensionResponse::class.java)     // No need to add TypeAdapter

        val requestData = apiData.listCrypto
    }
}