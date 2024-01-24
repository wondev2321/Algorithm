package hanghae.day14.B_13305_filling_station;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] cityDis = new long[n - 1];
        long[] oPrice = new long[n];
        long result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int index = 0;
        while(st.hasMoreTokens()) {
            cityDis[index] = Long.parseLong(st.nextToken());
            index += 1;
        }
        
        st = new StringTokenizer(br.readLine());
        index = 0;
        while(st.hasMoreTokens()) {
            oPrice[index] = Integer.parseInt(st.nextToken());
            index += 1;
        }

        long minPrice = oPrice[0];
        for(int i = 0; i< n - 1; i++){
            if(minPrice > oPrice[i]){
                minPrice = oPrice[i];
            }
            result += cityDis[i] * minPrice;
        }

        System.out.println(result);
    }
}
