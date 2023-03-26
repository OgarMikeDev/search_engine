package searchengine.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import searchengine.dto.statistics.StatisticsResponse;
import searchengine.dto.statistics.request.RequestSite;
import searchengine.dto.statistics.response.ResponseSite;
import searchengine.services.StatisticsService;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private StatisticsService service;

    @GetMapping("/statistics")
    public ResponseEntity<StatisticsResponse> statistics() {
        return ResponseEntity.ok(service.getStatistics());
    }


    @PostMapping("/startIndexing")
//    @ConfigurationProperties(prefix = "indexing-settings")
    public ResponseSite startIndexing(@RequestBody RequestSite request) {
        return service.createEntry(request);
    }


}
