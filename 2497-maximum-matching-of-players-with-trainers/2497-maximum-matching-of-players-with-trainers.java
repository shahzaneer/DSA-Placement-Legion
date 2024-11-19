class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int trainersCapacityJ = 0;
        int playersAbilityI = 0;
        int counter = 0;

        Arrays.sort(players);
        Arrays.sort(trainers);


        while(playersAbilityI < players.length && trainersCapacityJ < trainers.length){
            
            
            if(players[playersAbilityI] <= trainers[trainersCapacityJ]){
                trainersCapacityJ++;
                counter++;
                playersAbilityI++;
            }
            else{
                trainersCapacityJ++;
            }
        }

        return counter;
 
    }
}