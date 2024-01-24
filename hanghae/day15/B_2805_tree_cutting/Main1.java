package hanghae.day15.B_2805_tree_cutting;

import java.io.IOException;
import java.util.Scanner;
public class Main1 {
    
    public static void main(String[] args)throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long [] treeLen = new long [n];

        
        for(int i = 0; i<treeLen.length; i++){
            treeLen[i] = sc.nextInt();
        }
        
        long start = 0;
        long end = (int)1e9; //10의 9승 10^9
        long result = 0;

        while(start <= end){
            long total = 0;

            long  mid = (start + end) / 2;

            for(int k = 0; k < n; k++){
                if(treeLen[k] > mid){
                    total += treeLen[k] - mid;
                }
            }

            if(total < m){
                end = mid - 1;
            }else{
                result = mid;
                start = mid + 1;
            }
        }
        System.out.println(result);
    }
}
