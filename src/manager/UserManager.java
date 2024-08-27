package manager;

import function.function_admin.IFunctionAdmin_Customer;
import model.Customer;
import read_write.ReadAndWriteDataUser;

import java.util.ArrayList;
import java.util.List;

public class UserManager implements IFunctionAdmin_Customer <Customer> {
    private ArrayList<Customer> customers;
    private ReadAndWriteDataUser readAndWriteDataUser = new ReadAndWriteDataUser();
    public UserManager() {
        customers = readAndWriteDataUser.readDataCustomer();
    }
    @Override
    public int getIndexCustomer(int id) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    @Override
    public void displayALlCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    @Override
    public Customer displaysInfo(int index) {
       return customers.get(index);
    }

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
        customer.setId(customers.size());
        readAndWriteDataUser.writeDataCustomer(customers);
    }

    @Override
    public void deleteCustomer(int index) {
        customers.remove(index);
        readAndWriteDataUser.writeDataCustomer(customers);
    }

    @Override
    public void updateCustomer(int index, Customer customer) {
        customers.set(index, customer);
        readAndWriteDataUser.writeDataCustomer(customers);
    }

    @Override
    public ArrayList<Customer> searchCustomerByName(String name) {
        ArrayList<Customer> customersNew = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getName().toUpperCase().contains(name.toUpperCase())) {
                customersNew.add(customer);
            }
        }
        return customersNew;
    }


}
