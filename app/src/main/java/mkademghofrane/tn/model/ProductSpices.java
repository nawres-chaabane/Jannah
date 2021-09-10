package mkademghofrane.tn.model;

public class ProductSpices {
    Integer productSpicesId;
    String productSpicesSize;
    String productSpicesPrice, productSpicesDescription, productSpicesName;
    Integer imageSpicesUrl;

    public ProductSpices(Integer productSpicesId, String productSpicesSize, String productSpicesPrice, String productSpicesDescription, String productSpicesName, Integer imageSpicesUrl) {
        this.productSpicesId = productSpicesId;
        this.productSpicesSize = productSpicesSize;
        this.productSpicesPrice = productSpicesPrice;
        this.productSpicesDescription = productSpicesDescription;
        this.productSpicesName = productSpicesName;
        this.imageSpicesUrl = imageSpicesUrl;
    }

    public Integer getProductSpicesId() {
        return productSpicesId;
    }

    public void setProductSpicesId(Integer productSpicesId) {
        this.productSpicesId = productSpicesId;
    }

    public String getProductSpicesSize() {
        return productSpicesSize;
    }

    public void setProductSpicesSize(String productSpicesSize) {
        this.productSpicesSize = productSpicesSize;
    }

    public String getProductSpicesPrice() {
        return productSpicesPrice;
    }

    public void setProductSpicesPrice(String productSpicesPrice) {
        this.productSpicesPrice = productSpicesPrice;
    }

    public String getProductSpicesDescription() {
        return productSpicesDescription;
    }

    public void setProductSpicesDescription(String productSpicesDescription) {
        this.productSpicesDescription = productSpicesDescription;
    }

    public String getProductSpicesName() {
        return productSpicesName;
    }

    public void setProductSpicesName(String productSpicesName) {
        this.productSpicesName = productSpicesName;
    }

    public Integer getImageSpicesUrl() {
        return imageSpicesUrl;
    }

    public void setImageSpicesUrl(Integer imageSpicesUrl) {
        this.imageSpicesUrl = imageSpicesUrl;
    }
}