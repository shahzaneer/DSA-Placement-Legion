class Solution {
    public int findContentChildren(int[] g, int[] s) {
         int i = 0;
        int cookiesSizePosition = 0;
        int counter = 0;

        Arrays.sort(g);
        Arrays.sort(s);


        while(cookiesSizePosition < s.length && i < g.length){
            
            
            if(s[cookiesSizePosition] >= g[i]){
                cookiesSizePosition++;
                counter++;
                i++;
            }
            else{
                cookiesSizePosition++;
            }
        }

        return counter;
    }
}