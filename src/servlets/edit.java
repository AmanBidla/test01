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
 * Servlet implementation class edit
 */
@WebServlet("/edit")
public class edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);
		request.getRequestDispatcher("edit.jsp").include(request, response);
		HttpSession ht1 = request.getSession(false);
		while(ht1==null){
			out.println("<html><head><body><center>Enter Account Number</center></body></head></html>");
			request.getRequestDispatcher("home.jsp").include(request, response);
		}
		String account = request.getParameter("account");
		
		beanclass bean=null;
		
	        try {
				bean=operations.getselect(Integer.parseInt(account));
				out.println("<html><body><center><h3>ID &nbsp; &nbsp; First Name: &nbsp; &nbsp; Last Name &nbsp; &nbsp; Book Name &nbsp; &nbsp; Price &nbsp; &nbsp;Status</h3><br>");
				out.println(bean.getaccountnumber()+"&nbsp; &nbsp;"+bean.getfirstname()+"&nbsp; &nbsp;"+bean.getlastname()+"&nbsp; &nbsp;"+bean.getbalance()+"&nbsp; &nbsp;<br>");
				out.println("<a href ='welcome.jsp'> Return</a>");
				out.println("</center></body></html>");
				
				operations.getdelete(Integer.parseInt(account));
				request.getRequestDispatcher("createaccount.jsp").include(request, response);
			
	        } catch (NumberFormatException | ClassNotFoundException | SQLException e) {
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
