<template>
  <div>
  <el-container style="height: 500px; border: 1px solid #eee">
    <el-header style="font-size:40px;background-color: rgb(238, 241, 246)">超市进销存管理系统</el-header>
    <el-container>
      <el-aside width="200px"> 
        <el-menu :default-openeds="['1','2']">
          <el-submenu index="1">
            <template slot="title"><i class="el-icon-message"></i>人员信息管理</template>
            <el-menu-item index="1-1">
              <router-link to="/emp">职工信息</router-link>
              </el-menu-item>
            <el-menu-item index="1-2">
              <router-link to="/sup">供应商信息</router-link>
              </el-menu-item>
          </el-submenu>
        </el-menu>       
        <el-menu :default-openeds="['1','2']">
          <el-submenu index="2">
          <template slot="title"><i class="el-icon-message"></i>商品信息管理</template>
          <el-menu-item index="2-1">
              <router-link to="/goods_info">商品基本信息</router-link>
            </el-menu-item>
            <el-menu-item index="2-2">
              <router-link to="/TyPe">商品种类信息</router-link>
            </el-menu-item>
            <el-menu-item index="2-3">
              <router-link to="/goods_sales">商品销售信息</router-link>
            </el-menu-item>
        </el-submenu>
        </el-menu>    
        <el-menu :default-openeds="['1','2','3']">
          <el-submenu index="3">
          <template slot="title"><i class="el-icon-message"></i>库存信息管理</template>
          <el-menu-item index="3-1">
              <router-link to="/WareHouse">仓库基本信息</router-link>
            </el-menu-item>
            <el-menu-item index="3-2">
              <router-link to="/goods_warehouse">商品库存信息</router-link>
            </el-menu-item>
            <el-menu-item index="3-3">
              <router-link to="/PurChase">进货信息</router-link>
            </el-menu-item>
            <el-menu-item index="3-4">
              <router-link to="/StoRage">入库信息</router-link>
            </el-menu-item>
            <el-menu-item index="3-5">
              <router-link to="/ReTrieval">出库信息</router-link>
            </el-menu-item>
            <el-menu-item index="3-6">
              <router-link to="/MoVe">移库信息</router-link>
            </el-menu-item>
            <el-menu-item index="3-7">
              <router-link to="/ReTurn">退货信息</router-link>
            </el-menu-item>
            
        </el-submenu>
        </el-menu>    
      </el-aside>  

        <el-main>
          <el-form :inline="true" :model="searchForm" class="demo-form-inline">
            <el-form-item label="供应商号">
              <el-input v-model="searchForm.Sno" placeholder="供应商号"></el-input>
            </el-form-item>
              <el-form-item label="姓名">
              <el-input v-model="searchForm.Sname" placeholder="姓名"></el-input>
            </el-form-item>
            <el-form-item label="电话">
              <el-input v-model="searchForm.Sphone" placeholder="电话"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="onSubmit">查询</el-button>
            </el-form-item>
            <el-form-item>
    <el-button type="primary" @click="addDialogVisible = true">新增</el-button>
  </el-form-item>
