package dao;

import java.util.List;

public class pagebean<T> {
	private int pageno;
	private int pagesize;
	private int totalpage;
	private int totalline;
	private List<T> content;
	public List<T> getContent() {
		return content;
	}
	public void setContent(List<T> content) {
		this.content = content;
	}
	public int getPageno() {
		return pageno;
	}
	public void setPageno(int pageno) {
		this.pageno = pageno;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public int getTotalline() {
		return totalline;
	}
	public void setTotalline(int totalline) {
		this.totalline = totalline;
	}
	
}
