<template>
    <div class="login_container">
        <div class="login_box">
            <!-- 头像区 -->
            <div class="avatar_box">
                <img src="../assets/J.png" alt="">
            </div>
            <!-- 表单区 -->
            <el-form  label-width="0px" class="login_form">
                <!-- 用户名 -->
                <el-form-item prop="username">
                    <el-input v-model="sname" prefix-icon="el-icon-user"></el-input>
                </el-form-item>
                <!-- 密码 -->
                <el-form-item prop="password">
                    <el-input v-model="spwd" prefix-icon="el-icon-lock" type="password"></el-input>
                </el-form-item>
                <!-- 按钮 -->
                <el-form-item class="btns">
                    <el-button type="primary" @click="login">登录</el-button>
                    <el-button type="info" @click="register">注册</el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>
<script>
export default {
    data(){
        return{
            sname:'',
            spwd:''
        }
    },
    methods:{
        // 登录
        login(){
            var url="/login"
            var params={
                'sname':this.sname,
                'spwd':this.spwd
            }
            this.$http.get(url,{params}).then(res=>{
                if(res.data==200){
                    this.$message.success('登陆成功')
                    this.$router.push('/Studisplay')
                }else{
                    this.$message.error('登陆失败')
                }
            })
        },
        // 点击注册跳转到注册页面
        register(){
            this.$router.push('/register')
        }
    }
}
</script>
<style scoped>
    .login_container{
        background-color:#2b4b6b;
        height: 100%;
    }
    .login_box{
        width: 450px;
        height: 300px;
        background-color: white;
        border-radius: 3px;
        position:absolute;
        top: 50%;
        left: 50%;
        margin-left: -225px;/*子div宽度的一半*/
        margin-top: -150px; /*子div高度的一半*/
    }
    .avatar_box{
        height: 130px;
        width: 130px;
        border: 1px solid #eee;
        border-radius: 50%;
        padding: 10px;
        box-shadow: 0 0 10px #ddd;
        position: absolute;
        left:50%;
        transform: translate(-50%,-50%);
        background-color: #fff;
        
    }
    img{
        width: 100%;
        height: 100%;
        border-radius: 50%;
        background-color: rgb(247, 246, 246);
    }
    .btns{
        display: flex;
        justify-content: flex-end;
    }
    .login_form{
        position: absolute;
        bottom: 0;
        width: 100%;
        padding: 0 20px;
        box-sizing: border-box;
    }
</style>