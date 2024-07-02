package br.com.alura.service

import java.io.IOException
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse


class ConsumoApi {
    fun  obterDados(endereco: String?): String? {
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()
        var response: HttpResponse<String?>? = null
        try {
            response = client
                .send(request, HttpResponse.BodyHandlers.ofString())
        } catch (e: IOException) {
            throw RuntimeException(e)
        } catch (e: InterruptedException) {
            throw RuntimeException(e)
        }

        val json = response.body()
        return json
    }
}