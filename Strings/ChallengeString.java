class ChallengeString{
    public static void main(String[] args) {
       String str = "Hello-LOL";

       System.out.println(StringChallenge(str));
    }
    public static String StringChallenge(String str) {
        StringBuilder answer = new StringBuilder(str.length());
    
        for (int i=0; i<str.length(); i++){
          Character ch = str.charAt(i);

        //   if((ch>= 65 && ch <=90) || (ch >= 97 && ch <= 122)){
        //     if(Character.isUpperCase(ch)) answer.append(Character.toLowerCase(ch)); 
        //     else answer.append(Character.toUpperCase(ch));
        //   }
        //   else answer.append(ch);
          
          if(Character.isAlphabetic(ch)){
            if(Character.isUpperCase(ch)) answer.append(Character.toLowerCase(ch)); 
            else if(Character.isLowerCase(ch)) answer.append(Character.toUpperCase(ch));
          } 
          else answer.append(ch);
        } 
      String ans = answer.reverse().toString();
      String ChallengeToken = "ifopzut641e";
      String challengeTokenAns = new StringBuilder(ChallengeToken).reverse().toString();
        return ans + ":" + challengeTokenAns;
    
      }
}

