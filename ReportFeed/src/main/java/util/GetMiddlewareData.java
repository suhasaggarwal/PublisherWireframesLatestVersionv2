package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.publisherdata.model.Article;
import com.publisherdata.model.Section;
import com.publisherdata.model.Site;

public class GetMiddlewareData {

	/*
	 public static Map<String,String> sectionMap;
	  public static Map<String,String> articleMap;
	  public static Map<String,String> siteMap;
	  
	  
	  static {
	      Map<String, String> siteMap1 = new HashMap<String,String>();
	      List<Site> sitedata = GetMiddlewareData.getSiteData("1");
	     
	      try {

	         
	         
	        for(Site site: sitedata){

	             try{
	          	 siteMap.put(site.getSiteId(),site.getSiteName());
	             }
	             catch(Exception e)
	             {
	          	     
	            	 e.printStackTrace(); 
	                 continue;
	             }

	          }


	        
	      
	      }

	      
	      
	      
	catch(Exception e){
		
		e.printStackTrace();
	} 

	      
	      siteMap = Collections.unmodifiableMap(siteMap);  
	  
	      //    System.out.println(citycodeMap);
	  }
	
	  

	  static {
	      Map<String, String> sectionMap1 = new HashMap<String,String>();
	      for (Map.Entry<String, String> entry : siteMap.entrySet())
	      {
	       
	      List<Site> sitedata = GetMiddlewareData.getSiteData(entry.getKey());
	     
	      try {

	         
	         
	        for(Site site: sitedata){
	             
	        	try{
	          	 sectionMap1.put(site.getSiteId(),site.getSiteName());
	        	}
	             catch(Exception e)
	             {
	          	     
	            	 e.printStackTrace(); 
	                 continue;
	             }

	          }


	        
	      
	      }

	      
	      
	      
	catch(Exception e){
		
		e.printStackTrace();
	} 
	      
	      }
	      
	      sectionMap = Collections.unmodifiableMap(sectionMap1);  
	  
	      //    System.out.println(citycodeMap);
	  }
	  
	  
	  
	 
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	
	  static {
	      Map<String, String> articleMap1 = new HashMap<String,String>();
	      for (Map.Entry<String, String> entry : siteMap.entrySet())
	      {
	       
	      List<Article> articledata = GetMiddlewareData.getArticleData(entry.getKey());
	     
	      try {

	         
	         
	        for(Article article: articledata){

	             try{
	          	 articleMap1.put(article.getId(), article.getArticleName());
	             }
	             catch(Exception e)
	             {
	          	     
	            	 e.printStackTrace(); 
	                 continue;
	             }

	          }


	        
	      
	      }

	      
	      
	      
	catch(Exception e){
		
		e.printStackTrace();
	} 
	      
	      }
	      
	      articleMap = Collections.unmodifiableMap(articleMap1);  
	  
	      //    System.out.println(citycodeMap);
	  }
	 
	  
	  */
	  
	  
	  
	  
	  
	  
	  
	  
	  
	public static void main(String[] args) throws IOException {
		
	//	String mobilesId = "Sony E5653 Xperia M5 2015_september";
		
	//	GetMiddlewareData.get91mobilesData(mobilesId); 
		GetMiddlewareData.getSiteData("1");
	}
	
	
	
  

