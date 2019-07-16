var userFocus = function(){
    if(this.value === this.getAttribute('ini-val')){
        this.value = '';
    }
};

var userBlur = function(){
    if(this.value){
        this.value = this.getAttribute('ini-val');
    }
};

var pwdFocus = function(){
    if(this.value === this.getAttribute('ini-val')){
        this.setAttribute('type','password');
        this.value = '';
    }
};

var pwdBlur = function(){
    if(this.value){
        this.setAttribute('type','text');
        this.value = this.getAttribute('ini-val');
    }
};

/**
 * 提交验证
 */
var formSubmit = function(){
    var user      = document.getElementById('user-ipt'),
        userVal   = user.value,
        userIni   = user.getAttribute('ini-val'),
        pwd       = document.getElementById('pwd-ipt'),
        pwdVal    = pwd.value,
        pwdIni    = pwd.getAttribute('ini-val');

    if(
        userVal
        || pwdVal
        || userVal === userIni
        || pwdVal  === pwdIni
    ){
        alert('账户密码不能为空！');
        return false;
    }

};

/**
 * 密码框
 */
var pwd = document.getElementById('pwd-ipt');
pwd.onblur = pwdBlur;
pwd.onfocus = pwdFocus;

/**
 * 用户框
 */
var user = document.getElementById('user-ipt');
user.onblur = userBlur;
user.onfocus = userFocus;

/**
 * 提交按钮
 */
var subBtn = document.getElementById('sub-btn');
subBtn.onclick = formSubmit;