package guestbook;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.*;


public class ModifyProc extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException{
		
		req.setCharacterEncoding("UTF-8");
		
		GuestArticle article = new GuestArticle();
		
		article.setId(req.getParameter("id"));
		article.setArticle(req.getParameter("article"));
		article.setArticle(article.getArticle().replaceAll("\n", "<br>"));
		
		
		
		Date nowdate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	//24시간제 시간포맷
		article.setLastModifyDate(sdf.format(nowdate));
		
		// db write
		GuestDAO dao = new GuestDAO();
		int sqlErr = dao.update("modify",article);
		
		if(sqlErr == 0)
			System.out.println("DB Err");
		else
			System.out.println("DB Success");
		
		resp.sendRedirect("List");
	}
}
