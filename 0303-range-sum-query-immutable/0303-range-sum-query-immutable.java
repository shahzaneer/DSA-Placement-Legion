class NumArray {
    int [] array;
    public NumArray(int[] nums) {
       array = new int [nums.length]; 

       for(int i=0; i<nums.length; i++){
        array[i] = nums[i];
        // Prefix sum to be stored in array
        if (i>0) array[i] = array[i-1] + array[i];
       }
    }
    
    public int sumRange(int left, int right) {
        return array[right] - (left > 0 ? array[left - 1]: 0);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */