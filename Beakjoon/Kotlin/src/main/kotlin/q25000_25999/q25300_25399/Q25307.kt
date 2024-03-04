package q25000_25999.q25300_25399

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.math.abs
import kotlin.math.min

private val br = BufferedReader(InputStreamReader(System.`in`))
private var answer: Int = -1

private const val wall: Int = 1
private const val chair: Int = 2
private const val mannequin: Int = 3
private const val start: Int = 4
private const val makeWall: Int = 5
private val dy: Array<Int> = arrayOf(-1, 0, 0, 1)
private val dx: Array<Int> = arrayOf(0, -1, 1, 0)
private val mannequins = ArrayList<Pos>()

private var N: Int = 0
private var M: Int = 0
private var K: Int = 0
private var arr: Array<IntArray>? = null
private var startY: Int = 0
private var startX: Int = 0
fun main() {
    input()
    solve()
    println(answer)
}

private fun input() {
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()
    K = st.nextToken().toInt()
    arr = Array(N + 1) { IntArray(M + 1) }
    for (y in 1..N) {
        st = StringTokenizer(br.readLine())
        for (x in 1..M) {
            arr!![y][x] = st.nextToken().toInt()
            if (arr!![y][x] == start) {
                startX = x
                startY = y
            }
            if (arr!![y][x] == mannequin) {
                mannequins.add(Pos(y, x, 0))
                mannequins[mannequins.size - 1].rootY = y
                mannequins[mannequins.size - 1].rootX = x
            }
        }
    }
}

private fun solve() {
    drawMannequinArea()
    move()
}

private fun drawMannequinArea() {
    val queue = ArrayDeque<Pos>()
    for (pos in mannequins) {
        queue.addLast(pos)
    }
    while (queue.isNotEmpty()) {
        val pos = queue.removeFirst()
        for (i in 0..3) {
            val newY = pos.y + dy[i]
            val newX = pos.x + dx[i]
            if (validateOutOfRange(newY, newX)
                || abs(newY - pos.rootY) + abs(newX - pos.rootX) > K
                || arr!![newY][newX] == makeWall
                || arr!![newY][newX] == mannequin
            ) {
                continue
            }
            arr!![newY][newX] = makeWall
            val newPos = Pos(newY, newX, 0)
            newPos.rootY = pos.rootY
            newPos.rootX = pos.rootX
            queue.addLast(newPos)
        }
    }
}

private fun move() {
    val queue = ArrayDeque<Pos>()
    queue.addLast(Pos(startY, startX, 0))

    val visited: Array<BooleanArray> = Array(N + 1) { BooleanArray(M + 1) }
    visited[startY][startX] = true

    while (queue.isNotEmpty()) {
        val pos = queue.removeFirst()
        for (i in 0..3) {
            val newY = pos.y + dy[i]
            val newX = pos.x + dx[i]
            if (validateOutOfRange(newY, newX)
                || visited[newY][newX]
                || arr!![newY][newX] == wall
                || arr!![newY][newX] == mannequin
                || arr!![newY][newX] == makeWall
            ) {
                continue
            }
            if (arr!![newY][newX] == chair) {
                answer = if (answer == -1) pos.count + 1 else min(answer, pos.count + 1)
            }
            visited[newY][newX] = true
            queue.addLast(Pos(newY, newX, pos.count + 1))
        }
    }
}

private fun validateOutOfRange(y: Int, x: Int): Boolean {
    return y < 1 || y > N || x < 1 || x > M
}

private data class Pos(
    val y: Int,
    val x: Int,
    val count: Int
) {
    var rootY: Int = -1
    var rootX: Int = -1
}