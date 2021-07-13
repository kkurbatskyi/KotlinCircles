import java.awt.Graphics
import java.util.*
import javax.swing.JFrame
import kotlin.concurrent.schedule
import kotlin.concurrent.timerTask


class Visual(width: Int, height: Int): JFrame() {

    val TICK = 1000 / 60
    var timer: Timer = Timer()

    fun start() {
        timer.schedule(0, TICK.toLong()){
            repaint()
        }
    }

    override fun paintComponents(g: Graphics?) {
        super.paintComponents(g)
    }
}