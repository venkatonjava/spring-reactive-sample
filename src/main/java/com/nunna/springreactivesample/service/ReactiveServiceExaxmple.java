package com.nunna.springreactivesample.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.nunna.springreactivesample.vo.Language;
import reactor.core.publisher.Flux;

@Service
public class ReactiveServiceExaxmple {
  
  public Flux<Language> getJobHistory() {
    return WebClient.create()
        .get()
        .uri("http://localhost:8082/data/language/1")
        .retrieve()
        .bodyToFlux(Language.class);
  }
}
