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


$('#chaxun').click(function () {
    //1.查数据

    $.get('/query',{},function (result) {
        if(result && result['success']){
            var jsonResult = result['data'];
            console.log(jsonResult);

            var list1=[];
            var list3=[];
            $.each(jsonResult, function(idx, obj) {
                list1=[idx,obj['student']['xsName'],obj['kemu']['name'],obj['fenshu']];
                var list2={checked: true, data:list1};
                list3.push(list2);
            });


            $('table.datatable').datatable('load', {
                cols: [
                    {width: '20px', text: '#', type: 'string', flex: false, colClass: 'text-center'},
                    {width: 80, text: '姓名', type: 'string', flex: false, colClass: ''},
                    {width: 80, text: '科目', type: 'string', flex: true, colClass: ''},
                    {width: 80, text: '成绩', type: 'string', flex: true, colClass: ''},

                ],
                rows: list3
            });
        }
    })
});