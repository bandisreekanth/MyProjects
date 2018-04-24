package dataBaseTest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class database_connect_ex {
	public static void main(String args[]) throws SQLException, ClassNotFoundException
	{
		System.out.println("Started");
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		System.out.println("Register the Driver ");
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Register the SQL Server Driver");
		/*String dbURL = "jdbc:sqlserver://localhost\\sqlexpress;user=sa;password=secret";
		Connection conn = DriverManager.getConnection(dbURL);
		if (conn != null) {
		    System.out.println("Connected");
		}*/
		
		//System.setProperty("java.library.path", "C:\\Program Files\\Java\\jdk1.8.0_112\\bin");

		//-Djava.library.path="C:\Program Files\Java\jdk1.8.0_112\bin;";
		
		
		String dbURL = "jdbc:sqlserver://192.168.84.78;integratedSecurity=true;databaseName=icici_shg";
		String user = "KARVY\\sreekath.bandi";
		String pass = "";
		Connection conn = DriverManager.getConnection(dbURL,user,pass);
		if (conn != null) {
		    System.out.println("Connected");
    	}
		else
		{
			System.out.println("Not Connected");
		}
		String sql="SELECT *  FROM ICICI_SHG.dbo.ICICI_SHG_ROLEMASTER";
		//String sql="SELECT *  FROM [ICICI_SHG].[dbo].[ICICI_SHG_ROLEMASTER]";
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
			System.out.println(rs.getString(1)+"  "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
		}		
	}
}
