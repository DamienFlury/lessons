package ch.bbw.df.jsonmashup.controllers;

import ch.bbw.df.jsonmashup.nasa.ImageOfTheDay;
import ch.bbw.df.jsonmashup.nasa.MarsPhoto;
import ch.bbw.df.jsonmashup.nasa.MarsRoverPhotos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/nasa")
public class NasaController {
  @GetMapping
  public ImageOfTheDay getImageOfTheDay() {
    RestTemplate restTemplate = new RestTemplate();
    ImageOfTheDay result = restTemplate.getForObject(
        "https://api.nasa.gov/planetary/apod?api_key=wAICQ2fbFNssEofWabFJHJQOc71U54NC6Ssq8rHs", ImageOfTheDay.class);
    return result;
  }

  @GetMapping("/curiosity")
  public MarsPhoto getCuriosityPhoto() {
    RestTemplate template = new RestTemplate();
    List<MarsPhoto> photos = template.getForObject("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?earth_date=2018-2-2&api_key=wAICQ2fbFNssEofWabFJHJQOc71U54NC6Ssq8rHs", MarsRoverPhotos.class).getPhotos();
    Random rand = new Random();
    return photos.get(rand.nextInt(photos.size()));
  }
}
