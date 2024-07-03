package br.com.alura

import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.Scanner

fun main() {

    val leitura = Scanner(System.`in`)
    println("Digite o codigo do jogo para buscar:")

    val busca = leitura.nextLine()
    val endereco = "https://www.cheapshark.com/api/1.0/games?id=$busca"



    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(endereco))
        .build()
    var response = client
        .send(request, BodyHandlers.ofString())
    val json = response.body()
//    println(json)

    val gson = Gson()


//    try {
//        val meuJogo = Jogo(meuInfoJogo.info.title, meuInfoJogo.info.thumb)
//        println(meuJogo)
//    }catch (ex: NullPointerException){
//        println("Jogo inixistente tente outro id.")
//    }

    var meuJogo:Jogo? =null

    val resultado = runCatching {
        val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)
         meuJogo = Jogo(meuInfoJogo.info.title, meuInfoJogo.info.thumb)
    }
    resultado.onFailure {
        println("Jogo inixistente tente outro id.")
    }
    resultado.onSuccess {
        println("Deseja inserir uma descrição personalizada? S/N")
        val opcao = leitura.nextLine()
        if (opcao.equals("s",true)){
            println("Insira a descrição personalizada para o jogo:")
            val descricaoPersonalizada  = leitura.nextLine()
            meuJogo?.descricao = descricaoPersonalizada;
            println(meuJogo)
        }else{
            meuJogo?.descricao = meuJogo?.titulo
            println(meuJogo)
        }
        resultado.onSuccess {
            println("Busca finalizada com sucesso!")
        }

    }




}