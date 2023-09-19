import { useContext, useState } from "react";
import anhNenThucDon from "../../image/banner-thuc-don.jpg";
import anh1 from "../../image/line-hoang-long-restaurant.png";
import { authApi, endpoint } from "../../configs/Apis";
import { MyUserContext } from "../../App";
import { Link } from "react-router-dom";
import { Alert } from "react-bootstrap";

const Feedback = () => {
    const [taiKhoan,] = useContext(MyUserContext);
    const [phanHoiKhachHang, setPhanHoiKhachHang] = useState(null);
    const [content, setContent] = useState();
    const [isSuccess, setIsSuccess] = useState(null);
    const [err, setErr] = useState(null);
    const guiPhanHoi = (evt) => {
        evt.preventDefault();
        if (content.trim() === '') {
            alert('Vui lòng nhập nội dung phản hồi trước khi gửi.');
            return;
        }
        const process = async () => {
            try {
                let res = await authApi().post(endpoint['phanHoiKhachHang'], {
                    "phanHoi": content
                });
                if (res.status === 201) {
                    setPhanHoiKhachHang(res.data);
                    setContent("");
                    setIsSuccess(true);
                } else {
                    setErr("Hệ thống đang bị lỗi. Vui lòng thử lại sau.");
                }
                
            } catch (err) {
                setErr("Hệ thống đang bị lỗi!");
            }
           
        }

        process();
    }
    

    let url = `/login?next=/feedback`;
    return (
        <>
            <div className="container-xxl py-5 container-bg">
                <div className="containe">
                    <div className="row g-5 align-items-center">
                        <div className="col-lg-6">
                            <h1 className="mb-4 text-center "><span className="title-about text-uppercase">Phản hồi khách hàng</span></h1>
                            <p className="mb-4 text-center">Những đóng góp ý kiến của bạn sẽ là lời động viên tinh thần cho chúng tôi tốt hơn ngày hôm nay.</p>
                        </div>
                        <div className="col-lg-6">
                            <img src={anhNenThucDon} />
                        </div>
                    </div>
                </div>
            </div>
            <div id="about">
                <div className="container container-bg">
                    <div className="widthImg">
                        <img alt="" src={anh1} />
                    </div>
                    <div className="section-header">
                        <h2 className='title-about'>Phản hồi khách hàng</h2>
                        <div className='text-center'>
                            <p>Ý kiến của bạn</p>
                            <p>Thành quả của chúng ta</p>
                        </div>
                    </div>
                    <form>
                        <div className="row g-3">
                            <h4>Thông tin liên hệ</h4>
                            <div className="col">
                                <div className="control-group">
                                    <textarea className="form-control" rows={5} id="feedback" placeholder="Thông tin phản hồi"
                                        value={content} onChange={e => setContent(e.target.value)} />
                                </div>
                            </div>
                            {taiKhoan === null ? <p>Vui lòng <Link to={url}>đăng nhập</Link> để gửi phản hồi! </p> : <>
                                <div className="col-3">
                                    <button className="btn btn-primary w-100 py-3" onClick={guiPhanHoi}>Gửi</button>
                                </div>
                            </>}
                            {err === null ? "" : <Alert variant="danger">{err}</Alert>}
                            {isSuccess === null ? "" : <Alert variant="success">Bạn đã gửi phản hồi thành công. Cảm ơn sự đóng góp ý kiến của bạn.</Alert>}

                        </div>
                    </form>
                </div>
            </div>
        </>
    )
}

export default Feedback;