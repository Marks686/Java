package `48days`.day7

import java.io.BufferedReader
import java.io.InputStreamReader

class Test2 {
}

import java.util.Scanner // 导入Scanner类，用于获取用户输入
import java.io.* // 导入java.io包，用于处理IO操作

object Main {
    @kotlin.jvm.Throws(Exception::class)
    @kotlin.jvm.JvmStatic
    fun main(args: Array<String>) { // 主方法入口
        val br = BufferedReader(InputStreamReader(System.`in`)) // 创建BufferedReader对象读取用户输入
        val s: CharArray = br.readLine().toCharArray() // 读取一行字符串并转换为字符数组
        var begin = -1
        var len = 0
        val n = s.size // 初始化变量，begin记录最长数字串的起始索引，len记录长度，n为字符串长度
        run {
            var i = 0
            while (i < n) {
                // 遍历字符串的每个字符
                if (s[i] >= '0' && s[i] <= '9') { // 如果当前字符是数字
                    var j = i // j作为记录连续数字串结束位置的索引
                    while (j < n && s[j] >= '0' && s[j] <= '9') { // 寻找连续的数字串
                        j++ // 移动到下一个字符
                    }
                    if (j - i > len) { // 如果当前连续数字串长度大于之前记录的长度
                        begin = i // 更新最长数字串的起始索引
                        len = j - i // 更新最长数字串的长度
                    }
                    i = j // 跳过已经检查的连续数字，继续检查后面的字符
                }
                i++
            }
        }
        for (i in begin until begin + len) { // 从最长数字串的起始索引开始，打印最长的数字串
            print(s[i]) // 打印当前字符
        }
    }
}