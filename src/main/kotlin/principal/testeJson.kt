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
    val periodo1 = Periodo(LocalDate.now(),LocalDate.now().plusDays(3))
    val periodo2 = Periodo(LocalDate.now(),LocalDate.now().plusDays(7))
    val periodo3 = Periodo(LocalDate.now(),LocalDate.now().plusDays(10))


    val jogoSpider = listaJogos.get(13)
    val jogoTheLastOfUs = listaJogos.get(2)

    gamerCaroline.alugaJogo(jogoResidenteVillage,periodo1)
    gamerCaroline.alugaJogo(jogoSpider,periodo2)
    gamerCaroline.alugaJogo(jogoTheLastOfUs,periodo3)


    println(gamerCaroline.jogosAlugados)

}