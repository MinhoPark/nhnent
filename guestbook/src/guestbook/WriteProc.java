package guestbook;

import java.io.IOException;
import java.io.Reader;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		
		GuestArticle article = new GuestArticle();
		
		article.setEmail(req.getParameter("email"));
		// password 해쉬 저장
		
		try {
			article.setPassword(MakeSHA.getSHA1(req.getParameter("password")));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		article.setArticle(req.getParameter("article"));
		article.setArticle(article.getArticle().replaceAll("\n", "<br>"));
		
		Date nowdate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
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
