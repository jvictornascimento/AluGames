package br.com.alura

class Jogo {
    var titulo = ""
    var capa = ""
    override fun toString(): String {
        return "Meu Jogo:\n" +
                "Titulo: $titulo\n"+
                "capa=$capa"
    }

}