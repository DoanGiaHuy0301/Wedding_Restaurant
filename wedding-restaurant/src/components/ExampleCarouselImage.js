// ExampleCarouselImage.js
import React from 'react';

const ExampleCarouselImage = ({ text, imageUrl }) => {
  return (
    <div>
      <img src={imageUrl} alt={text} />
    </div>
  );
};

export default ExampleCarouselImage;
