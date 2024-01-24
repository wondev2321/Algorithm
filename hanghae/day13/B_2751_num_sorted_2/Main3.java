package hanghae.day13.B_2751_num_sorted_2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3 {
    static int[] sorted, resultArr;
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(br.readLine());
        
        int[] num = new int[testcase];
        for(int i = 0; i < num.length; i++){
            num[i] = Integer.parseInt(br.readLine()); 
        }

        mergesort(num, 0, num.length - 1);
        
        for(int el : num){
            System.out.println(el);
        }
    }
    public static void merge(int[] arr, int start, int end, int mid){
       int i = end;
       int j = mid + 1;
       int k = end;
       sorted = new int[end];

        while(i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                sorted[k] = arr[i];
                i++;
            }
            else {
                sorted[k] = arr[j];
                j++;
            }
            k++;
        }

        // 남은 데이터도 삽입
        if (i > mid) {
            for (int z = j; z <= end; z++) {
                sorted[k] = arr[z];
                k++;
            }
        }
        else {
            for (int z = i; z <= mid; z++) {
                sorted[k] = arr[z];
                k++;
            }
        }
        
        // 정렬된 배열을 삽입
        for (int z = start; z <= end; z++) {
            arr[z] = sorted[z];
        }
    }

    public static void mergesort(int[] list, int start, int end){
        if(start < end){
            int mid = list.length / 2;
            mergesort(list, start, mid);
            mergesort(list, mid + 1, end);
            merge(list, start, mid, end);        
        }
    }
}
