class Solution {
    public int[] rearrangeArray(int[] array) {
        ArrayList<Integer> positives = new ArrayList<>();
        ArrayList<Integer> negatives = new ArrayList<>();

        for(int i=0; i<array.length;i++){
            if(array[i] > 0) positives.add(array[i]);
            else if (array[i] < 0) negatives.add(array[i]);
        }

        for(int i=0; i<array.length/2; i++){
            array[2*i] = positives.get(i);
            array[(2*i) + 1] = negatives.get(i);
        }
        return array;
    }
}