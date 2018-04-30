package com.sist.databoard.dao;
import java.util.*;
import java.sql.*;
import javax.sql.*;

import com.sun.corba.se.impl.ior.GenericTaggedComponent;

import javax.naming.*;

public class DataBoardDAO {
 private Connection conn;
 private PreparedStatement ps;
 public void getConnection()
 {
	 try
	 {
		 //저장된 위치 => 주소값 읽기   ===> JNDY(이름으로 디렉토리)
		 Context init =new InitialContext(); //탐색기를 열었다.
		 Context c= (Context)init.lookup("java://comp/env"); // c driver 위치
		 DataSource ds =(DataSource)c.lookup("jdbc/oracle"); // type: dataSource ,  이름은 jdbc/oracle
		 
		 conn= ds.getConnection();
		 
		 
		 
		 
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
		 if(ps!=null)ps.close();
		 if(conn!=null)conn.close();
	 }
	 catch(Exception ex) {}
 }
 
 //기능
 /*   	  주소                                    상태
  *    ============    ==========
  *    connection(주소)    X   ===>  O
  *    connection(주소)	  X  
  *    connection(주소)	  X
  *    connection(주소)    X
  *    connection(주소)    X
  *    
  *    conn.close()  ===>(o==>X)  // 반환 된다.(disconnection())
  *    maxwait () : 반환 될 때까지 기다린다.
  *    
  * 
  */
 public ArrayList<DataBoardVO> boardTopData()
 {
	 ArrayList<DataBoardVO> list = new ArrayList<DataBoardVO>();
	 try
	{
		getConnection();
		//rownum : 위에서 잘라내기 O ==> 중간 x
		String sql = "SELECT no,subject,rownum "
				+ "FROM (SELECT no,subject "
				+ "FROM databoard ORDER BY hit DESC) "
				+ "WHERE rownum<=5";
		ps=conn.prepareStatement(sql);
		ResultSet rs =ps.executeQuery();
		while(rs.next())
		{
			DataBoardVO vo =new DataBoardVO();
			vo.setNo(rs.getInt(1));
			vo.setSubject(rs.getString(2));
			list.add(vo);
		}
		rs.close();
	
		
	}catch(Exception ex)
	{
		System.out.println(ex.getMessage());
	}
	finally
	{
	    //반환
		disConnection();
	}
	 return list;
 }
 public ArrayList<DataBoardVO> boardListData(int page)

 {
	 ArrayList<DataBoardVO> list = new ArrayList<DataBoardVO>();
	 try
	  {
		  // 주소값 얻기 ==> Connection
		  getConnection();
		  // sql문장 전송 
		  int rowSize=10;
		  /*
		   *     rownum ==> 1
		   *     1 page => 1~10
		   *     2 page => 11~20
		   */
		  int start=(page*rowSize)-(rowSize-1);
		  int end=page*rowSize;
		  String sql="SELECT no,subject,name,regdate,hit,num "
				    +"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
				    +"FROM (SELECT no,subject,name,regdate,hit "
				    +"FROM databoard ORDER BY no DESC)) "
				    +"WHERE num BETWEEN ? AND ?";
		  // SQL문장 
		  ps=conn.prepareStatement(sql);
		  ps.setInt(1,start);
		  ps.setInt(2, end);
		  
		  ResultSet rs=ps.executeQuery();
		  while(rs.next())
		  {
			  DataBoardVO vo=new DataBoardVO();
			  vo.setNo(rs.getInt(1));
			  vo.setSubject(rs.getString(2));
			  vo.setName(rs.getString(3));
			  vo.setRegdate(rs.getDate(4));
			  vo.setHit(rs.getInt(5));
			  list.add(vo);
		  }
		  rs.close();
	  }catch(Exception ex)
	  {
		  System.out.println(ex.getMessage());
	  }
	  finally
	  {
		  // 반환 
		  disConnection();
	  }
	  return list;
	  
 }
 
