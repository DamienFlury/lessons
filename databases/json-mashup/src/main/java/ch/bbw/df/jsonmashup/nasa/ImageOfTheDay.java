package ch.bbw.df.jsonmashup.nasa;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
public class ImageOfTheDay implements Serializable {
  private String copyright;
  private String date;
  private String explanation;
  private String title;
  private String url;
}
