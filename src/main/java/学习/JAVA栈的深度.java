package 学习;

public class JAVA栈的深度 {

    private int count = 0;

    public void testAdd() {
        count++;
        testAdd();
    }

    public void test() {
        try {
            testAdd();
        } catch (Throwable e) {
            System.out.println(e);
            System.out.println("栈深度:" + count);
        }
    }

    public static void main(String[] args) {
        new JAVA栈的深度().test();
    }

}
