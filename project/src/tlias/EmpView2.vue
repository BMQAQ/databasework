<template>
  <div>
  <el-container style="height: 500px; border: 1px solid #eee">
    <el-header style="font-size:40px;background-color: rgb(238, 241, 246)">超市进销存管理系统</el-header>
    <el-container>
      <el-aside width="200px"> 
        <el-menu :default-openeds="['1','2']">
          <el-submenu index="2">
          <template slot="title"><i class="el-icon-message"></i>商品信息管理</template>
          <el-menu-item index="2-1">
              <router-link to="/goods_info2">商品基本信息</router-link>
            </el-menu-item>
            <el-menu-item index="2-2">
              <router-link to="/TyPe2">商品种类信息</router-link>
            </el-menu-item>
            <el-menu-item index="2-3">
              <router-link to="/goods_sales2">商品销售信息</router-link>
            </el-menu-item>
        </el-submenu>
        </el-menu>    
        <el-menu :default-openeds="['1','2','3']">
          <el-submenu index="3">
          <template slot="title"><i class="el-icon-message"></i>库存信息管理</template>
          <el-menu-item index="3-1">
              <router-link to="/WareHouse2">仓库基本信息</router-link>
            </el-menu-item>
            <el-menu-item index="3-2">
              <router-link to="/goods_warehouse2">商品库存信息</router-link>
            </el-menu-item>
            <el-menu-item index="3-3">
              <router-link to="/PurChase2">进货信息</router-link>
            </el-menu-item>
            <el-menu-item index="3-4">
              <router-link to="/StoRage2">入库信息</router-link>
            </el-menu-item>
            <el-menu-item index="3-5">
              <router-link to="/ReTrieval2">出库信息</router-link>
            </el-menu-item>
            <el-menu-item index="3-6">
              <router-link to="/MoVe2">移库信息</router-link>
            </el-menu-item>
            <el-menu-item index="3-7">
              <router-link to="/ReTurn2">退货信息</router-link>
            </el-menu-item>
            
        </el-submenu>
        </el-menu>    
      </el-aside>  
       
        <el-main>
          <el-form :inline="true" :model="searchForm" class="demo-form-inline">
            <el-form-item label="职工号">
              <el-input v-model="searchForm.eno" placeholder="职工号"></el-input>
            </el-form-item>
              <el-form-item label="姓名">
              <el-input v-model="searchForm.ename" placeholder="姓名"></el-input>
            </el-form-item>
            <el-form-item label="性别">
              <el-select v-model="searchForm.gender" placeholder="性别">
                <el-option label="男" value="男"></el-option>
                <el-option label="女" value="女"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="onSubmit">查询</el-button>
            </el-form-item>
            <el-form-item>
            <el-button type="primary" @click="addDialogVisible = true">新增</el-button>
            </el-form-item>
          </el-form>
        

          <el-table :data="tableData" border width="100%">
      <el-table-column prop="ename" label="姓名" width="200"></el-table-column>
      <el-table-column prop="eno" label="职工号" width="200"></el-table-column>
      <el-table-column prop="epos" label="职务"></el-table-column>
      <el-table-column prop="eid" label="身份证号"></el-table-column>
      <el-table-column prop="esex" label="性别" width="100"></el-table-column>
      <el-table-column prop="ephone" label="电话"></el-table-column>
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
        <el-button type="primary" @click="deleteEmployee">确定</el-button>
      </span>
    </el-dialog>

    <el-dialog title="新增员工" :visible.sync="addDialogVisible" width="30%">
  <el-form :model="addForm" label-width="100px">
    <el-form-item label="职工号">
      <el-input v-model="addForm.eno"></el-input>
    </el-form-item>
    <el-form-item label="姓名">
      <el-input v-model="addForm.ename"></el-input>
    </el-form-item>
    <el-form-item label="职务">
      <el-input v-model="addForm.epos"></el-input>
    </el-form-item>
    <el-form-item label="电话">
      <el-input v-model="addForm.ephone"></el-input>
    </el-form-item>
    <el-form-item label="性别">
      <el-select v-model="addForm.esex">
        <el-option label="男" value="男"></el-option>
        <el-option label="女" value="女"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="身份证号">
      <el-input v-model="addForm.eid"></el-input>
    </el-form-item>
  </el-form>

  
  
  <div slot="footer" class="dialog-footer">
    <el-button @click="addDialogVisible = false">取消</el-button>
    <el-button type="primary" @click="addEmployee">确定</el-button>
  </div>
