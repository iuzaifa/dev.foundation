import { Star, StarHalf } from "lucide-react";

const RatingStars = ({ rating }) => {
  const fullStars = Math.floor(rating); // e.g., 4
  const hasHalfStar = rating % 1 !== 0; // true for 4.5
  const emptyStars = 5 - fullStars - (hasHalfStar ? 1 : 0);

  return (
    <div className="flex items-center">
      {/* Full Stars */}
      {[...Array(fullStars)].map((_, i) => (
        <Star
          key={`full-${i}`}
          className="w-4 h-4 fill-yellow-500 text-yellow-500"
        />
      ))}

      {/* Half Star */}
      {hasHalfStar && (
        <StarHalf className="w-4 h-4 fill-yellow-400 text-yellow-400" />
      )}

      {/* Empty Stars */}
      {[...Array(emptyStars)].map((_, i) => (
        <Star key={`empty-${i}`} className="w-4 h-4 text-gray-300 fill-gray-200" />
      ))}
    </div>
  );
};

export default RatingStars;