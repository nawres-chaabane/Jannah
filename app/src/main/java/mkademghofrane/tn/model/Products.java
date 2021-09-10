package mkademghofrane.tn.model;
public class Products {
    Integer productId;
    String productPrice;
    String productSize,productName,productDescription;
    Integer imageUrl;

    public Integer getProductId() {
        return productId;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public String getProductSize() {
        return productSize;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public Products(Integer productId, String productPrice, String productSize, String productName, String productDescription, Integer imageUrl) {
        this.productId = productId;
        this.productPrice = productPrice;
        this.productSize = productSize;
        this.productName = productName;
        this.productDescription = productDescription;
        this.imageUrl = imageUrl;

    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }
}