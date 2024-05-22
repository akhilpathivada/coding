/**
 * author: akhilpathivada
 * time: 22/05/24 10:42
 *
 * https://leetcode.com/problems/longest-uploaded-prefix/description/
 *
 */
package misc;

public class LongestUploadedPrefix {

    private final boolean[] seen;

    private int index;

    public LongestUploadedPrefix(int n) {
        seen = new boolean[n + 1];
        index = 0;
    }

    public void upload(int video) {
        seen[video] = true;
        while (index + 1 < seen.length && seen[index + 1]) {
            ++index;
        }
    }

    public int longest() {
        return index;
    }

    public static void main(String[] args) {
        LongestUploadedPrefix server = new LongestUploadedPrefix(4);   // Initialize a stream of 4 videos.
        server.upload(3);                    // Upload video 3.
        System.out.println(server.longest());                    // Since video 1 has not been uploaded yet, there is no prefix. So, we return 0.
        server.upload(1);                    // Upload video 1.
        System.out.println(server.longest());                    // The prefix [1] is the longest uploaded prefix, so we return 1.
        server.upload(2);                    // Upload video 2.
        System.out.println(server.longest());                    // The prefix [1,2,3] is the longest uploaded prefix, so we return 3.
    }
}