</el-form>

          <el-table :data="tableData" border>
            <el-table-column prop="sno" label="供应商号">
            </el-table-column>
            <el-table-column prop="sname" label="姓名">
            </el-table-column>
            <el-table-column prop="sphone" label="电话">
            </el-table-column>
            <el-table-column prop="sadress" label="地址">
            </el-table-column>
            <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button type="primary" @click="showEditDialog(scope.row)">修改</el-button>
          <el-button type="danger" size="mini" @click="confirmDelete(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog title="确认删除" :visible.sync="confirmDialogVisible" width="30%">
      <span>确定要删除该记录吗？</span>
      <span slot="footer" class="dialog-footer">
        <el-button @click="cancelDelete">取消</el-button>
        <el-button type="primary" @click="deletesupplier">确定</el-button>
      </span>
    </el-dialog>
          
          <el-dialog title="新增供应商" :visible.sync="addDialogVisible" width="30%">
  <el-form :model="newSupplier" :rules="addFormRules" ref="addForm" label-width="100px">
    <el-form-item label="供应商号" prop="Sno">
      <el-input v-model="newSupplier.Sno"></el-input>
    </el-form-item>
    <el-form-item label="姓名" prop="Sname">
      <el-input v-model="newSupplier.Sname"></el-input>
    </el-form-item>
    <el-form-item label="电话" prop="Sphone">
      <el-input v-model="newSupplier.Sphone"></el-input>
    </el-form-item>
    <el-form-item label="地址" prop="Sadress">
      <el-input v-model="newSupplier.Sadress"></el-input>
    </el-form-item>
  </el-form>

  <div slot="footer" class="dialog-footer">
    <el-button @click="addDialogVisible = false">取消</el-button>
    <el-button type="primary" @click="addSupplier">确认新增</el-button>
  </div>
</el-dialog>

