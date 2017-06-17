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
    var idade:Int = 0,
    var email:String = "",
    var tipoContato:String = "",
    var telefoneContato:String = "",
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

)