var app = new Vue({
    el: '.login-container',
    data: {
        isPhoneLogin: false,
        username: '',
        password: '',
        phone: '',
        verificationCode: ''
    },
    methods: {
        switchToPhoneLogin: function() {
            this.isPhoneLogin = true;
        },

        switchToUsernameLogin: function() {
            this.isPhoneLogin = false;
        },

        sendVerificationCode: function() {
            // 在这里添加发送验证码的逻辑
            axios.post('http://localhost:81/user/sendMsg', {
                phone: this.phone
            }).then(() => {
                alert('验证码已发送到您的手机')
            })

        },


        loginWithPhoneAndVerificationCode: function() {
// 在这里添加使用手机号和验证码登录的逻辑
            axios.post('http://localhost:81/user/login', {
                phone: this.phone,
                verificationCode: this.verificationCode
            }).then(resp => {
                console.log(resp.data)
                alert('登陆成功：' + resp.data.data);
                window.location.href = '../page/index.html'
            })

        }
    }
});

function logoutApi(){
    return $axios({
        'url': 'http://localhost:81/user/logout',
        'method': 'post',
    })
}