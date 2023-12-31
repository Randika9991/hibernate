package lk.ijse.orm.thogakade.repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.orm.thogakade.config.SessionFactoryConfig;
import lk.ijse.orm.thogakade.dto.tm.CustomerTm;
import lk.ijse.orm.thogakade.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerRepository {
    private final Session session;

    public CustomerRepository(){
        session= SessionFactoryConfig.getInstance().getSession();
    }

    public Customer getStudent(int id) {
        try {
            return session.get(Customer.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public boolean saveCustomer(Customer customer) {
        Transaction transaction = session.beginTransaction();
        try {
            int customerId = (int)session.save(customer);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            transaction .rollback();
            session.close();
            return false;
        }
    }

    public boolean updateCustomer(Customer customer) {
        Transaction transaction1 = session.beginTransaction();
        try {
            session.update(customer);   //session updated(customer1)  --->me dekenma puluwan
            transaction1.commit();
            session.close();
            return true;
        } catch (Exception e) {
            transaction1.rollback();
            session.close();
            return false;
        }
    }

    public boolean deleteCustomer(Customer customer) {
        Transaction deleateTransaction = session.beginTransaction();
        try {
            session.delete(customer);
            deleateTransaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            deleateTransaction.rollback();
            session.close();
            return false;
        }
    }

    public ObservableList<CustomerTm> getAllCustomer() {
        Transaction transaction = session.beginTransaction();
        int id = 0;
        try {
            List<Customer> customers = session.createQuery("from Customer", Customer.class).list();
            ObservableList<CustomerTm> dataList = FXCollections.observableArrayList();
            for (Customer customer1 : customers) {
                id=customer1.getCustId();
                Customer nr = session.get(Customer.class, id);
                dataList.add(new CustomerTm(
                        nr.getCustId(),
                        nr.getCustName(),
                        nr.getCustAddress(),
                        nr.getCustSalary()
                ));

                /*System.out.println(nr.getCustId());
                System.out.println(nr.getCustName());
                System.out.println(nr.getCustAddress());
                System.out.println(nr.getCustSalary());*/
            }
            transaction.commit();
            session.close();
            return dataList;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            throw e;
        }
    }
}
