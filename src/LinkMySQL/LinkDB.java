package LinkMySQL;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class LinkDB {

    static final String DB_URL = "jdbc:mysql://10.5.100.50:3306/xfaf";
    // MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称
    static final String USER = "hxl";
    static final String PASS = "1003";


//    public static void main(String[] args) throws SQLException, Exception {
    public void SqlInsert(String str1,String str2,String str3) throws SQLException, Exception {
        Connection conn = null;
        Statement stat = null;
        String sql_insert = "insert into sys_user_role values(?,?,?)";//数据库操作语句（插入）
        // 注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 创建链接
        conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement pst = conn.prepareStatement(sql_insert);//用来执行SQL语句查询，对sql语句进行预编译处理
        // 执行查询
        stat = conn.createStatement();
        String sql_check = "SELECT * FROM sys_user_role";
        ResultSet rs = stat.executeQuery(sql_check);
        // 输出查询结果
        while (rs.next()) {
            System.out.print(rs.getString("id") + "\t");
            System.out.print(rs.getString("user_id") + "\t");
            System.out.print(rs.getString("role_id") + "\t");
            System.out.print("\n");
        }
        pst.setString(1, str1);
        System.out.println("成功插入ID"+str1);
        pst.setString(2, str2);
        System.out.println("成功插入用户ID"+str2);
        pst.setString(3, str3);
        System.out.println("成功插入权限ID"+str3);
        pst.executeUpdate();//解释在下

        // 关闭
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stat != null) {
                    stat.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

