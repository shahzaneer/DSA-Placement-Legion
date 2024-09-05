// Given two sorted arrays arr1 and arr2 of size m and n respectively, return the median of the two sorted arrays. 
// The median is defined as the middle value of a sorted list of numbers.
//  In case the length of the list is even, the median is the average of the two middle elements.
public class MedianOfTwoSortedArray{
    public static void main(String [] args){
        
    }
    
    //! Brute: TC: O(n) SC: O(n)
    static double findMedianBrute(int [] array1, int [] array2){
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

        if(n%2 == 1){
            return array3[(n/2)];
        }else{
            return (double) ( ( (double) array3[n/2] + (double) array3[(n/2 - 1)]) / 2);
        }
    }
    //! Better: TC: O(n) SC: O(1) -> by using the sorted property
    static double findMedianBetter(int [] array1 , int [] array2){
        // I will focus on finding the focused elements only.
        int n1 = array1.length;
        int n2 = array2.length;
        int n = n1+n2;
        int index2 = n/2;  //index of interest
        int index1 = index2 - 1; //index of interest
        int elem1 = -1, elem2 = -1;
        int count = 0;
        int i=0, j= 0;
        while(n1>i && n2>j){
            if(array1[i] < array2[j]){
                if(count == index1) elem1 = array1[i];
                if(count == index2) elem2 = array1[i];
                count++;
                i++;
            }else{
                if(count == index1) elem1 = array2[j];
                if(count == index2) elem2 = array2[j];
                count++;
                j++;
            }
        }

        while(n1 > i){
            if(count == index1) elem1 = array1[i];
            if(count == index2) elem2 = array1[i];
            count++;
            i++;
        }

        while(n2 > j){
            if(count == index1) elem1 = array2[j];
            if(count == index2) elem2 = array2[j];
            count++;
            j++; 
        }

        if(n%2 == 1) return elem2;
        else return (double)((double) (elem1+elem2) / 2.0);
    }

    // !Optimal: By Binary Search -> (a bit complex)
}