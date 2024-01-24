package hanghae.day14.B_13305_filling_station;



/** 주유소
 * 1 입력값 도시의 개수 : N
 * 2 입력값 도시와 도시의 거리 배열 N-1
 * 3 입력값 도시의 리터당 가격 배열 N
 *  제일 왼쪽 도시 부터 제일 오른쪽 도시까지 거리 1~1,000,000,000
 *  리터당 가격 범위 1 ~ 1,000,000,000
 * 왼쪽에서 오른쪽 도시로 이동하는 최소의 비용을 계산하는 프로그램을 작성하라
 * 
 * 서브 태스크 
 * 모든 주유소의 리터당 가격은 1원이다. - 17점
 * 2 <= N <= 1,000 / 도시거리 최대 10,000/ 리터당 가격 최대 10,000 - 41점
 * 원래의 조건 - 42점
 * 
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] cityDis = new int[n - 1];
        int[] oPrice = new int[n];
        int totalDis = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int index = 0;
        while(st.hasMoreTokens()) {
            cityDis[index] = Integer.parseInt(st.nextToken());
            totalDis += cityDis[index];
            index += 1;
        }
        
        st = new StringTokenizer(br.readLine());
        index = 0;
        while(st.hasMoreTokens()) {
            oPrice[index] = Integer.parseInt(st.nextToken());
            index += 1;
        }

        System.out.println(totalDis);
    }
}
