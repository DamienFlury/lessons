/* eslint-disable camelcase */
import React, { useState, useEffect } from 'react';
import ImageCard from '../styled-components/ImageCard';
import WikiArticle from '../types/WikiArticle';

type RoverPhoto = {
  // eslint-disable-next-line camelcase
  img_src: string,
  // eslint-disable-next-line camelcase
  earth_date: string,
};

const CuriosityPhoto: React.FC = () => {
  const [photo, setPhoto] = useState<RoverPhoto | null>(null);
  const [article, setArticle] = useState<WikiArticle | null>(null);

  useEffect(() => {
    const fetchPhoto = async () => {
      const response = await fetch('http://localhost:8080/nasa/curiosity');
      const data = await response.json();
      setPhoto(data);
    };
    fetchPhoto();
  }, []);

  useEffect(() => {
    const fetchArticle = async () => {
      const response = await fetch('http://localhost:8080/wiki/curiosity');
      const data = await response.json();
      setArticle(data);
    };
    fetchArticle();
  }, []);

  return (
    <div>
      {photo && (
      <ImageCard image={photo.img_src}>
        <h2>
Curiosity Photo (
          { photo?.earth_date }
)

        </h2>
        <p style={{ padding: 20, textAlign: 'left' }}>{article?.extract ?? 'Loading'}</p>
      </ImageCard>
      )}
    </div>
  );
};

export default CuriosityPhoto;
