package design.medium;

import java.util.HashMap;
import java.util.Map;

public class _535_Encode_and_Decode_TinyURL {

    /**
     * 系统设计。
     *
     */

    static Map<Integer, String> map = new HashMap<>();
    static final String HOST = "http://tinyurl.com/";
    // Encodes a URL to a shortened URL.
    public static String encode(String longUrl) {
        int key = longUrl.hashCode();
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            map.put(key, longUrl);
        }
        return HOST + key;
    }

    // Decodes a shortened URL to its original URL.
    public static String decode(String shortUrl) {
        Integer key = Integer.valueOf(shortUrl.replace(HOST, ""));

        return map.get(key);
    }

    public static void main(String[] args) {
        String url = "https://leetcode.com/problems/design-tinyurl";
        String encoded = encode(url);
        System.out.println(encoded);
        System.out.println(decode(encoded));
    }
}
