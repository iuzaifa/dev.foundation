import Counter from "./Counter";
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';


export default function TestApp (){
    return (
        <>
            <div className="max-w-5xl mx-auto text-[#c9c9c9d1] mt-5">
                <h5 className="text-center font-bold text-lg mb-5">Learning Redux</h5>

                <Counter/>




            </div>

            <ToastContainer position="top-right" autoClose={2000} />

        </>
    )
}