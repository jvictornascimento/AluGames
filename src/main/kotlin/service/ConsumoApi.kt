package br.com.alura.alugames.service

import br.com.alura.br.com.alura.alugames.model.InfoJogo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import model.Gamer
import model.InfoGameJson
import utilitario.criaGame
import java.io.IOException
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.util.*


class ConsumoApi {
    private fun consomeDados(endereco:String) :String {
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()
        var response = client
            .send(request, HttpResponse.BodyHandlers.ofString())
       return response.body()
    }
    fun   buscaJogo(id: String?): InfoJogo {
        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"
        //val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        var json = consomeDados(endereco)
        val gson = Gson()
        val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)
        return meuInfoJogo
    }
    fun buscaGames(): List<Gamer>{
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        var json = consomeDados(endereco)
        val gson = Gson()
        var meuGamerTipo = object : TypeToken<List<InfoGameJson>>(){}.type
        val listaGamer: List<InfoGameJson> = gson.fromJson(json, meuGamerTipo)

        val listaGamerConvertida = listaGamer.map { infoGameJson -> infoGameJson.criaGame() }
        return listaGamerConvertida
    }
}