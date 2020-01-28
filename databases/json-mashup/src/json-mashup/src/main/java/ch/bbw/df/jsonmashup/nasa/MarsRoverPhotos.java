package ch.bbw.df.jsonmashup.nasa;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MarsRoverPhotos implements Serializable {
  private java.util.List<MarsPhoto> photos;
}