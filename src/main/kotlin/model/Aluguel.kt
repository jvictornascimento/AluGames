package model

import br.com.alura.br.com.alura.alugames.model.Jogo

data class Aluguel (val gamer:Gamer, val jogo:Jogo){
    override fun toString(): String {
        return "Alugado o ${jogo.titulo} por ${gamer.nome}"
    }
}