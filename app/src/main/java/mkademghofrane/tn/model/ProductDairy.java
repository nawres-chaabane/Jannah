package mkademghofrane.tn.model;

public class ProductDairy {
    Integer productDairyId;
    String productDairySize;
    String productDairyPrice,productDairyName,productDairyDescription;
    Integer imageDairyUrl;

    public ProductDairy(Integer productDairyId, String productDairySize, String productDairyPrice, String productDairyName, String productDairyDescription, Integer imageDairyUrl) {
        this.productDairyId = productDairyId;
        this.productDairySize = productDairySize;
        this.productDairyPrice = productDairyPrice;
        this.productDairyName = productDairyName;
        this.productDairyDescription = productDairyDescription;
        this.imageDairyUrl = imageDairyUrl;
    }

    public Integer getProductDairyId() {
        return productDairyId;
    }

    public void setProductDairyId(Integer productDairyId) {
        this.productDairyId = productDairyId;
    }

    public String getProductDairySize() {
        return productDairySize;
    }

    public void setProductDairySize(String productDairySize) {
        this.productDairySize = productDairySize;
    }

    public String getProductDairyPrice() {
        return productDairyPrice;
    }

    public void setProductDairyPrice(String productDairyPrice) {
        this.productDairyPrice = productDairyPrice;
    }

    public String getProductDairyName() {
        return productDairyName;
    }

    public void setProductDairyName(String productDairyName) {
        this.productDairyName = productDairyName;
    }

    public String getProductDairyDescription() {
        return productDairyDescription;
    }

    public void setProductDairyDescription(String productDairyDescription) {
        this.productDairyDescription = productDairyDescription;
    }

    public Integer getImageDairyUrl() {
        return imageDairyUrl;
    }

    public void setImageDairyUrl(Integer imageDairyUrl) {
        this.imageDairyUrl = imageDairyUrl;
    }
}