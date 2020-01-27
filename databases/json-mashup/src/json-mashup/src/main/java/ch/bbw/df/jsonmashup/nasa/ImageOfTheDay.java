package ch.bbw.df.jsonmashup.nasa;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class ImageOfTheDay implements Serializable {
  private String copyright;
  private String date;
  private String explanation;
  private String title;
  private String url;
}
