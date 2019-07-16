var error = function(node,tips){
    node.style.borderColor = 'red';
    node.nextElementSibling.innerHTML = tips;
};

var ckUser = function(node){
    if(node.value.trim()) return true;

    error(node,'用户名不能为空！');
};

var ckPwd = function(node){
    var val = node.value.trim(),
        ckNode = document.getElementById('ckpwd');
    if(!val){
        error(node,'密码不能为空');
    }
    else if(val !== ckNode.value.trim()){
        error(ckNode,'密码与确认密码不一致');
    }
};

var ckPhone = function(node){
    var val = node.value.trim();

    if(val > 11){
        error(node,'手机号必须大于11位');
    }
    else if(!(/^[0-9]+$/.test(val))){
        error(node,'手机号中有非法字符');
    }
};

var ckEmail = function(node){
    var val = node.value.trim(),
        myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;

    if(val == ''){
        return true;
    }
    else if(!myreg.test(val)){
        error(node,'邮箱格式有误！');
    }
};

var toSubmit = function(){
    var nodes = document.getElementsByClassName('form-node'),
        len   = nodes.length;

    for(var i=0; i<len; i++){
        var node = nodes[i],
            name = node.getAttribute('name');

        switch (name){
            case 'user':
                ckUser(node);
                break;
            case 'pwd':
                ckPwd(node);
                break;
            case 'phone':
                ckPhone(node);
                break
            case 'email':
                ckEmail(node);
                break
        }

        // console.log(name+':'+val);
    }

    return false;
};

var subBtn = document.getElementsByClassName('submit-btn')[0];
subBtn.onclick = toSubmit;

var nodes = document.getElementsByClassName('form-node');
for(var i in nodes){
    nodes[i].onchange = function(){
        this.removeAttribute("style");
        this.nextElementSibling.innerHTML = '';
    }
}