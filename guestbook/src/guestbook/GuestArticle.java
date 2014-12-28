package guestbook;

public class GuestArticle {
	private String email;
	private String password;
	private String article;
	private String firstDate;
	private String lastModifyDate;
	
	public GuestArticle(){
		
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String _email){
		email = _email;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String _password){
		password = _password;
	}
	
	public String getArticle(){
		return article;
	}
	
	public void setArticle(String _article){
		article = _article;
	}
	
	public String getFirstDate(){
		return firstDate;
	}
	
	public void setFirstDate(String _firstDate){
		firstDate = _firstDate;
	}
	
	public String getLastModifyDate(){
		return lastModifyDate;
	}
	
	public void setLastModifyDate(String _lastModifyDate){
		lastModifyDate = _lastModifyDate;
	}
	
	public String toString()
	{
		StringBuffer str = new StringBuffer();
		str.append(email+"/");
		str.append(article);
		
		return str.toString();
	}
}
