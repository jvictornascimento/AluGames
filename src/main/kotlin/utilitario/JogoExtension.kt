package utilitario

import br.com.alura.br.com.alura.alugames.model.Jogo
import model.InfoJogosJson

fun InfoJogosJson.criaJogo(): Jogo{
    return Jogo(this.titulo,this.capa,this.preco,this.descricao)
}