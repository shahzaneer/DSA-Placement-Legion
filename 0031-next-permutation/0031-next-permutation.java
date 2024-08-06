class Solution {
    public void nextPermutation(int[] nums) {
    int PivotIndex = -1;
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                PivotIndex = i;
                break;
            }
        }

        if(PivotIndex == -1){
            reverseArray(nums);
            return;
        }

        for(int i=nums.length - 1; i>PivotIndex; i--){
            if(nums[i] > nums[PivotIndex]){
                int temp = nums[i];
                nums[i] = nums[PivotIndex];
                nums[PivotIndex] = temp;
                break;
            }
        }

        Arrays.sort(nums, PivotIndex+1, nums.length);
        return;
    }

    static void reverseArray(int [] array){
        for(int i = array.length - 1; i >= 1; i--){
            for(int j = 0; j<= i - 1; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
    
        }
    }


}