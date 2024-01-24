package hanghae.day15._class;

import java.io.IOException;

/**
 * FixedPoint
 */
public class FixedPoint {

    public static int fixedPoint(int[] array){
        int start = 0;
        int end = 0;

        while(start < end){
            int mid = (start + end) / 2;
            if(array[mid] < mid){
                start = mid + 1;
            }else {
                end = mid;
            }
        }

        if(start < array.length && start == array[start]){
            return start;
        }else{
            return -1;
        }
    }
    public static void main(String[] args)throws IOException{

    }
}