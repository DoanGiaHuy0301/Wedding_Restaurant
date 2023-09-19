
import menu1 from "../../image/SAP_1.0.jpg";
import menu2 from "../../image/tiec_sn.jpg";
import menu3 from "../../image/Tiệc-sự-kiện.png";
import menu4 from "../../image/Gold-Palace4-tiec-doanh-nghiep.jpg";
import anhNenThucDon from "../../image/banner-thuc-don.jpg";
import anh1 from "../../image/line-hoang-long-restaurant.png";
import anh2 from "../../image/line-hoang-long-restaurant-D.png";

const Event = () => {
    return (
        <>
            <div className="container-xxl py-5 container-bg">
                <div className="containe">
                    <div className="row g-5 align-items-center">
                        <div className="col-lg-6">
                            <h1 className="mb-4 text-center "><span className="title-about text-uppercase">Sự kiện - tiệc</span></h1>
                            <p className="mb-4 text-center">Mỗi một món ăn đều được các đầu bếp chế biến theo khẩu vị khác nhau từ món thuần Việt đến ẩm thực Á – Âu, đảm bảo làm hài lòng cả những thực khách khó tính nhất.</p>
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
                        <h2 className='title-about'>Sự kiện - tiệc</h2>
                    </div>
                    <div className="row">
                        <div className="col-md-6 img-cols">
                            <div className="img-col">
                                <img alt="" className="img-fluid" src={menu1} />
                            </div>
                        </div>
                        <div className="col-md-6 content-cols">
                            <div className="content-col">
                                <h3>Tiệc cưới</h3>
                                <p>Đời người không có quá nhiều ngày được xem là đặc biệt, nhưng đặc biệt nhất vẫn là "Ngày Chung Đôi". Hãy để Gold Palace hiện thực hoá giấc mơ cưới mà bạn đã ấp ủ từ bao lâu, để ngày hai bạn "về chung nhà" trở thành khoảnh khắc lãng mạn, ấn tượng mãi trong lòng khách tham dự.</p>
                            </div>
                        </div>
                    </div>
                    <hr />

                    <div className="row">
                        <div className="col-md-6 img-cols d-block d-md-none">
                            <div className="img-col">
                                <img alt="" className="img-fluid" src={menu2} />
                            </div>
                        </div>
                        <div className="col-md-6 content-cols">
                            <div className="content-col">
                                <h3>Thôi nôi - sinh nhật</h3>
                                <p>Một buổi tiệc kỷ niệm trong một không gian ấm cúng sang trọng, ngập tràn trong ánh sáng lung linh của những ngọn nến và hoa, sự thân mật khi đón nhận những lời chúc mừng, sự đa dạng về dịch vụ dành cho sinh nhật, sự tận tâm từ Gold Palace... sẽ mang đến cho bạn một buổi tiệc thật đáng nhớ.</p>
                            </div>
                        </div>
                        <div className="col-md-6 img-cols d-none d-md-block">
                            <div className="img-col">
                                <img alt="" className="img-fluid" src={menu2} />
                            </div>
                        </div>
                    </div>

                    <hr />

                    <div className="row">
                        <div className="col-md-6 img-cols">
                            <div className="img-col">
                                <img alt="" className="img-fluid" src={menu3} />
                            </div>
                        </div>
                        <div className="col-md-6 content-cols">
                            <div className="content-col">
                                <h3>Hội nghị - sự kiện</h3>
                              <p>Gold Palace cung cấp đa dạng dịch vụ hội nghị, hội thảo chuyên đề, những buổi toạ đàm, hay những cuộc họp nội bộ, huấn luyện đào tạo quy mô... với mức chi phí linh hoạt (nửa ngày, nguyên ngày, trọn gói...) cùng với hệ thống cơ sở vật chất tiện ích và trang thiết bị hiện đại...</p>
                            </div>
                        </div>
                    </div>
                    <hr />

                    <div className="row">
                        <div className="col-md-6 img-cols d-block d-md-none">
                            <div className="img-col">
                                <img alt="" className="img-fluid" src={menu2} />
                            </div>
                        </div>
                        <div className="col-md-6 content-cols">
                            <div className="content-col">
                                <h3>Tiệc doanh nghiệp</h3>
                                <p>Là một trong những sự kiện phổ biến nhất trong mỗi doanh nghiệp để nhìn lại một chặng đường đã trải qua, nhằm vinh danh những tập thể - cá nhân xuất sắc cống hiến, là cơ hội gặp gỡ những đối tác - nhà cung cấp, hay đó là một buổi ra mắt - giới thiệu sản phẩm, hoặc đơn thuần chỉ là một buổi tiệc chúc mừng mỗi thành tựu đạt được.</p>
                            </div>
                        </div>
                        <div className="col-md-6 img-cols d-none d-md-block">
                            <div className="img-col">
                                <img alt="" className="img-fluid" src={menu4} />
                            </div>
                        </div>
                    </div>

                </div>
                <div className="widthImg">
                    <img alt="" src={anh2} />
                </div>
            </div>
        </>
    )
}

export default Event;