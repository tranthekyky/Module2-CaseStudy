package function.function_customer;

import java.util.ArrayList;

public interface IFunctionCustomer <B>{
    int getIndexBookInCart (String code) ;
    ArrayList<B> getBookListInCart () ;
    void addBooksIntoCart(B b, int quantity ) ;
    void removeBooksByCart(int index , int quantity) ;
    void displaysCart () ;
    double totalAmountInCart () ;
    String getDateTime ();

    void saveDataBuy(int idUser , B b);
    String readDataBuy(int idUser ) ;
;


}
