package utilitario

import model.Gamer
import model.InfoGameJson

fun InfoGameJson.criaGame(): Gamer{
    return Gamer(this.nome,this.email,this.dataNascimento,this.usuario)
}