import java.io.File

fun saveGame(game: Game, name: String){
    val board = game.board
    val rows = board.cells.map{line -> line.joinToString("") {stone ->  symbol(stone?.color).toString()}}
    val lines = listOf(
        board.size.toString(),
        game.turn.name,
        "${game.blackCaptures} ${game.whiteCaptures}"
    ) + rows
    File(name).writeText(lines.joinToString("\n"))
}
fun loadGame(name: String) : Game? {
    val file = File(name)
    val lines = file.readLines().map{it.trim()}

    if (lines.size < 3 + BOARD_SIZE) return null

    val size = lines[0].toIntOrNull() ?: return null
    if (size != BOARD_SIZE) return null

    val turn = StoneColor.values().firstOrNull{it.name == lines[1]} ?:return null
    val captures = lines[2].split(" ").mapNotNull {it.toIntOrNull()}
    if (captures.size != 2) return null

    val rows = lines.subList(3, 3 + BOARD_SIZE)
    for (row in rows) {
        if (row.length != BOARD_SIZE) return null
        if (row.any{it != symbol(StoneColor.BLACK) && it != symbol(StoneColor.WHITE) && it != symbol(null)}) return null
    }
    val cells = rows.map { row ->
        row.map { ch -> val color = StoneColor.values().firstOrNull { symbol(it) == ch }
            if (color == null) null else Stone(color)
        }
    }
    return Game(Board(size, cells), turn, captures[0], captures[1])
}
//utilizar Map e não é extenção .map
//separar a interface graphica do resto e fazer packages disto