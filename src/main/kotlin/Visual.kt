import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.RenderingHints
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.awt.event.MouseMotionAdapter
import java.util.*
import javax.swing.JComponent
import kotlin.concurrent.schedule


class Visual(width: Int, height: Int): JComponent() {

    val TICK = 1000 / 60
    var timer: Timer = Timer()
    val circles: ArrayList<Circle>

    init{
        circles = ArrayList<Circle>()
        addMouseListener(MouseClicks(circles))
        addMouseMotionListener(MouseMoves(circles))
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

    private fun paintComponent(g2: Graphics2D) {
        g2.color = Color.WHITE
        g2.clearRect(0, 0, width, height)

        paintCircles(g2)
    }

    private fun paintCircles(g2: Graphics2D) {
        for(circle in circles) {
            g2.color = circle.color
            g2.fillOval((circle.x - circle.radius()).toInt(), (circle.y - circle.radius()).toInt(),
                circle.diameter.toInt(), circle.diameter.toInt()
            )
        }
    }

    private class MouseClicks(_circles: ArrayList<Circle>) : MouseAdapter() {

        var timer: Timer
        val circles: ArrayList<Circle>
        init{
            timer = Timer()
            circles = _circles
        }

        override fun mousePressed(e: MouseEvent?) {
            timer = Timer()
            circles.add(Circle(e?.point?.x as Int, e.point.y,1f))
            timer.schedule(0, 10){
                circles.last().diameter += 1;
            }
        }

        override fun mouseReleased(e: MouseEvent?) {
            timer.cancel()
        }
    }

    private class MouseMoves(_circles: ArrayList<Circle>) : MouseMotionAdapter() {
        val circles: ArrayList<Circle> = _circles

        override fun mouseDragged(e: MouseEvent?) {
            circles.last().x = e?.point?.x as Int;
            circles.last().y = e.point.y;
        }
    }

}
