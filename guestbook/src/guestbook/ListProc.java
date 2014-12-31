package guestbook;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListProc extends HttpServlet {
	private final int ARTICLES_PER_PAGE = 10;
	private int m_TotalPageCount;
	private int m_ReqPage;
	
	private boolean isValidPage(String strReqPage)
	{
		if(strReqPage != null && (m_ReqPage <= m_TotalPageCount && m_ReqPage > 0))
			return true;
		else
			return false;
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		GuestDAO dao = new GuestDAO();
		resp.setContentType("text/html; charset=UTF-8");
		
		// 전체 게시글 카운트
		double totalArticles = Double.parseDouble(dao.getArticleCount());
		int totalArticlesInt = (int)totalArticles;
		totalArticles = totalArticles / ARTICLES_PER_PAGE;	// 페이지 개수
		m_TotalPageCount = (int)Math.ceil(totalArticles);
		
		// 페이징 처리
		
		String strReqPage = req.getParameter("page");
		
		if(isValidPage(strReqPage)){	// page 파라미터가 없거나 없는 페이지라면 그냥 1페이지 출력. 그 외에는 지정 페이지 출력.
			m_ReqPage = Integer.parseInt(strReqPage);
		}else{
			m_ReqPage = 1;
		}
		
		int offset = (m_ReqPage-1) * ARTICLES_PER_PAGE;	// limit offset 계산.
		
		System.out.println(offset);
		
		// dao 호출

		List<GuestArticle> articleList = dao.select("printlist", offset);
		
		req.setAttribute("lists", articleList);
		req.setAttribute("reqPage", Integer.toString(m_ReqPage));
		req.setAttribute("articlesPerPage", Integer.toString(ARTICLES_PER_PAGE));
		req.setAttribute("totalPageCount", Integer.toString(m_TotalPageCount));
		req.setAttribute("totalArticles", Integer.toString(totalArticlesInt));
		
		RequestDispatcher rd = req.getRequestDispatcher("/list.jsp");
		
		try {
			rd.include(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
