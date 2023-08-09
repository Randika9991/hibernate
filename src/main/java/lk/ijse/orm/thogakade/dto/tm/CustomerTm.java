package lk.ijse.orm.thogakade.dto.tm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


public class CustomerTm {
    //@GeneratedValue(strategy = GenerationType.AUTO)

    private int custId;
    private String custName;
    private String custAddress;
    private String custSalary;

    public CustomerTm() {

    }

    public CustomerTm(int custId, String custName, String custAddress, String custSalary) {
        this.custId = custId;
        this.custName = custName;
        this.custAddress = custAddress;
        this.custSalary = custSalary;

        System.out.println(custId);

    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustSalary() {
        return custSalary;
    }

    public void setCustSalary(String custSalary) {
        this.custSalary = custSalary;
    }

    @Override
    public String toString() {
        return "CustomerTm{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", custSalary='" + custSalary + '\'' +
                '}';
    }
}
