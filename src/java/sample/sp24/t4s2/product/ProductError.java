package sample.sp24.t4s2.product;

public class ProductError {

    private String productIDError;
    private String productNameError;
    private String imageError;
    private String priceError;
    private String quantityError;
    private String memoryError;
    private String categoryError;
    private String statusError;
    private String error;

    public ProductError() {
        this.productIDError = "";
        this.productNameError = "";
        this.imageError = "";
        this.priceError = "";
        this.quantityError = "";
        this.memoryError = "";
        this.categoryError = "";
        this.statusError = "";
        this.error="";
    }

    public ProductError(String productIDError, String productNameError, String imageError, String priceError, String quantityError, String memoryError, String categoryError, String statusError, String error) {
        this.productIDError = productIDError;
        this.productNameError = productNameError;
        this.imageError = imageError;
        this.priceError = priceError;
        this.quantityError = quantityError;
        this.memoryError = memoryError;
        this.categoryError = categoryError;
        this.statusError = statusError;
        this.error = error;
    }

    public String getProductIDError() {
        return productIDError;
    }

    public void setProductIDError(String productIDError) {
        this.productIDError = productIDError;
    }

    public String getProductNameError() {
        return productNameError;
    }

    public void setProductNameError(String productNameError) {
        this.productNameError = productNameError;
    }

    public String getImageError() {
        return imageError;
    }

    public void setImageError(String imageError) {
        this.imageError = imageError;
    }

    public String getPriceError() {
        return priceError;
    }

    public void setPriceError(String priceError) {
        this.priceError = priceError;
    }

    public String getQuantityError() {
        return quantityError;
    }

    public void setQuantityError(String quantityError) {
        this.quantityError = quantityError;
    }

    public String getMemoryError() {
        return memoryError;
    }

    public void setMemoryError(String memoryError) {
        this.memoryError = memoryError;
    }

    public String getCategoryError() {
        return categoryError;
    }

    public void setCategoryError(String categoryError) {
        this.categoryError = categoryError;
    }

    public String getStatusError() {
        return statusError;
    }

    public void setStatusError(String statusError) {
        this.statusError = statusError;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    
    
}
