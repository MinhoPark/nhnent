package guestbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class WriteProc extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException{
		
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		GuestArticle article = new GuestArticle();
				
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
		
		// password 해쉬 저장
		
		try {
			article.setPassword(MakeSHA.getSHA1(req.getParameter("password")));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		article.setArticle(req.getParameter("article"));
		article.setArticle(article.getArticle().replaceAll("\n", "<br>"));
		
		Date nowdate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	//24시간제 시간포맷
		article.setFirstDate(sdf.format(nowdate));
		
		// db write
		GuestDAO dao = new GuestDAO();
		int sqlErr = dao.insert("write",article);
		
		if(sqlErr == 0)
			System.out.println("DB Err");
		else
			System.out.println("DB Success");
		
		resp.sendRedirect("List");
	}
}
