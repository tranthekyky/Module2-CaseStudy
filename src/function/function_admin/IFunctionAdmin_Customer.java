package function.function_admin;

import model.Customer;

import java.util.ArrayList;

public interface IFunctionAdmin_Customer <C>{
    int getIndexCustomer (int id);
    ArrayList<C> getCustomers ();
    void displayALlCustomers();
    Customer displaysInfo (int index) ;
    void addCustomer(C c);
    void deleteCustomer(int index);
    void updateCustomer(int index, C c);
    ArrayList <C> searchCustomerByName (String name);

}
