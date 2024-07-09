package principal

import br.com.alura.alugames.service.ConsumoApi

fun main (){
    val consumo = ConsumoApi()
    val listaGamer = consumo.buscaGames()
    val jogoApi = consumo.buscaJogo("151")
    println(listaGamer)
    println(jogoApi)
}