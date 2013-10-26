package jp.matsuo.main;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HttpTest {
	public static void main(String[] args) {

		String url = "http://stocks.finance.yahoo.co.jp/stocks/detail/?code=3209.T";

		try {

			Document document = Jsoup.connect(url).get();
			String title = document.getElementsByTag("title").text();
			System.out.println(title);

			Elements elts = document.getElementsByAttributeValue("class", "stoksPrice");
			for (Element el :elts){
				System.out.println("data :" + el.data());
				System.out.println("baseUrl :" + el.baseUri());
				System.out.println("className :" + el.className());
				System.out.println("id :" + el.id());
				System.out.println("nodeName :" + el.nodeName());
				System.out.println("text :" + el.text());
				System.out.println("val :" + el.val());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
