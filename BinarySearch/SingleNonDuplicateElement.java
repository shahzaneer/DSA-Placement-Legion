public class SingleNonDuplicateElement {
    public static void main(String[] args) {
        int [] array  = {1,1,2,3,3,4,4,8,8};
        System.out.println(binarySearchNonDuplicate(array, 0, array.length-1));
    }

    //! error
    static int binarySearchNonDuplicate(int [] array, int low, int high){
        if(low > high) return -1;
        int mid = low + (high - low)/2;
        int midElement = array[mid];
        if(mid == 0 && midElement!=array[mid+1]) return midElement;
        else if(mid == (array.length -1) && midElement!=array[mid-1]) return midElement;
        else if(midElement != array[mid-1] && midElement!= array[mid+1]) return midElement;
        else {
            if(midElement==array[mid-1]) {
                int leftHalf = binarySearchNonDuplicate(array, low, mid-2);
                if(leftHalf!=-1) return leftHalf;
            }
            if(midElement== array[mid+1]) {
                int rightHalf = binarySearchNonDuplicate(array, mid+2, high);
                if(rightHalf!=-1) return rightHalf;
            }
        }        
        return -1;
    }
}
