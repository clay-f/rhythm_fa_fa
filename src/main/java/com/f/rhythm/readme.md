# 解决问题一些思路

## 动态规划

### 特点

* 计数。有多少种不同的方式完成什么事情
* 求最大值最小值。找出什么事情的最大值(最优解、最多、最少类似)
* 求存在性。是否存在一种方法达到什么效果

### 求解思路
* 确定状态。

  最后一步

  子问题。通过最后一步，将问题分解为子问题

* 转移方程
* 初始条件和边界情况。
  初始值、数组越界问题要注意，写程序要定义好
* 计算顺序
```
2,5,7三种硬币找出最少的硬币组合值为27

1.确定状态
最后一步 ak，最优策略的最后一步。最少的硬币组合，最后一枚硬币
 
2.转移方程
f[x] = min{f[x-2]+1, f[x-5]+1, f[x-7]+1}

3.初始条件、边界
f[0] = 0,不能拼出y,f[y] = 正无穷

4. 计算顺序
f[0], f[1],...


@Test
void bitCalc() {
   System.out.println(coin(new int[]{2, 5, 7}, 2));
}


public int coin(int[] arr, int m) {
    int[] f = new int[m + 1];
    int n = arr.length;
    f[0] = 0;

    int i, j;
    for (i = 1; i <= m; ++i) {
        f[i] = Integer.MAX_VALUE;
        for (j = 0; j < n; ++j) {
            if (i >= arr[j] && f[i - arr[j]] != Integer.MAX_VALUE) {
                f[i] = Math.min(f[i - arr[j]] + 1, f[i]);
            }
        }
    }

    if (f[m] == Integer.MAX_VALUE) {
        f[m] = -1;
    }
    return f[m];
}


```

## 递归

### 特点

重复、连续的做什么事情。

#### 求解思路。就像旅行一样

* 知道终点在哪里
* 怎么走下一步
* 将每一步连接起来


#### 类型

* 线性递归。

  该递归最常用，它通过一种简单的方式调用自己，并通过一个终止条件终止自身.这个调用过程称之为“缠绕(Winding)”,当函数返回给调用者时称之为“解除缠绕(Un-Winding)”。递归终止条件是我们已知的基础条件.

```
// 计算阶乘
public int Fact(int n) {
    if (0 > n)
        return -1;
    if (0 == n) {
        return 1;
    } else {
        return (n * Fact(n - 1));
    }
}
```


* 二分递归。

  二分递归是一个函数一次调用两次而不是一次调用一次的过程。它主要用于数据结构中，如树的遍历、查找高度、合并等操作。

```
//斐波那契数列
public int FibNum(int n) {
    // Base conditions
    if (n < 1)
        return -1;
    if (1 == n || 2 == n)
        return 1;

    // Recursive call by Binary Method
    return FibNum(n - 1) + FibNum(n - 2);
}
```

* 尾递归

  如果一个函数中所有递归形式的调用都出现在函数的末尾，我们称这个递归函数是尾递归的。当递归调用是整个函数体中最后执行的语句且它的返回值不属于表达式的一部分时，这个递归调用就是尾递归。尾递归函数的特点是在回归过程中不用做任何操作，这个特性很重要，因为大多数现代的编译器会利用这种特点自动生成优化的代码。
```
//如果参数初始值太大，线性递归会导致栈溢出
public int func(int n) {
    if (n <= 1) return 1;
    return (n * func(n - 1));
}

//采用尾递归优化
public int tailFunc(int n, int res) {
    if (n <= 1) return res;

    return tailFunc(n - 1, n * res);
}

```

* 嵌套递归

  指一种递归定义函数的模式.在递归定义函数f时，为了确定f在某处的值(如f(u,x+1))，可以利用在它“之前”的一些f之值(例如f<u,x)等)，假若这些f值本身又依赖于f的其他一些“在前”的f值，则这种f的递归定义方式称为嵌套的