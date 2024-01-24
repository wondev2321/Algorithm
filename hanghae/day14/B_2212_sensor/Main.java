package hanghae.day14.B_2212_sensor;

/** 센서
 * 첫째줄 입력 : N 센서 개수 1~10000
 * 둘째줄 입력 : K 집중국의 개수
 * 셋째줄 입력 : N개의 센서의 좌표가 한개의 정수로 N개 / 절대값 1,000,000
 * 결과값 : 최대 K개의 집중국의 수신 가능 영역의 길이의 합의 최솟값을 출력한다.
 *          즉 K개인 집중국으로 모든 세선를 커버할수 있도록하는 각 집중국 범위 합을 최소값을 구하는 문제
 */
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args)throws IOException{
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] sensorPos = new int[n];
        int[] sensorDis = new int[n - 1];

        if(k >= n){
            System.out.println(0);
            return ; 
        }
        
        for(int i = 0; i<n; i++){
            sensorPos[i] = sc.nextInt();
        }

        Arrays.sort(sensorPos);

        for(int j = 1; j < n - 1; j++){            
            sensorDis[j] = sensorPos[j] - sensorPos[j - 1];
        }
        Integer[] arrtemp = Arrays.stream(sensorDis).boxed().toArray(Integer[]::new);
        Arrays.sort(arrtemp, Collections.reverseOrder());


        int sum = 0;
        for(int i = k-1; i < n-1; i++){
            sum += arrtemp[i];
        }

        System.out.println(sum);
    }
}
