package sdu.out.jsoup.extract;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WorkWithUrl {

	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect("http://jsoup.org").get();

		Elements link = doc.select("a");
		for (Element element : link) {
			String relHref = element.attr("href");
			String absHref = element.attr("abs:href");
			System.out.println(relHref);
			System.out.println(absHref);
			System.out.println();
		}
		
		
	}

}
