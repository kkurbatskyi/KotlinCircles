import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.RenderingHints
import java.awt.event.*
import java.awt.image.BufferedImage
import java.io.File
import java.util.*
import javax.imageio.ImageIO
import javax.swing.JComponent
import kotlin.concurrent.schedule


class Visual(width: Int, height: Int): JComponent() {

    val TICK = 1000 / 60
    var timer: Timer = Timer()
    val circles: ArrayList<Circle>

    init{
        isFocusable = true

        circles = ArrayList<Circle>()
        addMouseListener(MouseClicks())
        addMouseMotionListener(MouseMoves())
        addKeyListener(KeyListener())
    }

    fun start() {
        println("Starting!")
        timer.schedule(0, TICK.toLong()){
            repaint()
        }
    }

    fun saveScreenShot() {
        val image = BufferedImage(
            getWidth(),
            getHeight(),
            BufferedImage.TYPE_INT_RGB
        )
        println("Snap!")
        // call the Component's paint method, using the Graphics object of the image
        paint(image.graphics)
        ImageIO.write(image, "png", File("./snapshots/circleDrawing.png"))
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
        g2.fillRect(0, 0, width, height)

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

    private inner class MouseClicks() : MouseAdapter() {

        var timer: Timer
        init{
            timer = Timer()
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

    private inner class MouseMoves : MouseMotionAdapter() {

        override fun mouseDragged(e: MouseEvent?) {
            circles.last().x = e?.point?.x as Int;
            circles.last().y = e.point.y;
        }
    }

    private inner class KeyListener : KeyAdapter() {

        override fun keyPressed(e: KeyEvent?) {
            if(e?.keyCode == KeyEvent.VK_S)
            {
                saveScreenShot()
            }
        }
    }

}
