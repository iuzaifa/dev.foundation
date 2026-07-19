import { Check, IndianRupee } from "lucide-react";
import React from "react";

const PricingSection = ({ pricePlans,  openSignUp }) => {
  return (
    <>
      <div className="py-20 bg-gray-50">
        <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
          <div className="text-center">
            <h2 className="text-3xl font-extrabold text-gray-900 sm:text-4xl">
              Simple, Transparent Pricing
            </h2>

            <p className="mt-4 max-w-2xl mx-auto text-xl text-gray-500">
              Choose the plan that's right for you
            </p>
          </div>

          {/* <div className="mt-16 space-y-12 lg: space-y-0 lg:grid-cols-3 lg:gap-8">


          </div> */}
          <div className="max-w-7xl mx-auto py-16 px-4 sm:px-6 lg:px-8">
            <div className="grid gap-12 md:grid-cols-3">
              {pricePlans.map((plan) => (
                <div
                  key={plan.name}
                  className={`border border-slate-200 rounded-lg p-6 flex flex-col shadow hover:scale-105 transition-transform duration-300 bg-white ${
                    plan.popular
                      ? "border-purple-400 ring-1 ring-purple-500 shadow-lg bg-gradient-to-b from-purple-50/40 to-purple-50 scale-105 hover:scale-110 transition-transform duration-300"
                      : ""
                  }`}
                >
                  {plan.popular && (
                    <span className="self-end bg-purple-100 text-purple-700 px-2 py-1 rounded-full text-xs font-bold mb-2">
                      Popular
                    </span>
                  )}
                  <h2 className="text-2xl font-bold text-gray-900 mb-2">
                    {plan.name}
                  </h2>
                  <p className="text-gray-500 mb-4">{plan.description}</p>
                  <p className="text-3xl flex items-center font-extrabold text-gray-900 mb-6">
                    <IndianRupee className="text-slate-900" /> {plan.price}
                  </p>

                  <ul className="mb-6 space-y-2 flex-1">
                    {plan.features.map((feature) => (
                      <li key={feature} className="flex items-center">
                        <Check className="w-5 h-5 text-purple-600 mr-2" />
                        {feature}
                      </li>
                    ))}
                  </ul>

                  <button
                    onClick={() => openSignUp()}
                    className={`mt-auto py-2 px-4 rounded ${plan.buttonStyle} hover:opacity-90`}
                  >
                    {plan.buttonText}
                  </button>
                </div>
              ))}
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default PricingSection;
