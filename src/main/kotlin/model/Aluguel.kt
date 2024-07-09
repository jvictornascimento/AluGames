package model

import br.com.alura.br.com.alura.alugames.model.Jogo
import java.time.LocalDate
import java.time.Period

data class Aluguel (
    val gamer:Gamer,
    val jogo:Jogo,
    val periodo: Periodo){

    val valorDoAluguel = jogo.preco * periodo.emDias
  override fun toString(): String {
        return "Alugado o ${jogo.titulo} por ${gamer.nome} pelo valor $valorDoAluguel"
    }
}