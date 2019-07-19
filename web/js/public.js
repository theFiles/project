window.onload = function(){
    var displayOnMouse = function(navLi){
        navLi.onmouseover = function(){
            this.firstElementChild.style.display = 'block';
        };
        navLi.onmouseout = function(){
            this.firstElementChild.style.display = 'none';
        };
    };

    var navLi = document.getElementsByClassName('nav-li');

    on(navLi,displayOnMouse);

};

function on(node,func){
    var len = node.length;

    if(len > 0){
        for (var i=0; i<len; i++){
            func(node[i]);
        }
    }
}

function delIni(delUrl){
    var dashedBox = document.getElementsByClassName('dashed-box');
    var setDelBtn = function(node){
        var fun = function(delNode){
            delNode.innerHTML = '&times;';

            delNode.onclick = function(){
                var num = this.getAttribute('num');
                var tips = this.getAttribute('tips-name') || '该选项';

                if(num > 0 && confirm('是否要删除'+tips+'?')){
                    if(typeof delUrl == 'function'){
                        delUrl(this,num,tips);
                    }
                    else location.href = delUrl+'&num='+num;
                }
            }
        }

        on(node.getElementsByTagName('b'),fun);
    };
    on(dashedBox,setDelBtn);
}

