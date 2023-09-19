import { useContext } from "react";
import { Button, Container, Nav, NavDropdown, Navbar } from "react-bootstrap";
import { Link } from "react-router-dom";
import { MyUserContext } from "../App";

const Header = () => {
    const [taiKhoan, dispatch] = useContext(MyUserContext);

    const logout = () => {
        dispatch({
            "type": "logout"
        })
    }

    console.log("taiKhoan", taiKhoan);



    return (<>
        <Navbar expand="lg" className="bg-body-tertiary">
            <Container>
                <Navbar.Brand href="#home">GH Wedding Restaurant</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    {taiKhoan === null ? <>
                        <Nav className="me-auto">
                            <Link className="nav-link" to="/about">Giới thiệu</Link>
                            <Link className="nav-link" to="/">Trang chủ</Link>
                            <NavDropdown title="Dịch vụ chung" id="navbarScrollingDropdown">
                                <NavDropdown.Item >
                                    <Link to="/lobby">Sảnh tiệc</Link>
                                </NavDropdown.Item>
                                <NavDropdown.Item >
                                    <Link to="/service">Dịch vụ</Link>
                                </NavDropdown.Item>
                                <NavDropdown.Item >
                                    <Link to="/menu">Thực đơn</Link>
                                </NavDropdown.Item>
                                <NavDropdown.Item >
                                    <Link to="/event">Sự kiện - tiệc</Link>
                                </NavDropdown.Item>
                            </NavDropdown>
                            <Link className="nav-link" to="/search">Tra cứu</Link>
                            <Link className="nav-link" to="/booking">Đặt tiệc</Link>
                            <Link className="nav-link" to="/feedback">Phản hồi khách hàng</Link>
                            {/* {taiKhoan == null ? " " : <Link className="nav-link" to="/bill">Thanh toán</Link>} */}
                        </Nav>
                    </> : taiKhoan.vaiTro === "ROLE_USER" ? <>
                        <Nav className="me-auto">
                            <Link className="nav-link" to="/about">Giới thiệu</Link>
                            <Link className="nav-link" to="/">Trang chủ</Link>
                            <NavDropdown title="Dịch vụ chung" id="navbarScrollingDropdown">
                                <NavDropdown.Item >
                                    <Link to="/lobby">Sảnh tiệc</Link>
                                </NavDropdown.Item>
                                <NavDropdown.Item >
                                    <Link to="/service">Dịch vụ</Link>
                                </NavDropdown.Item>
                                <NavDropdown.Item >
                                    <Link to="/menu">Thực đơn</Link>
                                </NavDropdown.Item>
                                <NavDropdown.Item >
                                    <Link to="/event">Sự kiện - tiệc</Link>
                                </NavDropdown.Item>
                            </NavDropdown>
                            <Link className="nav-link" to="/search">Tra cứu</Link>
                            <Link className="nav-link" to="/booking">Đặt tiệc</Link>
                            <Link className="nav-link" to="/feedback">Phản hồi khách hàng</Link>
                            <Link className="nav-link" to="/bill">Thanh toán</Link>
                        </Nav>
                    </> : <Nav className="me-auto">
                        
                        <Link className="nav-link" to="/employee">Trang chủ</Link>
                        <Link className="nav-link" to="/booking">Đặt tiệc</Link>
                        <Link className="nav-link" to="/search">Tra cứu</Link>
                        
                    </Nav>
                    }
                </Navbar.Collapse>
                <div className="">
                    {taiKhoan === null ? <Link to="/login" style={{ marginRight: '10px' }}>
                        <Button variant="success">Đăng nhập</Button>
                    </Link>
                        : <>
                            <div className="info-user d-flex align-items-center">
                                <img
                                    src={taiKhoan.avatar}
                                    className="rounded-circle small-avatar"
                                    alt="Avatar"
                                />
                                <Link className="nav-link text-danger mt-0" to="/">Chào {taiKhoan.tenDangNhap}!</Link>
                                <Button variant="secondary" onClick={logout} style={{ marginLeft: '10px' }} >Đăng xuất</Button>
                            </div>

                        </>}

                    {!taiKhoan && <Link to="/register"><Button variant="success">Đăng ký</Button></Link>}
                </div>

            </Container>
        </Navbar>

    </>)
}

export default Header;