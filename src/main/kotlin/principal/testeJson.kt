package principal

import br.com.alura.alugames.service.ConsumoApi
import model.Periodo
import model.PlanoAssinatura
import java.time.LocalDate

fun main (){
    val consumo = ConsumoApi()
    val listaGamer = consumo.buscaGames()
    val listaJogos = consumo.buscaJogo();

    val jogoResidenteVillage = listaJogos.get(10)
    val jogoSpider = listaJogos.get(13)
    val jogoTheLastOfUs = listaJogos.get(2)
    val jogoGta = listaJogos.get(1)

    val gamerCaroline = listaGamer.get(3)

    val periodo1 = Periodo(LocalDate.now(),LocalDate.now().plusDays(3))
    val periodo2 = Periodo(LocalDate.now(),LocalDate.now().plusDays(7))
    val periodo3 = Periodo(LocalDate.now(),LocalDate.now().plusDays(10))




    gamerCaroline.alugaJogo(jogoResidenteVillage,periodo1)
    gamerCaroline.alugaJogo(jogoSpider,periodo2)
    gamerCaroline.alugaJogo(jogoTheLastOfUs,periodo3)


    println(gamerCaroline.jogosAlugados)

    val gamerCamila = listaGamer.get(5)
    gamerCamila.plano = PlanoAssinatura("PRATA",9.90,3)

    gamerCamila.alugaJogo(jogoResidenteVillage,periodo1)
    gamerCamila.alugaJogo(jogoSpider,periodo2)
    gamerCamila.alugaJogo(jogoTheLastOfUs, periodo3)
    gamerCamila.alugaJogo(jogoGta,periodo3)
    print(gamerCamila.jogosAlugados)



}