package br.com.alura.br.com.alura.alugames.principal

import br.com.alura.alugames.service.ConsumoApi
import br.com.alura.br.com.alura.alugames.model.Jogo
import model.Gamer
import tranformarEmIdade
import java.util.*

fun main() {
    val buscaApi = ConsumoApi()
    val leitura = Scanner(System.`in`)
    val gamer = Gamer.criarGamer(leitura)
    println("Cadastro finalizado com sucesso")
    println(gamer)
    println("Idade do gamer: " + gamer.dataNascimento?.tranformarEmIdade())

    do {


        println("Digite o codigo do jogo para buscar:")
        val busca = leitura.nextLine()
        var informacaoJogo = buscaApi.buscaJogo()

        var meuJogo: Jogo? =null

        val resultado = runCatching {

            meuJogo = informacaoJogo.get(0)
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
            gamer.jogosBuscados.add(meuJogo)
    }
        println("Deseja buscar um novo jogo S/N")
        var resposta = leitura.nextLine()

    }while (resposta.equals("s",true))

    println("Jogos buscados:")
    println(gamer.jogosBuscados)

    println("\nJogos ordenados por titulo: ")
    gamer.jogosBuscados.sortBy {
        it?.titulo
    }
    gamer.jogosBuscados.forEach {
        println("Titulo: " + it?.titulo)
    }

    val jogosFiltrados = gamer.jogosBuscados.filter {
        it?.titulo?.contains("batman",true)?: false
    }
    println("\nJogos filtrados")
    println(jogosFiltrados)

    println("Desjea excluir algum item da lista original? S/N")
    val opcao = leitura.nextLine()

    if (opcao.equals("s",true)){
        println(gamer.jogosBuscados)
        println("\nInforme a posição do jogo que deseja excluir:")
        val position = leitura.nextInt()
        gamer.jogosBuscados.removeAt(position)
    }
    println("\nLista atualizada:")
    println(gamer.jogosBuscados)


    println("Busca finalizada com sucesso!")
}