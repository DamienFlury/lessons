package ch.bbw.df.jsonmashup.controllers;

import ch.bbw.df.jsonmashup.wiki.Article;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/wiki")
public class WikiController {
  @GetMapping("/{query}")
  public Article getArticle(@PathVariable(value = "query") String query) {
    RestTemplate restTemplate = new RestTemplate();
    Article result = restTemplate
            .getForObject("http://localhost:3100/wiki/" + query, Article.class);
    return result;
  }
}
