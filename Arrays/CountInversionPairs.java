import java.util.ArrayList;

public class CountInversionPairs {
    public static void main(String[] args) {
        int [] array = {5, 4, 3, 2, 1};
        System.out.println(countInversionPairsBrute(array));
        System.out.println(countInversionPairsOptimal(array));
    }
    //TODO: i < j && array[i] > array[j] then (array[i],array[j]) is a inversion Pair

    //! Brute: TC: O(n^2) SC: O(1) - trying all possible solutions
    static int countInversionPairsBrute(int [] array){
        int cunt = 0;
        for(int i = 0; i<array.length; i++){
            for(int j = i+1; j<array.length; j++){
                if(array[i] > array[j]){
                    cunt++;
                }
            }
        }
        return cunt;
    }
    //! Optimal: TC: O(n log n) SC: O(n) - merge sort modification
    static int countInversionPairsOptimal(int [] array){
        // initlialized count in both functions to be zero and make it return from both ends.
        // Also when array[left] > array[right] then I have count+= (mid - low + 1);

        return mergeSortHelper(array, 0, array.length -1 );
    }
    static int mergeSortHelper(int [] array, int low, int high){
        int count = 0;
    if(low == high) return count;

    int mid = (low+high)/2;
    count+= mergeSortHelper(array, low, mid);
    count+= mergeSortHelper(array, mid + 1, high);
    count+= merge(array,low, mid, high);
    return count;
}
    static int merge(int [] array, int low, int mid, int high){
    int count = 0;
    ArrayList<Integer> temp = new ArrayList<>();
    int left = low;
    int right = mid + 1;

    while(left <= mid && right <= high){
        if(array[left] <= array[right]){
            temp.add(array[left]);
            left++;
        }
        // Array[Left] is Greater (here is the modicifation code)
        else{
            count+= (mid - left + 1);
            temp.add(array[right]);
            right++;
        }
    }

    // if right array is exhausted
    while(left <= mid){
        temp.add(array[left]);
        left++; 
    }

    // if left array is exhausted
    while(right <= high){
        temp.add(array[right]);
        right++;
    }

    // Copying the temp sorted elements in Original array
    for(int i= low; i<= high; i++){
        array[i] = temp.get(i- low); //(low - low = 0) then (low+1 - low = 1) then (low+2-low = 2 and so on...)
    }
    return count;
}

}
