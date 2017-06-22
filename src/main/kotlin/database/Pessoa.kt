package database

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Created by kritiuns on 16/06/17.
 */
@Entity
data class Pessoa (
    var nomeCompleto:String = "",
    var telefoneFixo:String = "",
    var telefoneContato:String = "",
    var email:String = "",
    var quantidade:Int = 0,
    var opAtual:String = "",
    var razaoSocial:String = "",
    var cnpj:String = "",
    var tipoContato:String="",
    var ofertou:Boolean=false,
    var vendeu:Boolean=false,
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
)