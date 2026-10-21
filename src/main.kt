fun main() {
    var game = Game(Board(),StoneColor.BLACK)
    while (true) {
        printBoard(game.board)
        println("Turn: ${symbol(game.turn)} (${game.turn}) Captures: #=${game.blackCaptures}, whiteCaptures: #=${game.whiteCaptures}")
        print(">")

        val line = readlnOrNull() ?: return
        val parts = line.trim().split(' ').filter { it != "" }
        if (parts.isEmpty()) continue
        val command = parts[0]
        if (command == "exit") {
            return
        } else if (command == "new") {
            game = Game(Board(), StoneColor.BLACK)

        } else if (command == "play") {
            if (parts.size < 2) {
                println("invalid position")
            } else {
                val next = game.play(parts[1])
                if (next == game) {
                    println("invalid position")

                } else {
                    game = next
                }

            }
        }   else if (command == "save") {
                if (parts.size < 2) {
                    println("save <name>")
            } else {
                    saveGame(game, parts[1])
            }
        }   else if (command == "load") {
                if (parts.size < 2) {
                    println("load <name>")
            } else {
                val loaded = loadGame(parts[1])
                if (loaded != null) game = loaded
            }
        }

    }
}



