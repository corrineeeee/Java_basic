package service;

import java.sql.SQLException;
import java.util.List;

import dao.check;
import dao.pagebean;
import domain.china;

public class service {
	public static pagebean<china> getdata(int pageno,int pagesize) throws SQLException{
		check check = new check();
		List<china> list= check.findall(pageno, pagesize);
		
		pagebean<china> pb = new pagebean<china>();
		pb.setPageno(pageno);
		pb.setPagesize(pagesize);
		pb.setContent(list);
		int totalline =check.findallline();
		int totalpage = (int) Math.ceil((totalline*1.0)/pagesize);
		pb.setTotalline(totalline);
		pb.setTotalpage(totalpage);
		return pb;
	}
}
