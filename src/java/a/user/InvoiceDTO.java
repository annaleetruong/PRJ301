package a.user;

public class InvoiceDTO {

    private String proID;
    private String userID;
    private int quantity;
    private float price;
    private String phone;
    private String date;

    public InvoiceDTO() {
    }

    public InvoiceDTO(String proID, String userID, int quantity, float price, String phone, String date) {
        this.proID = proID;
        this.userID = userID;
        this.quantity = quantity;
        this.price = price;
        this.phone = phone;
        this.date = date;
    }

    public String getProID() {
        return proID;
    }

    public void setProID(String proID) {
        this.proID = proID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String
            phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
