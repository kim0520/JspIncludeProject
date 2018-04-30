package com.sist.databoard.dao;

import java.sql.Date;

/*
 * 
 *  jsp : 8장
 *  
 *  일반자바 클래스 : 자바 빈
 *  
 *  == 데이터 빈 : 데이터만 관리(읽기, 쓰기)
 *        읽기: getXXX
 *        쓰기 : setXXx
 *        상태 : is XX() ===> boolean 변수 
 *        
 *        =======Spring : ~vo
 *        =======MyBatis: ~DTO
 *        
 *  --- 액션 빈 : 빈을 활용하는 클래스(기능 수행 ==> 메소드)
 *     ~DAO
 *     ~Manager
 *     ~Service
 *  
 *  === 혼합 빈 : 데이터빈 + 액션 빈
 *  
 *  
 *    1) 메모리 할당 => <jsp:useBean>
 *    2) setXXXX 메소드 호출 <jsp:setProperty>
 *    3) getXXXX 메소드 호풀 <jsp:getProperty>
 *    <c:forEach>
 *    <>
 * 
 */
public class DataBoardVO {
	private int no;
	private String name;
	private String subject;
	private String content;
	private String pwd;
	private Date regdate;
	private int hit;
	private String filename;
	private int filesize;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getFilesize() {
		return filesize;
	}
	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}
	
}
