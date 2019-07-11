package solr;

import java.io.Serializable;

import org.apache.solr.client.solrj.beans.Field;

public class User implements Serializable{
	@Field
	private String id;
	@Field
	private String title;
	@Field
	private String content;
	@Field
	public String getId() {
		return id;
	}
	@Field
	public void setId(String id) {
		this.id = id;
	}
	@Field
	public String getTitle() {
		return title;
	}
	@Field
	public void setTitle(String title) {
		this.title = title;
	}
	@Field
	public String getContent() {
		return content;
	}@Field
	public void setContent(String content) {
		this.content = content;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public String toString() {
		return "User [id=" + id + ", title=" + title + ", content=" + content
				+ "]";
	}
	
}
