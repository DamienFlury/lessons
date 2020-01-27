package ch.bbw.df.jsonmashup.wiki;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Article implements Serializable {
  private String pageid;
  private String title;
  private String extract;
}