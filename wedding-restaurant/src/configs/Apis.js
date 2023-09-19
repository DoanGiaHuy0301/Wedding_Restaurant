import axios from "axios";
import Cookies from "universal-cookie";

const SERVER = "http://localhost:8080";

export const endpoint = {
    "loaiTiec": `/api/loaiTiec/`,
    "dichVu": `/api/dichVu/`,
    "thongTinSanh": `/api/thongTinSanh/`,
    "thucDon": `/api/thucDon/`,
    "login": `/api/login/`,
    "currentUser": `/api/current-user/`,
    "anhSanh": `/api/anhSanh/`,
    "register": `/api/users/`,
    "username-exist": `/api/username-exist/`,
    "phanHoiKhachHang": `/api/phanHoiKhachHang/`,
    "datTiec": `/api/datTiec/`,
    "thanhToan": `/api/thanhToan/`,
    "hoaDonKhachHang":  `/api/hoaDonKhachHang/`,
    "daThanhToan": `/api/daThanhToan/`,
    "thanhToanMomo": `/api/thanhToanMomo/`,
    "thongTinSanhChuaDat": `/api/thongTinSanhChuaDat/`,
    "hoaDon": `/api/hoaDon/`,
    "thanhToanHoaDon": `/api/thanhToanHoaDon/`,
    "phieuDatBan": `/api/phieuDatBan/`,


}



export const authApi = () => {

    const cookies = new Cookies();
    const token = cookies.get('accessToken');

    return axios.create({
        baseURL: SERVER,
        headers: {
            "Authorization":  token
        }
    })
}
export default axios.create({
    baseURL: SERVER,
    
})