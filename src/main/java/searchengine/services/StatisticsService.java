package searchengine.services;

import searchengine.dto.statistics.request.RequestSite;
import searchengine.dto.statistics.response.ResponseSite;
import searchengine.dto.statistics.StatisticsResponse;

public interface StatisticsService {
    StatisticsResponse getStatistics();

    ResponseSite createEntry(RequestSite request);
}
