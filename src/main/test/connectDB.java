import java.sql.*;

public class connectDB {
    public static final String url = "jdbc:mysql://127.0.0.1:3306/ssm?useUnicode=true&characterEncoding=UTF-8";
    public static final String name = "com.mysql.jdbc.Driver";
    public static final String user = "root";
    public static final String password = "123456";

    public Connection conn = null;
    public PreparedStatement pst = null;

    public connectDB(String sql) {
        try {
            Class.forName(name);//指定连接类型
            conn = DriverManager.getConnection(url, user, password);//获取连接
            pst = conn.prepareStatement(sql);//准备执行语句
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            this.conn.close();
            this.pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String sql = "select *from tb_user";//SQL语句
        connectDB db1 = new connectDB(sql);//创建DBHelper对象
        ResultSet ret=null;
        try {
            ret = db1.pst.executeQuery();//执行语句，得到结果集
            while (ret.next()) {
                String uid = ret.getString(1);
                String ufname = ret.getString(2);
                System.out.println(uid + "\t" + ufname + "\t");
            }//显示数据
            ret.close();
            db1.close();//关闭连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
