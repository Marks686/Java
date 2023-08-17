import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-08-16
 * Time: 11:01
 */
//通过这个类,把数据库连接过程封装一下,此处把这个类作为一个工具类,提供static方法 供其他代码来调用.
public class DBUtil {
    //静态成员跟随类对象 类对象在整个进程中只有唯一一份
    //静态成员相当于也是唯一的实例 (单例模式 饿汉模式)
    private static DataSource dataSource = new MysqlDataSource();

    static {
        //使用静态代码块 针对dataSourse初始化
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java106?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("123456");
    }
    //通过这个方法建立连接
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    //通过这个方法断开连接,释放资源
    public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet){
        //此处 try catch 分开写更好 避免前面的异常导致后面的代码不能被执行
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
