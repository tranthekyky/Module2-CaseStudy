package function.function_admin;

import model.Book;

import java.util.ArrayList;
import java.util.HashMap;

public interface IFunctionAdmin_Book <B>{
    ArrayList<B> getBooks();
    int getIndexBooks (String code);
    void displaysAllBookByLibrary ();
    void addNewBooks (B book);
    void deleteBook (int index);
    void updateBook (int index,B book);
    Book findBookByCode (int index);
    ArrayList<B> findBooksByName (String name);
    ArrayList<B> findBooksByType (String codeType);
    int getBooksQuantityAll ();
    int getBooksQuantityByType (String codeType);
    boolean checkQuantityBooks (ArrayList<B> cart , int quantity , int index);
    void saleBook (ArrayList<B> cart , int idUser);
    void printInvoice (ArrayList<B> cart) ;
    HashMap <Integer,ArrayList<B>> getSaleBook ();
    int getQuantityByCodeSell (String code);
}
