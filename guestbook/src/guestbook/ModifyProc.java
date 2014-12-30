package guestbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.*;


public class ModifyProc extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException{
		
		req.setCharacterEncoding("UTF-8");
		
		GuestArticle article = new GuestArticle();
		
		article.setId(req.getParameter("id"));
		article.setEmail(req.getParameter("email"));
		
		// 이메일 검사
		
		boolean isEmailMatch = Pattern.matches("^([\\.A-Za-z0-9_-]+)@([A-Za-z0-9\\-]+)(\\.[A-Za-z0-9]+){1,2}$", article.getEmail());
				
		if(!isEmailMatch){
			PrintWriter out = resp.getWriter();
					
			out.println("<script language = \"javascript\">");
			out.println("alert(\"Server : 이메일 주소 형식이 맞지 않습니다.\");");
			out.println("history.back();");
			out.println("</script>");
			return;
		}
		
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
