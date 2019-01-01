# lambda -> functional & stream

> 随着对函数式编程、代码参数化、多线程的需求于是出现了 lambda 与 stream

## lambda
> () -> expression / () -> { statements; }

lambda 又三部分组成: 1. 参数列表 2. 箭头 3. lambda 方法体

 lambda 只能出现在有函数接口的地方

## 函数接口
> 若一个接口只有一个抽象方法，则这个方法叫做函数描述符，这个接口被称为函数式接口. 通常接口会被加上 `@FunctionalInterface` 标记

### 类型检查、类型推断、限制
* 类型检查
lambda 的类型是根据使用 lambda 的上下文推断出来的。上下文(接受它传递的方法的参数、接受它的值的局部变量) 中表达式所需要的类型称为目标类型
```java
Function<Integer, Integer> f = x -> x + 1
  
// 当前上下文所期望的类型为 Function<Integer, Integer>，接口的描述符为 R apply(A a) 接受一个 Integer 返回一个 Integer 因此代码类型检查正确
```

* 类型推断
> 编译器会从目标类型推断出用什么函数式接口，有了函数式接口，那么它也可以推断出合适的 lambda 签名

* 限制
> lambda 所使用的局部变量必须是 final 

函数接口使用 lambda 要求: 
* 方法签名必须一致
```java
public interface A {
    int foo(Integer i);
}

// 其 lambda 表达式为: i -> i 
// 若函数描述符只有一个参数，则可以省略括号
```

## stream
> java 集合框架主要用来保存与操作值，把对值的计算交给 stream 

* 查找、匹配、归约求值
* 收集器: 归约、分组、分区
 
 