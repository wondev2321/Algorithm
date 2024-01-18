
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//버블 정렬 O(N^2)
public class Main {
    
    static public void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int testcace = Integer.parseInt(br.readLine());
        int[] num = new int[testcace]; 
        for(int i = 0; i < num.length; i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i<num.length - 1; i++ ){
            for (int j = 0; j < num.length - 1 - i; j++) {
                if (num[j] > num[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                }
            }
        }

        for(int el : num){
            System.out.println(el);
        }

    }
}
