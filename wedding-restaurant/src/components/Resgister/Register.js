import { Link, useNavigate } from 'react-router-dom';
import '../Login/Login.css';
import { useRef, useState } from 'react';
import Apis, { endpoint } from '../../configs/Apis';
import MySpinner from '../../layout/MySpinner';
import { Alert } from 'react-bootstrap';

const Register = () => {
    const [user, setUser] = useState({
        "tenDangNhap": "",
        "matKhau": "",
        "tenKhachHang": "",
        "soDienThoai": "",
        "email": "",
        "nhapLaiMatKhau": ""
    });

    const [loading, setLoading] = useState(false);
    const [err, setErr] = useState(null);
    const avatar = useRef();
    const nav = useNavigate();
    const [usernameExists, setUsernameExists] = useState(false);

    const checkUsernameExistence = async (username) => {
        try {
            const formData = new FormData(); // Tạo đối tượng FormData
            formData.append('tenDangNhap', username); // Thêm dữ liệu vào FormData
            const response = await Apis.post(endpoint['username-exist'], formData);
        } catch (error) {
            //setUsernameExists = true
            setUsernameExists(error.response.status === 400);
        }

    };

    const change = (evt, field) => {
        setUsernameExists(false);
        setUser(current => {
            return { ...current, [field]: evt.target.value };
        });
        if (field === 'tenDangNhap') {
            checkUsernameExistence(evt.target.value);
        }
    }

    const register = (evt) => {
        evt.preventDefault();

        const process = async () => {
            let formData = new FormData();
            for (let field in user)
                formData.append(field, user[field]);

            if (avatar.current.files.length > 0)
                formData.append("avatar", avatar.current.files[0]);

            setLoading(true);
            if (usernameExists === false) {
                let res = await Apis.post(endpoint['register'], formData);
                if (res.status === 201) {
                    nav("/login");
                } else {
                    setErr("Hệ thống đang bị lỗi!");
                    setLoading(false);
                }
            }
            else {
                setErr("Tên đăng nhập đã tồn tại");
                setLoading(false)
                setUser({
                    "tenDangNhap": "",
                    "matKhau": "",
                    "tenKhachHang": "",
                    "soDienThoai": "",
                    "email": "",
                    "nhapLaiMatKhau": ""
                });
                setUsernameExists(false)
            }

        }

        if (user.matKhau !== user.nhapLaiMatKhau) {
            setErr("Mật khẩu KHÔNG khớp!");
        } else {
            process();
        }
    }


    return (

        <div className='bodyLogin'>
            <div className="form">
                <form onSubmit={register}>
                    <h2>Đăng ký</h2>
                    <p className='close'><Link to="/">x</Link></p>
                    {err === null ? "" : <Alert variant="danger">{err}</Alert>}
                    <div className="form_userName control">
                        <input id="name" type="text" placeholder="Họ và tên" required value={user.tenKhachHang}
                            onChange={e => change(e, "tenKhachHang")} />
                        <small></small>
                        <span></span>
                    </div>
                    <div className="form_userName control">
                        <input id="soDienThoai" type="text" placeholder="Số điện thoại" required value={user.soDienThoai}
                            onChange={e => change(e, "soDienThoai")} />
                        <small></small>
                        <span></span>
                    </div>
                    <div className="form_userName control">
                        <input id="email" type="email" placeholder="Email" required value={user.email}
                            onChange={e => change(e, "email")} />
                        <small></small>
                        <span></span>
                    </div>
                    <div className="form_userName control">
                        <input id="tenDangNhap" type="text" required placeholder="Tên đăng nhập" value={user.tenDangNhap}
                            onChange={e => change(e, "tenDangNhap")} />
                        <small >{usernameExists && <Alert variant="danger">Tên đăng nhập đã tồn tại.</Alert>}</small>
                        <span></span>
                    </div>
                    <div className="form_Password control">
                        <input type="password" name="matKhau" required id="password" placeholder="Mật khẩu" value={user.matKhau}
                            onChange={e => change(e, "matKhau")} />
                        <small></small>
                        <span></span>
                    </div>
                    <div className="form_Password control">
                        <input type="password" name="matKhau" required id="confirmPassword" placeholder="Nhập lại mật khẩu" value={user.nhapLaiMatKhau}
                            onChange={e => change(e, "nhapLaiMatKhau")} />
                        <small></small>
                        <span></span>
                    </div>

                    <input id="file" type="file" placeholder="Avatar" ref={avatar} />

                    <div className="container_login">
                        {loading === true ? <MySpinner /> : <button className="LogIn" type="submit">Đăng ký</button>}
                        <p>Not a member? <Link to="/login">Đăng nhập</Link></p>
                    </div>
                </form>
            </div>
        </div>

    )
}

export default Register;