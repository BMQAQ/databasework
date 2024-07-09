<template>
  <div>
    <el-container style="height: 500px; border: 1px solid #eee">
      <el-header style="display: flex; justify-content: space-between; align-items: center; background-color: rgb(238, 241, 246)">
        <h1 style="font-size: 40px; margin: 0;">超市进销存管理系统</h1>
        <el-popover placement="bottom-end" width="160" trigger="hover">
          <div style="text-align: right; margin: 0;">
            <el-button type="primary" size="mini" @click="handleEditPassword">修改密码</el-button>
          </div>
        </el-popover>
      </el-header>

      <!-- 其他内容 -->
    </el-container>
    <input ref="fileInput" type="file" style="display: none" @change="handleFileChange" />
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      avatarUrl: ''
    };
  },
  methods: {
    handleEditAvatar() {
      this.$refs.fileInput.click();
      console.info("账号是"+this.$route.params.Eno);  
    },
    handleEditPassword() {
      // 处理修改密码逻辑
    },
    handleFileChange(event) {
      const file = event.target.files[0];
      this.uploadAvatar(file);
    },
    uploadAvatar(file) {
      const eno = this.$route.params.Eno;
      const apiUrl = `http://localhost:8081/login1/${eno}`;

      const isJPG = file.type === 'image/jpeg';
      const isLt2M = file.size / 1024 / 1024 < 2;

      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!');
        return;
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!');
        return;
      }

      // 创建 FormData 对象，用于发送文件和其他数据
      const formData = new FormData();
      formData.append('avatar', file);

      // 发送 POST 请求将头像文件上传到服务器
      axios.post(apiUrl, formData, {
        headers: {
          'Content-Type': 'multipart/form-data'
        }
      })
        .then(response => {
          this.avatarUrl = response.data.avatarUrl;
          this.$message.success('头像上传成功！');
        })
        .catch(error => {
          console.error('Failed to upload avatar:', error);
          this.$message.error('头像上传失败！');
        });
    },
  },
  created() {
    const eno = this.$route.params.Eno;
    const apiUrl = `http://localhost:8081/login1/${eno}`;

    axios.get(apiUrl)
      .then(response => {
        this.avatarUrl = response.data.avatarUrl;
        console.info(this.avatarUrl);
      })
      .catch(error => {
        console.error('Failed to fetch avatar URL:', error);
      });
  },
};
</script>

<style scoped>
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}
.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>
