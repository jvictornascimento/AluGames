package br.com.alura

data class Jogo(val titulo:String, val capa:String) {
    override fun toString(): String {
        return "Meu Jogo:\n" +
                "Titulo: $titulo\n"+
                "capa=$capa"
    }

}