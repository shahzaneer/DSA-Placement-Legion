class Solution {
    public boolean isIsomorphic(String s, String t) {
if(s.length()!=t.length()) return false; //1

        HashMap<Character,Character> tToSMap = new HashMap<>();
        HashMap<Character,Character> sToTMap = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);
            if(!tToSMap.containsKey(t1)){
                tToSMap.put(t1, s1);
            }
            if(!sToTMap.containsKey(s1)){
                sToTMap.put(s1, t1);
            }

            if(tToSMap.get(t1)!= s1 || sToTMap.get(s1)!= t1) return false; //2+3

        }

        return true;    }
}