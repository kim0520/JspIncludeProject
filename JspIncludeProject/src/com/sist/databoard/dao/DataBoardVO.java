package com.sist.databoard.dao;

import java.sql.Date;

/*
 * 
 *  jsp : 8��
 *  
 *  �Ϲ��ڹ� Ŭ���� : �ڹ� ��
 *  
 *  == ������ �� : �����͸� ����(�б�, ����)
 *        �б�: getXXX
 *        ���� : setXXx
 *        ���� : is XX() ===> boolean ���� 
 *        
 *        =======Spring : ~vo
 *        =======MyBatis: ~DTO
 *        
 *  --- �׼� �� : ���� Ȱ���ϴ� Ŭ����(��� ���� ==> �޼ҵ�)
 *     ~DAO
 *     ~Manager
 *     ~Service
 *  
 *  === ȥ�� �� : �����ͺ� + �׼� ��
 *  
 *  
 *    1) �޸� �Ҵ� => <jsp:useBean>
 *    2) setXXXX �޼ҵ� ȣ�� <jsp:setProperty>
 *    3) getXXXX �޼ҵ� ȣǮ <jsp:getProperty>
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
