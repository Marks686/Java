#变量
# 方差
#1.先计算平均值
#2.针对数字 分别计算数字和平均值的差值，在平方
#3.把上述的平方相加
#4.除以项数 -1
avg = (67.5 + 89.0 + 12.9 + 32.2) / 4
total = (67.5 - avg) ** 2 + (89.0 - avg) ** 2 + (12.9 - avg) ** 2 + (32.2 - avg) ** 2
result = total / 3
print(result)