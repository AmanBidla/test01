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
 * Servlet implementation class deposit
 */
@WebServlet("/deposit")
public class deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deposit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
         PrintWriter out = response.getWriter();
         String deposit = request.getParameter("deposit");
         HttpSession ht = request.getSession(false);
        if(ht==null){
        	out.println("<html><head><body><center>Enter Account Number</center></body></head></html>");
    		request.getRequestDispatcher("home.jsp").include(request, response);
        }
         int account = Integer.parseInt((String) ht.getAttribute("account"));
         beanclass bean = new beanclass(account,Integer.parseInt(deposit));
         
         try {
			
			int currentbal = operations.getdeposit(bean);
			out.println("<html><head><body><center>Current Balance: "+currentbal+"<br> Amount Deposit: "+deposit+"<br><br><br>"
					+ "<a href='account.html'>Return</a><br></center></body></head></html>");
			
		} catch (ClassNotFoundException | SQLException e) {
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
