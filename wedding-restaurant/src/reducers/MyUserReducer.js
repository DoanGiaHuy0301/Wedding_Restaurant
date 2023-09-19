

const MyUserReducer = (currentState, action) => {
    switch (action.type) {
        case "login":
            return action.payload;
        case "logout":
            document.cookie = 'accessToken=; Max-Age=-99999999;';
            document.cookie = 'userData=; Max-Age=-99999999;';
            
            return null;
    }

    return currentState;
}

export default MyUserReducer;