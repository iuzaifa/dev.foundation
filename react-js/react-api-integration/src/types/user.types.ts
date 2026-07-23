// types/user.ts


export interface UserResponse {
  statusCode: number;
  data: UsersData;
  message: string;
  success: boolean;
}

export interface UsersData {
  page: number;
  limit: number;
  totalPages: number;
  previousPage: boolean;
  nextPage: boolean;
  totalItems: number;
  currentPageItems: number;
  data: User[];
}

export interface User {
  id: number;
  gender: string;
  email: string;
  phone: string;
  cell: string;
  nat: string;

  name: {
    title: string;
    first: string;
    last: string;
  };

  location: {
    street: {
      number: number;
      name: string;
    };
    city: string;
    state: string;
    country: string;
    postcode: string;
    coordinates: {
      latitude: string;
      longitude: string;
    };
    timezone: {
      offset: string;
      description: string;
    };
  };

  login: {
    uuid: string;
    username: string;
    password: string;
    salt: string;
    md5: string;
    sha1: string;
    sha256: string;
  };

  dob: {
    date: string;
    age: number;
  };

  registered: {
    date: string;
    age: number;
  };

  picture: {
    large: string;
    medium: string;
    thumbnail: string;
  };
}