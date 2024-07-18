package `48days`.day7

class Test1 {

}


import java.util.* // 导入 Java 工具类库

class Solution {
    var m = 0
    var n // 声明两个整数变量 m 和 n，分别用于存储网格的行数和列数
            = 0
    var dx = intArrayOf(0, 0, 1, -1) // 声明一个整型数组 dx，存储在四个方向上 x 坐标的变化量
    var dy = intArrayOf(1, -1, 0, 0) // 声明一个整型数组 dy，存储在四个方向上 y 坐标的变化量
    var vis = Array(210) { BooleanArray(210) } // 声明一个布尔二维数组 vis，用于记录访问过的节点 默认值为false
    fun solve(grid: Array<CharArray>): Int {
        // solve 方法用于解决这个问题
        m = grid.size // 将 m 设置为网格的行数
        n = grid[0].length // 将 n 设置为网格的第一行的列数
        var ret = 0 // 初始化返回值 ret 为 0，用于计数

        // 遍历网格的每个单元格
        for (i in 0 until m) {
            for (j in 0 until n) {
                // 如果当前单元格是 '1' 并且未被访问过
                if (grid[i][j] == '1' && !vis[i][j]) {
                    ret++ // 计数增加
                    dfs(grid, i, j) // 调用深度优先搜索方法
                }
            }
        }
        return ret // 返回计数结果
    }

    fun dfs(grid: Array<CharArray>, i: Int, j: Int) {
        // 标记当前节点为已访问
        vis[i][j] = true
        // 遍历四个方向
        for (k in 0..3) {
            val x = i + dx[k] // 计算新位置的 x 坐标
            val y = j + dy[k] // 计算新位置的 y 坐标
            // 如果新位置在网格内，是 '1' 并且未被访问过
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1' && !vis[x][y]) {
                dfs(grid, x, y) // 递归调用深度优先搜索方法
            }
        }
    }
}