

export interface Avatar {
  _id: string;
  url: string;
  localPath: string;
}

export interface User {
  _id: string;
  username: string;
  email: string;
  role: "ADMIN" | "USER";
  loginType: "EMAIL_PASSWORD";
  isEmailVerified: boolean;
  avatar: Avatar;
  createdAt: string;
  updatedAt: string;
  __v: number;
}