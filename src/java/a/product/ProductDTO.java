package a.product;

public class ProductDTO {
    private String proID;
    private String name;
    private String description;
    private float price;
    private int quantity;
    private String srcImg;
    private boolean sale;
    private String category;

    public ProductDTO() {
        this.proID = "";
        this.name = "";
        this.description = "";
        this.price = 0;
        this.quantity = 0;
        this.srcImg = "";
        this.sale = false;
        this.category = "";
    }

    public ProductDTO(String proID, String name, String description, float price, int quantity, String srcImg, boolean sale, String category) {
        this.proID = proID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.srcImg = srcImg;
        this.sale = sale;
        this.category = category;
    }

    /**
     * @return the proID
     */
    public String getProID() {
        return proID;
    }

    /**
     * @param proID the proID to set
     */
    public void setProID(String proID) {
        this.proID = proID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the srcImg
     */
    public String getSrcImg() {
        return srcImg;
    }

    /**
     * @param srcImg the srcImg to set
     */
    public void setSrcImg(String srcImg) {
        this.srcImg = srcImg;
    }

    /**
     * @return the sale
     */
    public boolean isSale() {
        return sale;
    }

    /**
     * @param sale the sale to set
     */
    public void setSale(boolean sale) {
        this.sale = sale;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    
    
}
