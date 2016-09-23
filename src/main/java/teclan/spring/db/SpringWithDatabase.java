package teclan.spring.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringWithDatabase {
    @SuppressWarnings("resource")
    public static void main(String args[]) throws Exception {

        // 数据库配置文件名字任意，在这里指定正确的文件即可
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "database.xml");

        DataSource dataSource = ctx.getBean("dataSource", DataSource.class);

        String sql = "select * from teclan";

        Connection connection = dataSource.getConnection();

        Statement stm = connection.createStatement();

        ResultSet rs = stm.executeQuery(sql);

        while (rs.next()) {
            System.out.println(
                    rs.getString("id") + " " + rs.getString("content"));
            // System.out.println(rs.getString(1) + " " + rs.getString(2));

        }

    }

}
