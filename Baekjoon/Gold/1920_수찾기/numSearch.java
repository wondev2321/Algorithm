/* 첫줄 자연수 N
N개의 A 정수 배열 A[1] A[2] A[3] A[4] ... A[N]
자연수 M
M개의 정수들
M개의 정수들 값이 A[]배열 값에 존재하면 1 존재하지 않으면 0

<슈도>
#HashSet 생성
#int[] result 변수 생성

#N 크기 변수 저장

#int[] 생성
#입력값 넣기

#M 크기 변수 저장
#for문 N번 반복문
#HashSet if set.cotains(N[i])을 통해 있으면 1 없음 0
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;


public class numSearch {
    public static void main(String[] args) throws IOException{
        String input = "5\r\n4\n1\n5\n2\n3\r\n5\r\n1\n3\n7\n9\n5";

        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader(input));


        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> set = new HashSet<>(); 



        int N = Integer.parseInt(br.readLine());
        System.out.println(N);
        ArrayList<Integer> result = new ArrayList<>();
        int[] arrayA = new int[N];

        for(int i = 0; i < N; i++){
            arrayA[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            set.add(Integer.parseInt(st.nextToken())); 
        }


        for(int i = 0; i<N; i++){
            if(!set.isEmpty() && set.contains(arrayA[i])){
                result.add(1);
            }else{
                result.add(0);
            }
        }

        for (int el : result) {
            System.out.println(el);
        }
        
    }

    
}