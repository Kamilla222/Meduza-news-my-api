package com.mynews.app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController

public class MeduzaNewsApiController {
    @Value("${config.url.part-url-meduza-news}")
    private String partUrlMeduzaNews;
    @Value("${config.url.page}")
    private String page;
    @Value("${config.url.per-page}")
    private String perPage;

    @GetMapping("/")
    public String responseJson (){
        return partUrlMeduzaNews;
    }
    @GetMapping(value = "/news", produces = MediaType.APPLICATION_JSON_VALUE)
    public String news(@RequestParam(value = "page", required = false, defaultValue = "0") String pageNumber) {
       return getMeduzaNews(partUrlMeduzaNews, page, perPage,  pageNumber);
    }



    private String meduzaUrl (String partUrlMeduzaNews, String page, String perPage, String pageNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(partUrlMeduzaNews)
                .append(page)
                .append("=")
                .append(pageNumber)
                .append("&")
                .append(perPage);
        return stringBuilder.toString();
    }

    private String getMeduzaNews(String partUrlMeduzaNews, String page, String perPage, String pageNumber) {
        WebClient webClient = WebClient.create();
        String newsJson = webClient.get()
                .uri(meduzaUrl(partUrlMeduzaNews, page, perPage, pageNumber))
                .exchange()
                .block()
                .bodyToMono(String.class)
                .block();
        return newsJson;

    }

}
