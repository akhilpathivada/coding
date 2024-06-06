/**
 * author: akhilpathivada
 * time: 06/06/24 14:35
 */
package design;

import java.util.ArrayList;
import java.util.List;

public class ProductOfNumbers {

    private final List<Integer> product;

    public ProductOfNumbers() {
        this.product = new ArrayList<>(List.of(1));
    }

    public void add(int num) {
        if (num > 0) {
            product.add(product.get(product.size() - 1) * num);
        } else {
            product.clear();
            product.add(1);
        }
    }

    public int getProduct(int k) {
        int n = product.size();
        return k < product.size() ? product.get(n - 1) / product.get(n - k - 1) : 0;
    }
}
