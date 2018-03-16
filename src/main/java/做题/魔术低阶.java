package 做题;

import java.util.Scanner;
import java.util.Stack;

public class 魔术低阶 {
    public static Stack<Integer> stack=new Stack<Integer>();

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        search(n);
    }

    public static void search(int n ){
        if (n==0){
            for (int i = stack.size()-1; i>=0; i--){
                System.out.print(stack.get(i));
            }
            return ;
        }
        if ((n-1)%2==0){
            stack.push(1);
            search((n-1)/2);
            stack.pop();
        } else {
            stack.push(2);
            search((n-2)/2);
            stack.pop();
        }
    }


}
