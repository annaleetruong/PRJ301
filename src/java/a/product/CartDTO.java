package a.product;

import java.util.HashMap;
import java.util.Map;

public class CartDTO {

    private Map<String, ProductDTO> cart;

    public CartDTO() {
    }

    public CartDTO(Map<String, ProductDTO> cart) {
        this.cart = cart;
    }

    public Map<String, ProductDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, ProductDTO> cart) {
        this.cart = cart;
    }

    public void add(ProductDTO product, int quantity) {
        if (this.cart == null) {
            this.cart = new HashMap<String, ProductDTO>();
        }
        if (this.cart.containsKey(product.getProID())) {
//            int currentQuantity = this.cart.get(product.getProID()).getQuantity();
            product.setQuantity(quantity);
        }
        this.cart.put(product.getProID(), product);
    }

    public void update(String proID, ProductDTO newProduct) {
        if (this.cart == null) {
            return;
        }
        if (this.cart.containsKey(proID)) {
            this.cart.replace(proID, newProduct);
        }
    }

    public void remove(String proID) {
        if (this.cart == null) {
            return;
        }
        if (this.cart.containsKey(proID)) {
            this.cart.remove(proID);
        }
    }
}

