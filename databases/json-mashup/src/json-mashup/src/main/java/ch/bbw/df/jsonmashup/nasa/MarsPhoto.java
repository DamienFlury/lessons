package ch.bbw.df.jsonmashup.nasa;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MarsPhoto implements Serializable {
  private String img_src;
  private String earth_date;
}