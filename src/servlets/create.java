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
 * Servlet implementation class create
 */
@WebServlet("/create")
public class create extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public create() {
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
		HttpSession ht1 = request.getSession(false);
		while(ht1==null){
			out.println("<html><head><body><center>Enter Account Number</center></body></head></html>");
			request.getRequestDispatcher("home.jsp").include(request, response);
		}
		String accountnumber = request.getParameter("accountnumber");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String initialbal =request.getParameter("beginbalance");
		
		beanclass bean = new beanclass(Integer.parseInt(accountnumber),firstname,lastname,Integer.parseInt(initialbal));
		try {
			operations.getinsert(bean);
			out.println("<html><head><body><center><h3>Account Created Successfully<br><br><br><br><br></h3>"
					+ "<a href='welcome.jsp'>Return</a></center></body></head></html>");
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
