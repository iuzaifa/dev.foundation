import React from 'react';
import {Mail,Phone,MapPin,Mailbox,Globe,Cake,VenetianMask,} from 'lucide-react';
import type { User } from '../types/user.types';





// ---------- Helper component for each detail row ----------
interface DetailItemProps {
  icon: React.ReactNode;  // Lucide icon component
  label: string;
  value: string;
}

interface UserCardProps {
  user: User;
}

const DetailItem: React.FC<DetailItemProps> = ({ icon, label, value }) => {
  return (
    <div className="flex items-start gap-3 py-2 border-b border-gray-100 last:border-0">
      <div className="text-gray-500 w-5 h-5 mt-0.5 flex-shrink-0">
        {icon}
      </div>
      <div className="flex-1 min-w-0">
        <p className="text-xs uppercase tracking-wider text-gray-400 font-semibold">
          {label}
        </p>
        <p className="text-sm font-medium text-gray-800 truncate">
          {value}
        </p>
      </div>
    </div>
  );
};

// ---------- Main UserCard component ----------
const UserCard: React.FC<UserCardProps> = ({user}) => {

  
  const { name, email, gender, phone, location, dob, picture } = user;
  return (
    <div className="max-w-md w-full mx-auto bg-white rounded-2xl shadow-lg hover:shadow-xl transition-shadow duration-200 p-6 border border-gray-100">
      {/* Header: Avatar + Name */}
      <div className="flex items-center gap-4 pb-4 mb-2 border-b border-gray-200">
        <img
          src={picture.medium}
          alt={`${name}'s avatar`}
          className="w-16 h-16 rounded-full object-cover border-2 border-gray-200 bg-gray-50"
        />
        <h2 className="text-2xl font-bold text-gray-800 tracking-tight">
          {`${name.title}. ${name.first} ${name.last}`}
        </h2>
      </div>

      {/* Details Grid */}
      <div className="grid grid-cols-1 gap-1">
        <DetailItem icon={<Mail size={18} />} label="Email" value={email} />
        <DetailItem icon={<VenetianMask size={18} />} label="Gender" value={gender} />
        <DetailItem icon={<Phone size={18} />} label="Phone" value={phone} />
        <DetailItem icon={<MapPin size={18} />} label="Location" value={`${location.postcode}, ${location.street.name} ${location.street.number}, ${location.city}`} />
        <DetailItem icon={<Mailbox size={18} />} label="Postcode" value={`${location.postcode}`} />
        <DetailItem icon={<Globe size={18} />} label="Country" value={location.country} />
        <DetailItem icon={<Cake size={18} />} label="Date of Birth" value={`${dob.date}, Age: ${dob.age}`} />
      </div>
    </div>
  );
};

export default UserCard;