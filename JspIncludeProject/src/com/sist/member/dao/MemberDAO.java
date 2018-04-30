package com.sist.member.dao;
import java.util.*;  //ArrayList
import java.sql.*;  // Connection 
import javax.naming.*;  //Context
import javax.sql.*; // DataSource ==> Database�� ����

import com.sun.corba.se.impl.ior.GenericTaggedComponent;
//DBCP : connection�� �̸� �����Ŀ� ����Ŭ ����  => �������� ���  tomcat
/*
 *  1)������ Connection ������ ���� : getConnection
 *  2)���
 *  3)��ȯ
 *  ===============> Connection ������ �����ϸ鼭 �����̰����ϰ� ����� �ش�.
 */
public class MemberDAO {
   private Connection  conn;
   private PreparedStatement ps;
   // �ּ� ��´�(pool(connection�� �����ϴ� ����)���� �����´�)
   /*
    * POLL
    *  ================
    *   java://comp/env
    *  ================
    *         �̸�                            �ּ�             ��뿩��
    *   
    *   	 jdbc/oracle   100      false
    *   	 jdbc/oracle   200      false   
    *    	 jdbc/oracle   300      false  
    *     	 jdbc/oracle   400      false 
    *      	 jdbc/oracle   500      false 
    *  ================
    *   �����  : true  , ��ȯ : false
    *  ================
    *  //lookup : �ּҸ� �����´�.
    */
   // �ּ� ��´�
   public void getConnection()
   {
	   try
	   {
		   Context init=new InitialContext();
		   //Ž���� ����
		   //c:\\����̺꿡 ����
		   Context c= (Context)init.lookup("java://comp/env");
		   //������ ���̽��� ����� ���� ���
		   DataSource ds = (DataSource)c.lookup("jdbc/oracle");
		   conn=ds.getConnection();
		   
		   
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
   }
   //��ȯ 
   public void disConnection()
   {
	   try
	   {
		   if(ps!=null) ps.close(); // ������̶�� ��ȯ �϶�.
		   if(conn!=null)conn.close();
	   }catch(Exception ex)
	   {
		   
	   }
   }
   //���
   public int idCheck(String id)
   {
	   int count=0;
	   try
	   {
		   //�ּ� �� ���
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
