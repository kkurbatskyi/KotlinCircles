import javax.swing.WindowConstants.EXIT_ON_CLOSE

class Main {
    companion object {
        const val WIDTH: Int = 300
        const val HEIGHT: Int = 300

        @JvmStatic
        fun main(args: Array<String>) {
            val window = Visual(WIDTH, HEIGHT)

            window.setSize(WIDTH, HEIGHT)
            window.defaultCloseOperation = EXIT_ON_CLOSE
            window.isVisible = true
            window.start()
        }
    }
}