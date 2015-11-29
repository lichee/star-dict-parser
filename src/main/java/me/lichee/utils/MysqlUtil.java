package me.lichee.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import me.lichee.bean.JpMean;
import me.lichee.bean.JpWord;

public class MysqlUtil {
	
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL="jdbc:mysql://localhost:3306/openjpdic?characterEncoding=utf8&zeroDateTimeBehavior=convertToNull";//数据库端口号，demo为数据库名称  
    public static final String DBUSER="root";//mysql数据库用户名，默认为root  
    public static final String DBPASS="";//进入Mysql数据库的密码，跟自己设置的密码保持一致噢 
	
    private static final String INSERT_WORD = "insert into words set hanzi=?,luoma=?,jiaming=?,yinbiao=?,yindiao=?,audio=?,inserter=?";
    private static final String INSERT_MEAN = "insert into means set wordId=?,sort=?,mean=?";
    
    private static Connection cn = null;
    
	public static Connection  getConnection() throws Exception{
		if(cn!=null) return cn;
		Class.forName(DBDRIVER);
		Connection c = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		cn = c;
		return c;
	}
	
	public static void main(String[] args) throws Exception{
	}
	
	public static void saveWords(JpWord word) throws Exception{
		Connection c = getConnection();
		
		PreparedStatement psWord = c.prepareStatement(INSERT_WORD,Statement.RETURN_GENERATED_KEYS);
		psWord.setString(1, word.getHanzi());
		psWord.setString(2, word.getLuoma());
		psWord.setString(3, word.getJiaming());
		psWord.setString(4, word.getYinbiao());
		psWord.setString(5, word.getYindiao());
		psWord.setString(6, word.getAudio());
		psWord.setString(7, "admin");
		psWord.execute();
		ResultSet rs = psWord.getGeneratedKeys();
		int id = 0;
		if (rs.next()) {
			id = rs.getInt(1);
		}
		psWord.close();
		
		for(JpMean m : word.getMeans()){
			PreparedStatement psMean = c.prepareStatement(INSERT_MEAN);
			psMean.setInt(1, id);
			psMean.setInt(2, m.getSort());
			psMean.setString(3, m.getMean());
			psMean.execute();
			psMean.close();
		}
	}
}
