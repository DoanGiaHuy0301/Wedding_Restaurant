import { BrowserRouter, Route, Routes } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import React, { createContext, useReducer } from "react";
import Cookies from "universal-cookie";
import BaseLayout from "./layout/BaseLayout";
import Home from "./components/Home";
import Login from "./components/Login/Login";
import Register from "./components/Resgister/Register";
import MyUserReducer from "./reducers/MyUserReducer";
import Menu from "./components/Menu/Menu";
import Booking from "./components/Booking/Booking";
import About from "./components/About/about";
import Lobby from "./components/Lobby/Lobby";
import Feedback from "./components/Feedback/Feedback";
import Event from "./components/Event/Event";
import Service from "./components/Service/Service";
import Search from "./components/Search/Search";
import Bill from "./components/Bill/Bill";
import PayMomo from "./components/PayMomo/PayMomo";
import Employee from "./components/Employee/Employee";
import SearchEmp from "./components/Employee/SearchEmp/SearchEmp";
import PayEmp from "./components/Employee/PayEmp/PayEmp";

export const MyUserContext = createContext();

const App = () => {
  const cookies = new Cookies();
  const user = cookies.get('userData');
  const [taiKhoan, dispatch] = useReducer(MyUserReducer, user || null);


  return (
    <MyUserContext.Provider value={[taiKhoan, dispatch]}>

      <BrowserRouter>
        <Routes>
            <Route path="/" element={<BaseLayout><Home /></BaseLayout>} />
            <Route path="/menu" element={<BaseLayout><Menu /></BaseLayout>} />
            <Route path="/booking" element={<BaseLayout><Booking /></BaseLayout>} />
            <Route path="/about" element={<BaseLayout><About /></BaseLayout>} />
            <Route path="/lobby" element={<BaseLayout><Lobby /></BaseLayout>} />
            <Route path="/service" element={<BaseLayout><Service /></BaseLayout>} />
            <Route path="/event" element={<BaseLayout><Event /></BaseLayout>} />
            <Route path="/search" element={<BaseLayout><Search /></BaseLayout>} />
            <Route path="/feedback" element={<BaseLayout><Feedback /></BaseLayout>} />
            <Route path="/bill" element={<BaseLayout><Bill /></BaseLayout>} />
            <Route path="/employee" element={<BaseLayout><Employee /></BaseLayout>} />
            <Route path="/searchEmp" element={<BaseLayout><SearchEmp /></BaseLayout>} />
            <Route path="/payEmp" element={<BaseLayout><PayEmp /></BaseLayout>} />
            <Route path="/login" element={<Login />} />
            <Route path="/register" element={<Register />} />
            <Route path="/payMomo" element={<PayMomo />} />
           
        </Routes>
      </BrowserRouter>
    </MyUserContext.Provider>
  )
}

export default App;