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
        fechaNacimiento.set(year ,month + 1,day)
        val fechaHoy = Calendar.getInstance()
        if (fechaNacimiento.before(fechaHoy)) {
            Log.d("TAG", "El usuario es mayor a 18 años")
            listener.isOldEnough()
        }
    }
}

