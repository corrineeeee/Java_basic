package lucene;

import java.awt.TextField;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.FuzzyQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.WildcardQuery;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.sun.org.apache.xpath.internal.operations.String;

public class lucene_learning {

	/**
	 * 创建索引
	 * 
	 * @throws Exception
	 */
	@Test
	public void createIndex() throws Exception {
		// 创建文档对象
		Document document = new Document();
		// 添加字段，参数Field是一个接口，要new实现类的对象(StringField, TextField)
		// StringField的实例化需要3个参数：1-字段名，2-字段值，3-是否保存到文档，Store.YES存储，NO不存储
		document.add(new StringField("id", "1", Store.YES));
		// TextField：创建索引并提供分词，StringField创建索引但不分词
		document.add(new org.apache.lucene.document.TextField("title",
				"谷歌地图之父跳槽FaceBook", Store.YES));
		// 创建目录对象，指定索引库的存放位置；FSDirectory文件系统；RAMDirectory内存
		Directory directory = FSDirectory.open(new File(
				"C:\\Users\\Corrine\\Desktop\\JAVA就业班资料\\lucene\\index"));
		// 创建分词器对象
		Analyzer analyzer = new IKAnalyzer();
		// 创建索引写入器配置对象，第一个参数版本VerSion.LATEST,第一个参数分词器
		IndexWriterConfig config = new IndexWriterConfig(Version.LATEST,
				analyzer);
		// 创建索引写入器
		IndexWriter writer = new IndexWriter(directory, config);
		// 向索引库写入文档对象
		writer.addDocument(document);
		// 提交
		writer.commit();
		// 关闭
		writer.close();
	}

	/**
	 * 批量创建索引
	 * 
	 * @throws Exception
	 * 
	 */
	@Test
	public void createMoreIndex() throws Exception {
		// 创建文档对象集合
		List<Document> documents = new ArrayList<>();
		// 创建文档对象
		Document doc1 = new Document();
		doc1.add(new StringField("id", "1", Store.YES));
		doc1.add(new org.apache.lucene.document.TextField("title",
				"为什么现在要做不切实际的梦", Store.YES));
		documents.add(doc1);
		// 创建文档对象
		Document doc2 = new Document();
		doc2.add(new StringField("id", "2", Store.YES));
		doc2.add(new org.apache.lucene.document.TextField("title",
				"为什么现在要承受这巨大的痛", Store.YES));
		documents.add(doc2);
		// 创建文档对象
		Document doc3 = new Document();
		doc3.add(new StringField("id", "3", Store.YES));
		doc3.add(new org.apache.lucene.document.TextField("title",
				"乘着温暖的风随纸飞机不停的冲", Store.YES));
		documents.add(doc3);
		// 索引库对象
		Directory directory = FSDirectory.open(new File(
				"C:\\Users\\Corrine\\Desktop\\JAVA就业班资料\\lucene\\index"));
		Analyzer analyzer = new IKAnalyzer();
		// 创建索引写入器配置对象，1-版本，2-分词器：标准分词器
		IndexWriterConfig indexWriterConfig = new IndexWriterConfig(
				Version.LATEST, analyzer);
		// OpenMode打开模式，枚举类，CREATE：覆盖，APPEND：追加，
		indexWriterConfig.setOpenMode(OpenMode.CREATE);
		// 创建索引写入器对象
		IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
		// 执行写入操作
		indexWriter.addDocuments(documents);
		// 提交
		indexWriter.commit();
		// 关闭
		indexWriter.close();
	}

	/**
	 * 查询索引
	 * @throws ParseException 
	 * @throws Exception 
	 * 
	 */
	@Test
	public void indexSearch() throws  Exception {
		// 查询解析器对象 构造参数：1.搜索的目标字段名称 2.使用何种分词器对搜索的参数进行分析
		QueryParser queryParser = new QueryParser("title", new IKAnalyzer());
		// 同时查询多字段的查询解析器
		//new MultiFieldQueryParser(new String[]{"id","content"},  new IKAnalyzer());
		// 对搜索的参数进行解析 解析后得到Query对象
		Query query = queryParser.parse("为什么");
		DirectoryReader reader = DirectoryReader.open(FSDirectory.open(new File("C:\\Users\\Corrine\\Desktop\\JAVA就业班资料\\lucene\\index")));
		// 创建索引查询对象
		IndexSearcher searcher = new IndexSearcher(reader);
		// topDocs：排名前 n 的结果集
		TopDocs topDocs = searcher.search(query, Integer.MAX_VALUE);
		// 得分文档集合
		ScoreDoc[] scoreDocs = topDocs.scoreDocs;
		
		for (ScoreDoc scoreDoc : scoreDocs) {
			Integer docId = scoreDoc.doc;
			Document doc = searcher.doc(docId);
			//Document document = reader.document(docId);
			System.out.println(scoreDoc.score);
			System.out.println("id="+doc.get("id"));
			System.out.println("title"+doc.get("title"));
		}
		searcher.getIndexReader().close();
	}
	
	/**
	 * 特殊查询
	 * 共用方法
	 * @throws Exception 
	 * 
	 */
	
	public void search(Query query) throws Exception{
		// 创建目录对象
		Directory directory = FSDirectory.open(new File("C:\\Users\\Corrine\\Desktop\\JAVA就业班资料\\lucene\\index"));
		// 索引的读取对象
		IndexReader reader = DirectoryReader.open(directory);
		// 索引的搜索工具
		IndexSearcher searcher = new IndexSearcher(reader);
		// 尝试查询，1-查询对象，2-查询的条数
		// 返回的是前n条文档的对象，topDocs：包含文档的总条数，文档的得分数组
		TopDocs docs = searcher.search(query, 1);
		// 获取得分文档的数组，得分文档包含文档编号以及得分
		ScoreDoc[] scoreDocs = docs.scoreDocs;
		// 根据编号查询文档1
		for (ScoreDoc scoreDoc : scoreDocs) {
			Integer id = scoreDoc.doc;
			Document doc = searcher.doc(id);
			System.out.println("id="+doc.get("id"));
			System.out.println("title="+doc.get("title"));
		}
		searcher.getIndexReader().close();
	}
	
	
	/**
	 * TermQuery : 词条搜索 单个词条的搜索，输入的内容会被当做一个完整的词条，不会再对搜索参数进行分词
	 * @throws Exception
	 */
	@Test
	public void termQuery() throws Exception{
		// Term term = new Term("查询的目标字段", "查询的参数");
		Term term = new Term("title", "为什么");
		Query query = new TermQuery(term);
		search(query);
	}
	
	
	/**
	 * WildcardQuery : 通配符搜索 ?号代表单个字符，*号代表N个字符
	 * @throws Exception 
	 */
	@Test
	public void wildcardQueryTest() throws Exception{
		Term term = new Term("title", "纸飞机");
		Query query = new WildcardQuery(term);
		search(query);
	}
	
	/**
	 * FuzzyQuery : 模糊查询
	 * 自动补齐或切换位置，至多两次机会
	 * 若大于2？
	 * @throws Exception 
	 */
	@Test
	public void fuzzyQueryTest() throws Exception{
		// 查询条件对象（模糊查询
		// 参数：1-词条，查询字段及关键词，关键词允许写错；2-允许写错的最大编辑距离，并且不能大于2（0~2）
		// 最大编辑距离：facebool-->facebook需要编辑的次数，包括大小写
		Term term = new Term("title", "为不么");
		Query query = new FuzzyQuery(term);
		search(query);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
