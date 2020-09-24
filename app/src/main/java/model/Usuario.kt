package model

import android.util.Log
import com.example.practicatibu.ModelValidationListener
import java.io.Serializable
import java.util.*

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

    fun validacionMayoriaEdad(year: Int, month: Int, day: Int) {
        val fechaNacimiento = Calendar.getInstance()
        fechaNacimiento.set(year, month, day)
        val mayoriaEdad = 18
        if (calculoDiferenciaEdad(fechaNacimiento) >= mayoriaEdad) {
            Log.d("TAG", "El usuario es mayor a 18 años")
            listener.isOldEnough()
        }
    }

    fun calculoDiferenciaEdad(nacimiento: Calendar): Int {
        val fechaHoy = Calendar.getInstance()
        var diffYear = fechaHoy.get(Calendar.YEAR) - nacimiento.get(Calendar.YEAR)
        val diffMonth = fechaHoy.get(Calendar.MONTH) - nacimiento.get(Calendar.MONTH)
        val diffDay = fechaHoy.get(Calendar.DAY_OF_MONTH) - nacimiento.get(Calendar.DAY_OF_MONTH)
        //preg si est
        if (diffMonth < 0 || (diffMonth == 0 && diffDay < 0)) {
            diffYear -= 1
        }
        return diffYear
    }
}

