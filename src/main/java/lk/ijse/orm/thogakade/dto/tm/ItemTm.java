package lk.ijse.orm.thogakade.dto.tm;

public class ItemTm {
    //@GeneratedValue(strategy = GenerationType.AUTO)

    private String ItemCode;
    private String ItemDescription;
    private double unitPrice;
    private int qtyOnHand;

    public ItemTm() {
    }

    public ItemTm(String itemCode, String itemDescription, double unitPrice, int qtyOnHand) {
        ItemCode = itemCode;
        ItemDescription = itemDescription;
        this.unitPrice = unitPrice;
        this.qtyOnHand = qtyOnHand;
    }

    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String itemCode) {
        ItemCode = itemCode;
    }

    public String getItemDescription() {
        return ItemDescription;
    }

    public void setItemDescription(String itemDescription) {
        ItemDescription = itemDescription;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    @Override
    public String toString() {
        return "ItemTm{" +
                "ItemCode='" + ItemCode + '\'' +
                ", ItemDescription='" + ItemDescription + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                ", qtyOnHand=" + qtyOnHand +
                '}';
    }
}
