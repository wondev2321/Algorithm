package hanghae.day14.B_11399_ATM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2 {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        String[] strs = br.readLine().split(" ");

        int[] waitTime = new int[testcase];

        for(int i = 0; i < waitTime.length; i++){
            waitTime[i] = Integer.parseInt(strs[i]);
        }

        Arrays.sort(waitTime);

        int sum = 0; 
        int prev = 0;

        for(int j = 0; j < waitTime.length; j++){
            sum += waitTime[j] + prev;

            prev += waitTime[j];
        }

        System.out.println(sum);
    }
    
}
