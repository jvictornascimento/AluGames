package br.com.alura.br.com.alura.alugames.model

data class Jogo(val titulo:String, val capa:String) {
    val preco:String? =null
     var descricao:String? = null


    override fun toString(): String {
        return "Meu Jogo:\n" +
                "Titulo: $titulo\n"+
                "capa: $capa\n"+
                "Descrição: $descricao"
    }

}




