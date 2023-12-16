package com.nunna.springreactivesample.controller;

import java.time.Duration;
import java.util.logging.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nunna.springreactivesample.service.ReactiveServiceExaxmple;
import com.nunna.springreactivesample.vo.Language;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class SampleReactiveController {

  @Autowired
  private ReactiveServiceExaxmple reactiveServiceExaxmple;
  
  @GetMapping("/greeting-demo")
  public Mono<String> greeting() {
    return constructMono();
  }

  private Mono<String> constructMono() {
    return Mono.just("Hello World! This is from Reactive web development"+ Thread.currentThread().getName()).delayElement(Duration.ofSeconds(5l));
  }
  
  
  @GetMapping(value = "/event-demo", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<Integer> getStreamOfData() {
    return Flux
        .range(1, 10)
        .delayElements(Duration.ofSeconds(1)).log();
  }
  
  
  @GetMapping(value = "/service-call")
  public Flux<Language> getFluxDataFromServiceCall() {
    return reactiveServiceExaxmple.getJobHistory().log(Level.INFO.getName());
  }
}
