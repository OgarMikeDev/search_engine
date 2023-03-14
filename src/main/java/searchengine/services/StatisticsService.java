package searchengine.services;

import searchengine.dto.statistics.ResponseSite;
import searchengine.dto.statistics.StatisticsResponse;

public interface StatisticsService {
    StatisticsResponse getStatistics();

    ResponseSite createEntry(String url, String name);
}
