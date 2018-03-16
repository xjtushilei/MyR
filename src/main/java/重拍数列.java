import java.util.LinkedList;
import java.util.Scanner;

public class 重拍数列 {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        while (n-->0){
            int len=s.nextInt();
            int[] arr = new int[len];
            for(int i = 0; i < len; i++){
                arr[i] = s.nextInt();
            }
            if (search(arr)){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        }

    }

    public static LinkedList<Integer> list=new LinkedList<>();
    public static boolean search(int[] n ){
        if (list.size()==n.length){
            return true;
        }
        boolean flag=false;
        for (int i=0;i<n.length;i++){
            if (!list.contains(n[i])){
                list.add(n[i]);
                if (list.size()>=2){
                    if (check(list)){
                        flag=search(n);
                        list.remove(new Integer(n[i]));
                    }
                    else{
                        list.remove(new Integer(n[i]));
                        break;
                    }
                }
            }
        }
        return flag;
    }
 public static boolean search1(int[] n ){
        if (list.size()==n.length){
            return true;
        }
        boolean flag=false;
        for (int i=0;i<n.length;i++){
            if (!list.contains(n[i])){
                list.add(n[i]);
                if (list.size()>=2){
                    if (check(list)){
                        flag=search(n);
                        list.remove(new Integer(n[i]));
                    }
                    else{
                        list.remove(new Integer(n[i]));
                        break;
                    }
                }
            }
        }
        return flag;
    }

    public static boolean check(LinkedList<Integer> list){
        for (int i =1;i<list.size();i++){
            if (list.get(i)*list.get(i-1)%4!=0){
                return false;
            }
        }
        return true;
    }


}
