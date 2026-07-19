import { Star } from 'lucide-react';
import React from 'react'
import RatingStars from '../ui/RatingStars';

const TestimonialSection = ({ testimonial }) => {
  return (
    <>
      <section className="testimonial-section py-16 bg-white">
        <div className="container mx-auto px-4">
          <div>
            <h2 className="text-3xl font-bold text-center text-gray-800">
              What Our Users Say
            </h2>
            <p className="text-center text-gray-600 mb-12">
              Hear from our satisfied users who have experienced the benefits of
            </p>
          </div>
          <div className="grid grid-cols-1 md:grid-cols-3 gap-8">
            {testimonial.map((item, index) => (
              <div
                key={index}
                className="testimonial-card p-6 border border-purple-200 rounded-sm bg-purple-50/20 hover:shadow-sm transition-shadow duration-100"
              >
                <div className='py-2'>
                  <RatingStars rating={item.rating} />
                </div>
                <blockquote>
                  <p className="text-gray-600 font-medium mb-4 italic">
                    "{item.feedback}"
                  </p>
                </blockquote>
                <div className="flex items-center">
                  <div className="flex gap-5">
                    <img
                      src={item.avatar}
                      alt={item.name}
                      className="h-14 rounded-full border-2 border-green-500"
                    />
                    <div>
                      <p className="text-lg font-semibold text-gray-800">
                        {item.name}
                      </p>
                      <p className="text-sm text-gray-500">{item.role}</p>
                    </div>
                  </div>
                </div>
              </div>
            ))}
          </div>
        </div>
      </section>
    </>
  );
};

export default TestimonialSection