package guestbook;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListProc extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		GuestDAO dao = new GuestDAO();
		resp.setContentType("text/html; charset=UTF-8");
		List<GuestArticle> articleList = dao.select("printlist");
		
		req.setAttribute("lists", articleList);
		RequestDispatcher rd = req.getRequestDispatcher("/list.jsp");
		
		try {
			rd.include(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
