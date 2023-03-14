package searchengine.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import searchengine.config.ConfigSite;
import searchengine.config.SitesList;
import searchengine.dto.statistics.*;
import searchengine.dto.statistics.request.RequestSite;
import searchengine.dto.statistics.response.ResponseSite;
import searchengine.model.Enum;
import searchengine.model.Site;
import searchengine.repositories.SiteRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class StatisticsServiceImpl implements StatisticsService {

    private final Random random = new Random();
    private final SitesList sites;

    @Autowired
    private final SiteRepository siteRepository;


    @Override
    public StatisticsResponse getStatistics() {
        String[] statuses = { "INDEXED", "FAILED", "INDEXING" };
        String[] errors = {
                "Ошибка индексации: главная страница сайта не доступна",
                "Ошибка индексации: сайт не доступен",
                ""
        };

        TotalStatistics total = new TotalStatistics();
        total.setSites(sites.getSites().size());
        total.setIndexing(true);

        List<DetailedStatisticsItem> detailed = new ArrayList<>();
        List<ConfigSite> sitesList = sites.getSites();
        for(int i = 0; i < sitesList.size(); i++) {
            ConfigSite site = sitesList.get(i);
            DetailedStatisticsItem item = new DetailedStatisticsItem();
            item.setName(site.getName());
            item.setUrl(site.getUrl());
            int pages = random.nextInt(1_000);
            int lemmas = pages * random.nextInt(1_000);
            item.setPages(pages);
            item.setLemmas(lemmas);
            item.setStatus(statuses[i % 3]);
            item.setError(errors[i % 3]);
            item.setStatusTime(System.currentTimeMillis() -
                    (random.nextInt(10_000)));
            total.setPages(total.getPages() + pages);
            total.setLemmas(total.getLemmas() + lemmas);
            detailed.add(item);
        }

        StatisticsResponse response = new StatisticsResponse();
        StatisticsData data = new StatisticsData();
        data.setTotal(total);
        data.setDetailed(detailed);
        response.setStatistics(data);
        response.setResult(true);
        return response;
    }

    @Override
    public ResponseSite createEntry(RequestSite request) {

        Site site = new Site();
        int idSite = site.generatedId();
        site.setStatus(Enum.INDEXING);
        site.setStatusTime(LocalDateTime.now());
        site.setLastError(request.getLastError());
        site.setUrl(request.getUrl());
        site.setName(request.getName());

        siteRepository.save(site);

//        UrlsContainer.setMainPageUrl(url);
//        Node node = new ForkJoinPool()
//                .invoke(new WebScraper(new Node(url)));

        return new ResponseSite(site.getStatus(), site.getUrl(), site.getName(), site.getLastError());
    }
}
