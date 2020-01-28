import React from 'react';
import styled from 'styled-components';
import Card from './Card';

const Image = styled.img`
  width: 100%;
`;

type Props = {
  image: string
}

const ImageCard: React.FC<Props> = ({ children, image }) => (
  <Card>
    <Image src={image} />
    {children}
  </Card>
);

export default ImageCard;
