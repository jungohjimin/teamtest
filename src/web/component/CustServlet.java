package web.component;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cust.Cust;
import com.cust.CustBiz;

@WebServlet({ "/CustServlet", "/cust" })
public class CustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   CustBiz biz=new CustBiz();
	   
    public CustServlet() {
        super();
        biz=new CustBiz();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String cmd= request.getParameter("cmd");
		String center ="";

		if(cmd.equals("getall")) {
			   ArrayList<Cust> list = null;

			try {
				list=biz.get();

				request.setAttribute("cust_list", list);
				center = "cust/allgetcustlist";
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		request.setAttribute("center", center);
		RequestDispatcher rd = request.getRequestDispatcher("main.jsp");//main.jsp·Î °£´Ù
		rd.forward(request, response);
		
	
	}

}
