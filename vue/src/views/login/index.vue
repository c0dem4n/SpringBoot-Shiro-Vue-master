<template>
  <div class="login-container">
    <div class="img" :style="img">
    <el-form autoComplete="on" :model="loginForm" :rules="loginRules" ref="loginForm" label-position="left"
             label-width="0px"
             class="card-box login-form">
      <h3 class="title">智慧社区环境管理平台</h3>
      <el-form-item prop="username">
        <span class="svg-container svg-container_login">
          <svg-icon icon-class="user"/>
        </span>
        <el-input v-model="loginForm.username" autoComplete="on"/>
      </el-form-item>
      <el-form-item prop="password">
        <span class="svg-container">
          <svg-icon icon-class="password"></svg-icon>
        </span>
        <el-input type="password" @keyup.enter.native="handleLogin" v-model="loginForm.password"
                  autoComplete="on"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" style="width:100%;"icon="plus"  @click="showCreate">
          注册
        </el-button>
      </el-form-item>
      <el-form-item>

        <el-button type="primary" style="width:100%;" :loading="loading" @click.native.prevent="handleLogin">
          登录
        </el-button>


      </el-form-item>
    </el-form>
      <el-dialog  :visible.sync="dialogFormVisible">
        <el-form class="small-space" :model="tempUser" label-position="left" label-width="80px"
                 style='width: 300px; margin-left:50px;'>
          <el-form-item label="用户名" required>
            <el-input type="text" v-model="tempUser.username">
            </el-input>
          </el-form-item>
          <el-form-item label="密码"  required>
            <el-input type="password" v-model="tempUser.password">
            </el-input>
          </el-form-item>
          <el-form-item label="昵称" required>
            <el-input type="text" v-model="tempUser.nickname">
            </el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button  type="success" @click="createUser">创 建</el-button>
        </div>
      </el-dialog>
  </div>
  </div>

</template>

<script>

  export default {
    name: 'login',
    data() {
      return {
        loginForm: {
          username: 'admin',
          password: '123456'
        },
        loginRules: {
          username: [{required: true, trigger: 'blur', message: "请输入用户名"}],
          password: [{required: true, trigger: 'blur', message: "请输入密码"}]
        },
        loading: false,

        dialogFormVisible: false,
        tempUser: {
          username: '',
          password: '',
          nickname: ''
        }
      }

    },

    methods: {
      createUser() {
        //添加新用户
        this.api({
          url: "/login/register",
          method: "post",
          data: this.tempUser
        }).then(() => {
          this.dialogFormVisible = false
        })
      },
      showCreate() {
        //显示新增对话框
        this.tempUser.username = "";
        this.tempUser.password = "";
        this.tempUser.nickname = "";
        this.dialogFormVisible = true
      },
      handleLogin() {
        this.$refs.loginForm.validate(valid => {
          if (valid) {
            this.loading = true
            this.$store.dispatch('Login', this.loginForm).then(data => {
              this.loading = false
              if ("success" === data.result) {
                this.$router.push({path: '/'})
              } else {
                this.$message.error("账号/密码错误");
              }
            }).catch(() => {
              this.loading = false
            })
          } else {
            return false
          }
        })
      }
    }
  }
</script>
<style rel="stylesheet/scss" lang="scss">
  @import "../../styles/mixin.scss";
  $bg: #2d3a4b;
  $dark_gray: #889aa4;
  $light_gray: #eee;

  .login-container {
    @include relative;
    height: 100vh;
    background-color: $bg;
    input:-webkit-autofill {
      -webkit-box-shadow: 0 0 0px 1000px #293444 inset !important;
      -webkit-text-fill-color: #fff !important;
    }
    input {
      background: transparent;
      border: 0px;
      -webkit-appearance: none;
      border-radius: 0px;
      padding: 12px 5px 12px 15px;
      color: black;
      height: 47px;
    }
    .el-input {
      display: inline-block;
      height: 47px;
      width: 85%;
    }
    .tips {
      font-size: 14px;
      color: #fff;
      margin-bottom: 10px;
    }
    .svg-container {
      padding: 6px 5px 6px 15px;
      color: $dark_gray;
      vertical-align: middle;
      width: 30px;
      display: inline-block;
      &_login {
        font-size: 20px;
      }
    }
    .title {
      font-size: 26px;
      color: $light_gray;
      margin: 0px auto 40px auto;
      text-align: center;
      font-weight: bold;
    }
    .login-form {
      position: absolute;
      left: 0;
      right: 0;
      width: 400px;
      padding: 35px 35px 15px 35px;
      margin: 120px auto;
    }
    .el-form-item {
      border: 1px solid rgba(255, 255, 255, 0.1);
      background: rgba(0, 0, 0, 0.1);
      border-radius: 5px;
      color: #454545;
    }
    .show-pwd {
      position: absolute;
      right: 10px;
      top: 7px;
      font-size: 16px;
      color: $dark_gray;
      cursor: pointer;
    }
    .thirdparty-button {
      position: absolute;
      right: 35px;
      bottom: 28px;
    }
    .img{
      background-size: cover;
      height: 100%;
      width: 100%;
      background-image: url("../../assets/background.png");
      background-position: top;
    }
  }
</style>
