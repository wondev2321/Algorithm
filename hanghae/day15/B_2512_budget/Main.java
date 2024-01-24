package hanghae.day15.B_2512_budget;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] budgetPrice = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int index = 0;
        while(st.hasMoreTokens()) {
            budgetPrice[index] = Integer.parseInt(st.nextToken());
            index += 1;
        }

        for(int el : budgetPrice){
            Arrays.binarySearch(budgetPrice, index)
        }
    }
}
