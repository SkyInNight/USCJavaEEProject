
var $testTable = $('#testTable');
$testTable.bootstrapTable({
    method: "get",
    url: 'BilibiliServlet',
    striped: true,
    pagination: true,
    sidePagination: 'server',
    pageNumber:1, //当前第几页
    pageSize: 10,
    pageList: [5, 10, 25, 50, 100],
    search: false,  //是否启用查询
    showColumns: true,  //显示下拉框勾选要显示的列
    showRefresh: true,  //显示刷新按钮
    sidePagination: "server", //表示服务端请求
    columns: [{
        field: 'title',
        title: '番名'
    }, {
        field: 'index_show',
        title: '连载数'
    }, {
        field: 'tags',
        title: '分类'
    }, {
        field: 'score',
        title: '评分'
    }, {
        field: 'play',
        title: '播放次数'
    },
    //     {
    //     // formatter: function (value, row, index) {
    //     //     return [
    //     //         '<a href="javascript:modifyPer(' + row.title + ",'" + row.index_show + "'," + row.tags + ",'" + row.score + ",'" + row.play + "'" + ')">' +
    //     //         '</a>',
    //     //
    //     //     ].join('');
    //     // }
    // }
    ]
});


