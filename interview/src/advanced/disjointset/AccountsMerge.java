/**
 * https://leetcode.com/problems/accounts-merge/description/
 *
 * */
package advanced.disjointset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountsMerge {

    private List<List<String>> accountsMerge(List<List<String>> accounts) {
        return null;
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
