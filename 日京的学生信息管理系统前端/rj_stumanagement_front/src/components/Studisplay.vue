<template>
    <div class="whole_con">
      <el-container>
          <el-container>
            <el-container>
              <el-main>
                <!-- 中间的学生信息展示 -->
                <el-table :data="tableData" stripe align=center header-align=center  style="width: 800px">
                    <el-table-column type="index"></el-table-column>
                    <el-table-column prop="sno" label="学号" width="140" align="center" > </el-table-column>
                    <el-table-column prop="sname" label="姓名" width="140" align="center" > </el-table-column>
                    <el-table-column prop="saddress" label="住址" width="140" align="center"> </el-table-column>
                    <el-table-column  prop="sage" label="年龄"  width="140" align="center"> </el-table-column>
                    <el-table-column  prop="spwd" label="密码"  width="140" align="center"> </el-table-column>
                    <el-table-column label="操作" width="180" align="center">
                        <template slot-scope="scope">
                          <div class="option_btn">
                            <el-button type="primary" icon="el-icon-edit" size="mini" @click="handleEdit(scope.row)">编辑</el-button>
                            <el-button type="danger" icon="el-icon-delete" size="mini" @click="handleDel(scope.row)">删除</el-button>
                          </div>
                        </template> 
                    </el-table-column>
                </el-table>
                <!-- 分页 -->
                <div class="block">
                  <el-pagination
                    @size-change="handleSizeChange" 
                    @current-change="handleCurrentChange" 
                    :current-page="paginations.currentPage" 
                    :page-sizes="paginations.pageSizes" 
                    :page-size="paginations.PageSize" 
                    layout="total, sizes, prev, pager, next, jumper" 
                    :total="tableData.length">
                  </el-pagination>
                </div>
                <el-button style="width: 70.5%;" type="success" icon="el-icon-circle-plus-outline" size="medium " @click="handleAdd()">新增</el-button>
                <!-- 编辑的弹出框 -->
                <el-dialog title="更改学生信息" :visible.sync="dialogVisible1" width="60%" :before-close="handleClose">
                  <el-form label-width="70px">
                    <el-form-item label="学号：" >
                      <el-input v-model="sno" autocomplete="off" :disabled="true"></el-input>
                    </el-form-item>
                    <el-form-item label="姓名：" >
                      <el-input v-model="sname" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="住址：" >
                      <el-input v-model="saddress" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="年龄" >
                      <el-input v-model="sage" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="密码：" >
                      <el-input v-model="spwd" autocomplete="off"></el-input>
                    </el-form-item>
                  </el-form>
                  <span slot="footer" class="dialog-footer">
                    <el-button @click="dialogVisible1 = false">取 消</el-button>
                    <el-button type="primary" @click="dialogUpdateConfirm">确 定</el-button>
                  </span>
                </el-dialog>
                <!-- 新增的弹出框 -->
                <el-dialog title="新增学生信息" :visible.sync="dialogVisible2" width="60%" :before-close="handleClose">
                  <el-form label-width="70px">
                    <el-form-item label="学号：" >
                      <el-input v-model="sno" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="姓名：" >
                      <el-input v-model="sname" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="住址：" >
                      <el-input v-model="saddress" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="年龄" >
                      <el-input v-model="sage" autocomplete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="密码：" >
                      <el-input v-model="spwd" autocomplete="off"></el-input>
                    </el-form-item>
                  </el-form>
                  <span slot="footer" class="dialog-footer">
                    <el-button @click="dialogVisible2 = false">取 消</el-button>
                    <el-button type="primary" @click="dialogAddConfirm">确 定</el-button>
                  </span>
                </el-dialog>
              </el-main>
            </el-container>
          </el-container>
      </el-container>
    </div>
