package lk.ijse.orm.thogakade.repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.orm.thogakade.config.SessionFactoryConfig;
import lk.ijse.orm.thogakade.dto.tm.CustomerTm;
import lk.ijse.orm.thogakade.dto.tm.ItemTm;
import lk.ijse.orm.thogakade.entity.Customer;
import lk.ijse.orm.thogakade.entity.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ItemRepository {
    private final Session session;

    public ItemRepository(){
        session= SessionFactoryConfig.getInstance().getSession();
    }

    public Item getStudent(String id) {
        try {
            return session.get(Item.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public boolean saveItem(Item customer) {
        Transaction transaction = session.beginTransaction();
        try {
            String customerId = (String)session.save(customer);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction .rollback();
            session.close();
            return false;
        }
    }

    public boolean updateItem(Item item) {
        Transaction transaction1 = session.beginTransaction();
        try {
            session.update(item);   //session updated(customer1)  --->me dekenma puluwan
            transaction1.commit();
            session.close();
            return true;
        } catch (Exception e) {
            transaction1.rollback();
            session.close();
            return false;
        }
    }

    public boolean deleteItem(Item item) {
        Transaction deleateTransaction = session.beginTransaction();
        try {
            session.delete(item);
            deleateTransaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            deleateTransaction.rollback();
            session.close();
            return false;
        }
    }

    public ObservableList<ItemTm> getAllItem() {
        Transaction transaction = session.beginTransaction();
        String id = "";
        try {
            List<Item> items = session.createQuery("from Item", Item.class).list();
            ObservableList<ItemTm> dataList = FXCollections.observableArrayList();
            for (Item item : items) {
                id=item.getItemCode();
                Item nr = session.get(Item.class, id);
                dataList.add(new ItemTm(
                        nr.getItemCode(),
                        nr.getItemDescription(),
                        nr.getUnitPrice(),
                        nr.getQtyOnHand()
                ));
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
