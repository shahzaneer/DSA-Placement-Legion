class Solution {
    public String frequencySort(String s) {
       if (s.length() <= 1) return s;

        // Step 1: Create a frequency map
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Step 2: Create a bucket (list of lists), where index represents frequency
        ArrayList<ArrayList<Character>> buckets = new ArrayList<>(s.length() + 1);
        
        // Initialize buckets (each index has an empty list)
        for (int i = 0; i <= s.length(); i++) {
            buckets.add(new ArrayList<>());
        }

        // Step 3: Fill the buckets
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            int frequency = entry.getValue();
            buckets.get(frequency).add(c); // Add character to its corresponding frequency bucket
        }

        // Step 4: Build the result by iterating through the buckets from highest to lowest frequency
        StringBuilder result = new StringBuilder();
        for (int i = buckets.size() - 1; i > 0; i--) {
            for (char c : buckets.get(i)) {
                for (int j = 0; j < i; j++) {  // Append character 'i' times
                    result.append(c);
                }
            }
        }

        return result.toString();


    }
}