data class Stone(val color: StoneColor)

enum class StoneColor {
    BLACK,
    WHITE;

    val nextTurn get() = if (this == BLACK) WHITE else BLACK
}
fun symbol(color: StoneColor?) : Char = when(color){
    StoneColor.BLACK -> '#'
    StoneColor.WHITE -> 'O'
    null -> '.'
}

//fun StoneColor?.toSymbol() : Char = when(this){
//    StoneColor.BLACK -> '#'
//    StoneColor.WHITE -> 'O'
//    null -> '.'
//}
