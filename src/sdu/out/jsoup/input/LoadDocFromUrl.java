package sdu.out.jsoup.input;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class LoadDocFromUrl {

	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect("http://www.baidu.com/").get();
		String title = doc.title();
		System.out.println(title);
		
		Document doc2 = Jsoup.connect("http://example.com")
				  .data("query", "Java")
				  .userAgent("Mozilla")
				  .cookie("auth", "token")
				  .timeout(3000)
				  .post();
		System.out.println(doc2.title());
		
		
	}

}
