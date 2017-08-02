

$('#chaxun').click(function () {
    $.get('/query', {}, function (result) {
        if (result && result['success']) {
            var jsonResult = result['data'];
            var list3 = [];
            $.each(jsonResult, function (idx, obj) {
                var list1 = {
                    id: idx,
                    xq: obj['xueqi']['xqName'],
                    zy: obj['zhuanye']['zyName'],
                    bj: obj['banji']['bjName'],
                    xs: obj['student']['xsName'],
                    km: obj['kemu']['name'],
                    fs: obj['fenshu']
                };
                list3.push(list1);
            });

            console.log("list==" + list3);
            $('#table').bootstrapTable('destroy').bootstrapTable({
                columns: [{
                    field: 'id',
                    title: 'ID'
                }, {
                    field: 'xq',
                    title: '学期'
                }, {
                    field: 'zy',
                    title: '专业'
                }, {
                    field: 'bj',
                    title: '班级'
                }, {
                    field: 'xs',
                    title: '学生'
                }, {
                    field: 'km',
                    title: '科目'
                }, {
                    field: 'fs',
                    title: '分数'
                }],
                data: list3
            })
        }
    });

});

function actionFormatter(value, row, index) {
    return [
        '<a class="edit ml10" href="javascript:void(0)" title="Edit">',
        '<i class="glyphicon glyphicon-edit"></i>',
        '</a>',
        '<a class="remove ml10" href="javascript:void(0)" title="Remove">',
        '<i class="glyphicon glyphicon-remove"></i>',
        '</a>'
    ].join('');
}

// var opts = {
//     autoUpload: true,            // 当选择文件后立即自动进行上传操作
//     url: '/upload',  // 文件上传提交地址
//     file_data_name: 'file',			//定义表单参数
//     filters: {						//指定上传文件的类型、大小
//         mime_types: [
//             {title: 'excel文件', extensions: 'xls,xlsx'}
//         ],
//         max_file_size: '10mb'
//     },
//     chunk_size: '0',
//     multipart_params: {
//         randNum: Math.random()
//     }
//
// };
// $('#uploaderExcel').uploader(opts);
//
// $('table.datatable').datatable({
//     checkable: true,
//     checkByClickRow:true,
//     sortable:true,
//     minColWidth:1,
//
// });
//
// $('#chaxun').click(function () {
//     //1.查数据
//
//     $.get('/query',{},function (result) {
//         if(result && result['success']){
//             var jsonResult = result['data'];
//             console.log(jsonResult);
//
//             var list1=[];
//             var list3=[];
//             $.each(jsonResult, function(idx, obj) {
//                 list1=[idx,obj['xueqi']['xqName'],
//                            obj['zhuanye']['zyName'],
//                            obj['banji']['bjName'],
//                            obj['student']['xsName'],
//                            obj['kemu']['name'],
//                            obj['fenshu']];
//                 var list2={checked: true, data:list1};
//                 list3.push(list2);
//             });
//
//
//             $('table.datatable').datatable('load', {
//                 cols: [
//                     {width: '2px', text: '#', type: 'string', flex: false, colClass: ''},
//                     {width: '20px', text: '学期', type: 'string', flex: false, colClass: ''},
//                     {width: '20px', text: '专业', type: 'string', flex: false, colClass: ''},
//                     {width: '40px', text: '班级', type: 'string', flex: false, colClass: ''},
//                     {width: '5px', text: '姓名', type: 'string', flex: false, colClass: ''},
//                     {width: '10px', text: '科目', type: 'string', flex: false, colClass: ''},
//                     {width: '5px', text: '成绩', type: 'string', flex: false, colClass: ''},
//
//                 ],
//                 rows: list3
//             });
//         }
//     })
// });