delIni(function(delNode){
    var upload = document.getElementById('upload');
    var uploadImg = document.getElementById('upload-img');
    upload.removeAttribute('style');
    uploadImg.style.display = 'none';
    delNode.style.display = 'none';
});