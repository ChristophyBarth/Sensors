package kodecamp.android.sensors

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEventListener
import android.hardware.SensorManager

class SensorHelper(context: Context) {
    private val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager

    fun getAllSensors(): List<Sensor> {
        return sensorManager.getSensorList(Sensor.TYPE_ALL)
    }

    fun find(sensorType: Int) = getAllSensors().find { it.type == sensorType }

    fun addSensorListener(sensor: Sensor, listener: SensorEventListener) =
        sensorManager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_NORMAL)

    fun removeSensorListener(listener: SensorEventListener) =
        sensorManager.unregisterListener(listener)
}