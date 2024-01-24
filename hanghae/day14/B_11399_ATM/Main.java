package hanghae.day14.B_11399_ATM;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 그리디 알고리즘
 * 문제 해석
 *  ATM : 가장 적은 시간을 갖는 사람부터 정렬후 합계를 더해 최솟값을 반환한다.
 */
public class Main {
    
    public static void main(String[] args)throws IOException{
        //System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        Map<Integer, Integer> peopleNum = new HashMap<>(testcase);
        
        String[] strs = br.readLine().split(" ");
        int sum = 0;
        int[] result = new int[testcase];

        for(int i = 0; i < peopleNum.size(); i++){
            peopleNum.put(i + 1, Integer.parseInt(strs[i]));
        }
		List<Integer> keys = new ArrayList<>(peopleNum.keySet()); 

        Collections.sort(keys, (v1, v2) -> (peopleNum.get(v1).compareTo(peopleNum.get(v2)))); 

        int j = 0;
        for (int key : keys) { // Map 정렬되지 않는 자료구조라고 들었다 어떻게 키값은 정렬이 되는지?
			sum +=  peopleNum.get(key);
            result[j] = sum;
            j += 1;
		}

        sum = 0;
        for(int el : result){
            sum += el;
        }

        System.out.println(sum);
    }
}
