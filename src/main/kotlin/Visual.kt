import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.RenderingHints
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.util.*
import javax.swing.JComponent
import kotlin.concurrent.schedule


class Visual(width: Int, height: Int): JComponent() {

    val TICK = 1000 / 60
    var timer: Timer = Timer()
    var circles: ArrayList<Circle>

    init{
        addMouseListener(MouseClicks())
        circles =
    }

    fun start() {
        println("Starting!")
        timer.schedule(0, TICK.toLong()){
            repaint()
        }
    }


    override fun paintComponent(g: Graphics?) {
        val g2 = g as Graphics2D
        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON
        )
        paintComponent(g2)
    }

    fun paintComponent(g2: Graphics2D) {
        g2.setColor(Color.WHITE)
        g2.clearRect(0, 0, width, height)

    }

    class MouseClicks : MouseAdapter() {

        override fun mouseClicked(e: MouseEvent?) {

        }

        override fun mousePressed(e: MouseEvent?) {

        }
    }

}
