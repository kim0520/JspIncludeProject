package com.sist.member.dao;
import java.util.*;  //ArrayList
import java.sql.*;  // Connection 
import javax.naming.*;  //Context
import javax.sql.*; // DataSource ==> Database의 정보

import com.sun.corba.se.impl.ior.GenericTaggedComponent;
//DBCP : connection을 미리 생성후에 오라클 접속  => 웹에서만 사용  tomcat
/*
 *  1)생성된 Connection 가지고 오기 : getConnection
 *  2)사용
 *  3)반환
 *  ===============> Connection 갯수를 제한하면서 재사용이가능하게 만들어 준다.
 */
public class MemberDAO {
   private Connection  conn;
   private PreparedStatement ps;
   // 주소 얻는다(pool(connection을 관리하는 영역)에서 가져온다)
   /*
    * POLL
    *  ================
    *   java://comp/env
    *  ================
    *         이름                            주소             사용여부
    *   
    *   	 jdbc/oracle   100      false
    *   	 jdbc/oracle   200      false   
    *    	 jdbc/oracle   300      false  
    *     	 jdbc/oracle   400      false 
    *      	 jdbc/oracle   500      false 
    *  ================
    *   사용중  : true  , 반환 : false
    *  ================
    *  //lookup : 주소를 자져온다.
    */
   // 주소 얻는다
   public void getConnection()
   {
	   try
	   {
		   Context init=new InitialContext();
		   //탐색기 열기
		   //c:\\드라이브에 연결
		   Context c= (Context)init.lookup("java://comp/env");
		   //데이터 베이스에 저장된 정보 얻기
		   DataSource ds = (DataSource)c.lookup("jdbc/oracle");
		   conn=ds.getConnection();
		   
		   
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
   }
   //반환 
   public void disConnection()
   {
	   try
	   {
		   if(ps!=null) ps.close(); // 사용중이라면 반환 하라.
		   if(conn!=null)conn.close();
	   }catch(Exception ex)
	   {
		   
	   }
   }
   //기능
   public int idCheck(String id)
   {
	   int count=0;
	   try
	   {
		   //주소 값 얻기
		   getConnection();
		   String sql= "SELECT COUNT(*) FROM food_member "
		   		+ "WHERE id=?";
		   ps=conn.prepareStatement(sql);
		   ps.setString(1, id);
		   ResultSet rs =ps.executeQuery();
		   rs.next();
		   count=rs.getInt(1);
		   rs.close();
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
	   finally
	   {
		   disConnection();
	   }
	   return count;
   }
   public ArrayList<ZipcodeVO> postfind(String dong)
   {
	   ArrayList<ZipcodeVO> list = new ArrayList<ZipcodeVO>();
	   try
	   {
		   getConnection();
		   String sql="SELECT zipcode,sido,gugun,dong,"
		   		+ "NVL(bunji,' ') "
		   		+ "FROM zipcode "
		   		+ "WHERE dong LIKE '%'||?||'%'";
		   ps= conn.prepareStatement(sql);
		   ps.setString(1, dong);
		   ResultSet rs =ps.executeQuery();
		   while(rs.next())
		   {
			   ZipcodeVO vo = new ZipcodeVO();
			   vo.setZipcode(rs.getString(1));
			   vo.setSido(rs.getString(2));
			   vo.setGugun(rs.getString(3));
			   vo.setDong(rs.getString(4));
			   vo.setBunji(rs.getString(5));
			   list.add(vo);
		   }
		   rs.close();
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
	   finally
	   {
		   disConnection();
	   }
	   
	   return list;
   }
   public int postfindCount(String dong)
   {
	   int count=0;
	   try
	   {
		   getConnection();
		   String sql="SELECT COUNT(*) FROM zipcode "
		   		+ "WHERE dong LIKE '%'||?||'%'";
		   ps= conn.prepareStatement(sql);
		   ps.setString(1, dong);
		   ResultSet rs =ps.executeQuery();
		   rs.next();
		   count=rs.getInt(1);
		   rs.close();
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
	   finally
	   {
		   disConnection();
	   }
	   
	   return count;
   }
   public void memberJoin(MemberVO vo)
   {
	   
   }
   
}
