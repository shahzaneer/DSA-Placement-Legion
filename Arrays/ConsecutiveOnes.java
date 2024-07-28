public class ConsecutiveOnes {
    public static void main(String[] args) {
        int [] nums = {1,1,1,0,1,1,1};
        System.out.println(consecutiveOnes(nums));
    }

    static int consecutiveOnes(int [] nums){
        int onesCounter = 0;
        int onesCounterPrev = 0;
        for(int i= 0; i<nums.length;i++){
            if(nums[i] == 1){
                onesCounter++;
            }
            if(nums[i] == 0 || i == nums.length - 1){
                if(onesCounter > onesCounterPrev){
                onesCounterPrev = onesCounter;
                }
                onesCounter = 0;
            }
        }

        return onesCounterPrev;
    }
}
