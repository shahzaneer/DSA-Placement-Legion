class Solution {
    public double findMedianSortedArrays(int[] array1, int[] array2) {
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
}