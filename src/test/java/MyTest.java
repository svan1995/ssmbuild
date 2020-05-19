import com.csf.dao.BookMapper;
import com.csf.pojo.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;
import java.util.List;

public class MyTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookMapper booKMapper = context.getBean("bookMapper", BookMapper.class);
//        List<Book> list = booKMapper.queryAllBook();
//        System.out.println(list);
//        Book book = booKMapper.queryBookById(1);
//        System.out.println(book);

//        Book book = new Book();
//        book.setBookCounts(66);
//        book.setBookName("Hello,你好");
//        book.setDetail("测试书籍");
//        int i = booKMapper.addBook(book);
//        System.out.println(i);

//        Book book = booKMapper.queryBookById(4);
//        book.setDetail("测试膝盖");
//        int i = booKMapper.updateBook(book);
//        System.out.println(i);

        int i = booKMapper.deleteBookById(4);
        System.out.println(i);

//        Class.forName("com.mysql.jdbc.Driver");
//
//        String url = "jdbc:mysql://129.211.33.43:3306/ssmbuild?useUnicode=true&characterEncoding=utf8&useSSL=false";
//        String userName = "root";
//        String password = "Csflovey89_mysql";
//        Connection connection = null;
//        try {
//            connection = DriverManager.getConnection(url, userName, password);
//            System.out.println(111);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//
//        connection.close();

    }
}
