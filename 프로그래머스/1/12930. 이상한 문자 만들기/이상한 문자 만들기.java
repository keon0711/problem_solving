import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    
    public String solution(String s) {
        String[] words = s.split(" ", -1);
        List<String> result = new ArrayList<>();

        for (String word : words) {
            char[] charArray = word.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if (i % 2 == 0) {
                    charArray[i] = Character.toUpperCase(charArray[i]);
                } else {
                    charArray[i] = Character.toLowerCase(charArray[i]);
                }
            }
            result.add(String.valueOf(charArray));
        }

        String join = String.join(" ", result);
        System.out.println(join.trim());
        return join;
    }
    
}