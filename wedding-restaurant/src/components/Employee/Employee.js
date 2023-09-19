import { useContext } from "react";
import SearchEmp from "./SearchEmp/SearchEmp";
import { MyUserContext } from "../../App";
import { Navigate } from "react-router-dom";

const Employee = () => {
    const [taiKhoan, dispatch] = useContext(MyUserContext);

    if (taiKhoan === null || taiKhoan.vaiTro === "ROLE_USER") {
        return <Navigate to="/" />;
    }
    return (
        <>
            <div className="container-bg">
                <h1 className="text-center text-success">Chào mừng bạn đến trang nhân viên nhà hàng tiệc cưới GH - WEDDING RESTAURANT</h1>
            </div>
            <SearchEmp />
        </>
    )
}

export default Employee;