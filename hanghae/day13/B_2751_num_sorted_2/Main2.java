import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//퀵정렬 최선 O(NlogN) 최악일 경우 o(N^2)
public class Main2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int testcace = Integer.parseInt(br.readLine());
        int[] num = new int[testcace]; 

        for(int i = 0; i < num.length; i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        //퀵정렬
        quicksort(num, 0, num.length - 1);

    }

    public static int[] quicksort(int[] lst, int start, int end) {
        if (start >= end) {
            return lst;
        }

        int p = partition(lst, start, end);
        quicksort(lst, start, p - 1);
        quicksort(lst, p + 1, end);
        return lst;
    }

    private static int partition(int[] part, int ps, int pe) {
        int pivot = part[pe];
        int i = ps - 1;

        for (int j = ps; j < pe; j++) {
            if (part[j] <= pivot) {
                i++;
                // Swap part[i] and part[j]
                int temp = part[i];
                part[i] = part[j];
                part[j] = temp;
            }
        }

        // Swap part[i + 1] and part[pe]
        int temp = part[i + 1];
        part[i + 1] = part[pe];
        part[pe] = temp;

        return i + 1;
    }
}
