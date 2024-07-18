package `48days`.day7

class Test3 {
}

import java.util.* // 导入 Java 标准库中的 Scanner 和 Arrays 类

object Main {
    // 定义公共类 Main
    @kotlin.jvm.JvmStatic
    fun main(args: Array<String>) { // 主方法入口
        val `in` = Scanner(System.`in`) // 创建 Scanner 对象用于读取输入
        var t = `in`.nextInt() // 读取测试用例的数量
        val arr = IntArray(6) // 创建一个长度为 6 的整数数组

        // 处理每个测试用例
        while (t-- != 0) {
            for (i in 0..5) { // 通过 for 循环读取 6 个整数到数组 arr
                arr[i] = `in`.nextInt() // 将读取的整数存储在数组 arr 的相应位置
            }
            Arrays.sort(arr) // 对数组 arr 进行排序

            // 检查数组是否满足特定的条件
            if ( // 条件 1: 前两个数的和大于第三个数，且第四个数和第五个数的和大于第六个数
                    arr[0] + arr[1] > arr[2] && arr[3] + arr[4] > arr[5] ||  // 条件 2: 第一个数和第三个数的和大于第四个数，且第二个数和第五个数的和大于第六个数
                    arr[0] + arr[2] > arr[3] && arr[1] + arr[4] > arr[5] ||  // 条件 3: 第一个数和第四个数的和大于第五个数，且第二个数和第三个数的和大于第六个数
                    arr[0] + arr[3] > arr[4] && arr[1] + arr[2] > arr[5] ||  // 条件 4: 第一个数和第五个数的和大于第六个数，且第二个数和第三个数的和大于第四个数
                    arr[0] + arr[4] > arr[5] && arr[1] + arr[2] > arr[3]) {
                println("Yes") // 如果任一条件满足，输出 "Yes"
            } else {
                println("No") // 如果所有条件都不满足，输出 "No"
            }
        }
        `in`.close() // 关闭 Scanner 对象
    }
}