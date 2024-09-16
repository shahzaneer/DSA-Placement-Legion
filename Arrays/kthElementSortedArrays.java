import java.util.ArrayList;

public class kthElementSortedArrays {
    public static void main(String[] args) {
        
    }

    // ! Brute : TC: O(m+n)  SC: O(m+n)
static int kthElementBrute(int [] array1, int [] array2, int k){
        int n1 = array1.length, n2 = array2.length;
        int n = n1+n2;
        int [] array3 = new int [n];
        int index = -1;
        int i= 0, j = 0;
        while(n1>i && n2>j){
            if(array1[i] < array2[j]){
                array3[++index] = array1[i];
                i++;
            }else{
                array3[++index] = array2[j];
                j++;
            }
        }
        while(n1> i){
            array3[++index] = array1[i];
                i++;
        }
        while(n2> j){
            array3[++index] = array2[j];
            j++; 
        }

        return array3[k-1];
    }
    // ! Better : TC: O(m+n) SC: O(1)
static int kthElementBetter(int [] array1, int [] array2, int k){
        // I will focus on finding the focused elements only.
        int n1 = array1.length;
        int n2 = array2.length;
        int n = n1+n2;
        int elem = -1;
        int count = 0;
        int i=0, j= 0;
        while(n1>i && n2>j){
            if(array1[i] < array2[j]){
                if(count == k-1) elem = array1[i];
                count++;
                i++;
            }else{
                if(count == k-1) elem = array2[j];
                count++;
                j++;
            }
        }

        while(n1 > i){
            if(count == k-1) elem = array1[i];
            count++;
            i++;
        }

        while(n2 > j){
            if(count == k-1) elem = array2[j];
            count++;
            j++; 
        }

        return elem;
    }
    // ! Optimal: TC: O(log min(m,n)) (Binary Search)
static int kthElementOptimal(ArrayList<Integer> a, ArrayList<Integer> b, int m, int n, int k) {
        if (m > n) return kthElementOptimal(b, a, n, m, k);

        int left = k; // length of left half

        // apply binary search:
        int low = Math.max(0, k - n), high = Math.min(k, m);
        while (low <= high) {
            int mid1 = (low + high) >> 1;
            int mid2 = left - mid1;
            // calculate l1, l2, r1, and r2
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if (mid1 < m) r1 = a.get(mid1);
            if (mid2 < n) r2 = b.get(mid2);
            if (mid1 - 1 >= 0) l1 = a.get(mid1 - 1);
            if (mid2 - 1 >= 0) l2 = b.get(mid2 - 1);

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }

            // eliminate the halves:
            else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return 0; // dummy statement
    }

}
