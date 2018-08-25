package hashtable.easy;

import java.util.*;

public class _500_Keyboard_Row {

    /**
     * 易错题。
     * 注意字母的大小写。
     */
    public static String[] findWords(String[] words) {
        String l1 = "qwertyuiopQWERTYUIOP";
        String l2 = "asdfghjklASDFGHJKL";
        String l3 = "zxcvbnmZXCVBNM";
        ArrayList<String> res = new ArrayList<>();
        for (String word : words) {
            String line = null;
            int i = 0;
            for (;i < word.length();i++) {
                char ch = word.charAt(i);
                if (line == null) {
                    if (l1.indexOf(ch) >= 0) {
                        line = l1;
                    } else if (l2.indexOf(ch) >= 0) {
                        line = l2;
                    } else {
                        line = l3;
                    }
                } else {
                    if (line.indexOf(ch) < 0) {
                        break;
                    }
                }

            }
            if (i == word.length()) res.add(word);
        }
        return res.stream().toArray(String[]::new);
    }

    /**
     * HASHMAP
     */
    public String[] findWordsHM(String[] words) {
        String[] strs = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<strs.length; i++){
            for(char c: strs[i].toCharArray()){
                map.put(c, i);//put <char, rowIndex> pair into the map
            }
        }
        List<String> res = new LinkedList<>();
        for(String w: words){
            if(w.equals("")) continue;
            int index = map.get(w.toUpperCase().charAt(0));
            for(char c: w.toUpperCase().toCharArray()){
                if(map.get(c)!=index){
                    index = -1; //don't need a boolean flag.
                    break;
                }
            }
            if(index!=-1) res.add(w);//if index != -1, this is a valid string
        }
        return res.toArray(new String[0]);
    }
}
