import { Link, Navigate } from 'react-router-dom';
import './Login.css';
import { useContext, useState } from 'react';
import Apis, { authApi, endpoint } from '../../configs/Apis';
import { MyUserContext } from '../../App';
import { Alert } from 'react-bootstrap';

const Login = () => {
    const [taiKhoan, dispatch] = useContext(MyUserContext);
    const [tenDangNhap, setTenDangNhap] = useState();
    const [matKhau, setMatKhau] = useState();
    const [err, setErr] = useState(null);


    const login = (evt) => {
        evt.preventDefault();

        const process = async () => {
            try {
                let res = await Apis.post(endpoint['login'], {
                    "tenDangNhap": tenDangNhap,
                    "matKhau": matKhau
                });

                console.log("login", res);
                const accessToken = await res.data;
                document.cookie = `accessToken=${accessToken}; Path=/;`;

                let user = await authApi().get(endpoint['currentUser']);


                const userDataObj = await user.data;
                const userDataString = JSON.stringify(userDataObj)

                document.cookie = `userData=${userDataString}; Path=/;`;


                dispatch({
                    "type": "login",
                    "payload": userDataObj
                });

                console.info(user.data);



            } catch (err) {
                if(err.response.status === 400) {
                    setErr(err.response.data);
                } else {
                    setErr("Hệ thống đang bị lỗi!");
                }

                
            }

        }

        process();
    }

    if (taiKhoan !== null && taiKhoan.vaiTro === "ROLE_USER") {
        return <Navigate to="/" />
    } 
    if (taiKhoan !== null && taiKhoan.vaiTro === "ROLE_STAFF") {
        return <Navigate to="/employee" />
    }

    return (
        <div className='bodyLogin'>
            <div className="form">
                <form onSubmit={login}>
                    <h2>Đăng nhập</h2>
                    <p className='close'><Link to="/">x</Link></p>
                    {err === null ? "" : <Alert variant="danger">{err}</Alert>}
                    <div className="form_userName control">
                        <input id="tenDangNhap" value={tenDangNhap} onChange={e => setTenDangNhap(e.target.value)} type="text" placeholder="Tên đăng nhập" />
                        <small></small>
                        <span></span>
                    </div>
                    <div className="form_Password control">
                        <input type="password" value={matKhau} onChange={e => setMatKhau(e.target.value)} name="matKhau" id="matKhau" placeholder="Mật khẩu" />
                        <small></small>
                        <span></span>
                    </div>
                    <div className="container_login">
                        <button className="LogIn" type="submit">Đăng nhập</button>
                        <p>Not a member? <Link to="/register">Đăng ký</Link></p>
                    </div>
                </form>
            </div>
        </div>
    )
}

export default Login;