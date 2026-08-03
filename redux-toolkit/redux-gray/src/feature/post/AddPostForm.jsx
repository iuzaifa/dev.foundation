import {useState} from "react";
import {useDispatch, useSelector} from "react-redux";
import {postAdded} from "./postSlice.js";
import {selectAllUsers} from "../users/usersSlice.js"


function AddPostForm() {

    const [title, setTitle] = useState('');
    const [content, setContent] = useState('');
    const [userId, setUserId] = useState('');

    const users = useSelector(selectAllUsers)
    console.log("users", users)
    const dispatch = useDispatch();

    const onPostTitleChange = (e) => setTitle(e.target.value);
    const onPostContentChange = (e) => setContent(e.target.value);
    const onAutherChange = (e) => setUserId(e.target.value);

    console.log("title", title);
    console.log("content", content);

    const handleSaveNewPost = () => {
        if(title && content) {
            dispatch(
                postAdded(title, content, userId)
            );
            setTitle(``)
            setContent(``);
        }
    }

    const canSavePost = Boolean(title) && Boolean(content) && Boolean(userId);

    const userOptions = users.map(user => (
        <option key={user.id} value={user.id}>
            {user.name}
        </option>
    ))

    console.log("userOptions", userOptions)

    const btn = `px-6 py-2 bg-emerald-700 text-white ${
        canSavePost
            ? "cursor-pointer hover:bg-emerald-900/40"
            : "cursor-not-allowed opacity-50"
        }`;

    return (
        <>
            <section className="bg-gray-300 rounded-sm p-5">
                <h2 className={`font-semibold text-xl`}>Add New Post</h2>
                <form>

                    <label htmlFor="postTitle">Post Title</label>
                    <input type={`text`} id={`postTitle`} name={`postTitle`} value={title} onChange={onPostTitleChange} className={`w-full h-10 my-1  text-xs bg-gray-400 px-4`} placeholder={`Enter title of post`}/>

                    <label htmlFor="postAuthor">Select Author</label>
                    <select name="postAuthor" value={userId} onChange={onAutherChange} id="postAuthor"  className={`w-full h-10 my-1  text-xs bg-gray-400 px-4`}>
                        <option>select user</option>
                        {userOptions}
                    </select>
                    
                    <label htmlFor="postContent">Description</label>
                    <textarea id={`postContent`} name={`postContent`} value={content} onChange={onPostContentChange} className={`w-full py-4 my-1 text-xs bg-gray-400 px-4`}  rows={5} placeholder={`Enter content of post`}/>

                    <button disabled={!canSavePost} type={"button"} onClick={handleSaveNewPost} className={btn}>Save Post</button>
                </form>

            </section>
        </>
    )
}

export default AddPostForm;