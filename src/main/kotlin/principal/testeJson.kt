package principal

import br.com.alura.alugames.service.ConsumoApi
import model.Periodo
import java.time.LocalDate

fun main (){
    val consumo = ConsumoApi()
    val listaGamer = consumo.buscaGames()
    val listaJogos = consumo.buscaJogo();

    val gamerCaroline = listaGamer.get(3)
    val jogoResidenteVillage = listaJogos.get(10)
    val periodo = Periodo(LocalDate.now(),LocalDate.now().plusDays(7))

    var aluguel = gamerCaroline.alugaJogo(jogoResidenteVillage,periodo)


    println(gamerCaroline)
    println(jogoResidenteVillage)
    println(aluguel)
}