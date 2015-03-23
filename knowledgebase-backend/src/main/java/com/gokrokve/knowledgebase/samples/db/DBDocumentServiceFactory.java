package com.gokrokve.knowledgebase.samples.db;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gokrokve.knowledgebase.samples.backend.DocumentService;

public class DBDocumentServiceFactory {
	
	public static DocumentService getService(){
		
		String connect_string = System.getenv("DATABASE_URL");
		Pattern pattern =  Pattern.compile("^(\\w+)\\:\\/\\/(\\w+)\\:(\\w+)\\@(\\d+\\.\\d+\\.\\d+\\.\\d+)\\:(\\d+)\\/(.+)$");
		Matcher matcher = pattern.matcher(connect_string);
		matcher.find();
		
		String db_type = matcher.group(1);
		String user = matcher.group(2);
		String pass = matcher.group(3);
		String host = matcher.group(4);
		String port = matcher.group(5);
		String db = matcher.group(6);
		String conn_url = "jdbc:"+db_type+"://"+host+":"+port+"/" + db;		
		return new DBDocumentService(getSessionFactory(user, pass, conn_url));
	
	}

	private static SessionFactory getSessionFactory(String user, String pass,
			String conn_url) {
		Configuration conf = new Configuration().configure();
		conf.setProperty("hibernate.connection.url",conn_url);
		conf.setProperty("hibernate.connection.username",user);
		conf.setProperty("hibernate.connection.password",pass);
        return conf.buildSessionFactory();
	}

}
