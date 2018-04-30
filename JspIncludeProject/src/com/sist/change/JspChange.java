package com.sist.change;

public class JspChange {
	private static String[] jsp= {
		"home.jsp",
		"../member/join.jsp",
		"../foodhouse/foodhouse.jsp",
		"",
		"../databoard/databoard.jsp"
		
	};
	private static String[] databoard_jsp= {
			"list.jsp",
			"detail.jsp",
			"insert.jsp",
			"update.jsp"
	};
	public static String change(int no)
	{
		return jsp[no];
	}
	public static String  databoard_change(int no)
	{
		return databoard_jsp[no];
	}
}
