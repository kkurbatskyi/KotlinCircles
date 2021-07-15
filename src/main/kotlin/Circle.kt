import java.awt.Color

class Circle(_x: Int, _y: Int, _diameter: Float) {
    val colors: List<Color> = listOf(Color.GREEN, Color.MAGENTA, Color.RED, Color.BLUE, Color.ORANGE, Color.PINK, Color.YELLOW, Color.CYAN)
    val color: Color
    var x: Int
    var y: Int
    var diameter: Float

    init{
        x = _x
        y = _y
        diameter = _diameter
        color = colors.random()
    }

    fun radius(): Float{
        return diameter / 2
    }
}