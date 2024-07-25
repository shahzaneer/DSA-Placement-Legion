class Solution {
    public int[] sortArray(int[] nums) {
      mergeSortHelper(nums, 0, nums.length-1);
      return nums;  
    }

    static void mergeSortHelper(int [] array, int low, int high){
    if(low == high) return;

    int mid = (low+high)/2;
    mergeSortHelper(array, low, mid);
    mergeSortHelper(array, mid + 1, high);
    merge(array,low, mid, high);
}

static void merge(int [] array, int low, int mid, int high){
    ArrayList<Integer> temp = new ArrayList<>();
    int left = low;
    int right = mid + 1;

    while(left <= mid && right <= high){
        if(array[left] <= array[right]){
            temp.add(array[left]);
            left++;
        }
        else{
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
        array[i] = temp.get(i- low);
    }

}

}