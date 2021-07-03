<template>
    <div>
        <el-header>日京的学生信息管理系统修改密码界面</el-header>
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="用户名：" >
                <el-input v-model="sname" autocomplete="off" disabled></el-input>
            </el-form-item>
            <el-form-item label="新密码" prop="newPwd">
                <el-input v-model="ruleForm.newPwd" clearable size="small" type="password"></el-input>
            </el-form-item>
            <el-form-item label="确认密码" prop="confirmPwd">
                <el-input v-model="ruleForm.confirmPwd" clearable size="small" type="password"></el-input>
            </el-form-item>
            <el-form-item>
            <el-button class="btn_con" type="primary" size="medium" @click="resetPwd">修改密码</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
export default {
      name:"resetPwd",
      data() {
        var validatePass = (rule, value, callback) => {
            if (value === '') {
                    callback(new Error('请输入密码'));
            } else {
            if (this.ruleForm.confirmPwd !== '') {
                this.$refs.ruleForm.validateField('confirmPwd');
            }
            callback();
            }
        };
        var validatePass2 = (rule, value, callback) => {
            if (value === '') {
                callback(new Error('请再次输入密码'));
            } else if (value !== this.ruleForm.newPwd) {
                callback(new Error('两次输入密码不一致!'));
            } else {
                callback();
            }
        };
        return {
            changePwdDialog:false,//修改密码弹框
            ruleForm: {
                newPwd: '',
                confirmPwd:''
            },
            rules: {
                newPwd: [
                    { required: true, message: '请输入密码', trigger: 'blur' },
                    { min: 6, max: 16, message: '长度在 6 到 16 个字符', trigger: 'blur' },
                    { validator: validatePass, trigger: 'blur' }
                ],
                confirmPwd:[
                    { required: true, message: '请确认密码', trigger: 'blur' },
                    { min: 6, max: 16, message: '长度在 6 到 16 个字符', trigger: 'blur' },
                    { validator: validatePass2, trigger: 'blur', required: true }
                ],
            },
            sno:'',
            sname:'',
            spwd:''
        }
    },
    created(){
        this.getSname()
    },
    methods:{
        // 修改密码功能的实现
        resetPwd(){
            var url="/resetPwd"
            var params={
                'sno':this.sno,
                'spwd':this.ruleForm.newPwd
            }
            this.$http.get(url,{params}).then(res=>{
                if(res.data==200){
                    this.$message.success('修改成功')
                    this.$router.push('/login')
                }else{
                    this.$message.error('修改失败')
                }
            })
        },
        // 获取从home.vue中传过来的sname
        getSname(){
          var sname=this.$route.query.sname
          this.sname=sname
          // 根据sname获得sno
          var url="/getSno"
          var params={
              'sname':this.sname,
          }
          this.$http.get(url,{params}).then(res=>{
              this.sno=res.data
          })
        },
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
  .el-form{
    background-color: #E9EEF3;
    padding-top: 10px;
    padding-bottom: 10px;
  }
  .btn_con{
      /* width: 100%; */
      margin-left: 44%;
  }
</style>