   public static List<Section> getSectionData( String siteid) {
	   
	    String ServerConnectionURL = "jdbc:mysql://205.147.102.47:3306/middleware";
		String DBUser = "root";
	    String DBPass = "Qwerty12@";
	    String DBName = "";
		String TABLENAME = "";
		Connection con = null;
		DBConnector connector1 = new DBConnector();
		con = connector1.getPooledConnection(ServerConnectionURL);
	    String status1 = "false";
	    Statement stmt = null;
	    String query0 = null;
	    String query1 = null;
	//    dateadded = new Timestamp(System.currentTimeMillis()).toString();
	    System.out.println("Getting Section Data");
	    List<Section> section = new ArrayList<Section>();
	    String sectionid = null;
	    String sectionurl = null;
	   
	    query0 = "Select * from Section where siteid="+siteid;
	    
	    Statement st = null;
		try {
			st = con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      
	      // execute the query, and get a java resultset
	     ResultSet rs = null;
		try {
			rs = st.executeQuery(query0);
		    
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		 try {
			while(rs.next()){
	    	
				sectionid = rs.getString("Id");
			    sectionurl = rs.getString("SectionUrl");
			     System.out.println(sectionurl);
	             Section obj = new Section();
	             obj.setSiteId(siteid);
	             obj.setSectionUrl(sectionurl);
	    		 obj.setId(sectionid);
	    	     section.add(obj);
	    	
	    	
			}    
		 }  
	      catch(Exception e){
	      
	    	  
	      }
		 finally {
				
			    DBUtil.close(rs);
				DBUtil.close(st);
				DBUtil.close(con);
			
			}  
	    
		
	        
	    return section;
		 
  }
   
     



   public static List<Article> getArticleData( String siteid ) {
	   String ServerConnectionURL = "jdbc:mysql://205.147.102.47:3306/middleware";
	 		String DBUser = "root";
	 	    String DBPass = "Qwerty12@";
	 	    String DBName = "";
	 		String TABLENAME = "";
	 		Connection con = null;
	 		DBConnector connector1 = new DBConnector();
	 		con = connector1.getPooledConnection(ServerConnectionURL);
	 	    String status1 = "false";
	 	    Statement stmt = null;
	 	    String query0 = null;
	 	    String query1 = null;
	 	//    dateadded = new Timestamp(System.currentTimeMillis()).toString();
	 	    System.out.println("Getting Article Data");
	 	    List<Article> article = new ArrayList<Article>();
	 	    String articleid = null;
	 	    String articleurl = null;
	 	    String articlename = null;
	 	    query0 = "Select * from Article where siteid="+siteid;
	 	    
	 	    Statement st = null;
	 		try {
	 			st = con.createStatement();
	 		} catch (SQLException e1) {
	 			// TODO Auto-generated catch block
	 			e1.printStackTrace();
	 		}
	 	      
	 	      // execute the query, and get a java resultset
	 	     ResultSet rs = null;
	 		try {
	 			rs = st.executeQuery(query0);
	 		    
	 		
	 		} catch (SQLException e1) {
	 			// TODO Auto-generated catch block
	 			e1.printStackTrace();
	 		}
	 		
	 		 try {
	 			while(rs.next()){
	 	    	     
	 				articleid = rs.getString("Id");
		 		    articleurl = rs.getString("ArticleUrl");
	 				articlename = rs.getString("ArticleName");
	 				System.out.println(articleurl);
	 	             Article obj = new Article();
	 	             obj.setId(articleid);
	 	             obj.setArticleUrl(articleurl);
	 	    		 obj.setSiteId(siteid);;
	 	    	     obj.setArticleName(articlename);
	 	    		 article.add(obj);
	 	    	
	 	    	
	 			}    
	 		 }  
	 	      catch(Exception e){
	 	    	  
	 	    	  
	 	      }
	 		 finally {
					
				    DBUtil.close(rs);
					DBUtil.close(st);
					DBUtil.close(con);
				
				}   
	 	         
	 	        
	 	    return article;
		 
 }
  
   public static Article getArticleMetaData( String url ) {
	   String ServerConnectionURL = "jdbc:mysql://205.147.102.47:3306/middleware";
	 		String DBUser = "root";
	 	    String DBPass = "qwerty12@";
	 	    String DBName = "";
	 		String TABLENAME = "";
	 		Connection con = null;
	 		DBConnector connector1 = new DBConnector();
	 		con = connector1.getPooledConnection(ServerConnectionURL);
	 	    String status1 = "false";
	 	    Statement stmt = null;
	 	    String query0 = null;
	 	    String query1 = null;
	 	//    dateadded = new Timestamp(System.currentTimeMillis()).toString();
	 	    System.out.println("Getting Article Data");
	 	    List<Article> article = new ArrayList<Article>();
	 	    String articleid = null;
	 	    String articleurl = null;
	 	    String articlename = null;
	 	    String articletitle = null;
	 	    String siteid = null;
	 	    String author = null;
	 	    String publishdate = null;
	 	    String mainimage = null;
	 	    String tag = null;
	 	    query0 = "Select * from Article where ArticleUrl like '%"+url+"%'";
	 	    Article obj = new Article();
	 	    Statement st = null;
	 		try {
	 			st = con.createStatement();
	 		} catch (SQLException e1) {
	 			// TODO Auto-generated catch block
	 			e1.printStackTrace();
	 		}
	 	      
	 	      // execute the query, and get a java resultset
	 	     ResultSet rs = null;
	 		try {
	 			rs = st.executeQuery(query0);
	 		    
	 		
	 		} catch (SQLException e1) {
	 			// TODO Auto-generated catch block
	 			e1.printStackTrace();
	 		}
	 		
	 		 try {
	 			while(rs.next()){
	 	    	     
	 				articleid = rs.getString("Id");
		 		    articleurl = rs.getString("ArticleUrl");
	 				articlename = rs.getString("ArticleName");
	 				siteid = rs.getString("SiteId");
	 			    publishdate = rs.getString("PublishDate");
	 			    articletitle = rs.getString("ArticleTitle");
	 			    author = rs.getString("Author");
	 			    mainimage = rs.getString("MainImage");
	 			    tag =rs.getString("Tags");
	 				System.out.println(articleurl);
	 	             
	 	             obj.setId(articleid);
	 	             obj.setArticleUrl(articleurl);
	 	    		 obj.setSiteId(siteid);;
	 	    	     obj.setArticleName(articlename);
	 	    		 obj.setAuthor(author);
	 	    		 obj.setPublishdate(publishdate);
	 	    		 obj.setMainimage(mainimage);
	 	    		 obj.setTag(tag);
	 	    	     obj.setArticletitle(articletitle);
	 	    		// article.add(obj);
	 	    	
	 	    	
	 			}    
	 		 }  
	 	      catch(Exception e){
	 	    	  
	 	    	  
	 	      }
	 		 finally {
					
				    DBUtil.close(rs);
					DBUtil.close(st);
					DBUtil.close(con);
				
				}   
	 	         
	 	        
	 	    return obj;
		 
 }
  
	    
   public static Article getArticleName( String articleId ) {
	   String ServerConnectionURL = "jdbc:mysql://205.147.102.47:3306/middleware";
	 		String DBUser = "root";
	 	    String DBPass = "Qwerty12@";
	 	    String DBName = "";
	 		String TABLENAME = "";
	 		Connection con = null;
	 		DBConnector connector1 = new DBConnector();
	 		con = connector1.getPooledConnection(ServerConnectionURL);
	 	    String status1 = "false";
	 	    Statement stmt = null;
	 	    String query0 = null;
	 	    String query1 = null;
	 	//    dateadded = new Timestamp(System.currentTimeMillis()).toString();
	 	    System.out.println("Getting Article Data");
	 	    List<Article> article = new ArrayList<Article>();
	 	    String articleid = null;
	 	    String articleurl = null;
	 	   
	 	    query0 = "Select * from Article where Id="+articleId;
	 	    
	 	    Statement st = null;
	 		try {
	 			st = con.createStatement();
	 		} catch (SQLException e1) {
	 			// TODO Auto-generated catch block
	 			e1.printStackTrace();
	 		}
	 	      
	 	      // execute the query, and get a java resultset
	 	     ResultSet rs = null;
	 	     Article obj = new Article();
	 	     
	 	     try {
	 			rs = st.executeQuery(query0);
	 		    
	 		
	 		} catch (SQLException e1) {
	 			// TODO Auto-generated catch block
	 			e1.printStackTrace();
	 		}
	 		
	 		 try {
	 			while(rs.next()){
	 	    	     
	 				articleid = rs.getString("Id");
		 		    articleurl = rs.getString("ArticleUrl");
	 				
	 				System.out.println(articleurl);
	 	             
	 	             obj.setId(articleid);
	 	             obj.setArticleUrl(articleurl);
	 	    		 obj.setArticleName(rs.getString("ArticleName"));
	 	    	    
	 	    	
	 	    	
	 			}    
	 		 }  
	 	      catch(Exception e){
	 	    	  
	 	    	  
	 	      }
	 		 finally {
					
				    DBUtil.close(rs);
					DBUtil.close(st);
					DBUtil.close(con);
				
				}    
	 	         
	 	        
	 	    return obj;
		 
 }


   public static Section getSectionName( String sectionId ) {
	   String ServerConnectionURL = "jdbc:mysql://205.147.102.47:3306/middleware";
		String DBUser = "root";
	    String DBPass = "Qwerty12@";
	    String DBName = "";
		String TABLENAME = "";
		Connection con = null;
		DBConnector connector1 = new DBConnector();
		con = connector1.getPooledConnection(ServerConnectionURL);
	    String status1 = "false";
	    Statement stmt = null;
	    String query0 = null;
	    String query1 = null;
	//    dateadded = new Timestamp(System.currentTimeMillis()).toString();
	    System.out.println("Getting Section Data");
	    List<Section> section = new ArrayList<Section>();
	    String sectionid = null;
	    String sectionurl = null;
	    String sectionname = null;
	    query0 = "Select * from Section where Id="+sectionId;
	    
	    Statement st = null;
		try {
			st = con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      
	      // execute the query, and get a java resultset
	     ResultSet rs = null;
	     Section obj = new Section();
	     
	     try {
			rs = st.executeQuery(query0);
		    
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		 try {
			while(rs.next()){
	    	
				sectionid = rs.getString("Id");
			    sectionurl = rs.getString("SectionUrl");
			    sectionname = rs.getString("SectionName");
			    System.out.println(sectionurl);
	            
	 
	             obj.setSectionUrl(sectionurl);
	    		 obj.setId(sectionid);
	    	     obj.setSectionName(sectionname);
	    		 section.add(obj);
	    	
	    	
			}    
		 }  
	      catch(Exception e){
	    	  
	    	  
	      }
		 finally {
				
			    DBUtil.close(rs);
				DBUtil.close(st);
				DBUtil.close(con);
			
			}   
	         
	        
	    return obj;
 }

   public static Site getSiteName( String siteId ) {
	   String ServerConnectionURL = "jdbc:mysql://205.147.102.47:3306/middleware";
		String DBUser = "root";
	    String DBPass = "Qwerty12@";
	    String DBName = "";
		String TABLENAME = "";
		Connection con = null;
		DBConnector connector1 = new DBConnector();
		con = connector1.getPooledConnection(ServerConnectionURL);
	    String status1 = "false";
	    Statement stmt = null;
	    String query0 = null;
	    String query1 = null;
	//    dateadded = new Timestamp(System.currentTimeMillis()).toString();
	    System.out.println("Getting Section Data");
	    List<Section> section = new ArrayList<Section>();
	    String siteid = null;
	    String siteurl = null;
	    String sitename = null;
	    query0 = "Select * from Site where Id="+siteId;
	    
	    Statement st = null;
		try {
			st = con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      
	      // execute the query, and get a java resultset
	     ResultSet rs = null;
	     Site obj = new Site();
	     
	     try {
			rs = st.executeQuery(query0);
		    
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		 try {
			while(rs.next()){
	    	
				siteid = rs.getString("Id");
			    siteurl = rs.getString("SiteUrl");
			    sitename = rs.getString("SiteName");
			    
	            
	 
	             obj.setSiteId(siteid);
	    		 obj.setSiteName(sitename);
	    	     obj.setSiteurl(siteurl);
	    		
	    	
	    	
			}    
		 }  
	      catch(Exception e){
	    	  
	    	  
	      }
		 finally {
				
			    DBUtil.close(rs);
				DBUtil.close(st);
				DBUtil.close(con);
			
			}  
	         
	        
	    return obj;
 }

   
   public static Site getSiteDetails( String sitename ) {
	   String ServerConnectionURL = "jdbc:mysql://205.147.102.47:3306/middleware";
		String DBUser = "root";
	    String DBPass = "Qwerty12@";
	    String DBName = "";
		String TABLENAME = "";
		Connection con = null;
		DBConnector connector1 = new DBConnector();
		con = connector1.getPooledConnection(ServerConnectionURL);
	    String status1 = "false";
	    Statement stmt = null;
	    String query0 = null;
	    String query1 = null;
	//    dateadded = new Timestamp(System.currentTimeMillis()).toString();
	    System.out.println("Getting Section Data");
	    List<Section> section = new ArrayList<Section>();
	    String siteid = null;
	    String siteurl = null;
//	    String sitename = null;
	    query0 = "Select * from Site where SiteName='"+sitename+"'";
	    
	    Statement st = null;
		try {
			st = con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      
	      // execute the query, and get a java resultset
	     ResultSet rs = null;
	     Site obj = new Site();
	     
	     try {
			rs = st.executeQuery(query0);
		    
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		 try {
			while(rs.next()){
	    	
				siteid = rs.getString("Id");
			    siteurl = rs.getString("SiteUrl");
			    sitename = rs.getString("SiteName");
			    
	            
	 
	             obj.setSiteId(siteid);
	    		 obj.setSiteName(sitename);
	    	     obj.setSiteurl(siteurl);
	    		
	    	
	    	
			}    
		 }  
	      catch(Exception e){
	    	  
	    	  
	      }
		 finally {
				
			    DBUtil.close(rs);
				DBUtil.close(st);
				DBUtil.close(con);
			
			}  
	         
	        
	    return obj;
 }

   
   
   
   
   
   
   
   
   
   
   public static List<Site> getSiteData( String userId ) {
	   String ServerConnectionURL = "jdbc:mysql://205.147.102.47:3306/middleware";
		String DBUser = "root";
	    String DBPass = "Qwerty12@";
	    String DBName = "";
		String TABLENAME = "";
		Connection con = null;
		DBConnector connector1 = new DBConnector();
		con = connector1.getPooledConnection(ServerConnectionURL);
	    String status1 = "false";
	    Statement stmt = null;
	    String query0 = null;
	    String query1 = null;
	//    dateadded = new Timestamp(System.currentTimeMillis()).toString();
	    System.out.println("Getting Section Data");
	    List<Site> site = new ArrayList<Site>();
	    String siteid = null;
	    String siteurl = null;
	    String sitename = null;
	    query0 = "Select * from Site where UserId="+userId;
	    
	    Statement st = null;
		try {
			st = con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      
	      // execute the query, and get a java resultset
	     ResultSet rs = null;
	     Site obj = new Site();
	     
	     try {
			rs = st.executeQuery(query0);
		    
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		 try {
			while(rs.next()){
	    	
				siteid = rs.getString("Id");
			    siteurl = rs.getString("SiteUrl");
			    sitename = rs.getString("SiteName");
			    
	            
	 
	             obj.setSiteId(siteid);
	    		 obj.setSiteName(sitename);
	    	     obj.setSiteurl(siteurl);
	    		 site.add(obj);
	    	
	    	
			}    
		 }  
	      catch(Exception e){
	    	  
	    	  
	      }
		 
		 finally {
				
			    DBUtil.close(rs);
				DBUtil.close(st);
				DBUtil.close(con);
			
			}   
	         
	        
	    return site;
 }




}