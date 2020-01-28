import React, { useState, useEffect } from 'react';
import ImageOfTheDay from '../types/ImageOfTheDay';
import Wiki from './Wiki';
import ImageCard from '../styled-components/ImageCard';

// const Title = styled.div`
//   font-size: 1.1rem;
//   margin: 10px;
// `;

const NasaImage: React.FC = () => {
  const [image, setImage] = useState<ImageOfTheDay | null>(null);

  useEffect(() => {
    const fetchImage = async () => {
      const response = await fetch('http://localhost:8080/nasa');
      const data = await response.json();
      setImage(data);
    };
    fetchImage();
  }, []);

  return (
    image && (
      <ImageCard image={image.url}>
        <Wiki topic={image.title} />
      </ImageCard>
    )
  );
};

export default NasaImage;
