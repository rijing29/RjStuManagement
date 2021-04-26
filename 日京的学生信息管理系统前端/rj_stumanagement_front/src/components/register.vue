<template>
    <div>
        <el-container>
            <el-container>
              <el-header>日京的学生信息管理系统注册界面</el-header>
              <el-main>
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
                  <el-button type="primary" size="medium" @click="register">注册</el-button>
              </el-main>
            </el-container>
        </el-container>
    </div>
</template>
<script>
export default {
    data(){
        return{
            sno:'',
            sname:'',
            sage:'',
            saddress:'',
            spwd:''
        }
    },
    methods:{
        // 注册功能的实现
        register(){
             var url="/register"
            var params={
                'sno':this.sno,
                'sname':this.sname,
                'sage':this.sage,
                'saddress':this.saddress,
                'spwd':this.spwd
            }
            this.$http.get(url,{params}).then(res=>{
                if(res.data==200){
                    this.$message.success('注册成功')
                    this.$router.push('/login')
                }else{
                    this.$message.error('注册失败')
                }
            })
        }
    }
}
</script>
<style scoped>
 .login_container{
    background-color:#2b4b6b;
    height: 100%;
 }
 .el-form-item{
     color: white;
 }
 .el-header{
    background-color: #B3C0D1;
    color: rgb(255, 255, 255);
    text-align: center;
    line-height: 60px;
    font-size: 26px;
  }
  
  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 82px;
    font-weight: bold;
  }
</style>