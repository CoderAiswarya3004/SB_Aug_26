import React from 'react'

const Summary = ({expenses}) => {
  const totalExpense = expenses.reduce((accum,exp)=> exp.price+accum,0) 

  return (
    <div className='bg-white rounded-2xl shadow-md p-6 mb-6'>
    <h2 className='text-xl font-semibold text-gray-700 mb-4'>summary</h2>

      <div className='grid grid-cols-1 md:grid-cols-2 gap-4'>
        {/* Total Expense */}
        <div className='bg-blue-50 border-blue-200 rounded-xl p-4 flex items-center gap-4'>
          <div className='text-3xl'>💰</div>
          <div>
          <p className='font-medium text-gray-500 text-sm'>Total Expense</p>
          <p className='text-2xl text-blue-600 font-bold'>{totalExpense}</p>
          </div>
        </div>

        {/* Total Enteries */}
        <div className='bg-green-50 border-green-200 rounded-xl p-4 flex items-center gap-4'>
          <div className='text-3xl'>📋</div>
          <div>
          <p className='font-medium text-gray-500 text-sm'>Total Enteries</p>
          <p className='text-2xl text-blue-600 font-bold'>{expenses.length}</p>
          </div>
        </div>
      </div>
    </div>
  )
}

export default Summary