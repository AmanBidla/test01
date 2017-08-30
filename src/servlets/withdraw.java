package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.beanclass;
import bean.operations;

/**
 * Servlet implementation class withdraw
 */
@WebServlet("/withdraw")
public class withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public withdraw() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	PrintWriter out = response.getWriter();
	String withdraw = request.getParameter("withdraw");
	HttpSession ht = request.getSession(false);
	if(ht==null){
		out.println("<html><head><body><center>Enter Account Number</center></body></head></html>");
		request.getRequestDispatcher("home.jsp").include(request, response);
	}	
		
	int account = Integer.parseInt((String) ht.getAttribute("account"));
      
	beanclass bean = new beanclass(account,Integer.parseInt(withdraw)); 
       try {
		int currentbal= operations.getwithdraw(bean);
		if(currentbal != 1){
			out.println("<html><head><body><center>Amount Withdrawn:"+withdraw+"<br> Current Balance: "+currentbal+"<br><br><br><a href='account.html'>Return</a></center></body></head></html>");
		}
		else{
			out.println("<html><head><body><center>Insufficient Funds Try lesser amount<br>");
		request.getRequestDispatcher("withdraw.jsp").include(request, response);
		out.println("<a href='account.html'>Return</a></center></body></head></html>");
		}
		} catch (ClassNotFoundException | SQLException e) {
		out.println("<html><body><center>Error Processing request try later</center></body></html>");
		request.getRequestDispatcher("home.jsp").include(request, response);
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
