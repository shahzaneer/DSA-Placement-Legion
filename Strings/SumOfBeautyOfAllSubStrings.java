public class SumOfBeautyOfAllSubStrings {
    public static void main(String[] args) {
        
    }

    static int sumOfBeauty(String s){
        // ! GetALLSubStrings
        int sumOfAllBeauties = 0; 
        for(int i=0; i<s.length(); i++){
            int [] frequency = new int [26];
            for(int j = i; j<s.length(); j++){
                frequency[s.charAt(j) - 'a']++;   // 'a' - 'a' == 0 and so on
                int maxFrequency = getMax(frequency);
                int minFrequency = getMin(frequency);
                int beauty = maxFrequency - minFrequency;
                sumOfAllBeauties+=beauty;
            }
        }

        return sumOfAllBeauties;
    }

    private static int getMax(int[] frequency) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<frequency.length; i++){
            if(frequency[i]!=0) max = Math.max(max, frequency[i]);
        }
        return max;
    }

    private static int getMin(int[] frequency) {
        int min = Integer.MAX_VALUE;
        for(int i=0; i<frequency.length; i++){
            if(frequency[i]!=0) min = Math.min(min, frequency[i]);
        }
        return min;
    }
}
