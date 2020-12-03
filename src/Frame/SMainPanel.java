package Frame;

import Table.Book;
import resource.ResourceBook;
import resource.ResourceManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SMainPanel extends JPanel {
    JTable table ;
    List<Book> bookList;
    Object tableData[][];
    Object names[] =  {"编号","书名","作者","分类","总数","剩余数量"};
    ResourceBook resourceBook = ResourceBook.BookL;
    private Frame frame;
    public SMainPanel(Frame frame) {

        this.frame = frame;
        this.bookList = resourceBook.getBookList();
        Init();

    }

    private void Init() {

        int rows = bookList.size();
        tableData = new Object[rows][names.length];


        for (int i = 0; i < rows; i++) {
//            tableData[i][0] = bookList.get(i).getSno();
//            tableData[i][1] = bookList.get(i).getName();
//            tableData[i][2] = bookList.get(i).getChineseScore();
//            tableData[i][3] = bookList.get(i).getMathScore();
//            tableData[i][4] = bookList.get(i).getEnglishScore();
//            tableData[i][5] = bookList.get(i).getScoreTotal();
        }

        table = new JTable(tableData, names);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}
