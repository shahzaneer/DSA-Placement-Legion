public class LowerAndUpperBounds {
public static void main(String[] args) {
    //indexes   //  0,1,2,3,4,5,6
    int [] array = {1,1,3,4,5,9,12};

    System.out.println(lowerBound(array, 1)); // 0
    System.out.println(upperBound(array, 1)); // 2
    System.out.println(insertPosition(array, 2)); //2 
    System.out.println(ceilingElement(array, 2)); //3
    System.out.println(floorElement(array, 2)); // 1

}  

// ! TC: O(log n) SC: O(1)

//! LowerBound -> array[index] >= n return index
// index of that position where the element is found or where it should be placed (if not present)
static int lowerBound(int [] array, int key){
    int low = 0;
    int high = array.length - 1;
    int lowerBound = array.length;

    while(low <= high){
        int mid = (low + high) / 2;

        // Case 1: we found element or we found element > key (a close answer maybe) 
        if(array[mid] >= key){
            lowerBound = mid;
            high = mid - 1;
        }
        // case 2: we were not able to find so reducing searchSpace
        else low = mid + 1;
    }
    return lowerBound;
}
//! insert Position == lowerBound
static int insertPosition(int [] array, int key){
    return lowerBound(array, key);
}
//! UpperBound ->   array[index] > n return index
// index of the position where the next element should be added
static int upperBound(int [] array, int key){
    int low = 0;
    int high = array.length - 1;
    int upperBound = array.length;

    while(low <= high){
        int mid = (low + high) / 2;
        
        if(array[mid] > key){
            upperBound = mid;
            high = mid - 1;
        }
        else low = mid + 1;
    }
    return upperBound;
}

//! ceiling -> Largest element of the Array >= target -> (Still it is lowerBound but it is element)
static int ceilingElement(int [] array, int key){
    return array[lowerBound(array, key)];
}
//! floor -> largest element of the Array <= target  -> (reverse of LowerBound)
static int floorElement(int [] array, int key){
    int low = 0;
    int high = array.length - 1;
    int floor = -1;

    while(low <= high){
        int mid = (low + high) / 2;
        
        if(array[mid] <= key){
            floor =  array[mid];
            low = mid + 1;
        }
        else high = mid - 1;

    }
    return floor;
}
}

