package model

import com.example.practicatibu.ModelValidationListener
import java.io.Serializable
import java.util.*

const val comingOfAge = 18

data class Usuario(
    var name: String? = null,
    var sport: String? = null,
    var date: String? = null,
    var sex: Boolean = true,
) : Serializable {

    lateinit var listener: ModelValidationListener

    fun setModelValidationListener(obj: ModelValidationListener) {
        listener = obj
    }

    fun ageValidation(year: Int, month: Int, day: Int) {
        val birthDate = Calendar.getInstance()
        birthDate.set(year, month, day)
        val comingOfAge = Calendar.getInstance().get(Calendar.YEAR) - comingOfAge
        var dateMajorityAge = Calendar.getInstance()
        dateMajorityAge.set(comingOfAge, month, day)
        listener.isOldEnough(birthDate.before(dateMajorityAge))
    }
}

