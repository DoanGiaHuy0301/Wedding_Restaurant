import { useState } from "react";
import { Button, Col, Form, Row, Table } from "react-bootstrap";
import Apis, { endpoint } from "../../../configs/Apis";
import { format } from "date-fns";
import { Link } from "react-router-dom";

const SearchEmp = () => {

    const [hoaDon, setHoaDon] = useState();
    const [soDienThoai, setSoDienThoai] = useState("");

    const timKiemHoaDon = async (evt) => {
        evt.preventDefault();
        Apis.get(`${endpoint.hoaDon}?soDienThoai=${soDienThoai}`)
        .then(res => {
            setHoaDon(res.data);
            console.log("searchHoaDon",res.data);

        })
        .catch(error => {
            console.error(error);
        });
    }

    
    
    return (
        <>
            <section>
                <div className="container container-bg" style={{padding:'50px 0'}}>
                    <div className="row">
                        <div className="col-md-12 mb-5" style={{padding:'0 50px'}}>
                            <Form onSubmit={timKiemHoaDon} inline>
                                <Row>
                                    <p>Nhập số điện thoại: </p>
                                    <Col xs="auto">
                                        <Form.Control
                                            type="text"
                                            placeholder="Search"
                                            className=" mr-sm-2"
                                            value={soDienThoai}
                                            onChange={e => setSoDienThoai(e.target.value)}
                                        />
                                    </Col>
                                    <Col xs="auto">
                                        <Button type="submit">Tìm kiếm</Button>
                                    </Col>
                                </Row>
                            </Form>
                        </div>

                    </div>
                    <div className="container-bg ">
                        <div className="container">
                            <div className="table-responsive">
                                <Table responsive="sm">
                                    <thead>
                                        <tr>
                                            <th>Tên khách hàng</th>
                                            <th>
                                                Số điện thoại
                                            </th>
                                            <th>
                                                Địa chỉ
                                            </th>
                                            <th>Ngày dặt tiệc</th>
                                            <th>Tiền cọc</th>
                                            <th>Tiền còn lại</th>
                                            <th>Tổng tiền</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>

                                        {hoaDon === undefined ? "Không có hóa đơn nào!!" : hoaDon.map(t => <>
                                            <tr key={t.id}>
                                                <td >{t.tenKhachHang}</td>
                                                <td>{t.soDienThoai}</td>
                                                <td>{t.diaChi}</td>
                                                <td>{format(t.ngayDatCoc, 'dd/MM/yyyy')}</td>
                                                <td>{t.tienCoc.toLocaleString('vi-VN')} VND</td>
                                                <td>{t.tienConLai.toLocaleString('vi-VN')} VND</td>
                                                <td>{t.tongTienHoaDon.toLocaleString('vi-VN')} VND</td>
                                                <td>
                                                    <Link type="button" to={`/payEmp?id=${t.phieuDatBanId}`} className="btn btn-primary w-100" style={{margin:'0'}}>Thanh toán</Link>
                                                </td>
                                            </tr>
                                        </>
                                        )}

                                    </tbody>
                                </Table>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </>
    )
}

export default SearchEmp;