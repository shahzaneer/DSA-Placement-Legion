class Solution {
    public int longestConsecutive(int[] array) {
        if(array.length <= 1) return array.length;
        HashSet<Integer> hash = new HashSet<>();
        int longest = 1, count = 0;
        for(int i=0; i<array.length;i++){
            hash.add(array[i]);
        }
        for(int it: hash){
            if(!hash.contains(it-1)){
                count = 1;
                int x = it;
                while(hash.contains(x+1)){
                    count++;
                    x = x+1;
                }
            }
            longest = Math.max(longest, count);
        }
    return longest;
    }
}