</template>
<script>
export default {
    name:"Studisplay",
    data(){
        return{
            tableData: [],
            dialogVisible1: false,//控制更新弹出框的显示与否
            dialogVisible2: false,//控制新增弹出框的显示与否
            sno:'',
            sname:'',
            sage:'',
            saddress:'',
            spwd:'',
            //分页
            paginations:{
              // 默认显示第几页
              currentPage:1,
              // 个数选择器（可修改）
              pageSizes:[1,2,3,4],
              // 默认每页显示的条数（可修改）
              PageSize:4,
            },
        }
    },
    // 页面加载时就获取学生的所有信息
    created(){
      this.getStuList(this.paginations.PageSize,this.paginations.currentPage)
    },
    methods:{
      getStuList(PageSize,currentPage){
        // 要请求的地址
        var url="/stupage"
        var params={
          'pageSize':PageSize,
          'currPage':currentPage,
        }
        // 发送axios请求  $http是我封装的接口地址
        this.$http.get(url,{params}).then(res=>{
          // 把学生信息赋值给tableData
          this.tableData=res.data;
        })
      },
      // 编辑的逻辑
      handleEdit(row) {
        this.$confirm('是否更新此条数据, 是否继续?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning',
            center: true
        }).then(()=>{
          console.log(row.sno);//获取当前编辑学生的学号
          this.dialogVisible1=true;
          this.sno=row.sno,
          this.sname=row.sname,
          this.sage=row.sage,
          this.saddress=row.saddress,
          this.spwd=row.spwd
        })
      },
      //弹出框的关闭
      handleClose(done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
      },
      // 点击确认后的更新弹出框关闭
      dialogUpdateConfirm(){
        let that=this;
        // 要请求的地址
        var url="/update"
        var params={
          'sno': this.sno,
          'sname': this.sname,
          'sage': this.sage,
          'saddress': this.saddress,
          'spwd': this.spwd,
        }
        // 发送axios请求  $http是我封装的接口地址
        this.$http.get(url,{params}).then(res=>{
            console.log(res+"更新成功")
            window.location.reload();
        })
      },
      //删除的逻辑
      handleDel(row){
        let that=this;//改变this指向
        this.$confirm('是否删除此条数据, 是否继续?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning',
            center: true
        }).then(()=>{
          var url="del"
          var params={
            'sno':row.sno
          }
          this.$http.get(url,{params}).then(res=>{
              console.log(res+"删除成功")
              window.location.reload();
          })
        })
      },
       // 新增
      handleAdd(){
        this.dialogVisible2=true;
      },
      //点击确认后的新增弹出框关闭
      dialogAddConfirm(){
        let that=this;//改变this指向
        var url="add"
        var params={
          'sno': this.sno,
          'sname': this.sname,
          'sage': this.sage,
          'saddress': this.saddress,
          'spwd': this.spwd,
        }
        this.$http.get(url,{params}).then(res=>{
            console.log(res+"新增成功")
            window.location.reload();
        })
      },
      // //////////////////////////////////分页/////////////////////////////////
      // 每页显示多少条
      handleSizeChange(val) {
        // 改变每页显示的条数 
        this.paginations.PageSize=val
        // 注意：在改变每页显示的条数时，要将页码显示到第一页
        this.paginations.currentPage=1
        console.log(`每页 ${val} 条`);
      },
      // 现在显示当前页的第几页
      handleCurrentChange(val) {
        // 改变默认的页数
        this.paginations.currentPage=val
        console.log(`当前页: ${val}`);
      },
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      }
    }
}
</script>
<style>
  .el-header{
    background-color: #B3C0D1;
    color: rgb(255, 255, 255);
    text-align: center;
    line-height: 60px;
    font-size: 15px;
    padding: 0!important;
  }
  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    line-height: 200px;
    width:20%;
  }
  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 82px;
    font-weight: bold;
    padding: 0!important;
    width: 80%;
  }
  
  body > .el-container {
    margin-bottom: 40px;
  }
  
  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }
  
  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }
  .el-table{
    width: 90%!important;
    margin: 0 auto!important;
    margin-top: 32px!important;
  }
  .el-container{
      height: 100%;
  }
  .option_btn{
    display: flex;
    flex-direction: row;
    flex-wrap: nowrap;
  }
  .el-table__header tr,
  .el-table__header th {
      padding: 0;
      height: 60px;
      line-height: 60px;
  }
  .el-table__body tr,
  .el-table__body td {
      height: 60px;
      line-height: 60px;
  }
  .el-dialog__header{
    height: 59px!important;
  }
  /* 分页的样式 */
  .block{
    margin: 24px 0 24px 0;
    height: 11px;
  }
  /* 头部 */
  .head_con{
    display: flex;
    flex-direction: row;
    justify-content:space-between;
  }
  .head_title_con{
    background-color: #8aa3c2;
    width: 200px;
  }
  .el-dropdown{
    color: #ffffff!important; 
    width: 131px;
  }
  .dropdown_con{
    display: flex;
    flex-direction: row;
  }
  .el-icon--right{
      margin-top: 23px;
  }
  /* 侧边栏 */
  .el-col-12{
    width: 100%!important;
    height: 100%!important;;
  }
  .el-menu{
    height: 100%!important;
  }
  .el-submenu__icon-arrow{
    top: 52%;
    right: -56px;
    margin-top: -7px;
    position: absolute;
    transition: transform .3s;
    font-size: 12px;
  }
  /* 总体 */
  .whole_con{
    height:100%;
  }
  /* 个人信息 */
  .info_con{
    font-size: 19px;
    color: white!important;
  }
  .userimg_con{
    width: 25%;
    height: 47%;
    margin-top: 10%;
    margin-right: 5%;
  }
</style>