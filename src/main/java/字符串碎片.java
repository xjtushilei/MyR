import java.util.Scanner;

public class 字符串碎片 {
    public static void main(String[] args){
//        Scanner s=new Scanner(System.in);
//        String n=s.next();
//        search(n);
        search("dccbbbbebeacdbbbbdbaaaabbeeeeaaddeeeeaabbbeeecdccc");
    }

    private static void search(String n ){
        if (n.length()==0){
            System.out.println(0);
        }
        float sum=n.length();
        char temp=n.charAt(0);
        int temp_num=0;
        int type=1;
        for (int i =0;i<n.length();i++){
            if (temp!=n.charAt(i)){
                temp=n.charAt(i);
                temp_num=i;
                type++;
            }
        }
        if (temp_num!=n.length()-1 && temp!=n.charAt(n.length()-1)){
            type++;
        }
        System.out.format("%.2f",sum/type);
    }


}
