import anhNenThucDon from "../../image/banner-thuc-don.jpg";
import anh1 from "../../image/line-hoang-long-restaurant.png";
import anh2 from "../../image/line-hoang-long-restaurant-D.png";
import anh3 from "../../image/gt-hoang-long-ld-1.jpg";
import anh4 from "../../image/GOLD_1.1.jpg"
import anh5 from "../../image/GR_1.1.jpg";
import anh6 from "../../image/SAP_1.0.jpg";
import anh7 from "../../image/SILVER_2.1.jpg";
import anh8 from "../../image/SILVER_2.2.jpg";
import './About.css';
import { MDBCarousel, MDBCarouselItem } from "mdb-react-ui-kit";
const About = () => {

    return (
        <>
            <div className="container-xxl py-5 container-bg">
                <div className="containe">
                    <div className="row g-5 align-items-center">
                        <div className="col-lg-6">
                            <h6 className="section-title text-start title-about text-uppercase">About Us</h6>
                            <h1 className="mb-4">Welcome to <span className="title-about text-uppercase">GH - WEDDING RESTAURANT</span></h1>
                            <p className="mb-4">Khám phá <strong>GH - WEDDING RESTAURANT</strong> - nơi mà tiệc cưới trở thành những khoảnh khắc tuyệt vời. Chúng tôi tự hào tạo nên không gian sang trọng và ấm cúng để bạn và khách mời thân yêu tận hưởng ngày quan trọng nhất trong cuộc đời.</p>
                            <div className="row g-3 pb-4">
                                <div className="col-sm-4 wow fadeIn" data-wow-delay="0.3s">
                                    <div className="border rounded p-1">
                                        <div className="border rounded text-center p-4">
                                            <i className="fa fa-users-cog fa-2x text-primary mb-2"></i>
                                            <h2 className="mb-1" data-toggle="counter-up">1000+</h2>
                                            <p className="mb-0">Staffs</p>
                                        </div>
                                    </div>
                                </div>
                                <div className="col-sm-4 wow fadeIn" data-wow-delay="0.5s">
                                    <div className="border rounded p-1">
                                        <div className="border rounded text-center p-4">
                                            <i className="fa fa-users fa-2x text-primary mb-2"></i>
                                            <h2 className="mb-1" data-toggle="counter-up">2000+</h2>
                                            <p className="mb-0">Clients</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="col-lg-6">
                            <img src={anhNenThucDon} />
                        </div>
                    </div>
                </div>
            </div>
            <div className="container container-bg">
                <div className="widthImg">
                    <img src={anh1} />
                </div>
                <div className="text-center">
                    <h1 className="title-about mt-2 mb-2">Về với chúng tôi</h1>
                </div>
                <div className="container text-center">
                    <p><strong>GH - WEDDING RESTAURANT</strong> là một trong những Trung tâm Hội nghị – Tiệc cưới có vị trí thuận lợi hàng đầu cho một loạt các Quận trong nổi bật thành phố như quận Trung tâm Quận 1, Quận 2, Quận 4, Quận 7, Quận Bình Thạnh,…</p>
                    <p>Không gian lãng mạn, thực đơn đa dạng và dịch vụ tận tâm là những gì bạn sẽ trải nghiệm khi đến với <strong>GH - WEDDING RESTAURANT</strong>. Chúng tôi tin rằng mỗi đám cưới là một câu chuyện riêng biệt, và chúng tôi sẽ làm mọi điều để biến giấc mơ của bạn thành hiện thực.</p>
                    <p></p>
                </div>
                <div className="container">
                    <div className="widthImg">
                        <img src={anh3} />
                    </div>
                </div>
                <div className="container text-center">
                    <p>Trong trái tim của thành phố, tại một góc phố yên bình, đứng vững một tòa nhà lịch lãm và độc đáo. Nhà hàng GH - Wedding Restaurant, từng bước tiết lộ câu chuyện về tình yêu và hạnh phúc của những người đôi uyên ương.</p>
                    <p>Với sự đam mê về nghệ thuật ẩm thực và tình yêu vô hạn dành cho những câu chuyện tình, chủ nhân của nhà hàng GH đã tạo nên một không gian tuyệt đẹp, nơi mà mọi chi tiết đều được chăm chút tỉ mỉ. Từ lối trang trí đậm chất lãng mạn cho đến các món ăn tinh tế, mọi thứ đều được xây dựng để tạo ra những khoảnh khắc đáng nhớ cho các đôi uyên ương.</p>
                    <p>Những cánh cửa mở ra, tiết lộ một thế giới của sự sang trọng và lãng mạn. Đèn lấp lánh rọi sáng không gian, tạo nên bầu không gian ấm cúng và lịch lãm. Trong nhà hàng GH, mỗi phòng đều được thiết kế riêng biệt với sự cẩn trọng đến từng chi tiết, để đáp ứng những mong muốn độc nhất của các đôi uyên ương.</p>
                    <p>Những đầu bếp tài ba tại nhà hàng GH không chỉ biết cách tạo ra những món ăn ngon lành mắt mà còn thấu hiểu cảm xúc của tình yêu. Thực đơn đa dạng từ những món truyền thống đến các sáng tạo mới, luôn mang theo thông điệp về tình yêu và hy vọng. Mỗi bữa tiệc trở thành một trải nghiệm ẩm thực không chỉ bởi hương vị mà còn bởi tình cảm mà mỗi món ăn mang lại.</p>
                    <p>Câu chuyện tại nhà hàng GH không chỉ đơn thuần là về việc tổ chức đám cưới, mà còn về việc tạo nên những khoảnh khắc kỷ niệm đáng nhớ trong cuộc đời. Những đôi uyên ương đến đây không chỉ tận hưởng buổi tiệc cưới hoàn hảo mà còn được chạm vào những giá trị tinh thần của tình yêu và gia đình.</p>
                    <p>Nhà hàng GH - Wedding Restaurant, một không gian đầy tình yêu và tận tụy, nơi mà mọi ước mơ về một đám cưới hoàn hảo có thể trở thành hiện thực.</p>
                </div>
                <MDBCarousel className="widthImg" showControls showIndicators>
                    <MDBCarouselItem
                        className='w-100 d-block'
                        itemId={1}
                        src={anh4}
                        alt='...'
                    />
                    <MDBCarouselItem
                        className='w-100 d-block'
                        itemId={2}
                        src={anh5}
                        alt='...'
                    />
                    <MDBCarouselItem
                        className='w-100 d-block'
                        itemId={3}
                        src={anh6}
                        alt='...'
                    />
                     <MDBCarouselItem
                        className='w-100 d-block'
                        itemId={3}
                        src={anh7}
                        alt='...'
                    />
                     <MDBCarouselItem
                        className='w-100 d-block'
                        itemId={3}
                        src={anh8}
                        alt='...'
                    />
                </MDBCarousel>
                <div className="widthImg">
                    <img src={anh2} />
                </div>
            </div>
        </>
    );
}

export default About;