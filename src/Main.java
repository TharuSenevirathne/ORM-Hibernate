import config.FactoryConfiguration;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Main {
    private static FactoryConfiguration factoryConfiguration;

    public static void main(String[] args) {
        factoryConfiguration = factoryConfiguration.getInstance();

//        FactoryConfiguration factoryConfiguration = FactoryConfiguration.getInstance();
//
//        Customer customer1 = new Customer(1,"Alice","alice12@gmail.com","0773876489");
//
//        Session session =factoryConfiguration.getSessionFactory();
//
//        try {
//            Transaction transaction = session.beginTransaction();
//            session.save(customer1);
//            transaction.commit();
//            session.close();
//        }catch (Exception e){
//            System.out.println("Failed to save customer!!");
//        }

        Customer customer2 = new Customer(2,"Kamal","kamal12@gmail.com","0775873659");
        Customer customer3 = new Customer(3,"Nimal","nimal12@gmail.com","0775873659");
        Customer customer4 = new Customer(4,"Sunil","sunil12@gmail.com","0775873659");
        Customer customer5 = new Customer(5,"Amal","amal12@gmail.com","0775873659");

        saveCustomer(customer2);
        saveCustomer(customer3);
        saveCustomer(customer4);
        saveCustomer(customer5);


        Customer customer = getCustomer(2);
        System.out.println(customer);

  //      deleteCustomer(2);
  //      updateCustomer(2,new Customer(2,"Alice","alice13@gmail.com","0764556765")); // update krnn ona kenw thamai methanata denne

        List<Customer> allCustomers = getAllCustomers();
        for (Customer c : allCustomers) {
            System.out.println(c);
        }
    }


    public static List<Customer> getAllCustomers() {
        Session session = factoryConfiguration.getSessionFactory();
        List<Customer> customers = session.createQuery("from Customer",Customer.class).list();
        session.close();
        return customers;

    }

    public static boolean updateCustomer(int id , Customer newCustomerData) {
        Session session = factoryConfiguration.getSessionFactory();

        try {
            Customer customerById = session.get(Customer.class,id);
            Transaction transaction = session.beginTransaction();

 //           session.update(newCustomerData);
            customerById.CustomerFullName(newCustomerData.getName());
            customerById.setEmail(newCustomerData.getEmail());
            customerById.setPhone(newCustomerData.getPhone());

//            session.update(customerById);
            transaction.commit();
            return true;
        }catch (Exception e) {
            System.out.println("Customer not updated!!");
            e.printStackTrace();
            return false;
        }finally {
            if (session!= null){
                session.close();
            }
        }
    }

    public static boolean deleteCustomer(int id){
        Session session = factoryConfiguration.getSessionFactory();

        try {
            Customer getCustomer = getCustomer(id);

            Transaction transaction = session.beginTransaction();
            session.delete(getCustomer);

            transaction.commit();
            return true;
        }catch (Exception e){
            System.out.println("Customer not found");
            e.printStackTrace();
            return false;
        }finally {
            if (session!= null){
            session.close();
            }
        }
    }

    public static Customer getCustomer(int id) {
        Session session = factoryConfiguration.getSessionFactory();
        Customer customer = session.get(Customer.class, id);
        session.close();
        return customer;
    }

    public static boolean saveCustomer(Customer customer){
        Session session = factoryConfiguration.getSessionFactory();

        try {
            Transaction transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            if (session!= null){
                session.close();
            }
        }
    }
}
