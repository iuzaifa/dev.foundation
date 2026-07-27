import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getLoggedInUser } from "../store/authSlice";
import { getUserId } from "../utils/auth";

const Profile = () => {
  const dispatch = useDispatch();

  const { isLoggedIn, user, loading } = useSelector(
    (state) => state.auth
  );

  const id = getUserId();

  useEffect(() => {
    if (isLoggedIn && id) {
      dispatch(getLoggedInUser(id));
    }
  }, [dispatch, isLoggedIn, id]);

  if (loading) return <h2>Loading...</h2>;

  if (!user) return <h2>No profile found</h2>;

  return (
    <div className="max-w-md mx-auto mt-24 rounded-lg border p-6 shadow">
      <h2 className="mb-4 text-2xl font-bold">Profile</h2>

      <p>
        <strong>Name:</strong> {user.name.firstname} {user.name.lastname}
      </p>

      <p>
        <strong>Username:</strong> {user.username}
      </p>

      <p>
        <strong>Email:</strong> {user.email}
      </p>

      <p>
        <strong>Phone:</strong> {user.phone}
      </p>

      <p>
        <strong>Street:</strong> {user.address.street}
      </p>

      <p>
        <strong>City:</strong> {user.address.city}
      </p>

      <p>
        <strong>Zipcode:</strong> {user.address.zipcode}
      </p>
    </div>
  );
};

export default Profile;