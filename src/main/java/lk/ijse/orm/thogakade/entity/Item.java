package lk.ijse.orm.thogakade.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Item")
public class Item {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Item_code",length = 50)
    private String ItemCode;
    @Column(name = "Item_description")
    private String ItemDescription;
    @Column(name = "unitPrice")
    private double unitPrice;
    @Column(name = "Item_qtyOnHand")
    private int qtyOnHand;

    public Item() {

    }

    public Item(String itemCode, String itemDescription, double unitPrice, int qtyOnHand) {
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
        return "Item{" +
                "ItemCode='" + ItemCode + '\'' +
                ", ItemDescription='" + ItemDescription + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                ", qtyOnHand=" + qtyOnHand +
                '}';
    }
}
