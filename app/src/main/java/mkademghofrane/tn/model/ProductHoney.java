package mkademghofrane.tn.model;

public class ProductHoney {
    Integer productHoneyId;
    String productHoneySize;
    String productHoneyPrice,ProductHoneyName,productHoneyDescription;
    Integer imageHoneyUrl;

    public ProductHoney(Integer productHoneyId, String productHoneySize, String productHoneyPrice, String productHoneyName, String productHoneyDescription, Integer imageHoneyUrl) {
        this.productHoneyId = productHoneyId;
        this.productHoneySize = productHoneySize;
        this.productHoneyPrice = productHoneyPrice;
        ProductHoneyName = productHoneyName;
        this.productHoneyDescription = productHoneyDescription;
        this.imageHoneyUrl = imageHoneyUrl;
    }

    public Integer getProductHoneyId() {
        return productHoneyId;
    }

    public void setProductHoneyId(Integer productHoneyId) {
        this.productHoneyId = productHoneyId;
    }

    public String getProductHoneySize() {
        return productHoneySize;
    }

    public void setProductHoneySize(String productHoneySize) {
        this.productHoneySize = productHoneySize;
    }

    public String getProductHoneyPrice() {
        return productHoneyPrice;
    }

    public void setProductHoneyPrice(String productHoneyPrice) {
        this.productHoneyPrice = productHoneyPrice;
    }

    public String getProductHoneyName() {
        return ProductHoneyName;
    }

    public void setProductHoneyName(String productHoneyName) {
        ProductHoneyName = productHoneyName;
    }

    public String getProductHoneyDescription() {
        return productHoneyDescription;
    }

    public void setProductHoneyDescription(String productHoneyDescription) {
        this.productHoneyDescription = productHoneyDescription;
    }

    public Integer getImageHoneyUrl() {
        return imageHoneyUrl;
    }

    public void setImageHoneyUrl(Integer imageHoneyUrl) {
        this.imageHoneyUrl = imageHoneyUrl;
    }
}