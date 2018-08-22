package string.easy;

import java.util.HashMap;
import java.util.Map;

public class _383_Ransom_Note {

    /**
     * map to store key and count.
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        //use once
        //map parse mag
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch)+1);
            } else {
                map.put(ch, 1);
            }
        }

        for (int j = 0; j < ransomNote.length(); j++) {
            char ch  = ransomNote.charAt(j);
            if (map.containsKey(ch)) {
                int cnt = map.get(ch);
                if (cnt == 0) {
                    return false;
                } else {
                    map.put(ch, --cnt);
                }
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 高级解法
     */
    public boolean canConstructGaoji(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(--arr[ransomNote.charAt(i)-'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
