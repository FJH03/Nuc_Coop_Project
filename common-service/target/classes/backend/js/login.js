function loginApi(data) {
    return $axios({
        'url': 'http://localhost:82/admin/login',
        'method': 'post',
        data
    })
}

function logoutApi(){
    return $axios({
        'url': 'http://localhost:82/admin/logout',
        'method': 'post',
    })
}