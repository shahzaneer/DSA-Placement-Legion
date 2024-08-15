class Solution {
    public List<List<Integer>> threeSum(int[] array) {
        List<List<Integer>> threeSum = new ArrayList<>();
    Arrays.sort(array);
    for(int i = 0; i<array.length;i++){
        if(i!=0 && array[i] == array[i-1]) continue; //avoiding duplicates
        int j = i+1;
        int k = array.length - 1;
        while(j<k){
            int sum = array[i] + array[j] + array[k];
            if(sum > 0){
                k--;
            }
            else if(sum < 0){
                j++;
            }
            else{
                List<Integer> temp = Arrays.asList(array[i],array[j],array[k]);
                temp.sort(null);
                threeSum.add(temp);
                j++;
                k--;
                // avoiding duplicates
                while(j<k && array[j] == array[j-1]) j++;
                while(j<k && array[k] == array[k+1]) k--;
            }
        }
    }
    return threeSum;
    }
}