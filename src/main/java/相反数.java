import java.util.Scanner;
import java.util.Stack;

public class 相反数 {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        search(n);
    }

    public static void search(int n ){
        int re=Integer.parseInt(String.valueOf(new StringBuffer(Integer.toString(n)).reverse()));
        System.out.println(re+n);
    }


}
