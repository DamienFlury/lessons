package ch.bbw.df.jsonmashup.controllers;

import ch.bbw.df.jsonmashup.nasa.ImageOfTheDay;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/nasa")
public class NasaController {
  @GetMapping
  public ImageOfTheDay getImageOfTheDay() {
    var restTemplate = new RestTemplate();
    var result = restTemplate
            .getForObject("https://api.nasa.gov/planetary/apod?api_key=wAICQ2fbFNssEofWabFJHJQOc71U54NC6Ssq8rHs", ImageOfTheDay.class);
    return result;
  }
}
