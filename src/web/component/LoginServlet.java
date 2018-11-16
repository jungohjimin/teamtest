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

@WebServlet({ "/LoginServlet", "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	CustBiz biz;
	
    public LoginServlet() {
        super();
        biz = new CustBiz();
    }
    //Logout ó��
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session 
    	= request.getSession();
    	if(session != null) {
    		session.invalidate();
    	}
    	response.sendRedirect("main.mc");
    }
    // Login ó��
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		// �ش� ID�� ���� �ϴ��� �˻�
		// �ش� ID�� cust ��ü ����
		// pwd�� cust ��ü�� pwd�� �� �Ѵ�.
		Cust cust = null;
		String center = "";
	
		try {
			cust = biz.get(id);
			if(pwd.equals(cust.getPwd())) {
				center = "loginok";
				HttpSession session = request.getSession();
				session.setAttribute("login_cust", cust);//���⼭ login_cust ����
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			center = "loginfail";
			e.printStackTrace();
		}
		
		request.setAttribute("center", center);
		RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
	}

}







