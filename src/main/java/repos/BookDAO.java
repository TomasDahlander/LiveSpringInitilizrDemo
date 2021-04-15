package repos;

import models.Book;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Tomas Dahlander <br>
 * Date: 2021-04-08 <br>
 * Time: 14:24 <br>
 * Project: LiveSpringInitilizrDemo <br>
 */
public class BookDAO {

    public List<Book> getAllBooks(){
        Book b1 = new Book(1,"title1","author1");
        Book b2 = new Book(2,"title2","author2");
        Book b3 = new Book(3,"title3","author3");
        Book b4 = new Book(4,"title4","author4");
        Book b5 = new Book(5,"title5","author5");
        Book b6 = new Book(6,"title6","author6");

        return Arrays.asList(b1,b2,b3,b4,b5,b6);
    }
}
