var opts = {
    autoUpload: true,            // 当选择文件后立即自动进行上传操作
    url: '/upload',  // 文件上传提交地址
    file_data_name: 'file',			//定义表单参数
    filters: {						//指定上传文件的类型、大小
        mime_types: [
            {title: 'excel文件', extensions: 'xls,xlsx'}
        ],
        max_file_size: '10mb'
    },
    chunk_size: '0',
    multipart_params: {
        randNum: Math.random()
    }

};
$('#uploaderExcel').uploader(opts);

$('table.datatable').datatable();

$('#test').click(function () {
    console.log("click button");
    $('table.datatable').datatable('load', {
        cols: [
            {width: 80, text: '#', type: 'number', flex: false, colClass: 'text-center'},
            {width: 160, text: '时间', type: 'date', flex: false, sort: 'down'},
            {width: 80, text: '名称', type: 'string', flex: true, colClass: ''}
        ],
        rows: [
            {checked: false, data: [1, '2016-01-18 11:09:36', '新的名称示例1']},
            {checked: false, data: [2, '2016-01-22 12:06:16', '新的名称示例2']},

        ]
    });
});

$('#chaxun').click(function () {
    //1.查数据
    $.get(url,{},function (result) {

    })

    //2.显示数据

});