package br.com.alura.br.com.alura.alugames.principal

import br.com.alura.alugames.service.ConsumoApi
import br.com.alura.br.com.alura.alugames.model.Jogo
import java.util.*

fun main() {
    val buscaApi = ConsumoApi()
    val leitura = Scanner(System.`in`)

    println("Digite o codigo do jogo para buscar:")
    val busca = leitura.nextLine()
    var informacaoJogo = buscaApi.buscaJogo(busca)

    var meuJogo: Jogo? =null

    val resultado = runCatching {

         meuJogo = Jogo(informacaoJogo.info.title, informacaoJogo.info.thumb)
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