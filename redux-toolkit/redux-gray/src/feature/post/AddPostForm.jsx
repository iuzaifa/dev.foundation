import {useState} from "react";
import {useDispatch} from "react-redux";
import {postAdded} from "./postSlice.js";


function AddPostForm() {

    const [title, setTitle] = useState('');
    const [content, setContent] = useState('');

    const dispatch = useDispatch();

    const onPostTitleChange = (e) => setTitle(e.target.value);
    const onPostContentChange = (e) => setContent(e.target.value);

    console.log("title", title);
    console.log("content", content);

    const handleSaveNewPost = () => {
        if(title && content) {
            dispatch(
                postAdded(title, content)
            );
            setTitle(``)
            setContent(``);
        }
    }

    const btn = `px-6 py-2 bg-emerald-700 hover:bg-emerald-800 text-white cursor-pointer`
    return (
        <>
            <section className="bg-gray-300 rounded-sm p-5">
                <h2 className={`font-semibold text-xl`}>Add New Post</h2>
                <form>

                    <label htmlFor="postTitle">Post Title</label>
                    <input type={`text`} id={`postTitle`} name={`postTitle`} value={title} onChange={onPostTitleChange} className={`w-full h-10 my-1  text-xs bg-gray-400 px-4`} placeholder={`Enter title of post`}/>

                    <label htmlFor="postContent">Description</label>
                    <textarea id={`postContent`} name={`postContent`} value={content} onChange={onPostContentChange} className={`w-full py-4 my-1 text-xs bg-gray-400 px-4`}  rows={5} placeholder={`Enter content of post`}/>

                    <button type={"button"} onClick={handleSaveNewPost} className={btn}>Save Post</button>
                </form>

            </section>
        </>
    )
}

export default AddPostForm;