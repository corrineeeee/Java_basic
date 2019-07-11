package solr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class solr_learning {
	
	/**
	 * 需求： 添加数据到solr core 当前处于java程序，solr core交由tomcat启动的solr服务器管理
	 * solr对外提供接口，用户通过http请求调用接口，进行数据的CRUD
	 * @throws IOException 
	 * @throws SolrServerException 
	 */
	@Test
	public void addData() throws SolrServerException, IOException{
		//连接
		String url = "http://localhost:8080/solr/collection1";
		SolrServer solrServer = new HttpSolrServer(url);
		//添加单条数据
		SolrInputDocument document = new SolrInputDocument();
		document.addField("id", 3L);
		document.addField("title", "name");
		document.addField("content", "翁楚龄");
		solrServer.add(document);
		//添加多条数据
		SolrInputDocument document2 = new SolrInputDocument();
		SolrInputDocument document3 = new SolrInputDocument();
		ArrayList<SolrInputDocument> list = new ArrayList<SolrInputDocument>();
		document2.addField("id", 4L);
		document2.addField("title", "name");
		document2.addField("content", "ccc");
		document3.addField("id",6L);
		document3.addField("title", "name");
		document3.addField("content", "CCC");
		list.add(document2);
		list.add(document3);
		solrServer.add(list);
		solrServer.commit();
	}
	
	/**
	 * 直接使用javaBean向solr core中添加数据
	 * @throws SolrServerException 
	 * @throws IOException 
	 */
	@Test
	public void addJaveBeanData() throws IOException, SolrServerException{
		String url = "http://localhost:8080/solr/collection1";
		HttpSolrServer solrServer = new HttpSolrServer(url);
		User user = new User();
		user.setId("7L");
		user.setTitle("birthday");
		user.setContent("19970616");
		solrServer.addBean(user);
		solrServer.commit();
		
	}
	
	/**
	 * 删除索引库数据
	 * @throws IOException 
	 * @throws SolrServerException 
	 */
	@Test
	public void deleteData() throws SolrServerException, IOException{
		String url = "http://localhost:8080/solr/collection1";
		HttpSolrServer solrServer = new HttpSolrServer(url);
		solrServer.deleteById("4");
		solrServer.commit();
	}
	
	/**
	 * 查询索引库数据
	 *以Document形式返回查询结果
	 * @throws IOException 
	 * @throws SolrServerException 
	 */
	@Test
	public void searchData() throws SolrServerException, IOException{
		String url = "http://localhost:8080/solr/collection1";
		HttpSolrServer solrServer = new HttpSolrServer(url);
		SolrQuery params = new SolrQuery("*:*");
		QueryResponse response = solrServer.query(params);
		SolrDocumentList list = response.getResults();
		for (SolrDocument solrDocument : list) {
			System.out.println("id = "+ solrDocument.getFieldValue("id"));
			System.out.println("title = " + solrDocument.getFieldValue("title"));
			System.out.println("content = "+solrDocument.getFieldValue("content"));
		}
		solrServer.commit();
	}
	
	/**
	 * 以JavaBean形式返回查询结果
	 * @throws IOException 
	 * @throws SolrServerException 
	 */
	@Test
	public void searchBeanData() throws SolrServerException, IOException{
		String url = "http://localhost:8080/solr/collection1";
		HttpSolrServer solrServer = new HttpSolrServer(url);
		SolrQuery params = new SolrQuery("*:*");
		QueryResponse response = solrServer.query(params);
		List<User> list = response.getBeans(User.class);
		for (User user : list) {
//			System.out.println("id = "+user.getId());
//			System.out.println("title = "+user.getTitle());
//			System.out.println("content = "+user.getContent());
			System.out.println(user);
		}
		solrServer.commit();
	}
	
	
	
	
	
	
	
	
	
	
	

}
