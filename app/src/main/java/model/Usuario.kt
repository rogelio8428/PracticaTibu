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
        var isOlder: Boolean
        val fechaNacimiento = Calendar.getInstance()
        fechaNacimiento.set(year, month, day)
        val mayoriaEdad = 1
        val fechaHoy = Calendar.getInstance()
        val añoMayoriaEdad = fechaHoy.get(Calendar.YEAR) - mayoriaEdad
        var fechaNacimientoMayoriaEdad = Calendar.getInstance()
        fechaNacimientoMayoriaEdad.set(añoMayoriaEdad, month, day)
        if (fechaNacimiento.before(fechaNacimientoMayoriaEdad)) {
            Log.d("TAG", "El usuario es mayor a 18 años")
            isOlder = true
        } else {
            isOlder = false
        }
        listener.isOldEnough(isOlder)
    }
}

