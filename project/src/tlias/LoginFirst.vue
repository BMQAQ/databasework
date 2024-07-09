<template>
  <div class="login-container">
    <el-card class="login-card">
      <h2 v-if="title1" class="login-title">登录</h2>
      <el-form v-if="show1" class="login-form" :model="form" ref="loginForm">
        <el-form-item label="用户名" prop="username">
          <el-input v-model="form.username" placeholder="请输入用户名"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input type="password" v-model="form.password" placeholder="请输入密码"></el-input>
        </el-form-item>
        <el-form-item style="margin-bottom: 20px;">
          <el-button type="primary" @click="handleClick" style="margin-right: 180px;">登录</el-button>
          <el-button type="primary" @click="showChangePasswordForm">修改密码</el-button>
        </el-form-item>
      </el-form>
      <el-form v-if="showChangePassword" :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px"
        class="demo-ruleForm">

        <el-form-item label="用户名" prop="username">
          <el-input v-model="ruleForm.username"></el-input>
        </el-form-item>
        <el-form-item label="当前密码" prop="before">
          <el-input type="password" v-model="ruleForm.before" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="pass">
          <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="checkPass">
          <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'LoginComponent',
  data() {
    const validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'));
      } else {
        if (this.ruleForm.checkPass !== '') {
          this.$refs.ruleForm.validateField('checkPass');
        }
        callback();
      }
    };

    const validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'));
      } else if (value !== this.ruleForm.pass) {
        callback(new Error('两次输入密码不一致!'));
      } else {
        callback();
      }
    };

    return {
      form: {
        username: '',
        password: '',
      },
      ruleForm: {
        pass: '',
        checkPass: '',
        username: '',
        before: '',
      },
      rules: {
        pass: [{ validator: validatePass, trigger: 'blur' }],
        checkPass: [{ validator: validatePass2, trigger: 'blur' }],
      },
      showChangePassword: false,
      show1: true,
      title1: true,
      change: '0',
    };
  },

  methods: {
    handleClick() {
      this.login();
    },

    showChangePasswordForm() {
      this.showChangePassword = true;
      this.show1 = false;
      this.title1 = false;
    },
    login1() {
      const loginUrl = `http://localhost:8081/login/${this.ruleForm.username}/${this.ruleForm.before}`;

      return axios
        .post(loginUrl)
        .then((response) => {
          const code2 = response.data.code;

          if (code2 === 1) {
            //this.$message.success('登录成功！');
            return '1';
          } else {
            this.$message.error('登录失败！');
            return '0';
          }
        })
        .catch((error) => {
          console.error(error);
          this.$message.error('登录出现错误，请重试！');
          return '0';
        });
    },
    async submitForm() {
      this.change = await this.login1();
      if (this.change === '1') {
        const requestData = {
          username: this.ruleForm.username,
          checkPass: this.ruleForm.checkPass,
          before: this.ruleForm.before,
          pass: this.ruleForm.pass,
        };
        this.$message.success(this.change + this.ruleForm.username + this.ruleForm.pass);
        const changePasswordUrl = `http://localhost:8081/login1/${this.ruleForm.username}/${this.ruleForm.pass}`;
        axios
          .post(changePasswordUrl, requestData)
          .then((response) => {
            const code = response.data.code;
            if (code === 1) {
              this.$message.success('密码修改成功！');
              this.showChangePassword = false;
              this.show1 = true;
              this.title1 = true;
              this.$refs.ruleForm.resetFields();
            } else {
              this.$message.error('当前密码错误！');
            }
          })
          .catch((error) => {
            console.error(error);
          });
      } else if (this.change === '0') {
        //this.$message.error('用户名或密码错误！');
      }
    },





    login() {
      const loginUrl = `http://localhost:8081/login/${this.form.username}/${this.form.password}`;

      axios
        .post(loginUrl)
        .then((response) => {
          const code = response.data.code;

          if (code === 1) {
            const uposUrl = `http://localhost:8081/login/${this.form.username}`;
            this.$message.success('成功！');
            return axios.get(uposUrl);
          } else {
            this.$message.error('用户名或密码错误！');
          }
        })
        .then((response) => {
          if (response) {
            const upos = response.data.data;

            switch (upos) {
              case 1:
                console.log(this.form.username);
                this.$nextTick(() => {
                  this.$router.push({
                    name: 'goods_info2',
                    params: {
                      Eno: this.form.username,
                    },
                  });
                });
                break;
              case 2:
                this.$nextTick(() => {
                  this.$router.push({ name: 'emp' });
                });
                break;
              default:
                console.log('未知身份');
                break;
            }
          }
        })
        .catch((error) => {
          console.error(error);
        });
    },

    mounted() {
      console.log('当前登录用户的username:', this.form.username);
    },
  },
};
</script>

<style scoped>
.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #f5f7fa;
}

.login-card {
  width: 400px;
}

.login-title {
  font-size: 24px;
  text-align: center;
  margin-bottom: 20px;
}

.login-form {
  margin-bottom: 20px;
}
</style>
