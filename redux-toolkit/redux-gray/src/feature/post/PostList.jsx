import {useSelector} from "react-redux";
import {selectAllPosts} from "./postSlice.js";
import AddPostForm from "./AddPostForm.jsx";


function PostList () {
    const posts = useSelector (selectAllPosts)



    const aric = `bg-gray-100 border border-slate-300 p-5 rounded-sm hover:bg-slate-200/80 cursor-pointer`;
    const sec = `max-w-7xl mx-auto grid grid-cols-1 sm:grid-cols-2 md:grid-cols-2 lg:grid-cols-3 gap-4`;
    return (
        <>
            <section className="px-20">
                <h2 className={`text-center font-semibold text-3xl py-3 text-emerald-500`}>List Of Post</h2>


                <div className="flex flex-col sm:flex-row gap-10">
                    <div className="w-full sm:w-[70%]">
                        <div className={sec}>
                            {posts.map((post) => (
                                <article key={post.id} className={aric}>
                                    <h2 className={`text-md font-semibold`}>{post.title.substring(0,20)}</h2>
                                    <p className={`text-xs`}>{post.content.substring(0,100)}</p>
                                </article>
                            ))}
                        </div>
                    </div>
                    <div className="w-full sm:w-[30%]">
                        <AddPostForm/>
                    </div>
                </div>


            </section>
        </>
    )
}

export default PostList;