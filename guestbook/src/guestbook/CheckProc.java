package guestbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckProc extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
			req.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html; charset=UTF-8");
			
			String compPassword = req.getParameter("password");	// 비교해야할 비밀번호 값.
			RequestDispatcher rd;
			
			try {
				compPassword = MakeSHA.getSHA1(compPassword);
				System.out.println(compPassword);
			} catch (NoSuchAlgorithmException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			// DAO 생성
			GuestDAO dao = new GuestDAO();
			
			// 게시물 추출
			System.out.println(req.getParameter("id"));
			GuestArticle article = dao.selectOne("selectOneArticle", req.getParameter("id"));
			
			if(article == null)
				System.out.println("DB Err");
			else
				System.out.println("DB Success");
			
			// 비밀번호 해시 비교
			
			if(!compPassword.equals(article.getPassword())){
				PrintWriter out = resp.getWriter();
				
				out.println("<script language = \"javascript\">");
				out.println("alert(\"비밀번호가 틀렸습니다.\");");
				out.println("history.back();");
				out.println("</script>");
				// 비밀번호 에러
				return;
			}
			
			// 수정/삭제 실시
			
			if(req.getParameter("opr").equals("modify")){
				article.setArticle(article.getArticle().replaceAll("<br>", "\n"));
				req.setAttribute("article",article);
				rd = req.getRequestDispatcher("/modify.jsp");
				
			}else{
				req.setAttribute("id", article.getId());
				rd = req.getRequestDispatcher("/Delete");
			}
			
			rd.forward(req, resp);
		}
}
