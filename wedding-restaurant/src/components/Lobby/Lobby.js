import anhNenThucDon from "../../image/banner-thuc-don.jpg";
import './Lobby.css';
import { Carousel, Table } from "react-bootstrap";
import ExampleCarouselImage from "../ExampleCarouselImage";
import { useEffect, useState } from "react";
import Apis, { endpoint } from "../../configs/Apis";
import MySpinner from "../../layout/MySpinner";

const lobbyInfo = {
    DIAMOND: {
        lobbyName: 'DIAMOND',
        description: 'Sảnh DIAMOND như một viên Kim Cương sáng giá đặt tại Tầng G nhằm điểm nhấn thêm nét sang trọng, quý phái của TT Hội nghị - Tiệc Cưới GOLD PALACE. Hội tụ đầy đủ các yếu tố cần thiết từ thiết kế không gian, trang thiết bị hiện đại, tông (tone) màu thanh nhã kết hợp cùng ghế Tiffany thời thượng sẽ mang đến cho sự kiện của bạn những ấn tượng khó phai.'
    },
    GOLD: {
        lobbyName: 'GOLD',
        description: 'Đại sảnh GOLD là sảnh tiệc có diện tích và sức chứa lớn nhất lên đến hàng nghìn người tại GOLD PALACE. Lối kiến trúc xuyên suốt được điểm nhấn bằng những hoạ tiết tinh tế kết hợp cùng vẻ thoáng đãng của ghế Tiffany sẽ càng làm cho không gian tổ chức của bạn thêm phần lãng mạn nhưng không kém phần ấm cúng, sang trọng.'
    },
    SILVER: {
        lobbyName: 'SILVER',
        description: 'Đúng như tên gọi của một loại kim loại quý, đó là Bạc. SILVER là sảnh tiệc thu hút được nhiều sự chú ý nhất của khách hàng dành cho GOLD PALACE. Toạ lạc tại vị trí cao nhất của toà nhà, không gian hướng thẳng ra dòng sông Sài Gòn thơ mộng và hướng nhìn ôm trọn toà nhà Landmark cũng như toàn cảnh trung tâm thành phố.'
    },
    RUBY: {
        lobbyName: 'RUBY',
        description: 'Từ lâu, Hồng Ngọc (RUBY) đã là đại diện cho tình yêu lãng mạn, là biểu tượng của sự tận tâm và chung thuỷ trong một mối quan hệ. Sảnh tiệc RUBY tại GOLD PALACE được tô điểm như một món quà ý nghĩa gửi đến các cặp đôi với hy vọng trên bước đường chung đôi thật trọn vẹn, đón nhận những khoảnh khắc ngọt ngào dâng trào như dòng máu đỏ tuần hoàn trong từng nhịp đập con tim.'
    },
    SAPPIRE: {
        lobbyName: 'SAPPIRE',
        description: 'Một số người tin rằng cái tên SAPPHIRE có nguồn gốc từ sự liên kết của nó với Sao Thổ. Từng mảng kiến trúc được sắp đặt hài hoà, mang sự chắc chắn nhưng không kém phần trang hoàng, lộng lẫy như một cung điện hoàng gia. Ngoài ra, tên gọi SAPPHIRE với mong muốn mọi cặp đôi sẽ có được một bước đường chung đôi thật bền chặt như chính ý nghĩa của loại đá quý này.'
    },
    'GRAND DIAMOND': {
        lobbyName: 'GRAND DIAMOND',
        description: 'Sảnh GRAND DIAMOND tại Tầng 3 thuộc TT Hội nghị - Tiệc cưới Gold Palace.'
    },
    'GRAND RUBY': {
        lobbyName: 'GRAND RUBY',
        description: 'Sảnh GRAND RUBY tại Tầng 5 thuộc TT Hội nghị - Tiệc cưới Gold Palace.'
    }

};

