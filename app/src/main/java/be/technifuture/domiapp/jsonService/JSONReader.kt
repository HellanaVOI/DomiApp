package be.technifuture.domiapp.jsonService

import com.google.gson.Gson
import java.io.InputStream

class JSONReader {

    fun getExt(input: InputStream): MutableList<ExtensionModel>{

        val size: Int = input.available()
        val buffer = ByteArray(size)
        input.read(buffer)
        val jsonString = String(buffer)

        val apiData = Gson().fromJson(jsonString, ExtensionResponse::class.java)

        return apiData.list
    }

    fun getCard(input: InputStream): MutableList<CardModel>{

        val size: Int = input.available()
        val buffer = ByteArray(size)
        input.read(buffer)
        val jsonString = String(buffer)

        val apiData = Gson().fromJson(jsonString, CarResponse::class.java)

        return apiData.list
    }
}