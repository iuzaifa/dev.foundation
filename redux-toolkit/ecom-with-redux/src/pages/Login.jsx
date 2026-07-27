import { useState } from "react";
import { useDispatch } from "react-redux";
import { getLoggedInUser, login } from "../store/authSlice";
import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import { getUserId } from "../utils/auth";

const Login = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    username: "",
    password: "",
  });

  const handleChange = (e) => {
    setFormData((prev) => ({
      ...prev,
      [e.target.name]: e.target.value,
    }));
  };
 
  const handleLogin = async (e) => {
    e.preventDefault();

    try {
      await dispatch(login(formData)).unwrap();

      const id = getUserId();

      await dispatch(getLoggedInUser(id)).unwrap();

      toast.success("Login Success");
      navigate("/");
    } catch (error) {
      toast.error(error?.message || "Login Failed");
    }
  };
  return (
    <>
      <div className="flex min-h-screen items-center justify-center bg-gray-100 px-4">
        <div className="w-full max-w-md rounded-xl bg-white p-8 shadow-lg">
          {/* Heading */}
          <div className="mb-8 text-center">
            <h2 className="text-3xl font-bold text-[#45125f]">Welcome Back</h2>
            <p className="mt-2 text-sm text-gray-500">
              Login to continue shopping
            </p>
          </div>

          <form onSubmit={handleLogin}>
            {/* Username */}
            <div className="mb-5">
              <label className="mb-2 block text-sm font-medium text-gray-700">
                Username <span className="text-red-500">*</span>
              </label>

              <input
                type="username"
                name="username"
                value={formData.username}
                onChange={handleChange}
                placeholder="Enter username"
                className="w-full rounded-lg border border-gray-300 px-4 py-3 outline-none transition focus:border-[#45125f] focus:ring-2 focus:ring-[#45125f]/20"
              />
            </div>

            {/* Password */}
            <div className="mb-6">
              <label className="mb-2 block text-sm font-medium text-gray-700">
                Password <span className="text-red-500">*</span>
              </label>

              <input
                type="password"
                name="password"
                value={formData.password}
                onChange={handleChange}
                placeholder="Enter password"
                className="w-full rounded-lg border border-gray-300 px-4 py-3 outline-none transition focus:border-[#45125f] focus:ring-2 focus:ring-[#45125f]/20"
              />
            </div>

            {/* Login Button */}
            <button className="w-full rounded-lg bg-[#45125f] py-3 font-semibold text-white transition hover:bg-purple-800">
              Login
            </button>
          </form>
          <div className="mt-4 rounded-lg border border-red-300 bg-red-50 p-4">
            <p className="mb-2 text-sm font-semibold text-red-700">
              ⚠️ This is a learning project. These are demo credentials provided
              for testing purposes only. Please do not use any real personal or
              sensitive information.
            </p>

            <div className="rounded-md bg-white p-3 font-mono text-sm">
              <p>
                <span className="text-gray-700">Username:</span>{" "}
                <span className="font-semibold">johnd</span>
              </p>
              <p>
                <span className="text-gray-700">Password:</span>{" "}
                <span className="font-semibold">m38rmF$</span>
              </p>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default Login;
