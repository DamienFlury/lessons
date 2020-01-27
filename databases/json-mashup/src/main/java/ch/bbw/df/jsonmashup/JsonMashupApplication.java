package ch.bbw.df.jsonmashup;

import ch.bbw.df.jsonmashup.nasa.ImageOfTheDay;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class JsonMashupApplication {

	public static void main(String[] args) {
	  SpringApplication.run(JsonMashupApplication.class, args);
	}

	public static ImageOfTheDay getImageOfTheDay() {
	  var restTemplate = new RestTemplate();
	  var result = restTemplate
            .getForObject("https://api.nasa.gov/planetary/apod?api_key=wAICQ2fbFNssEofWabFJHJQOc71U54NC6Ssq8rHs", ImageOfTheDay.class);
	  return result;
  }

}
