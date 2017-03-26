import java.sql.*;

public class MySQLConnector {
	public static void main(String[] args) {

		Connection con = null;
		try {
			

			// JDBCドライバのロード - JDBC4.0（JDK1.6）以降は不要
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("接続するぞー");
			// MySQLに接続
			con = DriverManager.getConnection("jdbc:mysql://localhost/C_connect","root","p123p456p789");



			System.out.println("MySQLに接続できました。");

			Statement stm = con.createStatement();
			String sql = "select * from table1;";
			//結果はrsに入る
			ResultSet rs = stm.executeQuery(sql);

			System.out.println("whileに入りますよ");
			while(rs.next()){
				System.out.println("whileの中ですよ");
				String colmun1 = rs.getString("colmun1");
				int colmun2 = rs.getInt("colmun2");
				System.out.println("取得結果 -> " + colmun1 + ":" + colmun2);
			}


		} catch (SQLException e) {
			System.out.println("MySQLに接続できませんでした。");

		} catch (Exception e){
			System.out.println("Unknown Error."+e);

		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("MySQLのクローズに失敗しました。");
				}
			}
		}
	}
}
