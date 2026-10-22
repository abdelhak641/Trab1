fun Board.neighbour(row : Int, col : Int): List<Pair<Int, Int>> =
    listOf(Pair(row + 1, col), Pair(row, col + 1), Pair(row - 1, col), Pair(row, col - 1))
        .filter {(r, c) -> r in 0 until BOARD_SIZE && c in 0 until BOARD_SIZE}

fun Board.group(row: Int, col: Int): Set<Pair<Int, Int>>{
    val colorCheck = this[row, col]?.color ?: return emptySet()
    val checkNeighbour = this.neighbour(row, col).filter {(r, c) -> this[r, c]?.color == colorCheck}

}