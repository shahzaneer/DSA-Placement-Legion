class Solution {
    public List<List<Integer>> fourSum(int[] array, int target) {
       List<List<Integer>> fourSum = new ArrayList<>();
        Arrays.sort(array);

        for(int i = 0; i<array.length; i++){
            if(i!=0 && array[i]== array[i-1]) continue;
            for(int j = i+1; j<array.length; j++){
                if(j!=i+1 && array[j]== array[j-1]) continue;
                int k = j+1;
                int l = array.length - 1;
                while(k<l){
                       long sum = (long) array[i] + array[j];
                        sum += array[k];
                        sum += array[l];

                    if (sum > target){
                        l--;
                    }
                    else if(sum < target){
                        k++;
                    }
                    else{
                        List<Integer> temp = Arrays.asList(array[i],array[j],array[k],array[l]);
                        fourSum.add(temp);
                        k++;
                        l--;
                        while(k<l && array[k] == array[k-1]) k++;
                        while(k<l && array[l] == array[l+1]) l--;
                    }
                }
            }
        }
        return fourSum; 
    }
}