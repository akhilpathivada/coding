/**
 * author: akhilpathivada
 * time: 07/06/24 09:58
 *
 * https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/description/
 *
 */
package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveSubFoldersFromTheFilesystem {

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        final List<String> result = new ArrayList<>();
        for (String dir : folder) {
            if (result.isEmpty() || !dir.startsWith(result.get(result.size() - 1) + "/")) {
                result.add(dir);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] folder = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        System.out.println(new RemoveSubFoldersFromTheFilesystem().removeSubfolders(folder));
    }
}