</el-dialog>


  <el-dialog title="修改员工信息" :visible.sync="editDialogVisible" width="30%">
      <el-form :model="editForm" label-width="100px">
        <el-form-item label="职工号">
          <el-input v-model="editForm.eno"></el-input>
        </el-form-item>
        <el-form-item label="姓名">
          <el-input v-model="editForm.ename"></el-input>
        </el-form-item>
        <el-form-item label="职务">
          <el-input v-model="editForm.epos"></el-input>
        </el-form-item>
        <el-form-item label="电话">
          <el-input v-model="editForm.ephone"></el-input>
        </el-form-item>
        <el-form-item label="性别">
          <el-select v-model="editForm.esex">
            <el-option label="男" value="男"></el-option>
            <el-option label="女" value="女"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="身份证号">
          <el-input v-model="editForm.eid"></el-input>
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
      employees: [] ,
      tableData: [],
      searchForm: {
        eno: "",
        ename: "",
        gender: "",
        Epos:"",
        Eid:"",
        Ephone:"",
      },
      addForm: {
      eno: '',
      ename: '',
      epos: '',
      ephone: '',
      esex: '',
      eid: ''
    },
    editForm: {
        eno: '',
        ename: '',
        epos: '',
        ephone: '',
        esex: '',
        eid: '',
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
      axios.get('http://localhost:8081/employee').then((result) => {
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
    confirmDelete(row) {
      this.currentDeleteRow = row;
      this.confirmDialogVisible = true;
    },

    cancelDelete() {
      this.confirmDialogVisible = false;
      this.currentDeleteRow = null;
    },

    deleteEmployee() {
      const eno = this.currentDeleteRow.eno;
      // 发送异步请求删除数据
      axios
        .delete(`http://localhost:8081/employee/${eno}`)
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
  showEditDialog(row) {
      // 将员工信息赋值给 editForm 对象
      this.editForm.eno = row.eno;
      this.editForm.ename = row.ename;
      this.editForm.epos = row.epos;
      this.editForm.ephone = row.ephone;
      this.editForm.esex = row.esex;
      this.editForm.eid = row.eid;

      this.editDialogVisible = true;
    },
    saveEdit() {
      axios
        .post(`http://localhost:8081/employee/${this.editForm.eno}/${this.editForm.ename}/${this.editForm.epos}/${this.editForm.ephone}/${this.editForm.esex}/${this.editForm.eid}`)
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
onSubmit() {
  const { eno, ename, gender } = this.searchForm;
  const params = {
    page: this.currentPage,
    pagesize: this.pageSize,
    Eno: eno|| null, 
    name: ename|| "",
    sex: gender|| null,
  };
  axios.get('http://localhost:8081/employee1', { params })
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
    handleEdit(row) {
      // 处理编辑操作
      console.log('Edit row:', row);
    },
    addEmployee() {
    // 发送异步请求添加员工数据
    axios
      .post('http://localhost:8081/employee', this.addForm)
      .then(() => {
        // 处理添加成功的逻辑
        console.log('添加成功');
        // 关闭新增员工弹窗
        this.addDialogVisible = false;
        // 清空表单数据
        this.addForm = {
          eno: '',
          ename: '',
          epos: '',
          ephone: '',
          esex: '',
          eid: ''
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
  },
 
  mounted() {
    // 初始化数据
    this.getData();
  },
};
</script>

<style>

</style>


