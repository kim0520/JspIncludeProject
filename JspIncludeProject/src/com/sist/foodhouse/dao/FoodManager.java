package com.sist.foodhouse.dao;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class FoodManager {
 //jsoup ÀÐ±â
	public static void main(String[] arg)
	{
		FoodManager m = new FoodManager();
		ArrayList<CategoryVO>list = m.foodCategoryData();
		FoodDAO dao = new FoodDAO();
		for(CategoryVO vo:list)
		{
			dao.foodCategoryInsert(vo);
		}
		System.out.println("end");
	}
	public ArrayList<CategoryVO> foodCategoryData()
	{
		ArrayList<CategoryVO> list = new ArrayList<CategoryVO>();
		try
		{
			 Document doc=Jsoup.connect("https://www.mangoplate.com/").get();
	         Elements title=doc.select("figcaption.info span.title");
	         Elements subject=doc.select("figcaption.info p.desc");
	         //data-lazy
	         Elements poster=doc.select("img.center-croping");
			
			for(int i=0;i<9;i++)
			{
				System.out.println("==================");
				System.out.println(title.get(i).text());
				System.out.println(subject.get(i).text());
				System.out.println(poster.get(i).attr("data-lazy"));
			
				
				CategoryVO vo = new CategoryVO();
				vo.setTitle(title.get(i).text());
				vo.setSubject(subject.get(i).text());
				vo.setPoster(poster.get(i).attr("data-lazy"));
				list.add(vo);
			}
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return list;
	}
	
}
