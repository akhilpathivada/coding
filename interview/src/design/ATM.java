/**
 * author: akhilpathivada
 * time: 05/06/24 20:46
 *
 * https://leetcode.com/problems/design-an-atm-machine/description/
 *
 */
package design;

import java.util.Arrays;

public class ATM {

    private final static int DENOMS = 5;

    private final int[] denominations;

    private final int[] stores;

    public ATM() {
        this.denominations = new int[]{20, 50, 100, 200, 500};
        this.stores = new int[DENOMS];
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < DENOMS; ++i) {
            stores[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        final int[] notesDebited = new int[DENOMS];
        for (int i = DENOMS - 1; amount > 0 && i >= 0; --i) {
            int notesTaken = Math.min(amount / denominations[i], stores[i]);
            notesDebited[i] = notesTaken;
            amount -= notesTaken * denominations[i];
        }
        if (amount > 0) {
            return new int[]{-1};
        }
        // update the notes in the store
        for (int i = 0; i < DENOMS; ++i) {
            stores[i] -= notesDebited[i];
        }
        return notesDebited;
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.deposit(new int[]{0, 0, 1, 2, 1}); // Deposits 1 $100 banknote, 2 $200 banknotes,
        // and 1 $500 banknote.
        System.out.println(Arrays.toString(atm.withdraw(600)));        // Returns [0,0,1,0,1]. The machine uses 1 $100 banknote
        // and 1 $500 banknote. The banknotes left over in the
        // machine are [0,0,0,2,0].
        atm.deposit(new int[]{0, 1, 0, 1, 1}); // Deposits 1 $50, $200, and $500 banknote.
        // The banknotes in the machine are now [0,1,0,3,1].
        System.out.println(Arrays.toString(atm.withdraw(600)));        // Returns [-1]. The machine will try to use a $500 banknote
        // and then be unable to complete the remaining $100,
        // so the withdraw request will be rejected.
        // Since the request is rejected, the number of banknotes
        // in the machine is not modified.
        System.out.println(Arrays.toString(atm.withdraw(550)));        // Returns [0,1,0,0,1]. The machine uses 1 $50 banknote
        // and 1 $500 banknote.
    }
}
