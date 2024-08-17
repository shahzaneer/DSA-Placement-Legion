
import java.util.Arrays;

// You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

// Merge nums1 and nums2 into a single array sorted in non-decreasing order.

// The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.


// Example 1:

// Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
// Output: [1,2,2,3,5,6]
// Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
// The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

public class MergeArray {
    public static void main(String[] args) {
        int num1[] = { 1, 2, 3, 0, 0, 0 };
        int num2[] = { 2, 5, 6 };

        int n = 3;
        int m = 3;
        System.out.println("Pakistan noor hai aur Noor ko zawal nhi!");
        merge(num1, m, num2, n);
        System.out.println(Arrays.toString(num1));
        System.out.println(Arrays.toString(num2));

    }
    //! brute: TC: O(2(max of (m,n))) SC: O(n+m)
    static public void merge(int[] nums1, int m, int[] nums2, int n) {
       int [] array = new int[m+n];
       int left = 0;
       int right = 0;
       int index = 0;

    //    array filling
       while(left < m && right < n){
        if(nums1[left] < nums2[right]){
            array[index] = nums1[left];
            left++;
        }else{
            array[index] = nums2[right];
            right++;
        }
        index++;
       }

    //    if one of the arrays got exhausted
       while(left < m){
        array[index++] = nums1[left++];
       }
       while(right < n){
        array[index++] = nums2[right++];
       }

    //    Putting back
    for(int i = 0; i<array.length; i++){
        if(i<m)  nums1[i] = array[i];
        else nums2[i-n] = array[i];
    }

    }

    //! Optimal: TC: O(m + 2(nlogn)) SC: O(1)
    static void mergeOptimal(int [] nums1, int m, int [] nums2, int n){
        int left = m-1;
        int right = 0;
        
        while (left >= 0 && right < m) {
            if (nums1[left] > nums2[right]) {
                int temp = nums1[left];
                nums1[left] = nums2[right];
                nums2[right] = temp;
                left--;
                right++;
            } 
            else {
                break;
            }
    
        // Sort both the arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
    }
    }

    
}