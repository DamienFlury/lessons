package ch.bbw.df.jsonmashup.controllers;

import ch.bbw.df.jsonmashup.wiki.Article;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/wiki")
public class WikiController {
  @GetMapping("/{query}")
  public Article getArticle(@PathVariable(value = "query") String query) {
    var restTemplate = new RestTemplate();
    var result = restTemplate
            .getForObject("http://localhost:3100/wiki/" + query, Article.class);
    return result;
  }
}
