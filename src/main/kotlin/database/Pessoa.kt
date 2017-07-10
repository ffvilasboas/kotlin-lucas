package database

import java.util.*
import javax.persistence.*

/**
 * Created by kritiuns on 16/06/17.
 */
@Entity
data class Pessoa (
    var nomeCompleto:String = "",
    @Column(nullable = true)
    var telefoneFixo:String = "",
    var telefoneContato:String = "",
    var email:String = "",
    var quantidade:Int = 0,
    var opAtual:String = "",
    var razaoSocial:String = "",
    var cnpj:String = "",
    var tipoContato:String="",
    var status: Status = Status.SEM_OFERTA,
    var fechamento: Fechamento = Fechamento.INICIADO,
    var dataCriacao: Long= 0,
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
)