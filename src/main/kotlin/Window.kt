import javax.swing.JFrame

class Window: JFrame() {
    private val WIDTH: Int = 300
    private val HEIGHT: Int = 300
    var visual: Visual
    init{
        isResizable = true
        title = "Circles"
        visual = Visual()
        contentPane = visual
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