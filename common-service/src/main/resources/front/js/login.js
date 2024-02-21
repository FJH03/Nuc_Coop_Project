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
            }).then(resp => {
                if (resp.data.success) {
                    alert('验证码已发送到您的手机：' + this.phone);
                } else {
                    alert('发送失败！');
                }
            })

        },

        loginWithUsernameAndPassword: function() {
            // 在这里添加登录逻辑


        },

        loginWithPhoneAndVerificationCode: function() {
// 在这里添加使用手机号和验证码登录的逻辑
            axios.post('http://localhost:81/user/login', {
                phone: this.phone,
                verificationCode: this.verificationCode
            }).then(resp => {
                if (resp.data.success) {
                    alert('使用手机号和验证码登录：' + this.phone + '，验证码：' + this.verificationCode);
                } else {
                    alert('登陆失败:' + resp.data.message);
                }
            })

        }
    }
});