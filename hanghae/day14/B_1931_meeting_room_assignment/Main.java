package hanghae.day14.B_1931_meeting_room_assignment;

/**
 * 
 * 수업을 시작하는 시간 순으로 정렬한 후, 다음과 같은 방법으로 강의실을 할당합니다.
   현재 강의실이 비어 있으면, 현재 수업을 그 강의실에서 듣는다.
   현재 강의실이 이미 차 있으면, 새로운 강의실을 할당한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer[][] classTime = new Integer[n][2]; 
        
        
        int index = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            classTime[index][0] = Integer.parseInt(st.nextToken());
            classTime[index][1] = Integer.parseInt(st.nextToken());
            index += 1;
        }

        Arrays.sort(classTime);

        int count = 1;
        int class_start = classTime[0][0];
        int class_end = classTime[0][1];
        for(int j = 1; j < n; j++){
            if( class_start <= classTime[j][0] && class_end > classTime[j][1]){
                count++;
            }else{
                class_start = classTime[j][0];
                class_end = classTime[j][1];
            }
        }
        System.out.println(count);
    }
}

