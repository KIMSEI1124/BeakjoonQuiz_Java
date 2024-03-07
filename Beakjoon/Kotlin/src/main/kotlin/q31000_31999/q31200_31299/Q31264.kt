package q31000_31999.q31200_31299

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private var N = 0;
private var M = 0;
private var A = 0;
private val list = ArrayList<Int>()
private var answer = 0
fun main() {
    input()
    solve()
    println(answer)
}

private fun input() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()
    A = st.nextToken().toInt()
    st = StringTokenizer(br.readLine())
    while (st.hasMoreTokens()) {
        list.add(st.nextToken().toInt())
    }
}

private fun solve() {
    list.sort()
    var start = 0
    var end = list.size - 1
    var mid = 0
    while (start <= end) {
        mid = (start + end) / 2
        if (check(mid)) {
            end = mid - 1
        } else {
            start = mid + 1
        }
    }
    answer = list[mid]
}

private fun check(idx: Int): Boolean {
    var p = list[idx]
    for (i in 0..<list.size) {
        if (p < list[i]) {
            return false
        }
        p += list[i]
    }
    return p >= A
}