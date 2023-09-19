import { Link } from "react-router-dom";
import anhNenThucDon from "../../image/banner-thuc-don.jpg";
import anhDV1 from "../../image/DIAMOND_1.0.jpg";
import anhDV2 from "../../image/dich-vu-cuoi-2023-DP1-1024x768.jpg";
import anhDV3 from "../../image/gallery-dream-love-vong-hoa-1024x683.jpg";
import anhDV4 from "../../image/hoa-tuoi-2-1024x677.jpg";
const Service = () => {
    return (
        <>
            <div className="container-xxl py-5 container-bg">
                <div className="container">
                    <div className="row g-5 align-items-center">
                        <div className="col-lg-6">
                            <h1 className="mb-4 text-center "><span className="title-about text-uppercase">Dịch vụ</span></h1>
                            <p className="mb-4 text-center">Chào mừng bạn đến với dịch vụ tiệc cưới tại nhà hàng chúng tôi - nơi hòa quyện ẩm thực và không gian lãng mạn. Chúng tôi cam kết mang đến trải nghiệm tiệc cưới tinh tế và đáng nhớ với thực đơn đa dạng và không gian sang trọng. Hãy để chúng tôi cùng bạn tạo nên những kỷ niệm đẹp trong cuộc hành trình tình yêu của bạn.</p>
                        </div>
                        <div className="col-lg-6">
                            <img src={anhNenThucDon} />
                        </div>
                    </div>
                </div>
            </div>
            <div id="amenities" className="container-bg">
                <div className="container">
                    <div className="section-header">
                        <h2>Dịch vụ
                            <strong className="title-about">GH - WEDDING RESTAURANT</strong>
                        </h2>
                        <p>
                            Tham khảo nhiều thông tin để sẵn sàng cho ngày trọng đại, các cặp đôi hẳn sẽ rất thắc mắc mọi thứ có được chuẩn bị tươm tất? Tiệc cưới mình sẽ ra sao? Nghi thức lễ thế nào?… Và hàng ti tỉ những mối quan tâm khác nữa.
                        </p>
                        <p className="mt-2">
                            Thấu hiểu và luôn muốn chia sẻ, GH - WEDDING RESTAURANT hiểu được trọng trách mang đến sự trọn vẹn cho ngày tiệc. Các cặp đôi hãy cùng khám phá Diamond Place sẽ chuẩn bị những dịch vụ gì cho ngày trọng đại của mình nhé.
                        </p>
                    </div>
                </div>
            </div>
            <div className="container container-bg" style={{ padding: '0 100px' }}>
                <h2>
                    <span>
                        <strong>1. Ấn tượng cho khách mời từ không gian tổ chức tiệc:</strong>
                    </span>
                </h2>
                <p>
                    <span>
                        Từ những giây phút đầu tiên đến vị trí tổ chức tiệc, điều khách mời bắt gặp sẽ là sự chỉn chu trong không gian cưới, cô dâu chú rể trông vô cùng rạng rỡ bên những gói trang trí cao cấp, độc đáo…
                    </span>
                </p>
                <p>
                    <span>
                        Từ bàn tiếp tân, backdrop chụp hình hay không gian tiệc…
                    </span>
                </p>
                <p className="widthImg">
                    <span >
                        <img src={anhDV1} />
                    </span>
                </p>

                <h2>
                    <span>
                        <strong>2. “WELCOME DRINK” – Quầy nước trái cây cho khách mời đến sớm</strong>
                    </span>
                </h2>
                <p>
                    <span>
                        Ngày tiệc diễn ra, luôn có những vị khách đến sớm để cùng chia vui với các cặp đôi.
                    </span>
                </p>
                <p>
                    <span>
                        Là một dịch vụ được số ít các nhà hàng chuẩn bị,  sảnh chờ tại Diamond Place được “trang bị” quầy nước trái cây, nước suối mát lạnh để khách mời của mình cùng thưởng thức trong khi chờ đến giờ tiệc diễn ra.
                    </span>
                </p>

                <h2>
                    <span>
                        <strong>3. Sang trọng, hiện đại, thơ mộng hội tụ trong một nghi thức lễ đặc sắc</strong>
                    </span>
                </h2>
                <p>
                    <span>
                        Để khách mời có thể cùng các cặp đôi chia sẻ và cảm nhận được những khoảnh khắc thiêng liêng trên sân khấu, mỗi phần trong nghi thức lễ đều được Diamond Place xây dựng lên từ hiệu ứng âm thanh, ánh sáng độc đáo.
                    </span>
                </p>
                <p>
                    <span>
                        Phần trình diễn của nhóm múa sẽ mang đến những tiết mục tuyệt vời, kết nối khách mời hướng về sân khấu trước phần nghi lễ chính thức.
                    </span>
                </p>
                <p>
                    <span>
                        Và nhiều dịch vụ khác để có thể mang đến những giây phút trọn vẹn cho ngày vui trọng đại.
                    </span>
                </p>
                <p className="widthImg">
                    <span >
                        <img src={anhDV2} />
                    </span>
                </p>

                <h2>
                    <span>
                        <strong>4. Trang trí tiệc cưới độc nhất, khác biệt</strong>
                    </span>
                </h2>
                <p>
                    <span>
                        Tại Diamond Place một mẫu trang trí chỉ dành cho một tiệc duy nhất trong ngày hôm đó.
                    </span>
                </p>
                <p className="widthImg">
                    <span >
                        <img src={anhDV3} />
                    </span>
                </p>
                <p>
                    <span>
                        Nếu đến sau, chắc chắn bạn sẽ không đặt được gói trang trí này. Để đảm bảo tính độc nhất cho tiệc cưới, tránh sự trùng lặp, đụng hàng không đáng có.
                    </span>
                </p>
                <p className="widthImg">
                    <span >
                        <img src={anhDV4} />
                    </span>
                </p>
                <p>
                    <span>
                        Để biết thêm về những dịch vụ và phương thức đặt cọc các bạn xin vui lòng CLICK
                        <Link to="/booking">“NHẬN BÁO GIÁ“</Link>
                        để nhận được tư vấn sớm nhất nhé.
                    </span>
                </p>
            </div>
        </>
    )
}

export default Service;