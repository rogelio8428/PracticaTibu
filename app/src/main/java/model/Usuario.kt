package model

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.practicatibu.ModelValidationListener
import java.io.Serializable
import java.time.LocalDate
import java.time.Period

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

    @RequiresApi(Build.VERSION_CODES.O)
    fun validacionMayoriaEdad(year: Int, month: Int, day: Int) {
        var fechaNacimiento = LocalDate.of(year, month, day)
        var fechaHoy = LocalDate.now()
        var periodo: Period = Period.between(fechaNacimiento, fechaHoy)
        if (periodo.years >= 18) {
            Log.d("TAG", "El usuario es mayor a 18 años")
            listener.isOldEnough()
        }
    }
}

