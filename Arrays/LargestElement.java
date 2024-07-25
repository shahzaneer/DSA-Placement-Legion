class LargestElement{
    public static void main(String[] args) {
        int [] array = {1,2,3,45,6,7};
        System.out.println(largestElement(array));
        System.out.println(largestElementRecursive(array, array.length - 1, array[0]));
    }

    static int largestElement(int [] array){
        int largest = array[0];
        for(int i = 1; i<=array.length - 1;i++){
            if(array[i] > largest) largest = array[i];
        }

        return largest;
    }

    static int largestElementRecursive(int [] array, int size, int largest){
        if(size == 0) return largest;
        if(array[size] > largest) largest = array[size];
        return largestElementRecursive(array, --size, largest);
    }

}