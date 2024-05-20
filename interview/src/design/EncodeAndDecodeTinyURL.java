/**
 * author: akhilpathivada
 * time: 20/05/24 16:27
 */
package design;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EncodeAndDecodeTinyURL {

    // uuid
    private static int timer = 0;

    private final Map<String, String> map;

    public EncodeAndDecodeTinyURL() {
        map = new HashMap<>();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.put(String.valueOf(++timer), longUrl);
        return "http://tinyurl.com/" + timer;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        // last 6 character is the unique id
        String key = shortUrl.substring(shortUrl.indexOf(".com/") + 5);
        return map.get(key);
    }

    public static void main(String[] args) {
        String url = "https://leetcode.com/problems/design-tinyurl";
        System.out.println(new EncodeAndDecodeTinyURL().encode(url));
    }
}
