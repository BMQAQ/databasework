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
                <el-form-item label="进货单号">
                  <el-input v-model="searchForm.POno" placeholder="进货单号"></el-input>
                </el-form-item>
                  <el-form-item label="商品号">
                  <el-input v-model="searchForm.goods_id" placeholder="商品号"></el-input>
                </el-form-item>
                <el-form-item>
              <el-button type="primary" @click="onSubmit">查询</el-button>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="addDialogVisible = true">新增</el-button>
            </el-form-item>
              </el-form>
              
              <el-table :data="tableData" border >
                <el-table-column prop="pono" label="进货单号" >
                </el-table-column>                
                <el-table-column prop="eno" label="职工号">
                </el-table-column>
                <el-table-column prop="goodsid" label="商品号">
                </el-table-column>
                <el-table-column prop="sno" label="供应商号" >
                </el-table-column>
                <el-table-column prop="wno" label="仓库号">
                </el-table-column>
                <el-table-column prop="ponum" label="进货数量">
                </el-table-column>
                <el-table-column prop="potime" label="进货时间">
                </el-table-column>
                <el-table-column label="操作">
  <template slot-scope="scope">
    <div class="button-container">
      <el-button type="primary" size="mini" @click="handleEdit(scope.row)">编辑</el-button>
      <el-button type="danger" size="mini" @click="confirmDelete(scope.row)">删除</el-button>
    </div>
  </template>
</el-table-column>
          </el-table>

          <el-dialog title="新增进货信息" :visible.sync="addDialogVisible" width="30%">
            <el-form :model="purchase" :rules="addFormRules" ref="addForm" label-width="100px">
              <el-form-item label="进货单号" prop="pono">
                <el-input v-model="purchase.pono"></el-input>
              </el-form-item>
              <el-form-item label="商品号" prop="goodsid">
                <el-input v-model="purchase.goodsid"></el-input>
              </el-form-item>
              <el-form-item label="仓库号" prop="wno">
                <el-input v-model="purchase.wno"></el-input>
              </el-form-item>
              <el-form-item label="供应商号" prop="sno">
                <el-input v-model="purchase.sno"></el-input>
              </el-form-item>
              <el-form-item label="进货数量" prop="ponum">
                <el-input v-model="purchase.ponum"></el-input>
              </el-form-item>
              <el-form-item label="销售时间" prop="potime">
                <el-date-picker v-model="purchase.potime" type="date"></el-date-picker>
              </el-form-item>
              <el-form-item label="职工号" prop="eno">
                <el-input v-model="purchase.eno"></el-input>
              </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
              <el-button @click="addDialogVisible = false">取消</el-button>
              <el-button type="primary" @click="addpurchase">确认新增</el-button>
            </div>
          </el-dialog>

          <el-dialog title="确认删除" :visible.sync="confirmDialogVisible" width="30%">
            <span>确定要删除该记录吗？</span>
            <span slot="footer" class="dialog-footer">
              <el-button @click="cancelDelete">取消</el-button>
              <el-button type="primary" @click="deleteEmployee">确定</el-button>
            </span>
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
            POno:"",
            POtime:"",
            Eno:"",
            goodsid:"",
            Sno:"",
            Wno:"",
            POnum:"",
          },
      purchase: {
        pono: "",
        goodsid: "",
        sno:"",
        wno: "",
        ponum: "",
        potime: '',
        eno: '',
      },
          totalCount: 0,
      pageSize: 5,
      currentPage: 1,
      confirmDialogVisible: false, // 控制删除确认对话框的显示
      currentDeleteRow: null, // 当前待删除的行数据
      addDialogVisible: false,
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
      axios.get('http://localhost:8081/purchase').then((result) => {
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
      const POno = this.currentDeleteRow.pono;
      const goodsid = this.currentDeleteRow.goodsid;
      // 发送异步请求删除数据
      axios
        .delete(`http://localhost:8081/purchase/${POno}/${goodsid}`)
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
    onSubmit() {
  const { SOno,goods_id } = this.searchForm;
  const params = {
    page: this.currentPage,
    pagesize: this.pageSize,
    goods_id: goods_id|| null,
    SOno: SOno|| "",
  };
  axios.get('http://localhost:8081/purchase1', { params })
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
    addpurchase() {
  axios
    .post('http://localhost:8081/purchase', this.purchase)
    .then(() => {
      // 处理添加成功的逻辑
      console.log('添加成功');
      // 关闭新增对话框
      this.addDialogVisible = false;
      // 清空表单数据
      this.purchase = {
        pono: "",
        goodsid: "",
        sno:"",
        wno: "",
        ponum: "",
        potime: '',
        eno: '',
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
    handleEdit(row) {
      // 处理编辑操作
      console.log('Edit row:', row);
    },
    handleDelete(row) {
      // 处理删除操作
      console.log('Delete row:', row);
    },
  },
  mounted() {
    // 初始化数据
    this.getData();
  },
};
</script>

<style>
.button-container {
  display: flex;
  align-items: center;
}
</style>
