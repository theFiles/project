var mouseOver = function(){
    this.getElementsByTagName('b')[0].removeAttribute('style');
};

var mouseOut = function(){
    this.getElementsByTagName('b')[0].style.display = 'none';
};

var goodsInfo = document.getElementsByClassName('goods-info');
var len = goodsInfo.length;

for (var i=0; i<len; i++){
    goodsInfo[i].onmouseover = mouseOver;
    goodsInfo[i].onmouseout = mouseOut;
}

delIni('/index?c=DelGoods');
