public class Dior {
    public static void main(String[] args) {
        int i = 0;
        say(i++);
        System.out.println("方法调用完之后的 i: " + i);
    }

    public static void say(int a) {

        System.out.println("调用方法获取 i 值 :"+a);
    }
}
