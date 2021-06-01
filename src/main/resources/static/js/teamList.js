//查看团队列表
$("#btn1").click(function () {
    $.ajax({
        url: "/viewTeamList",
        type: "POST",
        dataType: "json",
        success: function (data) {
            var html = "";
            for (var i = 0; i < data.length; i++) {
                html += "<tr>" +
                    "<td>" + data[i].id + "</td>" +
                    "<td>" + data[i].team_type + "</td>" +
                    "<td>" + data[i].team_name + "</td>" +
                    "<td>" + data[i].team_Exp_title + "</td>" +
                    "<td>" +
                    "<button id=\"fat-btn\" class=\"btn btn-primary\" data-loading-text=\"申请中\" onclick=\"updateState("+ data[i].id + ",this)\"\n" +
                    "                    type=\"button\"> 申请\n" +
                    "                </button>" +
                    "</td>" +
                    "</tr>"
            }
            $("#teamList").html(html);
        }
    })
});

//搜索团队
$("#search").click(function (){
        $.ajax({
            url:"/searchTeam",
            data: {
                inputs:$("#content").val()
            },
            type: "POST",
            scriptCharset: 'utf-8',
            dataType: "json",
            success: function (data) {
                var html = "";
                for (var i = 0; i < data.length; i++) {
                    html += "<tr>" +
                        "<td>" + data[i].id + "</td>" +
                        "<td>" + data[i].team_type + "</td>" +
                        "<td>" + data[i].team_name + "</td>" +
                        "<td>" + data[i].team_Exp_title + "</td>" +
                        "<td>" +
                        "<button id=\"fat-btn\" class=\"btn btn-primary\" data-loading-text=\"申请中\" onclick=\"updateState("+ data[i].id + ",this)\"\n" +
                        "                    type=\"button\"> 申请\n" +
                        "                </button>" +
                        "</td>" +
                        "</tr>"
                }
                $("#teamList").html(html);
            }
        });
    }
);

//申请ajax
function updateState(id) {
    // var id = [[${teamList.id}]];
    var flag = confirm("确定要申请吗？");
    if (flag) {
        $.ajax({
            url: "/ajax",
            type: "POST",
            data: {
                id: id
            },
            dataType: "json",
            success: function (data) {
                if (data == "1") {
                    alert("已有团队，不能加入其它团队!")
                } else {
                    alert("已申请加入团队!")
                }
            }
        })
    }
}