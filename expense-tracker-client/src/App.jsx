import axios from "axios"
import ExpenseForm from "./components/ExpenseForm"
import ExpenseList from "./components/ExpenseList"
import Footers from "./components/Footers"
import Header from "./components/Header"
import Summary from "./components/Summary"
import { useEffect, useState } from "react"
import expenseService from "./services/expenseService"

export default function App() {

  const [expenses, setExpenses] = useState([])
  const [editingExpense, setEditingExpense] = useState(null)

  const getExpenses = async () => {
    try {
      const response = await expenseService.getExpenses()
      setExpenses(response.data)
      console.log("response is", response.data)

      // fetch("http://localhost:8080/expenses",{
      // method:{GET}
      // }).then().then()
    }
    catch (err) {
      console.log("some Error Occured:-", err)
    }
  }

  useEffect(() => {
    getExpenses();
  }, [])

  return (
    <div className="min-h-screen bg-gray-100">
      {/* <h1 className="bg-red-500">Our First FullStack Project</h1> */}
      <Header />
      <main className="max-w-4xl mx-auto py-4 mt-4">
        <ExpenseForm getExpenses={getExpenses} editingExpense={editingExpense} setEditingExpense={setEditingExpense} />
        <Summary expenses={expenses} />
        <ExpenseList expenses={expenses} getExpenses={getExpenses} setEditingExpense={setEditingExpense} />
      </main>

      {/* <Footer/> */}
      <Footers />
    </div>
  )
}