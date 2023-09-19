import './Menu.css';
import './bootstrap.min.css';
import menu1 from "../../image/Menu1.jpg";
import menu2 from "../../image/Menu2.jpg";
import menu3 from "../../image/Menu3.jpg";
import anhNenThucDon from "../../image/banner-thuc-don.jpg";
import anh1 from "../../image/line-hoang-long-restaurant.png";
import anh2 from "../../image/line-hoang-long-restaurant-D.png";

const Menu = () => {

   
    return (
        <>
            <div className="container-xxl py-5 container-bg">
                <div className="containe">
                    <div className="row g-5 align-items-center">
                        <div className="col-lg-6">
                            <h1 className="mb-4 text-center"><span className="title-about text-uppercase">Thực đơn</span></h1>
                            <p className="mb-4 text-center">Mỗi một món ăn đều được các đầu bếp chế biến theo khẩu vị khác nhau từ món thuần Việt đến ẩm thực Á – Âu, đảm bảo làm hài lòng cả những thực khách khó tính nhất.</p>
                        </div>
                        <div className="col-lg-6">
                            <img alt="" src={anhNenThucDon} />
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
                        <h2 className='title-about'>Thực đơn</h2>
                        <div className='text-center'>
                            <p>Gợi ý hương vị, chạm đến cảm xúc</p>
                            <p>"Thực đơn <strong className='title-about'>Nhà hàng GH</strong>: Hạnh phúc ẩm thực cho ngày trọng đại!"</p>
                        </div>
                    </div>
                    <div className="row">
                        <div className="col-md-6 img-cols">
                            <div className="img-col">
                                <img alt="" className="img-fluid" src={menu1} />
                            </div>
                        </div>
                        <div className="col-md-6 content-cols">
                            <div className="content-col">
                                <h3>Menu 1</h3>
                                <ul className='menu-ul'>
                                    <li>Khai vị 3 món:</li>
                                    <ul>
                                        <li>- Gỏi tôm thái</li>
                                        <li>- Chả giò bách thảo</li>
                                        <li>- Đậu hủ cuộn trứng</li>
                                    </ul>
                                    <li>Tôm sốt mật ông hạt tiêu</li>
                                    <li>Cá chép giòn sốt kiwwi vàng</li>
                                    <li>Giò heo Đức - khoai tây chiên</li>
                                    <li>Lẩu cá hồi</li>
                                    <li>Tráng miệng: Rau câu</li>
                                </ul>
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
                                <h3>Menu 2</h3>
                                <ul className='menu-ul'>
                                    <li>Khai vị 3 món:</li>
                                    <ul>
                                        <li>- Gỏi tôm thái Tây Thi</li>
                                        <li>- Chả giò GH</li>
                                        <li>- Chả thanh cua</li>
                                    </ul>
                                    <li>Tôm hấp bia tươi</li>
                                    <li>Mì xào sa tế tôm</li>
                                    <li>Cua lột sốt chanh dây</li>
                                    <li>Lẩu tôm Thái Lan</li>
                                    <li>Tráng miệng: Nho mỹ</li>
                                </ul>
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
                                <h3>Menu 3</h3>
                                <ul className='menu-ul'>
                                    <li>Khai vị 4 món:</li>
                                    <ul>
                                        <li>- Gỏi tôm</li>
                                        <li>- Chả giò bách thảo</li>
                                        <li>- Mực ống chiên xù</li>
                                        <li>- Nem nướng Hà Nội</li>
                                    </ul>
                                    <li>Bồ câu quay</li>
                                    <li>Bò hầm rượu vang - bánh mì</li>
                                    <li>Cá bống mú hấp Hồng Kong</li>
                                    <li>Lẩu hải sản sa tế</li>
                                    <li>Tráng miệng: Bánh plan</li>
                                </ul>
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

export default Menu;