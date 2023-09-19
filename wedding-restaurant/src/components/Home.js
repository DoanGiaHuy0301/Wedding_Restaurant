import React from 'react';
import { Carousel } from "react-bootstrap";
import ExampleCarouselImage from "./ExampleCarouselImage";
import a from "../image/DIAMOND_1.0.jpg"
import anhNenThucDon from "../image/banner-thuc-don.jpg";
import Menu from './Menu/Menu';
import Lobby from './Lobby/Lobby';

const Home = () => {


    return (
        <>
            <Carousel>
                <Carousel.Item>
                    <ExampleCarouselImage text="First slide" imageUrl={a} />
                    <Carousel.Caption>
                        <h3>First slide label</h3>
                        <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                    <ExampleCarouselImage text="Second slide" imageUrl={a} />
                    <Carousel.Caption>
                        <h3>Second slide label</h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                    <ExampleCarouselImage text="Third slide" imageUrl={a} />
                    <Carousel.Caption>
                        <h3>Third slide label</h3>
                        <p>
                            Praesent commodo cursus magna, vel scelerisque nisl consectetur.
                        </p>
                    </Carousel.Caption>
                </Carousel.Item>
            </Carousel>
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
                    <Lobby/>
                    <Menu/>
                </div>
            </div>

        </>
    )
}

export default Home;
