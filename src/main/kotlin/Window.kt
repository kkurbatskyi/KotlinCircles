import javax.swing.JFrame
import javax.swing.WindowConstants.EXIT_ON_CLOSE

class Window: JFrame() {
    val WIDTH: Int = 300
    val HEIGHT: Int = 300
    var visual: Visual
    init{
        setResizable(false)
        setTitle("Circles")
        visual = Visual(WIDTH, HEIGHT)
        setContentPane(visual)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val window = Window()

            window.setSize(window.WIDTH, window.HEIGHT)
            window.defaultCloseOperation = EXIT_ON_CLOSE
            window.isVisible = true
            window.visual.start()
        }
    }
}