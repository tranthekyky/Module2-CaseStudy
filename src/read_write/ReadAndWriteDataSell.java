package read_write;

import model.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ReadAndWriteDataSell {
    private File sellFile = new File("data_base/sell.csv");
    public void writeDataSell(HashMap<Integer, ArrayList<Book>> dataSell) {
        try {
            String data = "";
            Set<Integer> keys = dataSell.keySet();
            for (Integer key : keys) {
                for (Book book : dataSell.get(key)) {
                    data += key + "," + book.getCodeBook() + "," + book.getName() + "," + book.getAuthor() + "," + book.getPrice() + "," + book.getQuantity() + "," + book.getCodeType() + "\n";
                }
            }
            FileWriter fileWriter = new FileWriter(this.sellFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        }catch (IOException e){
            System.out.println("Lỗi lưu dữ liệu vào file 'sell.csv'");
        }
    }
    public HashMap<Integer, ArrayList<Book>> readDataSell() {
        HashMap<Integer, ArrayList<Book>> dataSell = new HashMap<>();

        try {
            FileReader fileReader = new FileReader(this.sellFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line ;
            while ((line = bufferedReader.readLine()) != null) {
                ArrayList<Book> books = new ArrayList<>();
                String[] data = line.split(",");
                if (!dataSell.containsKey(Integer.parseInt(data[0]))) {
                    books.add(new Book(data[1], data[2],data[3],Double.parseDouble(data[4]), Integer.parseInt(data[5]), data[6]));
                    dataSell.put(Integer.parseInt(data[0]), books);
                }else {
                    dataSell.get(Integer.parseInt(data[0])).add(new Book(data[1], data[2],data[3],Double.parseDouble(data[4]), Integer.parseInt(data[5]), data[6]));
                }


            }
            bufferedReader.close();
        }catch (IOException e){
            System.err.println("Lỗi đọc dữ liệu từ file 'sell.csv'");
        }
        return dataSell;
    }
}
