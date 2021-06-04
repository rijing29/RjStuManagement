<template>
    <div class="whole_con">
      <el-container>
          <el-header>
            <div class="head_con">
              <span class="head_title_con">日京的学生信息管理系统</span>
              <!-- 个人信息下拉框 -->
              <el-dropdown>
                <span class="el-dropdown-link">
                  <div class="dropdown_con">
                    <img class="userimg_con" src="../assets/img/user.png" alt="">
                    <span class="info_con">王胡景</span>
                    <i class="el-icon-arrow-down el-icon--right"></i>
                  </div>
                </span>
                <el-dropdown-menu slot="dropdown">
                  <el-dropdown-item >个人信息</el-dropdown-item>
                  <el-dropdown-item divided @click.native="quitLogin">退出</el-dropdown-item>
                  <el-dropdown-item divided>修改密码</el-dropdown-item>
                </el-dropdown-menu>
              </el-dropdown>
            </div>
          </el-header>
          <el-container>
            <!-- 侧边栏 -->
            <el-aside width="200px">
              <el-col :span="12">
                <el-menu
                  default-active="2"
                  class="el-menu-vertical-demo"
                  @open="handleOpen"
                  @close="handleClose"
                  background-color="#545c64"
                  text-color="#fff"
                  active-text-color="#ffd04b"
                  router>
                  <el-menu-item index="/index">
                    <i class="el-icon-setting"></i>
                    <span slot="title">首页</span>
                  </el-menu-item>
                  <el-submenu index="2">
                    <template slot="title">
                      <i class="el-icon-document"></i>
                      <span>学生信息</span>
                    </template>
                    <el-menu-item-group>
                      <el-menu-item index="/Studisplay">学生信息展示页面</el-menu-item>
                      <el-menu-item index="1-2">我的活动</el-menu-item>
                    </el-menu-item-group>
                  </el-submenu>
                  <el-menu-item index="3">
                    <i class="el-icon-menu"></i>
                    <span slot="title">导航二</span>
                  </el-menu-item>
                  <el-menu-item index="4" disabled>
                    <i class="el-icon-document"></i>
                    <span slot="title">导航三</span>
                  </el-menu-item>
                  
                </el-menu>
              </el-col>
            </el-aside>
            <el-container>
              <el-main>
                  <!-- 路由占位符 -->
                  <router-view></router-view>
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
        }
    },
    methods:{
      quitLogin(){
        this.$router.push('/login')
        this.$message.success('退出登录成功')
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