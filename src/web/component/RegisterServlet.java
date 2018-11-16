package web.component;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cust.Cust;
import com.cust.CustBiz;


@WebServlet({ "/RegisterServlet", "/register" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       CustBiz biz;
   
    public RegisterServlet() {
        super();
        biz = new CustBiz();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
    	if(session != null) {
    		session.invalidate();
    	}
    	response.sendRedirect("main.mc");
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		Cust cust = new Cust(id,pwd,name,Integer.parseInt(age));
		
		
		try {
			biz.register(cust);
			
			HttpSession session = request.getSession();//바로 로그인 되게끔
			
			session.setAttribute("login_cust",cust);//바로 로그인 되게끔
			request.setAttribute("rid",id);
			request.setAttribute("center", "registerok");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("FAIL");
		}
		RequestDispatcher rd =request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
		
	}


}
