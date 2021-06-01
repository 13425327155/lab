//查看任务列表
$("#btn2").click(function () {
    $.ajax({
        url: "/findAllAssignAjax",
        type: "POST",
        dataType: "json",
        success: function (data) {
            var html = "";
            for (var i = 0; i < data.length; i++) {
                var s;
                if (data[i].assign_state == '0'){
                    s = "未完成";
                }else {
                    s = "完成";
                }
                html += "<tr>" +
                    "<td>" + data[i].id + "</td>" +
                    "<td>" + data[i].task_name + "</td>" +
                    "<td>" + data[i].task_text + "</td>" +
                    "<td>" + data[i].difficulty + "</td>" +
                    "<td>" + data[i].release_time + "</td>" +
                    "<td>" + data[i].closing_time + "</td>" +
                    "<td>" + s + "</td>" +
                    "<td>" +
                    "<button id=\"fat-btn\" class=\"btn btn-primary\" data-loading-text=\"申请中\" onclick=\"updateAssignState("+ data[i].id + "," + data[i].assign_state + ")\"\n" +
                    "                    type=\"button\"> 完成\n" +
                    "                </button>" +
                    "</td>" +
                    "</tr>"
            }
            $("#tasksList").html(html);
        }
    })
});

//搜索团队
$("#search1").click(function (){
        $.ajax({
            url:"/searchTasks",
            data: {
                inputs:$("#searchText").val()
            },
            type: "POST",
            scriptCharset: 'utf-8',
            dataType: "json",
            success: function (data) {
                var html = "";
                for (var i = 0; i < data.length; i++) {
                    var s;
                    if (data[i].assign_state == '0'){
                        s = "未完成";
                    }else {
                        s = "完成";
                    }
                    html += "<tr>" +
                        "<td>" + data[i].id + "</td>" +
                        "<td>" + data[i].task_name + "</td>" +
                        "<td>" + data[i].task_text + "</td>" +
                        "<td>" + data[i].difficulty + "</td>" +
                        "<td>" + data[i].release_time + "</td>" +
                        "<td>" + data[i].closing_time + "</td>" +
                        "<td>" + s + "</td>" +
                        "<td>" +
                        "<button id=\"fat-btn\" class=\"btn btn-primary\" data-loading-text=\"申请中\" onclick=\"updateAssignState("+ data[i].id + "," + data[i].assign_state + ")\"\n" +
                        "                    type=\"button\"> 完成\n" +
                        "                </button>" +
                        "</td>" +
                        "</tr>"
                }
                $("#tasksList").html(html);
            }
        });
    }
);

//完成任务ajax
function updateAssignState(id,assign_state) {
    var flag = confirm("确定要完成吗？");
    if (flag) {
        $.ajax({
            url: "/updateAssignState",
            type: "POST",
            data: {
                "id": id,
                "assign_state": assign_state
            },
            dataType: "text",
            success: function (data) {
                if (data == "已完成") {
                    alert("任务完成!")
                    window.location.reload();
                } else {
                    alert("任务重复完成!")
                }
            }
        });
    }
}