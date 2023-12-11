/**
 * https://leetcode.com/problems/accounts-merge/description/
 * https://www.codingninjas.com/studio/problems/accounts-merge_1089558?leftPanelTabValue=PROBLEM
 * https://practice.geeksforgeeks.org/problems/account-merge/
 * */
package advanced.disjointset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountsMerge {

    private List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet disjointSet = new DisjointSet(n);
        Map<String, Integer> mailIdToNodeMap = new HashMap<>();
        // insert the elements into disjoint set
        for (int i = 0; i < n; ++i) {
            for (int j = 1; j < accounts.get(i).size(); ++j) {
                String mailId = accounts.get(i).get(j);
                if (!mailIdToNodeMap.containsKey(mailId)) {
                    mailIdToNodeMap.put(mailId, i);
                } else {
                    disjointSet.unionBySize(i, mailIdToNodeMap.get(mailId));
                }
            }
        }
        ArrayList<String>[] mergedMails = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            mergedMails[i] = new ArrayList<>();
        }
        for (Map.Entry<String, Integer> entry : mailIdToNodeMap.entrySet()) {
            String mailId = entry.getKey();
            int node = disjointSet.findUltimateParent(entry.getValue());
            mergedMails[node].add(mailId);
        }
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (mergedMails[i].size() == 0) {
                continue;
            }
            Collections.sort(mergedMails[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(mergedMails[i]);
            result.add(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"));
        accounts.add(Arrays.asList("John","johnsmith@mail.com","john00@mail.com"));
        accounts.add(Arrays.asList("Mary","mary@mail.com"));
        accounts.add(Arrays.asList("John","johnnybravo@mail.com"));
        System.out.println(new AccountsMerge().accountsMerge(accounts));
    }
}
