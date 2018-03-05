package 学习;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//接口类 计算接口
interface ICal {
    public int Cal(int a, int b);
}

//  加法实现
class ClassAdd implements ICal {
    @Override
    public int Cal(int a, int b) {
        System.out.println("ClassAdd！");
        return a + b;
    }
}

// 减法实现
class ClassSub implements ICal {
    @Override
    public int Cal(int a, int b) {
        System.out.println("ClassSub！");
        return a - b;
    }
}


//动态代理类，实现InvocationHandler接口
class DynamicProxy implements InvocationHandler {
    private Object target;

    public DynamicProxy(Object ac) {
        this.target = ac;
    }

    //动态生成代理对象
    public Object getDynamicProxyObject() {
        return Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] arg)
            throws Throwable {
        //调用之前可以做一些处理
        System.out.println("Method before！");
        Object result = method.invoke(target, arg);
        //调用之后也可以做一些处理
        System.out.println("Method after！");
        return result;
    }
}

public class 动态代理反射实现 {
    public static void main(String[] args) {

        //创建加法类的代理对象
        ICal calProxyObject = (ICal) new DynamicProxy(new ClassAdd()).getDynamicProxyObject();
        //调用加法类的计算方法。
        int add = calProxyObject.Cal(5, 3);
        System.out.println(add);
    }
}
