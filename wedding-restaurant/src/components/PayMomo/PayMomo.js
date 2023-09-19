import { useEffect, useState } from "react";
import Apis, { authApi, endpoint } from "../../configs/Apis";
import momoImg from "../../image/momo.jpg";
import MySpinner from "../../layout/MySpinner";
import { format } from "date-fns";
import { Alert } from "react-bootstrap";
import { Link } from "react-router-dom";

const PayMomo = () => {

    const [thanhToan, setThanhToan] = useState(null);
    const [err, setErr] = useState(null);
    const [loading, setLoading] = useState(false);
    const [data, setData] = useState({});
    const [inputVisible, setInputVisible] = useState(false);
    const [isSuccess, setIsSuccess] = useState(null);
    const [isPay, setIsPay] = useState(false);
    const [payCode, setPayCode] = useState({
        "maThanhToan": ""
    });

    const change = (evt, field) => {
        setPayCode(current => {
            return { ...current, [field]: evt.target.value };
        });
    }

    const handleConfirmPayment = () => {
        setInputVisible(true);
    };

    const urlParams = new URLSearchParams(window.location.search);
    const id = urlParams.get('id');


    const fetchThanhToanHoaDon = async (id) => {
        Apis.get(`${endpoint.thanhToan}?id=${id}`)
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
            for (let field in payCode) {
                formData.append(field, payCode[field]);
            }
            formData.append("id", id);



            setLoading(true);
            try {
                let res = await authApi().post(endpoint['thanhToanMomo'], formData);
                console.log("thanhToan", res);
                if (res.status === 200) {
                    setData(res.data);
                    setLoading(false);
                    setIsSuccess(true);
                    setIsPay(true);
                } else {
                    setErr("Mã thanh toán không hợp lệ. Vui lòng kiểm tra lại");
                    setLoading(false);
                    setIsPay(false);
                }
            } catch (error) {
                setErr("Hệ thống đang bị lỗi!");
                setLoading(false);
                setIsPay(false);
                console.log(error);
            }


        }
        process();
    };

    useEffect(() => {
        fetchThanhToanHoaDon(id);
    }, [id, isPay]);

    

    if (!thanhToan) {
        return <MySpinner />;
    }

    console.log(thanhToan.ngayDatCoc);
    return (
        <>
            <section className="container">
                <div className="row">
                    <div className="col-md-6 mt-5 text-center" style={{ padding: ' 0 100px' }}>

                        <img alt="Mã momo" src={momoImg} />
                        <div className="mt-3 mb-3 mx-auto text-center" style={{ width: '250px' }}>
                            { (isPay && thanhToan.tienCoc > 0) ? <div> <span>Phiếu đã thanh toán</span>
                                <Alert variant="success">Bạn đã thanh toán thành công. Quay lại <Link to="/">trang chủ</Link> </Alert>
                                </div>:
                                <button type="submit" className="btn btn-primary w-100 py-3 text-white"
                                    onClick={handleConfirmPayment}
                                    disabled={inputVisible}
                                >Xác nhận thanh toán</button>
                             }

                            </div>

                            {inputVisible && (
                                <form onSubmit={xacNhanThanhToan}>
                                    <div>
                                        <div className="col-md-6">
                                            <div className="form-floating">
                                                <input type="text" className="form-control" id="maGiaoDich" placeholder="Mã giao dịch"
                                                    value={payCode.maThanhToan}
                                                    onChange={e => change(e, "maThanhToan")} />
                                                <label htmlFor="name">Mã giao dịch</label>
                                            </div>
                                            {err === null ? "" : <Alert variant="danger">{err}</Alert>}
                                        </div>
                                        <div className="mt-3 mb-3" style={{ width: '150px' }}>
                                            {loading === true ? <MySpinner /> : isSuccess === true ? null : <button type="submit" className="btn btn-primary w-100 py-3 text-white">Xác nhận</button>}
                                            {isSuccess === null ? "" : <Alert variant="success">Bạn đã thanh toán thành công. Quay lại <Link to="/">trang chủ</Link> </Alert>}
                                        </div>
                                    </div>
                                </form>
                            )}


                        </div>
                        <div className="col-md-6 mt-5">
                            <div>
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
                            <hr />
                            <div>
                                <h2 className="text-center mt-5 mb-3">Thanh toán online</h2>
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
                                    <h3><strong>Tổng tiền:</strong></h3>
                                    <h3><strong>{thanhToan.tongTienHoaDon.toLocaleString('vi-VN')} VND</strong></h3>
                                </div>
                            </div>
                        </div>
                    </div>
            </section>

        </>
    )
}

export default PayMomo;