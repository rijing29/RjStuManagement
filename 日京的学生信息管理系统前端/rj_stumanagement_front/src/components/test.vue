<template>
<!------------------------------------- 测试分页 --------------------------------->
 <div class="app">    
     <!-- 将获取到的数据进行计算 -->   
     <el-table :data="tableData.slice((currentPage-1)*PageSize,currentPage*PageSize)" style="width: 100%">
         <el-table-column prop="sno" label="学号" width="140" align="center" > </el-table-column>
         <el-table-column prop="sname" label="姓名" width="140" align="center" > </el-table-column>
        <el-table-column prop="saddress" label="住址" width="140" align="center"> </el-table-column>
     </el-table>
      <div class="tabListPage">
           <el-pagination @size-change="handleSizeChange" 
                          @current-change="handleCurrentChange" 
                          :current-page="currentPage" 
                          :page-sizes="pageSizes" 
                          :page-size="PageSize" 
                          layout="total, sizes, prev, pager, next, jumper" 
                          :total="totalCount">
             </el-pagination>
       </div>
</div>
</template>
<script>
export default {
   data(){
       return {
            // 总数据
           tableData:[],
           // 默认显示第几页
           currentPage:1,
           // 总条数，根据接口获取数据长度(注意：这里不能为空)
           totalCount:1,
           // 个数选择器（可修改）
           pageSizes:[1,2,3,4],
           // 默认每页显示的条数（可修改）
           PageSize:1,
       }
   },
 methods:{
       getData(){
              var url="/StuDisplay"
              // 发送axios请求  $http是我封装的接口地址
              this.$http.get(url).then(reponse=>{
                console.log(reponse)
                   // 将数据赋值给tableData
                   this.tableData=reponse.data
                   // 将数据的长度赋值给totalCount
                   this.totalCount=reponse.data.length
              })
         },
        // 每页显示的条数
       handleSizeChange(val) {
           // 改变每页显示的条数 
           this.PageSize=val
           // 注意：在改变每页显示的条数时，要将页码显示到第一页
           this.currentPage=1
       },
         // 显示第几页
       handleCurrentChange(val) {
           // 改变默认的页数
           this.currentPage=val
       },
   },
   created:function(){
         this.getData() 
   }
}
</script>
