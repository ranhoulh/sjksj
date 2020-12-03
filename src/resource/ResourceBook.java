package resource;

import Table.Book;

import java.util.ArrayList;
import java.util.List;

public class ResourceBook {
    private List<Book> bookList;

    public static ResourceBook BookL = new ResourceBook();

    ResourceBook(){
        this.bookList = new ArrayList<>();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
