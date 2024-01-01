package TermDeposit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import Utilities.utility;

public class BranchService {
	
	public void SetDate(String date) throws ParseException
	{
		//String query = "UPDATE BRANCH_TL SET TODAY_DATE = ?, TOMORROW_DATE = ?, YESTERDAY_DATE = ? WHERE BRN_CD = '" + Session.GetBranchCode() + "'";
		String query = "UPDATE BRANCH_TL SET TODAY_DATE = ?, TOMORROW_date = Date(?)+1 Day , yesterday_date=Date(?)-1 Day WHERE BRN_CD = '" + Session.GetBranchCode() + "'";
		java.sql.Statement lcl_stmt;
		Connection lcl_conn_dt = utility.db_conn();
		try 
		{
			PreparedStatement preparedStatement = lcl_conn_dt.prepareStatement(query);
			Date today_date = utility.toDate("yyyy-MM-dd", date);
			preparedStatement.setString(1,today_date.toString());

			preparedStatement.setString(2,today_date.toString());

			preparedStatement.setString(3,today_date.toString());
//			date = date.min
//			Date yesterday_date = utility.toDate("YYYY-mm-dd", date.toString());
//			preparedStatement.setInt(2,);
//			preparedStatement.setString(3,);
			preparedStatement.executeUpdate();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
