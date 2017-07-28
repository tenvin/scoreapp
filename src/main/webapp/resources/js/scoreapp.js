function userInfo() {
    layer.open({
        type: 2,
        title: '信息查看',
        shadeClose: true,
        area: ['60%', '80%'],
        shade: 0.8,
        maxmin: true, //开启最大化最小化按钮
        content: ['${path}/myInfo', 'no'],
        end: function() {
        }
    });
}
//用户退出
function logOut() {
    layer.confirm('确定要退出系统吗？', {
        btn: ['嗯, 退出', '我再想想']
    }, function(index) {
        var url = '${path}/userLogOut';
        $.get(url, {}, function(data) {
            window.location.href = '${path}';
        }, 'json');
    });
}

