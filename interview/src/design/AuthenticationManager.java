/**
 * author: akhilpathivada
 * time: 06/06/24 10:54
 *
 * https://leetcode.com/problems/design-authentication-manager/
 *
 */
package design;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationManager {

    private final Map<String, Integer> tokenIdToExpiryTimeMap;

    private int time;

    public AuthenticationManager(int timeToLive) {
        this.tokenIdToExpiryTimeMap = new HashMap<>();
        this.time = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        tokenIdToExpiryTimeMap.put(tokenId, time + currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        int expiresAt = tokenIdToExpiryTimeMap.getOrDefault(tokenId, 0);
        if (expiresAt > currentTime) {
            generate(tokenId, currentTime);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (int expiresAt : tokenIdToExpiryTimeMap.values()) {
            count += expiresAt > currentTime ? 1 : 0;
        }
        return count;
    }

    public static void main(String[] args) {
        AuthenticationManager authenticationManager = new AuthenticationManager(5); // Constructs the AuthenticationManager with timeToLive = 5 seconds.
        authenticationManager.renew("aaa", 1); // No token exists with tokenId "aaa" at time 1, so nothing happens.
        authenticationManager.generate("aaa", 2); // Generates a new token with tokenId "aaa" at time 2.
        System.out.println(authenticationManager.countUnexpiredTokens(6)); // The token with tokenId "aaa" is the only unexpired one at time 6, so return 1.
        authenticationManager.generate("bbb", 7); // Generates a new token with tokenId "bbb" at time 7.
        authenticationManager.renew("aaa", 8); // The token with tokenId "aaa" expired at time 7, and 8 >= 7, so at time 8 the renew request is ignored, and nothing happens.
        authenticationManager.renew("bbb", 10); // The token with tokenId "bbb" is unexpired at time 10, so the renew request is fulfilled and now the token will expire at time 15.
        System.out.println(authenticationManager.countUnexpiredTokens(15)); // The token with tokenId "bbb" expires at time 15, and the token with tokenId "aaa" expired at time 7, so currently no token is unexpired, so return 0.
    }
}
