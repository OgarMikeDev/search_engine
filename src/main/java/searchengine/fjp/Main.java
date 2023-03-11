package searchengine.fjp;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import searchengine.repositories.PageRepository;

import java.io.IOException;
import java.io.PrintWriter;


import java.util.List;
import java.util.concurrent.ForkJoinPool;
@RequiredArgsConstructor
public class Main {
    public static String url = "http://www.playback.ru/";
//    public static PrintWriter writer;

    public static void main(String[] args) {
        UrlsContainer.setMainPageUrl(url);
        Node node = new ForkJoinPool()
                .invoke(new WebScraper(new Node(url)));
//        try {
//            writer = new PrintWriter("data/siteMap.txt");
//            List<String> urlsList = node.getAllUrls();
//            for(String urls : urlsList){
//                writer.write(urls);
//
//            }
//            writer.flush();
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}