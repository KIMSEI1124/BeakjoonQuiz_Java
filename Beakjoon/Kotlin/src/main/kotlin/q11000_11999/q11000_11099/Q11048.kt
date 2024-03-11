package q11000_11999.q11000_11099

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayDeque

private var N = 0
private var M = 0
private var ARRAY: Array<IntArray> = emptyArray()
private var VISITED: Array<IntArray> = emptyArray()

fun main() {
    input()
    solve()
    println(VISITED[N][M])
}

private fun input() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()
    ARRAY = Array(N + 1) { IntArray(M + 1) }
    VISITED = Array(N + 1) { IntArray(M + 1) { -1 } }
    for (y in 1..N) {
        st = StringTokenizer(br.readLine())
        for (x in 1..M) {
            ARRAY[y][x] = st.nextToken().toInt()
        }
    }
}

private val dr = arrayOf(0, 1)
private val dc = arrayOf(1, 0)

private fun solve() {
    val queue = ArrayDeque<Pos>()
    VISITED[1][1] = ARRAY[1][1]
    queue.addLast(Pos(1, 1))
    while (queue.isNotEmpty()) {
        val pos = queue.removeFirst()
        for (i in 0..1) {
            val newR = pos.r + dr[i]
            val newC = pos.c + dc[i]
            if (newR < 1 || newR > N
                || newC < 1 || newC > M
                || VISITED[newR][newC] >= VISITED[pos.r][pos.c] + ARRAY[newR][newC]
            ) {
                continue
            }
            VISITED[newR][newC] = VISITED[pos.r][pos.c] + ARRAY[newR][newC]
            queue.addLast(Pos(newR, newC))
        }
    }
}

private data class Pos(val r: Int, val c: Int)