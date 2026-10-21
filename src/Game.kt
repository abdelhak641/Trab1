data class Game(
    val board: Board,
    val turn: StoneColor,
    val blackCaptures: Int = 0,
    val whiteCaptures: Int = 0
)
fun Game.play(text: String): Game {
    val pos = board.position(text, BOARD_SIZE) ?: return this
    if (board[pos.first, pos.second] != null) return this
    return copy(
        board = board.piece(pos.first, pos.second, Stone(turn)),
        turn = turn.nextTurn
    )
}
