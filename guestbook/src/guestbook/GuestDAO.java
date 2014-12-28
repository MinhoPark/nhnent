package guestbook;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class GuestDAO {
	private static String confXML = "guestbook/guestbook-mybatis-conf.xml";
	private static Reader reader;
	private SqlSessionFactory sessionf;
	private SqlSession sqlsession;
	
	public GuestDAO() throws IOException
	{
		reader = Resources.getResourceAsReader(confXML);
		sessionf = new SqlSessionFactoryBuilder().build(reader);
		sqlsession = sessionf.openSession();
	}
	
	public int insert(String id, Object arg1)
	{
		int ret = sqlsession.insert(id, arg1);
		sqlsession.commit();
		return ret;
	}
	
	public int update(String id, Object arg1)
	{
		int ret = sqlsession.update(id, arg1);
		sqlsession.commit();
		return ret;
	}
	
	public int delete(String id, Object arg1)
	{
		int ret = sqlsession.delete(id, arg1);
		sqlsession.commit();
		return ret;
	}
	
	public List<GuestArticle> select(String id)
	{
		List<GuestArticle> selectResult = new ArrayList<GuestArticle>();
		selectResult = sqlsession.selectList(id);
		return selectResult;
	}
}
