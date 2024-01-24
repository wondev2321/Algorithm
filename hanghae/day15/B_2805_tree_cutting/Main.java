package hanghae.day15.B_2805_tree_cutting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 나무 자르기 - 파라 메트릭 서치 
// int N : 나무수 (1 ≤ N ≤ 1,000,000)
// int M : 가져가야할 나무 길이 (1 ≤ M ≤ 2,000,000,000)
// int[] treeLen : 나무 길이 
//int 최대값 : 2,147,483,647
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] treeLen = new int[n];
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<treeLen.length; i++){
            treeLen[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = (int)1e9;
        while(start <= end){
            long total = 0;

            int mid = (start + end) / 2;

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
