package database

/**
 * Created by kritiuns on 21/06/17.
 */
enum class Status(ofertaVenda: Int) {
    SEM_OFERTA(0),
    VENDIDO(1),
    PERDIDO(2),
    EM_NEGOCIACAO(3)
}