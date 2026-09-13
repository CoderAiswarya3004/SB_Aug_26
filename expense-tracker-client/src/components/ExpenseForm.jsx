import axios from 'axios'
import React, { useState } from 'react'

const ExpenseForm = (getExpenses) => {

    const [title,setTitle] = useState('')
    const [category,setCategory] = useState('')
    const [price ,setPrice ] = useState('')
    const [date,setDate] = useState('')

    const handleSubmit =async (e) =>{
        e.preventDefault();

        if(!validate()) return
        // console.log("title",title)
        // console.log("category",category)
        // console.log("price",price)
        // console.log("date",date)
        const expense = {
            id:0,
            title,
            category,
            price, 
            date
        }
    
        await createExpense(expense);
    }

    async function createExpense(expense){
        try{
        const response =await axios.post("http://localhost:8080/expenses",expense)

        // fetch("url",{body:expense})

        if(response.status === 201)
        {
            getExpenses()
            clearForm()

        }else{
            alert("Something went wrong")
        }
        }
        catch(err)
        {
            console.log("Some Error occured:-",err)
        }
    }

    // const handleTitleChange =(e)
    const clearForm = () =>
    {
        setTitle(""),
        setPrice(""),
        setCategory(""),
        setDate("")
    }


    const handleChange = (e) => {
        // console.log(e.target.name,'->',e.target.value)

        const{name,value} = e.target

        switch(name){
            case 'title':
                setTitle(value)
                setErrors(prev => ({...prev,title:''}))
                break;
            case 'category':
                setCategory(value)
                setErrors(prev => ({...prev,category:''}))
                break;
            case 'price':
                setPrice(value)
                setErrors(prev => ({...prev,price:''}))
                break;
            case 'date':
                setDate(value)
                setErrors(prev => ({...prev,date:''}))
                break;
        }
        

    }

    const [errors,setErrors] = useState({})
    const validate =() =>{

        const newErrors={}

        if(!title)
        {
           newErrors.title='Title is missing.'
        } else if(title.length <=2)
        {
            newErrors.title='Title must have atleast 3 characters.'
        }
        if(!category)
        {
            newErrors.category='Please choose a valid category.'
        } 
        if(!price || isNaN(price) || price <=0)
        {
            newErrors.price='Price must be greater than 0.'
        }
        if(!date)
        {
            newErrors.date='Date is required.'
        }

        setErrors(newErrors)
        return Object.keys(newErrors).length === 0 //
    }
    // const handleTitleChange = (e) =>{
    //    setTitle(e.target.value)
    // }
    // const handleCategory = (e) =>{
    //    setCategory(e.target.value)
    // }

  return (
    <div className='bg-white rounded-2xl shadow-md p-6 mb-6'>
    <h2 className='text-xl font-semibold text-gray-700 mb-4'>Add Expense</h2>
    <form action={"www.google.com"} onSubmit={handleSubmit} className='grid grid-cols-1 md:grid-cols-2 gap-4'>
        {/* Title */}
        <div>
            <label htmlFor="" className='block font-medium text-gray-600 mb-1'>Title</label>
            <input placeholder='e.g;House Rent' name='title' type="text" className='border w-full border-gray-300 rounded-lg px-3 py-2 focus:outline-none focus:border-blue-500 ' onChange={handleChange} value={title}/>
            {/* <input name='title' type="text" className='border w-full border-gray-300 rounded-lg px-3 py-2 focus:outline-none focus:border-blue-500 ' onChange={handleTitleChange} value={title}/> */}
        </div>
         {
            errors.title && (
                <p className='text-red-500 mt-1 text-sm'>{errors.title}</p>
            )
        }

        {/* Category */}
         <div>
            <label htmlFor="" className='block font-medium text-gray-600 mb-1'>Category</label>
            <select name="category" id="" className='border w-full border-gray-300 rounded-lg px-3 
            py-2 focus:outline-none focus:border-blue-500 '
            // onChange={handleCategory}
            onChange={handleChange} value={category}>
                <option value="">-- Select Category --</option>
                <option value="food">Food</option>
                <option value="travel">Travel</option>
                <option value="utilities">Utilities</option>
                <option value="shopping">Shopping</option>
                <option value="entertaintment">Entertaintment</option>
                <option value="health">Health</option>
                <option value="education">Education</option>
                <option value="others">Others</option>
            </select>
        </div>

        {
            errors.category && (
                <p className='text-red-500 mt-1 text-sm'>{errors.category}</p>
            )
        }
        {/* Price */}
        <div>
            <label htmlFor="" className='block font-medium text-gray-600 mb-1'>Price</label>
            <input placeholder="e.g,5000.99" name='price' type="text" className='border w-full border-gray-300 rounded-lg px-3 py-2 focus:outline-none focus:border-blue-500 ' onChange={handleChange} value={price}/>
        </div>
         {
            errors.price && (
                <p className='text-red-500 mt-1 text-sm'>{errors.price}</p>
            )
        }

        {/* Date */}
        <div>
            <label htmlFor="" className='block font-medium text-gray-600 mb-1'>Date</label>
            <input placeholder=''  name='date' type="date" className='border w-full border-gray-300 rounded-lg px-3 py-2 focus:outline-none focus:border-blue-500' onChange={handleChange}  value={date}/>
        </div>
         {
            errors.date && (
                <p className='text-red-500 mt-1 text-sm'>{errors.date}</p>
            )
        }

        {/* Add Expense Button */}
        <div className='mt-5'>
            <button className='bg-green-500 hover:bg-green-600 px-6 py-4 rounded-lg text-white text-lg font-medium transition-colors duration-200'>Add Expense</button>
        
        </div>
    </form>
    </div>
  )
}

export default ExpenseForm