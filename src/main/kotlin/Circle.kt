import java.awt.Color

class Circle(_x: Int, _y: Int, _diameter: Float) {
    private val colors: List<Color> = listOf(Color.GREEN, Color.MAGENTA, Color.RED, Color.BLUE, Color.ORANGE, Color.PINK, Color.YELLOW, Color.CYAN)
    val color: Color = colors.random()
    var x: Int = _x
    var y: Int = _y
    var diameter: Float = _diameter

    fun radius(): Float{
        return diameter / 2
    }
}