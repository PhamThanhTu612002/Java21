package sale.entities;

import java.util.Map;

public class Cart {
    private int id;
    private static int autoId;
    private Map<Integer, Product> productMap;

    public Cart( Map<Integer, Product> productMap) {
        this.id = ++autoId;
        this.productMap = productMap;
    }

    public Cart() {
    }

    public int getId() {
        return id;
    }

    public static int getAutoId() {
        return autoId;
    }

    public static void setAutoId(int autoId) {
        Cart.autoId = autoId;
    }

    public Map<Integer, Product> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<Integer, Product> productMap) {
        this.productMap = productMap;
    }
}
