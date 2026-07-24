import { useQuery } from '@tanstack/react-query';
import ProductCard from '../components/ProductCard';
import { useParams } from 'react-router-dom';
import { getAllProducts, getProductById } from '../api/products/product.api';
import { useEffect, useState } from 'react';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

export default function ProductDetails() {
    const { productsId } = useParams();
    const page = 1;
    const [limit, setLimit]  = useState<number>(12);


    const { data, error, isLoading } = useQuery({
        queryKey: ['products', productsId],
        queryFn: () => getProductById(Number(productsId)),
        enabled: !!productsId,
    });

     const { data: allProducts, isLoading: allProductsLoading, error : isError} = useQuery({
        queryKey: ['products', page, limit],
        queryFn: () => getAllProducts(page, limit),
    });


    useEffect(() => {
        if (error) {
            toast.error('Something went wrong');
        }
    }, [error]);
    if (isLoading) return <p>Loading........</p>;

    if (!data) return <>No Data found </>;

    // ---------------------------
   
    if (isError) {
        toast.error('Something went wrong');
    }
    if (allProductsLoading) return <p>Loading........</p>;

    if (!allProducts) return <>No Card Data found </>;

    return (
        <>
            <ProductCard product={data.data} />
            {/*  */}


            <div className="grid grid-cols-4 gap-4 px-5 max-w-7xl mx-auto mt-7 pt-20">

                {allProducts.data.data.map((product) => (
                    <ProductCard key={product.id} product={product} />
                ))}

            </div>

            <button onClick={() => setLimit((prev:number) => prev + 12)} >More products</button>




            <ToastContainer />
        </>
    );
}
