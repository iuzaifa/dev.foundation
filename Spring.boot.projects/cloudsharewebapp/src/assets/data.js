


// feature section data 
export const features = [
  {
    iconName: "ArrowUpCircle",
    iconColor: "text-blue-500",
    title: "Easy File Upload",
    description:
      "Upload your files instantly with a smooth and user-friendly interface.",
  },
  {
    iconName: "Shield",
    iconColor: "text-green-500",
    title: "Secure Storage",
    description:
      "Keep your data protected with encrypted and reliable cloud storage.",
  },
  {
    iconName: "Share2",
    iconColor: "text-purple-500",
    title: "Simple Sharing",
    description:
      "Share files with anyone using secure, one-click shareable links.",
  },
  {
    iconName: "CreditCard",
    iconColor: "text-red-500",
    title: "Flexible Credits",
    description:
      "Pay only for what you use with a credit-based and fully flexible system.",
  },
  {
    iconName: "FileText",
    iconColor: "text-yellow-500",
    title: "File Management",
    description:
      "Organize, rename, delete, and manage all your files in one place.",
  },
  {
    iconName: "Clock",
    iconColor: "text-orange-500",
    title: "Transactions History",
    description:
      "View your complete credit usage, payments, and activity history anytime.",
  },
];


export const pricePlans = [
  {
    name: "Free",
    price: "0",
    description: "Perfect for getting started",
    features: [
      "5 file uploads",
      "Basic file sharing",
      "7-day file retention",
      "Email support",
    ],
    buttonText: "Get Started",
    buttonStyle:
      "text-purple-600 border border-purple-300 cursor-pointer hover:bg-gray-100 bg-purple-50",
    popular: false,
  },
  {
    name: "Premium",
    price: "500",
    description: "For individuals with larger needs",
    features: [
      "500 file uploads",
      "Advanced file sharing",
      "30-day file retention",
      "Priority email support",
      "File analytics",
    ],
    buttonText: "Go Premium",
    buttonStyle: "bg-purple-600 text-white cursor-pointer",
    popular: true,
  },
  {
    name: "Ultimate",
    price: "2500",
    description: "For teams and businesses",
    features: [
      "5000 file uploads",
      "Team sharing capabilities",
      "Unlimited file retention",
      "24/7 priority support",
      "Advanced analytics",
      "API access",
    ],
    buttonText: "Go Ultimate",
    buttonStyle:
      "text-purple-600 border border-purple-300 cursor-pointer hover:bg-gray-100 bg-purple-50",
    popular: false,
  },
];



export const testimonial = [
  {
    name: "Alice Johnson",
    role: "Freelancer",
    feedback:
      "CloudShare has transformed the way I share files with my clients. The process is seamless and secure!",
    avatar: "https://randomuser.me/api/portraits/women/44.jpg",
    rating : 5,
  },
  { 
    name: "Mark Thompson",
    role: "Small Business Owner",
    feedback:
      "The flexible pricing plans allowed my business to scale our file sharing needs without breaking the bank.",
    avatar: "https://randomuser.me/api/portraits/men/35.jpg",
    rating : 2.5,
  },
  {
    name: "Sophie Lee", 
    role: "Graphic Designer",
    feedback:
      "I love the intuitive interface of CloudShare. Uploading and managing my files has never been easier.",
    avatar: "https://randomuser.me/api/portraits/women/68.jpg",
    rating : 5,
  },
  // {
  //   name: "David Kim",
  //   role: "Developer",
  //   feedback:
  //     "The API access in the Ultimate plan has been a game-changer for integrating file sharing into our applications.",
  //   avatar: "https://randomuser.me/api/portraits/men/22.jpg", 
  //   rating : 4,
  // },
  // {
  //   name: "Emma Wilson",
  //   role: "Photographer",
  //   feedback:
  //     "CloudShare's secure storage gives me peace of mind knowing my clients' photos are safe and easily accessible.",
  //   avatar: "https://randomuser.me/api/portraits/women/12.jpg", 
  //   rating : 5,

  // }
]