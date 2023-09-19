import '../Menu/Menu.css';
import '../Menu/bootstrap.min.css';
import b from "../../image/line-hoang-long-restaurant.png"
import anhNenThucDon from "../../image/banner-thuc-don.jpg";
import { useContext, useEffect, useState } from 'react';
import Apis, { authApi, endpoint } from '../../configs/Apis';
import MySpinner from '../../layout/MySpinner';
import { Link, useNavigate } from 'react-router-dom';
import { Alert } from 'react-bootstrap';
import { MyUserContext } from '../../App';

const Booking = () => {

    const [loaiTiec, setLoaiTiec] = useState(null);
    const [dichVu, setDichVu] = useState(null);
    const [thongTinSanh, setThongTinSanh] = useState(null);
    const [thucDon, setThucDon] = useState(null);

    const [loading, setLoading] = useState(false);
    const [data, setData] = useState({});
    const [taiKhoan,] = useContext(MyUserContext);
    const [err, setErr] = useState(null);
    const [isSuccess, setIsSuccess] = useState(null);
    const nav = useNavigate();
    const [book, setBook] = useState({
        "tenKhachHang": "",
        "ngayToChuc": "",
        "soDienThoai": "",
        "diaChi": "",
        "loaiTiecId": "",
        "thucDonId": "",
        "dichVuId": "",
        "sanhId": "",
        "ca": "",
        "soLuongBan": ""
    });

    const change = (evt, field) => {
        setBook(current => {
            return { ...current, [field]: evt.target.value };
        });
    }

    const loadLoaiTiec = async () => {
        let res = await Apis.get(endpoint['loaiTiec']);
        setLoaiTiec(res.data);
       
    }

    const loadDichVu = async () => {
        let res = await Apis.get(endpoint['dichVu']);
        setDichVu(res.data);
    }
    const loadThongTinSanh = async () => {
        let res = await Apis.get(endpoint['thongTinSanh']);
        setThongTinSanh(res.data);
    }
    const loadThucDon = async () => {
        let res = await Apis.get(endpoint['thucDon']);
        setThucDon(res.data);
    }

    const datTiec = (evt) => {
        evt.preventDefault();

        if (book.tenKhachHang.trim() === '') {
            alert('Vui lòng nhập nội.');
            return;
        }

        const process = async () => {
            let formData = new FormData();
            for (let field in book)
                formData.append(field, book[field]);


            setLoading(true);
            try {
                let res = await authApi().post(endpoint['datTiec'], formData);
                if (res.status === 201) {
                    setData(res.data);
                    setIsSuccess(true);
                    setLoading(false);
                }  else {
                    setErr("Hệ thống đang bận, vui lòng đặt bàn sau!");
                    setLoading(false);
                }
            } catch (error) {
                setErr("Hệ thống đang bị lỗi!");
                setLoading(false);
                console.log(error);
            }
           
           
        }
        
        process();
    };



    useEffect(() => {
        loadLoaiTiec();
        loadDichVu();
        loadThongTinSanh();
        loadThucDon();
    }, [])


    if (loaiTiec === null || thongTinSanh === null || dichVu === null || thucDon === null)
        return <MySpinner />;


    let url = `/login?next=/booking`;
    let urlThanhToan = `/bill?id=${data.id}`;
    return (
        <>
            <div className="container-xxl py-5 container-bg">
                <div className="containe">
                    <div className="row g-5 align-items-center">
                        <div className="col-lg-6">
                            <h1 className="mb-4 text-center "><span className="title-about text-uppercase">Đặt tiệc</span></h1>
                            <p className="mb-4 text-center">Mỗi một món ăn đều được các đầu bếp chế biến theo khẩu vị khác nhau từ món thuần Việt đến ẩm thực Á – Âu, đảm bảo làm hài lòng cả những thực khách khó tính nhất.</p>
                        </div>
                        <div className="col-lg-6">
                            <img src={anhNenThucDon} />
                        </div>
                    </div>
                </div>
            </div>

            <section>
                <div className="container container-bg">
                    <div className="row">
                        <div className="col-md-12">
                            <div className="mt-3">
                                <img src={b} />
                            </div>
                            <h1 className="text-center mt-5 title-about">Đặt tiệc</h1>
                            <form onSubmit={datTiec}>
                                <div className="row g-3" style={{ textAlign: 'center' }}>
                                    <h4>Thông tin liên hệ</h4>
                                    {err === null ? "" : <Alert variant="danger">{err}</Alert>}
                                    <div className="col-md-6">
                                        <div className="form-floating">
                                            <input type="text" className="form-control" id="name" placeholder="Họ và tên" value={book.tenKhachHang}
                                                onChange={e => change(e, "tenKhachHang")} />
                                            <label htmlFor="name">Họ và tên</label>
                                        </div>
                                    </div>
                                    <div className="col-md-6">
                                        <div className="form-floating">
                                            <input type="text" className="form-control" id="email" placeholder="Số điện thoại" value={book.soDienThoai}
                                                onChange={e => change(e, "soDienThoai")} />
                                            <label htmlFor="email">Số điện thoại</label>
                                        </div>
                                    </div>
                                    <div className="col-md-6">
                                        <div className="form-floating date" id="date3" data-target-input="nearest">
                                            <input type="Date" className="form-control" id="checkin" placeholder="Ngày tổ chức" value={book.ngayToChuc}
                                                onChange={e => change(e, "ngayToChuc")} />
                                            <label htmlFor="checkin">Ngày tổ chức</label>
                                        </div>
                                    </div>
                                    <div className="col-md-6">
                                        <div className="form-floating">
                                            <input type="text" className="form-control" id="diaChi" placeholder="Địa chỉ" value={book.diaChi}
                                                onChange={e => change(e, "diaChi")} />
                                            <label htmlFor="diaChi">Địa chỉ</label>
                                        </div>
                                    </div>
                                    <h4>Thông tin sự kiện</h4>
                                    <div className="col-md-6">
                                        <div className="form-floating">
                                            <select className="form-select" value={book.loaiTiecId} id="select1" onChange={e => change(e, "loaiTiecId")}>
                                                <option value="">Chọn loại tiệc</option>
                                                {loaiTiec.map(lt =>
                                                    <option value={lt.id} key={lt.id} >{lt.tenLoaiTiec}</option>
                                                )}
                                            </select>
                                            <label htmlFor="select1">Loại tiệc</label>
                                        </div>
                                    </div>
                                    <div className="col-md-6">
                                        <div className="form-floating">
                                            <select className="form-select" id="select2" value={book.thucDonId} onChange={e => change(e, "thucDonId")}>
                                                <option value="">Chọn thực đơn</option>
                                                {thucDon.map(td =>
                                                    <option value={td.id} key={td.id} >{td.maThucDon}</option>
                                                )}
                                            </select>
                                            <label htmlFor="select2">Thực đơn</label>
                                        </div>
                                    </div>
                                    <div className="col-md-6">
                                        <div className="form-floating">
                                            <select className="form-select" id="select2" value={book.ca} onChange={e => change(e, "ca")}>
                                                <option value="" selected>Chọn buổi ...</option>
                                                <option value="SA">Buổi sáng</option>
                                                <option value="CH">Buổi chiều</option>
                                                <option value="T">Buổi tối</option>
                                            </select>
                                            <label htmlFor="select2">Buổi tổ chức</label>
                                        </div>
                                    </div>
                                    <div className="col-md-6">
                                        <div className="form-floating">
                                            <input type="number" className="form-control" id="soLuongBan" placeholder="soLuongBan" value={book.soLuongBan}
                                                onChange={e => change(e, "soLuongBan")} />
                                            <label htmlFor="soLuongBan">Số lượng bàn</label>
                                        </div>
                                    </div>
                                    <div className="col-12">
                                        <div className="form-floating">
                                            <select className="form-select" id="select3" value={book.sanhId} onChange={e => change(e, "sanhId")}>
                                                <option value="">Chọn sảnh</option>
                                                {thongTinSanh.map(s =>
                                                    <option value={s.id} key={s.id} >{s.tenSanh}</option>
                                                )}
                                            </select>
                                            <label htmlFor="select3">Loại sảnh</label>
                                        </div>
                                    </div>
                                    <div className="col-12">
                                        <div className="form-floating">
                                            <select className="form-select" id="select3" value={book.dichVuId} onChange={e => change(e, "dichVuId")}>
                                                <option value="">Chọn dịch vụ</option>
                                                {dichVu.map(dv =>
                                                    <option value={dv.id} key={dv.id} >{dv.loaiDichVu}</option>
                                                )}
                                            </select>
                                            <label htmlFor="select3">Dịch vụ</label>
                                        </div>
                                    </div>
                                    <div className="col-3 mt-2 mb-2">
                                        {taiKhoan === null ? <p>Vui lòng <Link to={url}>đăng nhập</Link> để đặt tiệc! </p> : <>
                                            {loading === true ? <MySpinner /> : isSuccess === true ? null :<button className="btn btn-primary w-100 py-3" type="submit">Đặt tiệc</button>}
                                        </>}

                                    </div>
                                    {isSuccess === null ? "" : <Alert variant="success">Bạn đã đặt tiệc thành công. Vui lòng đến nhà hàng để đặt cọc hoặc thanh toán online <Link to={urlThanhToan}>Tại đây</Link>.</Alert>}
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </section>

        </>
    )
}

export default Booking;