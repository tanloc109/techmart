package sample.sp24.t4s2.shopping;
import sample.sp24.t4s2.product.ProductDTO;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<Integer, ProductDTO> cart;

    public Cart() {
    }

    public Cart(Map<Integer, ProductDTO> cart) {
        this.cart = cart;
    }

    public Map<Integer, ProductDTO> getCart() {
        return cart;
    }

    public void setCart(Map<Integer, ProductDTO> cart) {
        this.cart = cart;
    }

    public boolean add(ProductDTO product) {
        boolean check = false;
        try {
            if (this.cart == null) {
                this.cart = new HashMap<>();
            }
            if(this.cart.containsKey(product.getProductID())) {
                int currentQuantity = this.cart.get(product.getProductID()).getQuantity();
                product.setQuantity(currentQuantity + product.getQuantity());
            }
            this.cart.put(product.getProductID(), product);
            check = true;
        } catch (Exception e) {
        }
        return check;
    }

    public boolean edit(int id, int quantity) {
        boolean check = false;
        try {
            if(this.cart != null) {
                if(this.cart.containsKey(id)) {
                    ProductDTO product = this.cart.get(id);
                    product.setQuantity(quantity);
                    this.cart.replace(id, product);
                    check = true;
                }
            }
        } catch (Exception e) {
        }
        return check;
    }

    public boolean remove(int id) {
        boolean check = false;
        try {
            if(this.cart != null) {
                if(this.cart.containsKey(id)) {
                    this.cart.remove(id);
                    check = true;
                }
            }
        } catch (Exception e) {
        }
        return check;
    }

}
