package searchengine.fjp;

import org.springframework.beans.factory.annotation.Autowired;
import searchengine.model.Page;
import searchengine.repositories.PageRepository;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


public class UrlsContainer {
    @Autowired
    private static PageRepository pageRepository;


    private static String mainPageUrl;

    public static Set<String> uniqueUrls = ConcurrentHashMap.newKeySet();

    private static AtomicInteger idGeneratorForPage = new AtomicInteger();


    public static String getMainPageUrl() {
        return mainPageUrl;
    }

    public static void setMainPageUrl(String mainPageUrl) {
        UrlsContainer.mainPageUrl = mainPageUrl;
        uniqueUrls.add(mainPageUrl);

        Page page = new Page();

        int idPage = 1;
        page.setId(idPage);
        page.setSite(1);
        page.setPath(mainPageUrl);
        page.setCode(200);
        page.setContent("<!DOCTYPE html><html><head><title>");

        pageRepository.save(page);


    }

}
