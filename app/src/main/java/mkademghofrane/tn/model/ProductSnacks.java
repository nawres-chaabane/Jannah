package mkademghofrane.tn.model;

public class ProductSnacks {
    Integer productSweetId;
    String productSweetSize;
    String productSweetPrice, productSweetDescription, productSweetName;
    Integer imageSweetUrl;

    public ProductSnacks(Integer productSweetId, String productSweetSize, String productSweetPrice, String productSweetDescription, String productSweetName, Integer imageSweetUrl) {
        this.productSweetId = productSweetId;
        this.productSweetSize = productSweetSize;
        this.productSweetPrice = productSweetPrice;
        this.productSweetDescription = productSweetDescription;
        this.productSweetName = productSweetName;
        this.imageSweetUrl = imageSweetUrl;
    }

    public Integer getProductSweetId() {
        return productSweetId;
    }

    public void setProductSweetId(Integer productSweetId) {
        this.productSweetId = productSweetId;
    }

    public String getProductSweetSize() {
        return productSweetSize;
    }

    public void setProductSweetSize(String productSweetSize) {
        this.productSweetSize = productSweetSize;
    }

    public String getProductSweetPrice() {
        return productSweetPrice;
    }

    public void setProductSweetPrice(String productSweetPrice) {
        this.productSweetPrice = productSweetPrice;
    }

    public String getProductSweetDescription() {
        return productSweetDescription;
    }

    public void setProductSweetDescription(String productSweetDescription) {
        this.productSweetDescription = productSweetDescription;
    }

    public String getProductSweetName() {
        return productSweetName;
    }

    public void setProductSweetName(String productSweetName) {
        this.productSweetName = productSweetName;
    }

    public Integer getImageSweetUrl() {
        return imageSweetUrl;
    }

    public void setImageSweetUrl(Integer imageSweetUrl) {
        this.imageSweetUrl = imageSweetUrl;
    }
}