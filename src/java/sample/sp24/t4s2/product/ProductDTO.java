package sample.sp24.t4s2.product;

public class ProductDTO {

    private int productID;
    private String productName;
    private String image;
    private double price;
    private int quantity;
    private int memory;
    private int category;
    private int status;
    private String categoryName;
    private int sold;

    public ProductDTO() {
    }

    public ProductDTO(String productName, String image, double price, int quantity, int memory, int category, int status) {
        this.productName = productName;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.memory = memory;
        this.category = category;
        this.status = status;
    }

    public ProductDTO(int productID, String productName, String image, double price, int quantity, int memory, int category, int status) {
        this.productID = productID;
        this.productName = productName;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.memory = memory;
        this.category = category;
        this.status = status;
    }

    public ProductDTO(int productID, String productName, String image, double price, int quantity, int memory, int category, int status, String categoryName, int sold) {
        this.productID = productID;
        this.productName = productName;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.memory = memory;
        this.category = category;
        this.status = status;
        this.categoryName = categoryName;
        this.sold = sold;
    }  
    
    public ProductDTO(int productID, String productName, String image, double price, int quantity, int memory, int category, int status, String categoryName) {
        this.productID = productID;
        this.productName = productName;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.memory = memory;
        this.category = category;
        this.status = status;
        this.categoryName = categoryName;
    }  

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    
}
