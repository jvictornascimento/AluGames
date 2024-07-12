package model

class PlanoAvulso(tipo:String):Plano(tipo) {

    override fun obterValor(aluguel: Aluguel): Double {
        var valorOrinal = super.obterValor(aluguel)
        if(aluguel.gamer.media > 8 ){
            valorOrinal-= valorOrinal * 0.1

        }
        return valorOrinal
    }
}
