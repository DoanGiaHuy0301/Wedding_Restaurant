import { useContext, useEffect, useState } from "react";
import Apis, { authApi, endpoint } from "../../../configs/Apis";
import { Link, Navigate } from "react-router-dom";
import { format } from "date-fns";
import MySpinner from "../../../layout/MySpinner";
import { MyUserContext } from "../../../App";
import { Alert, Button, Modal } from "react-bootstrap";

const PayEmp = () => {
    const [taiKhoan, dispatch] = useContext(MyUserContext);
    const [thanhToan, setThanhToan] = useState(null);
    const [data, setData] = useState({});
    const [err, setErr] = useState(null);
    const [loading, setLoading] = useState(false);
    const [isSuccess, setIsSuccess] = useState(null);


    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    const urlParams = new URLSearchParams(window.location.search);
    const id = urlParams.get('id');


    const fetchThanhToanHoaDon = async (id) => {
        authApi().get(`${endpoint.hoaDonKhachHang}?id=${id}`)
            .then(res => {
                setThanhToan(res.data);
                console.log("--- fetchThanhToanHoaDon", res.data);
                console.log("tenLoaitiec", res.data.loaiTiec.tenLoaiTiec);
            })
            .catch(error => {
                console.error(error);
            });
    };

    const xacNhanThanhToan = (evt) => {
        evt.preventDefault();

        const process = async () => {
            let formData = new FormData();
            formData.append("id", thanhToan.id);
            formData.append("idTaiKhoanNV", taiKhoan.id);

            setLoading(true);
            try {
                let res = await authApi().post(endpoint['thanhToanHoaDon'], formData);
                console.log("thanhToan", res);
                if (res.status === 200) {
                    setData(res.data);
                    setLoading(false);
                    setIsSuccess(true);
                    handleClose();

                } else {
                    setErr("Thanh toán không thành công");
                    setLoading(false);

                }
            } catch (err) {
                setErr("Hệ thống đang bị lỗi!");
                setLoading(false);
                handleClose();
            }

        }
        process();
    };

    useEffect(() => {
        fetchThanhToanHoaDon(id);
    }, [id]);

    




    console.log("Thanh toan payEmp", thanhToan);
    console.log("Tài khoản", taiKhoan);



    if (taiKhoan === null || taiKhoan.vaiTro === "ROLE_USER" || !id) {
        return <Navigate to="/" />;
    }

    if (!thanhToan) {
        return <MySpinner />
    }


    return (
        <>
            <form onSubmit={xacNhanThanhToan}>
                <Modal show={show} onHide={handleClose}>
                    <Modal.Header closeButton>
                        <Modal.Title>Xác nhận thanh toán</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>Bạn có chắc muốn thanh toán không!</Modal.Body>
                    <Modal.Footer>
                        <Button variant="secondary" onClick={handleClose}>
                            Hủy
                        </Button>
                        {loading === true ? <MySpinner /> : isSuccess === true ? <alert variant="success">Bạn đã thanh toán thành công. <Link to="/employee">  Quay lại</Link> </alert> : <Button onClick={xacNhanThanhToan} variant="primary" > Xác nhận</Button>}

                    </Modal.Footer>
                </Modal>
            </form>
            <section className="container-bg" style={{ padding: '10px 100px' }}>

                <div className="row">
                    <h1 className="text-center mt-3">Thanh toán đặt tiệc</h1>
                    <div className="col-md-6 container" style={{}}>
                        <h3>Thông tin khách hàng</h3>
                        <ul>
                            <li className="bill_info">
                                Họ và tên khách hàng:
                                <p>{thanhToan.tenKhachHang}</p>
                            </li>
                            <li className="bill_info">
                                Số điện thoại:
                                <p>{thanhToan.soDienThoai}</p>
                            </li>
                            <li className="bill_info">
                                Địa chỉ:
                                <p>{thanhToan.diaChi}</p>
                            </li>
                        </ul>
                        <hr />
                        <h3>Thông tin đặt tiệc</h3>
                        <ul>
                            <li className="bill_info" >
                                Loại tiệc:
                                <p> {thanhToan.loaiTiec.tenLoaiTiec}</p>
                            </li>
                            <li className="bill_info" >
                                Loại sảnh: <p>{thanhToan.tenSanh.tenSanh}</p>
                            </li>
                            <li className="bill_info" >
                                Dịch vụ:
                                <p>{thanhToan.loaiDichVu.loaiDichVu}</p>
                            </li>
                            <li className="bill_info">
                                Thực đơn:
                                <p>{thanhToan.maThucDon.maThucDon}</p>
                            </li>
                            <li className="bill_info" >
                                Số lượng bàn: <p>{thanhToan.soLuongBan}</p>
                            </li>
                            <li className="bill_info">
                                Ngày tổ chức: <p> {format(thanhToan.ngayToChuc, 'dd/MM/yyyy')}</p>
                            </li>
                            <li className="bill_info" >
                                Buổi tổ chức: <p> {thanhToan.ca === "SA" ? "Buổi sáng" : thanhToan.ca === "CH" ? "Buổi chiều" : "Buổi tối"}</p>
                            </li>
                        </ul>
                    </div>
                    <div className="col-md-6" style={{}}>
                        <div>
                            <div className="bill_price">
                                <p>{thanhToan.tenSanh.tenSanh}:</p>
                                <p>{thanhToan.tongTienSanh.toLocaleString('vi-VN')} VND</p>
                            </div>
                            <div className="bill_price">
                                <p>{thanhToan.maThucDon.maThucDon}:</p>
                                <p>{thanhToan.maThucDon.giaGoi.toLocaleString('vi-VN')} VND</p>
                            </div>
                            <div className="bill_price">
                                <p>{thanhToan.maThucDon.maThucDon} = </p>
                                <p>{thanhToan.soLuongBan} * {thanhToan.maThucDon.giaGoi.toLocaleString('vi-VN')} VND</p>
                                <p>{thanhToan.tongTienThucDon.toLocaleString('vi-VN')} VND</p>
                            </div>
                            <div className="bill_price">
                                <p>{thanhToan.loaiDichVu.loaiDichVu}:</p>
                                <p>{thanhToan.loaiDichVu.giaDichVu.toLocaleString('vi-VN')} VND</p>
                            </div>
                            <div className="bill_price">
                                <h4><strong>Tiền cọc:</strong></h4>
                                <h4><strong>{thanhToan.tienCoc.toLocaleString('vi-VN')} VND</strong></h4>
                            </div>
                            <div className="bill_price">
                                <h4><strong>Tiền cọc:</strong></h4>
                                <h4><strong>{thanhToan.tienConLai.toLocaleString('vi-VN')} VND</strong></h4>
                            </div>
                            <div className="bill_price">
                                <h3><strong>Tổng tiền:</strong></h3>
                                <h3><strong>{thanhToan.tongTienHoaDon.toLocaleString('vi-VN')} VND</strong></h3>
                            </div>
                        </div>
                        <div className="mt-3 mb-3" style={{ width: '250px' }}>
                            {isSuccess === true ? <alert variant="success">Bạn đã thanh toán thành công. <Link to="/employee">  Quay lại</Link> </alert> : <button onClick={handleShow} className="btn btn-primary w-100 py-3 text-white"> Thanh toán</button>}
                            {isSuccess === true? "" : err === null ? "" : <Alert variant="danger">{err}</Alert>}
                        </div>
                    </div>

                </div>

            </section>

        </>
    )
}

export default PayEmp;