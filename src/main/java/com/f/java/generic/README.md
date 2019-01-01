# 泛型

### 擦除

> 在泛型代码内部，无法获得任何有关泛型参数类型的信息

当使用泛型时，任何具体的类型都被擦除，你唯一知道就是你正在使用一个对象。

```java
List<Integer> 和 List<String> //在运行时事实上是相同的类型。

List<Integer> List  //这两种形式都将被擦除为他它们的原生类型 List

```

### 边界
> 将类型参数限制为某个类型的子集，那么你就可以使用这个类型子集来调用方法。 Java 泛型重用了 `extends` 关键字

> 注意: `extends` 关键字在泛型边界上下文与普通环境下的意义是完全不同的

```java

 /*
    泛型会将类型参数擦除到它的第一个边界。编译器实际上会把类型参数替换为它的擦除.
    T 会被擦除到 Foo，就好像在类的声明中用 Foo 替换了 T 一样
 */

 public class Foo {}
    
 public class Bar<T extends Foo> {}
``` 

### 通配符

* <? extends T> 具有任何从 Fruit 继承的类型列表。
通配符引用的是明确的类型，因此它意味着某种 list 没有具体类型。因此这个被赋值的 list 必须持有如 fruit 或 apple 这种指定的某种类型.

你不能向 list 添加任何子类对象，因为 ArrayList 被向上转型以后，编译器并不知道你添加的类型是什么，所有不能向 list 添加任何对象，甚至是 Object
```java
    List<? extends Number> numberList = new ArrayList<>();
    numberList.add(1); //error
    numberLIst.add(1.1); //error
```

* <? super T> 通配符是由某个特定类的任何基类定界
参数 T 是某种基类型的 List，这样你就知道向其中添加 Apple 或 Apple 的子类型是安全的。既然 T 是下界，那么向 list 添加任何非 T 的子类都是不安全的。

注意: 不能对泛型参数给出超类边界 `<T super MyClass>`

* <?> 无界通配符意味着 "任何事物"，因此使用无界通配符好像等驾驭原生类型。

编译器很少关心使用的是原生类型还是 `<?>` ，<?> 可以被认为是一种装饰: 用 Java 泛型来定义类型，且不使用原生类型。
```java
Map<?, ?> map, Map<String, ?>
```
