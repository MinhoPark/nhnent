package guestbook;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteProc extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/html; charset=UTF-8");
		
		GuestDAO dao = new GuestDAO();
		int sqlErr = dao.delete("delete", req.getAttribute("id"));
		
		if(sqlErr == 0)
			System.out.println("DB Err");
		else
			System.out.println("DB Success");
		
		resp.sendRedirect("List");
	}
}
