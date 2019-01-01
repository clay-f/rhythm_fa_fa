package com.f.java.generic;

/**
 * 泛型边界的行为.
 *
 * 使用 javap -c SimpleHolder 查看字节码信息
 *
 *
 * <p>
 * 在获取获取 item 时，需要类型检查，将 obj 转化为 String
 */
class SimpleHolder {
    private Object obj;

    public void set(Object obj) {
        this.obj = obj;
    }

    public Object get() {
        return obj;
    }

    public static void main(String[] args) {
        SimpleHolder holder = new SimpleHolder();
        holder.set("Item");
        String s = (String) holder.get();
    }
}

/**
 * 在 setObj 时，在编译器会接受类型检查。
 * 在 getObj 时对值的转型仍旧时需要的，这时由编译器自动插入。
 *
 * 由于所产生的 get set 的字节码都相同，所以在泛型中所有动作都发生在边界处 --- 对传进来的值进行类型检查，并插入对传递出去的值的转型。
 *
 * <strong>边界是发生动作的地方</strong>
 * @param <T>
 */
class GenericHolder<T> {
    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public static void main(String[] args) {
        GenericHolder<String> holder = new GenericHolder();
        holder.setObj("Item");
        String s = holder.getObj();
    }
}

public class GenericScripeAction {

}
