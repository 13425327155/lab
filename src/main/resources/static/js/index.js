function funcShow(id) {
    for (var i = 0; i < 5; i++) {
        var divInfo = document.getElementById('div' + (i + 1));
        divInfo.style.display = 'none';
    }
    var div = document.getElementById('div' + id);
    div.style.display = 'block';
}
