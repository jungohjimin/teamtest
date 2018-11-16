package web.dispatcher;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/DispatcherServlet", "/dispatcher" })
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DispatcherServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		
		System.out.println(uri+" "+path);
		path = path.substring(1, path.lastIndexOf("."));//마지막은 포함 안됨
		
		System.out.println(path);
		
		String next = "main.jsp";
		if(path.equals("main"))
		{
			String view = request.getParameter("view");
			
			if(view != null ){
				build(request, view);
			}
			
			next = "main.jsp";
		}else{
			next = path;
			System.out.println(path);

		}
		RequestDispatcher rd = request.getRequestDispatcher(next);
		rd.forward(request, response);//다음 servlet으로 넘긴다.
	}
	
	// make ui
	private void build(HttpServletRequest request,String view){
		if(view.equals("login")) {
			request.setAttribute("navi", Navi.login);
			request.setAttribute("center", "login");
		}
		else if(view.equals("register")) {
			request.setAttribute("navi", Navi.register);
			request.setAttribute("center", "register");
		}
		else if(view.equals("p_register")) {
			//request.setAttribute("navi", Navi.register);
			request.setAttribute("center", "p_register");
		}
		
		
	}
	
	

}




