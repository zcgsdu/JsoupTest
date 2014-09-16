package sdu.out.jsoup.test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Csdn {
	
	private static final String USER_AGENT="Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.149 Safari/537.36";
	private static final String URL = "http://blog.csdn.net/"+"u010122002";
	
	public static void main(String[] args) throws IOException {
		int pageNum;
		
		Document doc=Jsoup.connect(URL)
				.userAgent(USER_AGENT)
				.timeout(0)
				.get();
		
		Element pageElement = doc.select("div.pagelist").first();
		String text = pageElement.text();
		
		String pageStr = text.substring(text.indexOf("¹²")+1, text.indexOf("Ò³"));
		pageNum = Integer.parseInt(pageStr);
		System.out.println(pageNum);
		for(int k = 0;k < 10;k++){
		for (int i = 1; i <= pageNum; i++) {
			Document doc2=Jsoup.connect(URL+"/article/list/"+i)
					.userAgent("")
					.get();
					Elements elements = doc2.select("span.link_title");
					for (Element element : elements) {
						Element element2 = (Element) element.childNode(0);
						String blogUrl = element2.attr("abs:href");
						System.out.println(blogUrl);
						Jsoup.connect(blogUrl)
								.userAgent(USER_AGENT)
								.execute();
					}
		}		
		}
	}

}
