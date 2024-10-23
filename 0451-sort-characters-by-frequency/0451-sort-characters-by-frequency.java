class Solution {
    public String frequencySort(String s) {
        if(s.length() <=1) return s;
    HashMap<Character, Integer> map = new HashMap<>();
    // Hash it to store the frequencies
    for(int i=0; i<s.length(); i++){
        if(map.containsKey(s.charAt(i))) map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        else map.put(s.charAt(i), 1);
    }
    // priority Queue 
    PriorityQueue<Character> queue = new PriorityQueue<>(
        (a,b) -> map.get(b) - map.get(a)
        );
//? Priority Queue stores unique elements
        queue.addAll(map.keySet());

        StringBuilder str = new StringBuilder();
        while(!queue.isEmpty()){
            Character ch = queue.poll();
            int frequency = map.get(ch);
            for(int i=0; i<frequency; i++){
                str.append(ch);
            }
        }

        return str.toString();

    }
}