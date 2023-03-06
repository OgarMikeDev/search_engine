package searchengine.fjp;

import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.*;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;


@Getter
public class WebScraper extends RecursiveTask<Node> {

    private final Node node;
    private final Logger logger = LogManager.getRootLogger();


    public WebScraper(Node node) {
        this.node = node;
    }

    @Override
    protected Node compute() {
        try {
            Thread.sleep(120);
            Document document = Jsoup.connect(node.getUrl())
                    .ignoreHttpErrors(true).followRedirects(false).ignoreContentType(true).get();
            Set<String> urls = getUrls(document);
            Set<WebScraper> taskList = new HashSet<>();
            for (String url : urls) {
                if (UrlsContainer.uniqueUrls.contains(url)) {
                    continue;
                }
                logger.error(url);
                UrlsContainer.uniqueUrls.add(url);
                Node child = new Node(url);
                node.addChild(child);
                WebScraper task = new WebScraper(child);
                task.fork();
                taskList.add(task);
            }
            for (WebScraper task : taskList) {
                node.addChild(task.join());
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            System.out.println(e.getMessage());
        }
        return node;
    }

    private Set<String> getUrls(Document document) {
        String selector = "a[href]";
        Elements elements = document.select(selector);
        return elements.stream().map(e -> e.absUrl("href"))
                .filter(e -> e.startsWith(UrlsContainer.getMainPageUrl())
                        && !e.contains(".doc")
                        && !e.contains(".pdf")
                        && !e.contains(".png")
                        && !e.contains(".php")
                        && !e.contains(".jpeg")
                        && !e.contains(".jpg")
                        && !e.contains("?page")
                        && !e.contains("?PAGEN")
                        && !e.contains("#")
                        && !e.contains(".JPG"))
                .collect(Collectors.toSet());
    }
}

