package principal

import br.com.alura.alugames.service.ConsumoApi

fun main (){
    val consumo = ConsumoApi()
    val listaGamer = consumo.buscaGames()
    val listaJogos = consumo.buscaJogo();

    val gamerCaroline = listaGamer.get(3)
    val jogoResidenteVillage = listaJogos.get(10)

    var aluguel = gamerCaroline.alugaJogo(jogoResidenteVillage)


    println(gamerCaroline)
    println(jogoResidenteVillage)
    println(aluguel)
}