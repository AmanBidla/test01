package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

public class operations {
	private static final String insertquery = "insert into account values(?,?,?,?)";
	private static final String deletequery = "delete from account where accountnumber =?";
	private static final String selectquery ="select * from account where accountnumber =?";
	

	public static void getinsert(beanclass bean) throws ClassNotFoundException, SQLException{
		Connection con = dbutil.getconnection();
		PreparedStatement insert = con.prepareStatement(insertquery);
		insert.setInt(1, bean.getaccountnumber());
		insert.setString(2,bean.getfirstname());
		insert.setString(3,bean.getlastname());
		insert.setInt(4, bean.getbalance());
		insert.executeUpdate();
	}
	
	public static void getdelete(int accountnumber) throws ClassNotFoundException, SQLException{
		Connection con = dbutil.getconnection();
		PreparedStatement delete = con.prepareStatement(deletequery);
		delete.executeUpdate();
	}
	
	public static beanclass getselect(int accountnumber) throws SQLException, ClassNotFoundException{
		 Connection con = dbutil.getconnection();
	     PreparedStatement select = con.prepareStatement(selectquery);
	     select.setInt(1, accountnumber);
	     ResultSet rs = select.executeQuery();
	     beanclass bean =null;
			while(rs.next()){
				bean =new beanclass();
				bean.setaccountnumber(rs.getInt(1));
				bean.setfirstname(rs.getString(2));
				bean.setlastname(rs.getString(3));
				bean.setbalance(rs.getInt(4));
			}
			return bean;
	}
	
	public static boolean getverify(int account) throws SQLException, ClassNotFoundException{
	
	 Connection con = dbutil.getconnection();
     PreparedStatement select = con.prepareStatement(selectquery);
     select.setInt(1, account);
     ResultSet rs = select.executeQuery();
     
     if(rs==null){
    	 return false;
     }
     else
    	 return true;
	}
	
	public static int getwithdraw(beanclass bean) throws SQLException, ClassNotFoundException{
	Connection con = dbutil.getconnection();
	PreparedStatement getbal = con.prepareStatement("select balance from account where accountnumber =?");
	getbal.setInt(1, bean.getaccountnumber());
	ResultSet rs = getbal.executeQuery();
	int currentbal =0;
	int balance=0;
    int withdrawamount=0;
	while(rs.next()){
	    balance=rs.getInt(1);
	    withdrawamount = bean.getwithdraw();
	    currentbal = balance -withdrawamount;
	}	    
	    if(balance<withdrawamount){
	    	return 1;
	    }
	    else{
	    	PreparedStatement update = con.prepareStatement("update account set balance=? where accountnumber=?");
	    	update.setInt(1, currentbal);
	    	update.setInt(2, bean.getaccountnumber());
	    	update.executeUpdate();
	    return currentbal;
	    }
	}
	
	public static int getdeposit(beanclass bean) throws ClassNotFoundException, SQLException{
		Connection con = dbutil.getconnection();
		PreparedStatement getbal = con.prepareStatement("select balance from account where accountnumber =?");
		getbal.setInt(1, bean.getaccountnumber());
		ResultSet rs = getbal.executeQuery();
		int currentbal =0;
		int balance=0;
	    int depositamount=0;
		while(rs.next()){
		    balance=rs.getInt(1);
		    depositamount = bean.getwithdraw();
		    currentbal = balance + depositamount;
		}
    	PreparedStatement update = con.prepareStatement("update account set balance=? where accountnumber=?");
    	update.setInt(1, currentbal);
    	update.setInt(2, bean.getaccountnumber());
    	update.executeUpdate();
return currentbal;
		
	}
	
	public static int getbalance(int account) throws ClassNotFoundException, SQLException{
		Connection con = dbutil.getconnection();
		PreparedStatement getbal = con.prepareStatement("select balance from account where accountnumber =?");
		getbal.setInt(1, account);
		ResultSet rs = getbal.executeQuery();
		int balance =0;
		while(rs.next()){
			balance = rs.getInt(1);
		}
		return balance;

	}
	
	
	}
	

