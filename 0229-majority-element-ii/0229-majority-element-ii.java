class Solution {
    public List<Integer> majorityElement(int[] array) {
        List<Integer> majorityElements = new ArrayList<>();
        int counter1 = 0, counter2 = 0;
        int element1 = 0, element2 = 0;

        for(int i=0; i<array.length; i++){
            if(counter1 == 0 && element2!= array[i]){
                counter1 = 1;
                element1 = array[i];
            }
            else if(counter2 == 0 && element1!= array[i]){
                counter2 = 1;
                element2 = array[i];
            }
            else if(element1 == array[i]) counter1++;
            else if (element2 == array[i]) counter2++;
            
            else 
            {
                --counter1; --counter2;
            }
        }

    // elem1 elem2 may or may not be the elements that are majorityElementsBy3
    int count1 = 0, count2 =0;
    for(int i=0; i<array.length;i++){
        if(array[i] == element1) count1++;
        else if(array[i] == element2) count2++;
    }
    
    if(count1 > array.length/3) majorityElements.add(element1);
    if(count2 > array.length/3) majorityElements.add(element2);

        return majorityElements;

    }
}