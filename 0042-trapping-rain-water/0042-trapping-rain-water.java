class Solution {
    public int trap(int[] buildings) {
        int total = 0;
        int [] prefixMax = prefixMax(buildings);
        int [] suffixMax = suffixMax(buildings);

        for(int i=0; i<buildings.length; i++){
            int leftMax = prefixMax[i];
            int rightMax = suffixMax[i];
            if(buildings[i] < leftMax && buildings[i] < rightMax)
                total += Math.min(leftMax, rightMax) - buildings[i];
        }

        return total;
    }

    static int [] prefixMax(int [] buildings){
        int [] prefixMax = new int [buildings.length];
        prefixMax[0] = buildings[0];
        for(int i=1; i<buildings.length; i++){
            prefixMax[i] = Math.max(prefixMax[i-1], buildings[i]);
        }
        return prefixMax;
    }

    static int [] suffixMax(int [] buildings){
        int [] suffixMax = new int [buildings.length];
        suffixMax[buildings.length - 1] = buildings[buildings.length - 1];
        for(int i=buildings.length - 2; i>=0; i--){
            suffixMax[i] = Math.max(suffixMax[i+1], buildings[i]);
        }
        return suffixMax;

    }

}