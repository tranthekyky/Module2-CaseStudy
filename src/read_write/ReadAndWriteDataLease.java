package read_write;

import model.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ReadAndWriteDataLease {
    private File leaseFile = new File("data_base/lease.csv");
    public void writeDataLease(HashMap<Integer, ArrayList<Book>> dataLease) {
        try {
            String data = "";
            Set<Integer> keys = dataLease.keySet();
            for (Integer key : keys) {
                for (Book book : dataLease.get(key)) {
                    data += key + "," + book.getCodeBook() + "," + book.getName() + "," + book.getAuthor() + "," + book.getPrice() + "," + book.getQuantity() + "," + book.getCodeType() + "\n";
                }
            }
            FileWriter fileWriter = new FileWriter(this.leaseFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        }catch (IOException e){
            System.out.println("Lỗi lưu dữ liệu vào file 'lease.csv'");
        }
    }
    public HashMap<Integer, ArrayList<Book>> readDataLease() {
        HashMap<Integer, ArrayList<Book>> dataLease = new HashMap<>();

        try {
            FileReader fileReader = new FileReader(this.leaseFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line ;
            while ((line = bufferedReader.readLine()) != null) {
                ArrayList<Book> books = new ArrayList<>();
                String[] data = line.split(",");
                books.add(new Book(data[1], data[2],data[3],Double.parseDouble(data[4]), Integer.parseInt(data[5]), data[6]));
                dataLease.put(Integer.parseInt(data[0]) , books) ;
            }
            bufferedReader.close();
        }catch (IOException e){
            System.err.println("Lỗi đọc dữ liệu từ file 'lease.csv'");
        }
        return dataLease;
    }
}
