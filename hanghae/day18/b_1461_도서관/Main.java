package hanghae.day18.b_1461_도서관;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/** 도서관 문제
 * 
 * 각 책들의 원래 위치가 주어질때 책을 모두 제자리에 놔둘때 드는 최소 걸음 수 계산
 * 세준 한 걸음에 좌표 1칸 이동
 * 책을 모두 제자리에 놔둔후 다시 0으로 돌아올필요 x
 * 세준이는 한번에 최대 M권의 책을 들수 있다.
 * 
 * 첫줄 
 * N : 책의 개수 N <= 50
 * M : 세준이 한번에 들수 있는 책의 개수 M <= 50
 *
 * 둘째줄
 * 책의 좌표 0 x / -10000<=point<=10000 
 * 
 * [6, 2]
 * [-37, 2, -6, -39, -29, 11, -28]
 * [-39, -37, -29, -28, -6, 0 , 2, 11]
 * (-39,-37),(-29, -28), (-6), (2, 11)
 * -39, -29, -6, 11
 * 39, 29, 6, 11
 * 6, 11, 29, 39
 * 6*2 + 11*2 + 29*2 + 39 => 12 + 22 + 58 + 39 = 34 + 97 = 131  
 */
public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        int[] book = new int[n+1];
        ArrayList<Integer> resultArray = new ArrayList<>();
        int originPoint = 0;
        int result = 0;

        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i< n; i++){
            book[i] = Integer.parseInt(st.nextToken());
        }
        book[n] = 0;

        Arrays.sort(book);

        for(int j = 0; j <= n; j++){
            if(book[j] == 0){
                originPoint = j;
            }
        }

        for(int i = 0; i < originPoint; i += m){
            resultArray.add(Math.abs(book[i]));
        }

        for(int j = n; j > originPoint; j -= m){
            resultArray.add(book[j]);
        }
        
        Collections.sort(resultArray);

        for(int k = 0; k < resultArray.size(); k++){
            if(k != resultArray.size() - 1){
                result += resultArray.get(k) * 2;
            }else{
                result += resultArray.get(k);
            }
        }

        System.out.println(result);
        
    }
    
}
