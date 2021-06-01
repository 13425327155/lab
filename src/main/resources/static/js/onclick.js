
//出入管理的删除
function delConfirm(value) {
    if (confirm("您确定要删除【" + value + " 】吗?")) {
        return true;
    } else {
        return false;
    }
}

//出入管理的编辑
function updateConfirm(value) {
    if (confirm("您确定要编辑这条数据吗?")) {
        return true;
    } else {
        return false;
    }
}