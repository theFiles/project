var userFocus = function(){
    var val = this.value;
    var iniVal = this.getAttribute('ini-val');
    if(val == iniVal){
        this.value = '';
    }
}

var userBlur = function(){
    var val = this.value;
    var iniVal = this.getAttribute('ini-val');

    if(val == ''){
        this.value = iniVal;
    }
}

var pwdFocus = function(){
    var val = this.value;
    var iniVal = this.getAttribute('ini-val');

    if(val == iniVal){
        this.setAttribute('type','password');
        this.value = '';
    }
}

var pwdBlur = function(){
    var val = this.value;
    var iniVal = this.getAttribute('ini-val');

    if(val == ''){
        this.setAttribute('type','text');
        this.value = iniVal;
    }
}

var formSubmit = function(){
    var userValue = document.getElementById('user-ipt');
    var userIni = userValue.getAttribute('ini-val');
    var pwdValue = document.getElementById('pwd-ipt');
    var pwdIni = pwdValue.getAttribute('ini-val');


    return false;
}

var pwd = document.getElementById('pwd-ipt');
pwd.onblur = pwdBlur;
pwd.onfocus = pwdFocus;

var user = document.getElementById('user-ipt');
user.onblur = userBlur;
user.onfocus = userFocus;

var subBtn = document.getElementById('sub-btn');
subBtn.onclick = formSubmit;