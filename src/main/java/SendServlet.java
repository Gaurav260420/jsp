import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
@WebServlet("/send")
@MultipartConfig(maxFileSize = 2000000000l, fileSizeThreshold = 2000000000,maxRequestSize = 200000000000l)
public class SendServlet extends HttpServlet {
	Database db;
	@Override
	public void init() throws ServletException {
		db= new Database("jdbc:mysql://localhost:3306/jsp","root","Gaurav26@");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password= req.getParameter("pass");
		Part p = req.getPart("file");
		String fname= p.getSubmittedFileName();
		
		for(Part p0:req.getParts()) {
			p0.write("C:\\Users\\GAURAV\\Desktop\\Upload\\"+fname);
		}
		boolean check = db.insert(name, email, password, "C:\\Users\\GAURAV\\Desktop\\Upload\\"+fname);
		if(check) {
		RequestDispatcher rd= req.getRequestDispatcher("resp.jsp");
		rd.forward(req, resp);
		}
		else {
			RequestDispatcher rd= req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
			
		}
	}
   

}
