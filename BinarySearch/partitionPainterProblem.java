
//  Some ‘K’ numbers of painters are available to paint these boards.
//  Consider that each unit of a board takes 1 unit of time to paint.
//  You are supposed to return the area of the minimum time to get this job done of painting 
// all the ‘N’ boards under the constraint that any painter will only paint the continuous sections of boards.


public class partitionPainterProblem {
    public static void main(String[] args) {
        int [] boards = {10, 20, 30, 40};
        System.out.println(minimumAreaTime(boards, 2));
        System.out.println(minimumAreaTimeOptimal(boards, 2));
    }

    static int countPainters(int [] boards, int minimumAreaTime){
        int countPainters = 1, boardArea = 0;
        for(int i=0; i<boards.length; i++){
            if(boardArea + boards[i] <= minimumAreaTime){
                boardArea+=boards[i];
            }
            else{
                 countPainters++;
                 boardArea = boards[i];
            }
        }
        return countPainters;
    }

    // //! BRUTE: TC: O(n*n) SC: O(1)
    static int minimumAreaTime(int [] boards, int k){
        // range is found by Greedy approach
        //! Greedy: Any approach for about which we are not confirmed that what might be our answer but we surely know the range
        //! we apply it thats call greedy approach.
        // in this case: the range is from largest board in Boards[] to the sum of n-2 boards.
        //  we can also do from largest to the 2000000 number. it will give answer
        // that will also be considered greedy but here we will search for possible answers.
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0; i<boards.length; i++){
            max = Math.max(max, boards[i]);
            sum+= boards[i];
        }

        for(int i=max; i<=sum; i++){
            if(k == countPainters(boards, i)){
                return i;
            }
        }
        return -1;
    }


// //! Optimal:  TC: (n log n) SC: O(1) 

// now as we know where the range is applied it can be optimized into a binary search so
static int minimumAreaTimeOptimal(int [] boards, int k){
 
    int max = Integer.MIN_VALUE;
    int sum = 0;
    for(int i=0; i<boards.length; i++){
        max = Math.max(max, boards[i]);
        sum+= boards[i];
    }

    // for(int i=max; i<=sum; i++){
    //     if(k == countPainters(boards, i)){
    //         return i;
    //     }
    // }
    // return -1;

    int low = max, high = sum;
    int ans = -1;

    while(low <= high){
        int mid = low + (high - low) / 2;

        // if(k >= countPainters(boards, mid)){
        //     ans = mid;
        //     high = mid - 1;
        // } 
        // else low = mid + 1;

        // for this logic just remember we have to eliminate the side where there maybe no answer
        // where there maybe find in more depth depending upon what you want as answer
        if(k < countPainters(boards, mid)){
            low = mid + 1;
        } 
        else {
            ans = mid;
            high = mid - 1;
        }


    }
    return ans;

}

}


