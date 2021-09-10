package mkademghofrane.tn.model;

public class ProductOils {
    Integer productOilsId;
    String productOilsSize;
    String productOilsPrice,productOilsDescription,productOilsName;
    Integer imageOilsUrl;

    public ProductOils(Integer productOilsId, String productOilsSize, String productOilsPrice, String productOilsDescription, String productOilsName, Integer imageOilsUrl) {
        this.productOilsId = productOilsId;
        this.productOilsSize = productOilsSize;
        this.productOilsPrice = productOilsPrice;
        this.productOilsDescription = productOilsDescription;
        this.productOilsName = productOilsName;
        this.imageOilsUrl = imageOilsUrl;
    }

    public Integer getProductOilsId() {
        return productOilsId;
    }

    public void setProductOilsId(Integer productOilsId) {
        this.productOilsId = productOilsId;
    }

    public String getProductOilsSize() {
        return productOilsSize;
    }

    public void setProductOilsSize(String productOilsSize) {
        this.productOilsSize = productOilsSize;
    }

    public String getProductOilsPrice() {
        return productOilsPrice;
    }

    public void setProductOilsPrice(String productOilsPrice) {
        this.productOilsPrice = productOilsPrice;
    }

    public String getProductOilsDescription() {
        return productOilsDescription;
    }

    public void setProductOilsDescription(String productOilsDescription) {
        this.productOilsDescription = productOilsDescription;
    }

    public String getProductOilsName() {
        return productOilsName;
    }

    public void setProductOilsName(String productOilsName) {
        this.productOilsName = productOilsName;
    }

    public Integer getImageOilsUrl() {
        return imageOilsUrl;
    }

    public void setImageOilsUrl(Integer imageOilsUrl) {
        this.imageOilsUrl = imageOilsUrl;
    }
}
