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

    var len = navLi.length;

    if(len > 0){
        for (var i=0; i<len; i++){
            displayOnMouse(navLi[i]);
        }
    }
};

