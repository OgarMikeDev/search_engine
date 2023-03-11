package searchengine.fjp;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import searchengine.model.Enum;
import searchengine.model.Site;
import searchengine.repositories.PageRepository;
import searchengine.repositories.SiteRepository;

import java.io.IOException;
import java.io.PrintWriter;


import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
public class Main {
    @Autowired
    private static SiteRepository siteRepository;

    public static String url = "http://www.playback.ru/";
    private static AtomicInteger idGeneratorForSite = new AtomicInteger();

    public static void main(String[] args) {
        UrlsContainer.setMainPageUrl(url);

        Node node = new ForkJoinPool()
                .invoke(new WebScraper(new Node(url)));

        int idSite = generatedId();
        Site site = new Site();
        site.setId(idSite);
        site.setStatus(Enum.INDEXING);
        site.setStatusTime(LocalDateTime.now());
        site.setLastError("");
        site.setUrl(url);
        site.setName(url);

        siteRepository.save(site);

    }


    public static int generatedId() {
        return idGeneratorForSite.getAndIncrement();
    }
}