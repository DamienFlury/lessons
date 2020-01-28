import React, { useState, useEffect } from 'react';
import styled from 'styled-components';
import WikiArticle from '../types/WikiArticle';


const Wrapper = styled.div`
  color: #393939;
`;

type Props = {
  topic: string,
}

const Wiki: React.FC<Props> = ({ topic }) => {
  const [article, setArticle] = useState<WikiArticle | null>(null);

  useEffect(() => {
    const fetchArticle = async () => {
      const response = await fetch(`http://localhost:8080/wiki/${topic}`);
      const data = await response.json();
      setArticle(data);
    };
    fetchArticle();
  }, [topic]);

  return (
    <Wrapper>
      <h1>{article?.title ?? topic}</h1>
      {article && <div>{article.extract ?? 'No Wikipedia article available'}</div>}
    </Wrapper>
  );
};

export default Wiki;