 //페이지 나누기
 public int dataBoardTotalPage()
 {
	 int total=0;
	 try
	 {
		getConnection();
		String sql="SELECT CEIL(COUNT(*)/10) FROM databoard";
		ps= conn.prepareStatement(sql);
		ResultSet rs =ps.executeQuery();
		 rs.next();
		 total=rs.getInt(1);
		rs.close();
		
		 
	 }catch(Exception ex) {
		 System.out.println(ex.getMessage());
	 }
	 
	 finally
	 {
		 disConnection();
	 }
	 return total;
 }
 
 //새글(글쓰기)
 public void databoardInsert(DataBoardVO vo)
 {
	 try
	 {
		 getConnection();
		 String sql="INSERT INTO databoard VALUES("
		 		+ "db_no_seq.nextval,?,?,?,?,SYSDATE,"
		 		+ "0,?,?)";
		 ps=conn.prepareStatement(sql);
		 ps.setString(1,vo.getName());
		 ps.setString(2,vo.getSubject());
		 ps.setString(3, vo.getContent());
		 ps.setString(4, vo.getPwd());
		 ps.setString(5, vo.getFilename());
		 ps.setInt(6, vo.getFilesize());
		 ps.executeUpdate();
		 
	 }catch(Exception ex)
	 {
		 System.out.println(ex.getMessage());
	 }
	 finally
	 {
		 disConnection();
	 }
 }
 
 //상세보기 페이지
 public DataBoardVO databoardDetailData(int no)
 {
	 DataBoardVO vo = new DataBoardVO();
	 try
	 {
		 getConnection();
		 //조회수 증가 
		 String sql ="UPDATE databoard SET "
		 		+ "hit=hit+1 "
		 		+ "WHERE no=?";
		 ps= conn.prepareStatement(sql);
		 ps.setInt(1, no);
		 ps.executeUpdate();
		 
		 //실제 데이터
		 sql="SELECT no,name,subject,content,regdate,hit, "
		 		+ "filename,filesize "
		 		+ "FROM databoard "
		 		+ "WHERE no=?";
		 ps= conn.prepareStatement(sql);
		 ps.setInt(1, no);
		 ResultSet rs= ps.executeQuery();
		 rs.next();
		 vo.setNo(rs.getInt(1));
		 vo.setName(rs.getString(2));
		 vo.setSubject(rs.getString(3));
		 vo.setContent(rs.getString(4));
		 vo.setRegdate(rs.getDate(5));
		 vo.setHit(rs.getInt(6));
		 vo.setFilename(rs.getString(7));
		 vo.setFilesize(rs.getInt(8));
		 rs.close();
		 
	 }catch(Exception ex)
	 {
		 System.out.println(ex.getMessage());
	 }
	 finally
	 {
		 disConnection();
	 }
	 return vo;
 }
 
 public DataBoardVO databoardFileinfo(int no)
 {
	 DataBoardVO vo = new DataBoardVO();
	 try
	 {
		getConnection();
		String sql="SELECT filename,filesize "
				+ "FROM databoard "
				+ "WHERE no=?";
		 ps= conn.prepareStatement(sql);
		 ps.setInt(1, no);
		 ResultSet rs =ps.executeQuery();
		 rs.next();
		
		vo.setFilename(rs.getString(1));
		vo.setFilesize(rs.getInt(2));
		rs.close();
		 
	 }catch(Exception ex) {
		 System.out.println(ex.getMessage());
	 }
	 
	 finally
	 {
		 disConnection();
	 }
	 return vo;
 }
 
 
 //실제 데이터 삭제
 public boolean databoardDelete(int no, String pwd)
 {
	 boolean bCheck=false;
	 try
	 {
		getConnection();
		String sql="SELECT pwd FROM databoard "
				+ "WHERE no=?";
		ps =conn.prepareStatement(sql);
		ps.setInt(1, no);
		ResultSet rs =ps.executeQuery();
		rs.next();
		
		String db_pwd=rs.getString(1);
		rs.close();
		
		if(db_pwd.equals(pwd))
		{
			bCheck=true;
			sql="DELETE FROM databoard "
					+ "WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ps.executeUpdate();
				
		}
		else
		{
			bCheck=false;
		}
	 }catch(Exception ex)
	 {
		 System.out.println(ex.getMessage());
	 }
	 finally
	 {
		 disConnection();
	 }
	 return bCheck;
 }
}
