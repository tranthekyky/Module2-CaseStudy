package read_write;

import model.Admin;
import model.Customer;

import java.io.*;
import java.util.ArrayList;

public class ReadAndWriteDataUser {
    private File fileUser = new File("data_base/customer.csv");
    public void writeDataCustomer(ArrayList<Customer> customers) {
        try {
            FileWriter fileWriter = new FileWriter(this.fileUser);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String data = "";
            for (Customer cus : customers) {
                data += cus.getId() + "," + cus.getName() + "," +cus.getEmail() + "," + cus.getNumberPhone() + ","+ cus.getAddress() +  "\n";
            }
            bufferedWriter.write(data);
            bufferedWriter.close();
        }catch (IOException e) {
            System.err.println("Lỗi lưu dữ liệu vào file 'customer.csv'");
        }
    }
    public ArrayList<Customer> readDataCustomer() {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(this.fileUser);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line ;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                Customer customer = new Customer(data[1] , data[2], data[3], data[4]);
                customer.setId(Integer.parseInt(data[0]));
                customers.add(customer);
            }

            bufferedReader.close();
        }catch (IOException e) {
            System.err.println("Lỗi đọc dữ liệu từ file 'customer.csv'");
        }
        return customers;
    }
}
