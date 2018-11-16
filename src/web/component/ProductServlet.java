package web.component;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.product.Product;
import com.product.ProductBiz;


@WebServlet({ "/ProductServlet", "/product" })
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductBiz biz = new ProductBiz();

    public ProductServlet() {
        super();
        biz=new ProductBiz();

    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cmd = request.getParameter("cmd");
		String center = "";

		if(cmd.equals("register")) {
			MultipartRequest mreq =
					new MultipartRequest(request, 
					"C:\\Users\\dlsrj\\eclipse-workspace\\jsp\\d04.zip_expanded\\d04\\web\\img", 
					1024*1024*1024, 
					"EUC-KR");
		String name = mreq.getParameter("name");
		String price = mreq.getParameter("price");
		String imgname = mreq.getOriginalFileName("imgname");
		
		Product p = 
				new Product(name, 
				Integer.parseInt(price), imgname);
		try {
			biz.register(p);
			
			request.setAttribute("center", "product/registerok");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("FAIL");
		}
		}else if(cmd.equals("getall")) {
			ArrayList<Product> list = null;
			try {
				list = biz.get();
				request.setAttribute("product_list", list);
				center = "product/allgetcustlist";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("center", center);
		RequestDispatcher rd =request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
	}

}
