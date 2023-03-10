package searchengine.fjp;

import org.springframework.beans.factory.annotation.Autowired;
import searchengine.repositories.PageRepository;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


public class UrlsContainer {
    private static String mainPageUrl;
    public static Set<String> uniqueUrls = ConcurrentHashMap.newKeySet();

//    @Autowired
//    private static PageRepository repository;


    public static String getMainPageUrl() {
        return mainPageUrl;
    }

    public static void setMainPageUrl(String mainPageUrl) {
        UrlsContainer.mainPageUrl = mainPageUrl;
        uniqueUrls.add(mainPageUrl);
    }

}
