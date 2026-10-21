const val BOARD_SIZE = 9

data class Board(val size: Int = BOARD_SIZE, val cells: List<List<Stone?>> = List(size) {
    List(size) { null }
} ) {

    operator fun get(row: Int, col: Int) = cells[row][col]

    fun position(text: String, size: Int): Pair<Int, Int>? {
        val letter = text.last().uppercaseChar()
        val number = text.dropLast(1).toInt()
        if (text.length < 2) return null
        return Pair(size-number, letter-'A')
    }

    fun piece(row : Int, col : Int, stone: Stone): Board {
        val newCells = List(size) { r ->
            List(size) { c ->
                if (r == row && c == col) stone else cells[r][c]
            }
        }
        return copy(cells = newCells)
    }
}
fun printBoard(board: Board){
    println("  "+ (0 until BOARD_SIZE).joinToString(" "){ ('A'+ it).toString()})
    for(r in 0 until BOARD_SIZE) {
        val row =(0 until BOARD_SIZE ).joinToString(" "){
            c -> symbol(board[r, c]?.color).toString() }
            println("${BOARD_SIZE-r} $row")

    }
}
//board.print