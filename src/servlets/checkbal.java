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

import bean.operations;

/**
 * Servlet implementation class checkbal
 */
@WebServlet("/checkbal")
public class checkbal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkbal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  PrintWriter out = response.getWriter();
		
		HttpSession ht = request.getSession();
	  if(ht==null){
      	out.println("<html><head><body><center>Enter Account Number</center></body></head></html>");
  		request.getRequestDispatcher("home.jsp").include(request, response);
      }
	  int account = Integer.parseInt((String) ht.getAttribute("account"));
	  try {
		int balance =operations.getbalance(account);
		out.println("<html><head><body><center><h3>Current Balance: "+balance+"</h3><br><br><br><br>"
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