const Lobby = () => {
    const [currentLoaiSanh, setCurrentLoaiSanh] = useState('DIAMOND');
    const [currentInfo, setCurrentInfo] = useState(lobbyInfo.DIAMOND);
    const [anhSanhList, setAnhSanhList] = useState([]);

    const fetchAnhSanhList = async (loaiSanh) => {
        Apis.get(`${endpoint.anhSanh}?loaiSanh=${loaiSanh}`)
            .then(res => {
                setAnhSanhList(res.data);
            })
            .catch(error => {
                console.error(error);
            });
    };

    console.log(anhSanhList)
    useEffect(() => {
        fetchAnhSanhList(currentLoaiSanh);
    }, [currentLoaiSanh]);
    console.log(currentInfo)


    const handleButtonClick = (value) => {
        fetchAnhSanhList(value);
        setCurrentInfo(lobbyInfo[value]);
    };


    if (fetchAnhSanhList === undefined)
        return <MySpinner />;

    return (
        <>
            <div className="container-xxl py-5 container-bg">
                <div className="container">
                    <div className="row g-5 align-items-center">
                        <div className="col-lg-6">
                            <h1 className="mb-4 text-center "><span className="title-about text-uppercase">Sảnh tiệc</span></h1>
                            <p className="mb-4 text-center">Khám phá không gian đẹp tinh tế tại sảnh cưới chúng tôi, nơi tất cả những giấc mơ về đám cưới trở thành hiện thực. Với thiết kế sang trọng, không gian rộng rãi và dịch vụ chuyên nghiệp, chúng tôi cam kết tạo nên một ngày trọng đại đầy ấn tượng và đáng nhớ. Đến với chúng tôi, mỗi chi tiết được chăm chút, để bạn tự do khắc họa câu chuyện tình yêu của riêng mình.</p>
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
                        <h2>Vì sao nên chọn
                            <strong className="title-about">GH - WEDDING RESTAURANT</strong>
                        </h2>
                        <p>
                            "Chắp cánh ước mơ, gói trọn hạnh phúc"
                        </p>
                    </div>
                    <div className="row">
                        <div className="col-md-4 col-sm-6 icons">
                            <i className="icon icon-2"></i>
                            <p>KHÔNG GIAN ĐA CHỨC NĂNG VỚI 12 SẢNH TIỆC. ĐA DẠNG CÔNG SUẤT TỪNG SẢNH.</p>
                        </div>
                        <div className="col-md-4 col-sm-6 icons">
                            <i className="icon icon-3"></i>
                            <p>MÀN HÌNH LED HIỆN ĐẠI.</p>
                        </div>
                        <div className="col-md-4 col-sm-6 icons">
                            <i className="icon icon-4"></i>
                            <p>HỆ THỐNG ÂM THANH ÁNH SÁNG CAO CẤP.</p>
                        </div>
                        <div className="col-md-4 col-sm-6 icons">
                            <i className="icon icon-5"></i>
                            <p>HỆ THỐNG SẢNH VÀ SẢNH CHỜ RIÊNG BIỆT TỪNG TẦNG TẠO KHÔNG GIAN RIÊNG TƯ.</p>
                        </div>
                        <div className="col-md-4 col-sm-6 icons">
                            <i className="icon icon-6"></i>
                            <p>ĐỘI NGŨ HÀNG TRĂM NHÂN SỰ CÓ KHẢ NĂNG PHỤC VỤ CÙNG LÚC 4000 KHÁCH.</p>
                        </div>
                        <div className="col-md-4 col-sm-6 icons">
                            <i className="icon icon-1"></i>
                            <p>HỆ THỐNG SẢNH VÀ SẢNH CHỜ RIÊNG BIỆT TỪNG TẦNG TẠO KHÔNG GIAN RIÊNG TƯ.</p>
                        </div>
                    </div>
                </div>
            </div>
            <div id="amenities" className="container-bg">
                <div className="container">
                    <div className="row">
                        <div className="col">
                            <div className="line-left"></div>
                        </div>
                        <h4 className="col section-title title-about">Sảnh tiệc</h4>
                        <div className="col">
                            <div className="line-right"></div>
                        </div>
                    </div>
                    <div className="container_lobby">
                        <ul className="nav nav-pills mb-3 justify-content-center justify-content-lg-start lobby_titles">
                            <li className="nav-item">
                                <button className="nav-link" onClick={() => handleButtonClick('DIAMOND')}>DIAMOND</button>
                            </li>
                            <li className="nav-item">
                                <button className="nav-link" onClick={() => handleButtonClick('GOLD')}>GOLD</button>
                            </li>
                            <li className="nav-item">
                                <button className="nav-link" onClick={() => handleButtonClick('SILVER')}>SILVER</button>
                            </li>
                            <li className="nav-item">
                                <button className="nav-link" onClick={() => handleButtonClick('RUBY')}>RUBY</button>
                            </li>
                            <li className="nav-item">
                                <button className="nav-link" onClick={() => handleButtonClick('SAPPIRE')}>SAPPIRE</button>
                            </li>
                            <li className="nav-item">
                                <button className="nav-link" onClick={() => handleButtonClick('GRAND DIAMOND')}>GRAND DIAMOND</button>
                            </li>
                            <li className="nav-item">
                                <button className="nav-link" onClick={() => handleButtonClick('GRAND RUBY')}>GRAND RUBY</button>
                            </li>
                        </ul>
                        <div className="carousel_lobby">
                            <Carousel className="carousel_img_lobby">
                                {anhSanhList.map((anhSanh, index) => (
                                    <Carousel.Item key={index}>
                                        <ExampleCarouselImage text="First slide" imageUrl={anhSanh[0]} />
                                    </Carousel.Item>
                                ))}
                            </Carousel>
                        </div>
                        {anhSanhList.length > 0 && (
                            <div className="description_lobby">
                                <div className="lobbyName">{currentInfo.lobbyName}</div>
                                <div className="divider"></div>
                                <p className="">{currentInfo.description}</p>
                            </div>
                        )}
                    </div>
                </div>
            </div>
            <div id="amenities" className="container-bg">
                <div className="container">
                    <div className="row">
                        <div className="col">
                            <div className="line-left"></div>
                        </div>
                        <h4 className="col section-title title-about">Thông tin chung</h4>
                        <div className="col">
                            <div className="line-right"></div>
                        </div>
                    </div>
                    <div className="table-responsive mt-5">
                        <Table responsive="sm">
                            <thead>
                                <tr className="table_lobby">
                                    <td colSpan={4} className="table_title_lobby">
                                        <p className="mt-3 text-white">CÔNG SUẤT VÀ DIỆN TÍCH</p>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Loại sảnh</th>
                                    <th>
                                        Diện tích
                                        <p>(m2)</p>
                                    </th>
                                    <th>
                                        Kích thước
                                        <p>(DàixNgangxCao)</p>
                                    </th>
                                    <th>Tầng</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>DIAMOND</td>
                                    <td>1376</td>
                                    <td>80 x 16 x 3,5</td>
                                    <td>1</td>
                                </tr>
                                <tr>
                                    <td>GOLD</td>
                                    <td>437</td>
                                    <td>27,35 x 16 x 3,435</td>
                                    <td>2</td>

                                </tr>
                                <tr>
                                    <td>SILVER</td>
                                    <td>437</td>
                                    <td>27,35 x 16 x 3,435</td>
                                    <td>3</td>

                                </tr>
                                <tr>
                                    <td>RUBY</td>
                                    <td>375</td>
                                    <td>18,35 x 16 x 3,435</td>
                                    <td>4</td>

                                </tr>
                                <tr>
                                    <td>SAPPIRE</td>
                                    <td>375</td>
                                    <td>18,35 x 16 x 3,435</td>
                                    <td>5</td>

                                </tr>
                                <tr>
                                    <td>GRAND DIAMOND</td>
                                    <td>285</td>
                                    <td>18,4 x 16 x 3,369</td>
                                    <td>Trệt</td>

                                </tr>
                                <tr>
                                    <td>GRAND RUBY</td>
                                    <td>285</td>
                                    <td>18,4 x 16 x 3,369</td>
                                    <td>Trệt</td>
                                </tr>


                            </tbody>
                        </Table>
                    </div>
                </div>
            </div>
        </>
    )
}

export default Lobby;