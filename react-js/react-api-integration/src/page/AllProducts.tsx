import { useQuery } from "@tanstack/react-query";
import { Table, type Column } from "../components/Table";
import type { Product } from "../types/products.type";
import { getAllProducts } from "../api/products/product.api";
import { useEffect, useState } from "react";
import { toast } from "react-toastify";
import { TableSkeleton } from "../components/skeletons/SkeletonTable";
import { ChevronLeft, ChevronRight, Eye } from 'lucide-react';
import { useNavigate } from "react-router-dom";

const columns : Column<Product>[] =[
    {
        header : "Sr No.",
        accessor : "id"
    },
    {
        header: "Title",
        accessor: "title",
        className : "text-left w-30 text-wrap text-xs"
    },
     {
        header: "Description",
        // accessor: "description",
        render: (product) =>
            product.description.length > 255
            ? product.description.substring(0, 255) + "..."
            : product.description,

        className : "text-left w-72 text-xs text-wrap"
    },
    {
        header : "Price",
        accessor : "price",
        className : "text-xs font-bold"
    },
    {
        header : "Discount %",
        accessor : "discountPercentage",
        className : "text-xs font-bold"

    },
    {
        header : "Rating",
        accessor : "rating",
        className : "text-xs font-bold"

    },
    {
        header : "Stock",
        accessor : "stock",
        className : "text-xs font-bold"

    },
    {
        header : "Brand",
        accessor : "brand",
        className : "text-xs"

    },
    {
        header : "Category",
        accessor : "category",
        className : "text-xs"
    },
    {
        header : "Images",
        render : (product) => (<img className="h-10 w-10" src={product.thumbnail} /> ),
        className : "py-1.5"
    }

]


export function AllProducts () {
    const navigate = useNavigate();

    const [page, setPage] = useState<number>(1);
    const limit = 15;

    const {data, isLoading, error} = useQuery({
        queryKey : ["products", page, limit],
        queryFn : () => getAllProducts(page, limit),
    })

    useEffect(() => {
        if (error) {
            toast.error("Failed to get products");
        } else {
            toast.dismiss();
        }
    }, [error]);

    if(isLoading) return <TableSkeleton/>



    return (
        <>

            <Table columns={columns} data={data?.data.data ?? []} actions={(product) => (
                <>
                    <div className="flex justify-center">
                        <button onClick={() => navigate(`/products/${product.id}`)}
                        className="bg-green-200 text-center flex justify-center text-green-600 p-2 rounded cursor-pointer">
                        <Eye size={15}/>
                    </button>
                    </div>
                </>
            )} />

            
            <div className="flex items-center justify-center gap-3 select-none mt-6">
            {/* Previous */}
            <button
                onClick={() => setPage((prev) => prev - 1)}
                disabled={data?.data.page === 1}
                className="flex items-center justify-center w-10 h-10 rounded-full border border-gray-300 bg-white text-gray-700 hover:bg-gray-50 hover:border-gray-400 disabled:opacity-40 disabled:cursor-not-allowed transition-all duration-200 shadow-sm"
            >
                <ChevronLeft size={20} strokeWidth={2.5} />
            </button>

            {/* Current page / Total pages – with gradient pill */}
            <div className="px-5 py-2 rounded-full bg-gradient-to-r from-blue-500 to-indigo-600 text-white font-semibold text-sm shadow-md min-w-[80px] text-center">
               {data?.data.totalPages} /  {data?.data.page} 
            </div>

            {/* Next */}
            <button
                onClick={() => setPage((prev) => prev + 1)}
                disabled={data?.data.page === data?.data.totalPages}
                className="flex items-center justify-center w-10 h-10 rounded-full border border-gray-300 bg-white text-gray-700 hover:bg-gray-50 hover:border-gray-400 disabled:opacity-40 disabled:cursor-not-allowed transition-all duration-200 shadow-sm"
            >
                <ChevronRight size={20} strokeWidth={2.5} />
            </button>


            </div>
        
        </>
    )
}