<el-dialog title="修改供应商信息" :visible.sync="editDialogVisible" width="30%">
      <el-form :model="editForm" label-width="100px">
        <el-form-item label="供应商号">
          <el-input v-model="editForm.Sno"></el-input>
        </el-form-item>
        <el-form-item label="姓名">
          <el-input v-model="editForm.Sname"></el-input>
        </el-form-item>
        <el-form-item label="电话">
          <el-input v-model="editForm.Sphone"></el-input>
        </el-form-item>
        <el-form-item label="地址">
          <el-input v-model="editForm.Sadress"></el-input>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="saveEdit">保存</el-button>
          <el-button @click="cancelEdit">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

          
          <el-pagination v-if="showPagination" background layout="total, prev, pager, next,jumper"
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :total="totalCount" :page-size="pageSize">
          </el-pagination>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      tableData: [],
      searchForm: {
        Sno: '',
        name: '',
        phone: '',
        address: '',
      },
      newSupplier: {
        Sno: '',
        Sname: '',
        Sphone: '',
        Sadress: '',
      },
      editForm: {
        Sno: '',
        Sname: '',
        Sadress:'',
        Sphone: '',
      },
      addFormRules: {
      // 定义表单验证规则
      Sno: [
        { required: true, message: '请输入供应商号', trigger: 'blur' },
        // 其他规则...
      ],
      Sname: [
        { required: true, message: '请输入姓名', trigger: 'blur' },
        // 其他规则...
      ],
      Sphone: [
        { required: true, message: '请输入电话', trigger: 'blur' },
        // 其他规则...
      ],
      Sadress: [
        { required: true, message: '请输入地址', trigger: 'blur' },
        // 其他规则...
      ],
    },
      totalCount: 0,
      pageSize: 5,
      currentPage: 1,
      confirmDialogVisible: false, // 控制删除确认对话框的显示
      currentDeleteRow: null, // 当前待删除的行数据
      addDialogVisible: false,
      editDialogVisible: false,
    };
  },
  computed: {
  showPagination() {
    // 根据数据总数和每页显示数量判断是否显示分页组件
    return this.totalCount > 0;
  },
},
  methods: {
    getData() {
      // 发送异步请求，获取数据
      axios.get('http://localhost:8081/supplier').then((result) => {
        // 假设异步请求返回的数据为 result.data.data
        const totalData = result.data.data;
        // 更新总记录数
        this.totalCount = totalData.length;
        // 根据当前页码和每页显示数量计算起始索引和结束索引
        const startIndex = (this.currentPage - 1) * this.pageSize;
        const endIndex = startIndex + this.pageSize;
        // 截取对应页码的数据
        this.tableData = totalData.slice(startIndex, endIndex);
      });
    },
    onSubmit() {
  const { Sno, Sname, Sphone } = this.searchForm;
  const params = {
    page: this.currentPage,
    pagesize: this.pageSize,
    Sno: Sno|| null,
    Sname: Sname|| "",
    Sphone: Sphone|| null,
  };
  axios.get('http://localhost:8081/supplier1', { params })
    .then(response => {
      // 处理获取到的数据
      const responseData = response.data; // 假设返回的数据为对象形式
      this.tableData = responseData.data.rows; // 假设数据存储在对象的"data"属性的"rows"字段中
      this.totalCount = responseData.data.total; // 假设总数存储在对象的"data"属性的"total"字段中
    })
    .catch(error => {
      // 处理错误
      console.error('查询失败', error);
      // 显示错误消息
      this.$message({
        type: 'error',
        message: '查询失败，请重试！',
      });
    });
},
showEditDialog(row) {
      // 将员工信息赋值给 editForm 对象
      this.editForm.Sno = row.sno;
      this.editForm.Sname = row.sname;
      this.editForm.Sadress = row.sadress;
      this.editForm.Sphone = row.sphone;
      this.editDialogVisible = true;
    },
    saveEdit() {
      axios
        .post(`http://localhost:8081/supplier/${this.editForm.Sno}/${this.editForm.Sname}/${this.editForm.Sphone}/${this.editForm.Sadress}`)
        .then(() => {
          // 处理删除成功的逻辑
          console.log('保存成功');
          // 重新获取数据
          this.getData();
          // 显示删除成功的消息
          this.$message({
            type: 'success',
            message: '保存成功！',
          });
        })
        .catch((error) => {
          // 处理删除失败的逻辑
          console.error('保存失败', error);
          // 显示删除失败的消息
          this.$message({
            type: 'error',
            message: '保存失败，请重试！',
          });
        })
      this.editDialogVisible = false;
    },
    cancelEdit() {
      this.editDialogVisible = false;
    },
cancelDelete() {
  this.confirmDialogVisible = false;
  this.currentDeleteRow = null;
},
deletesupplier() {
  console.log('正在删除供应商...');
  const sno = this.currentDeleteRow.sno; // 修改这里的属性名称
  // 发送异步请求删除数据
  axios
    .delete(`http://localhost:8081/supplier/${sno}`)
    .then(() => {
      // 处理删除成功的逻辑
      console.log('删除成功');
      // 重新获取数据
      this.getData();
      // 显示删除成功的消息
      this.$message({
        type: 'success',
        message: '删除成功！',
      });
    })
    .catch((error) => {
      // 处理删除失败的逻辑
      console.error('删除失败', error);
      // 显示删除失败的消息
      this.$message({
        type: 'error',
        message: '删除失败，请重试！',
      });
    })
    .finally(() => {
      this.cancelDelete(); // 删除完成后关闭对话框
    });
},
addSupplier() {
  // 发送异步请求添加供应商数据
  axios.post('http://localhost:8081/supplier', this.newSupplier)
    .then(() => {
      // 处理添加成功的逻辑
      console.log('添加成功');
      // 关闭新增供应商对话框
      this.addDialogVisible = false;
      // 清空表单数据
      this.newSupplier = {
        Sno: '',
        Sname: '',
        Sphone: '',
        Sadress: '',
      };
      // 重新获取数据
      this.getData();
      // 显示添加成功的消息
      this.$message({
        type: 'success',
        message: '添加成功！',
      });
    })
    .catch((error) => {
      // 处理添加失败的逻辑
      console.error('添加失败', error);
      // 显示添加失败的消息
      this.$message({
        type: 'error',
        message: '添加失败，请重试！',
      });
    });
},
    handleSizeChange(val) {
      // 更新每页记录数
      this.pageSize = val;
      // 重新获取数据
      this.getData();
    },
    handleCurrentChange(val) {
      // 更新当前页码
      this.currentPage = val;
      // 重新获取数据
      this.getData();
    },
  },
  mounted() {
    // 初始化数据
    this.getData();
  },
};
</script>

<style>

</style>
