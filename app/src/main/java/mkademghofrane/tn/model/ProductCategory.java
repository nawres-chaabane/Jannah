package mkademghofrane.tn.model;

public class ProductCategory {
    Integer productId;
    String productName;

    public ProductCategory(Integer productId, String productName){
        this.productId=productId;
        this.productName=productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Integer getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }
}