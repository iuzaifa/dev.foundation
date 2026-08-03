import { useSelector } from "react-redux";
import { selectAllUsers } from "../users/usersSlice";




const PostAuther = ({userID}) => {
    const users = useSelector(selectAllUsers);
    const author = users.find(user => user.id === userID);

  return (
    <>
        <span>by {author ? author.name : "Unkonwn Author"}</span>
    </>
  )
}

export default PostAuther