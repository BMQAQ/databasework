<template>
  <div>
    <el-container style="height: 500px; border: 1px solid #eee">
      <el-header style="font-size:40px;background-color: rgb(238, 241, 246)">超市进销存管理系统</el-header>
      <el-container>
        <el-aside width="200px">
          <el-menu :default-openeds="['1', '2']">
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
          <el-menu :default-openeds="['1', '2']">
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
          <el-menu :default-openeds="['1', '2', '3']">
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
          <el-menu :default-openeds="['1']">
            <el-submenu index="1"> 
                <template slot="title"><i class="el-icon-message"></i>账号信息管理</template>
            <el-menu-item index="3-1">
                <router-link to="/Emp_Info">基本信息</router-link>
              </el-menu-item>
            </el-submenu>
          </el-menu>    
        </el-aside>

        <el-main>
          <el-form :inline="true" :model="searchForm" class="demo-form-inline">
            <el-form-item label="商品号">
              <el-input v-model="searchForm.Goods_id" placeholder="商品号"></el-input>
            </el-form-item>
            <el-form-item label="商品名">
              <el-input v-model="searchForm.Goods_name" placeholder="商品名"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="onSubmit">查询</el-button>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="addDialogVisible = true">新增</el-button>
            </el-form-item>
          </el-form>

          <el-table :data="tableData" border>
            <el-table-column prop="goods_id" label="商品号">
            </el-table-column>
            <el-table-column prop="goods_name" label="商品名">
            </el-table-column>
            <el-table-column prop="purchase_price" label="商品进价">
            </el-table-column>
            <el-table-column prop="sale_price" label="商品售价">
            </el-table-column>
            <el-table-column prop="keepdate" label="保质期">
            </el-table-column>
            <el-table-column prop="unit" label="商品种类号">
            </el-table-column>
            <el-table-column prop="tyno" label="单位">
            </el-table-column>
            <el-table-column label="操作">
      <template slot-scope="scope">
        <el-button type="primary" @click="showEditDialog(scope.row)">修改</el-button>
      </template>
    </el-table-column>
          </el-table>

          <el-dialog title="新增商品" :visible.sync="addDialogVisible" width="30%">
            <el-form :model="newgoods" :rules="addFormRules" ref="addForm" label-width="100px">
              <el-form-item label="商品号" prop="goods_id">
                <el-input v-model="newgoods.goods_id"></el-input>
              </el-form-item>
              <el-form-item label="商品名" prop="goods_name">
                <el-input v-model="newgoods.goods_name"></el-input>
              </el-form-item>
              <el-form-item label="进价" prop="purchase_price">
                <el-input v-model="newgoods.purchase_price"></el-input>
              </el-form-item>
              <el-form-item label="售价" prop="sale_price">
                <el-input v-model="newgoods.sale_price"></el-input>
              </el-form-item>
              <el-form-item label="商品种类" prop="typeid">
                <el-select v-model="newgoods.typeid" placeholder="请选择">
                  <el-option v-for="item in type" :key="item.tyno" :label="`${item.tyno} - ${item.tyname}`"
                    :value="item.tyno"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="单位" prop="unit">
                <el-select v-model="newgoods.unit" placeholder="请选择">
                  <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-form>

            <div slot="footer" class="dialog-footer">
              <el-button @click="addDialogVisible = false">取消</el-button>
              <el-button type="primary" @click="addgoods">确认新增</el-button>
            </div>
          </el-dialog>

          <el-dialog title="修改商品信息" :visible.sync="editDialogVisible" width="30%">
      <el-form :model="editForm" label-width="100px">
        <el-form-item label="商品号">
          <el-input v-model="editForm.goods_id"></el-input>
        </el-form-item>
        <el-form-item label="商品名">
          <el-input v-model="editForm.goods_name"></el-input>
        </el-form-item>
        <el-form-item label="进价">
          <el-input v-model="editForm.purchase_price"></el-input>
        </el-form-item>
        <el-form-item label="售价">
          <el-input v-model="editForm.sale_price"></el-input>
        </el-form-item>
        <el-form-item label="保质期">
          <el-input v-model="editForm.keepdate"></el-input>
        </el-form-item>
        <el-form-item label="商品种类" prop="typeid">
                <el-select v-model="newgoods.typeid" placeholder="请选择">
                  <el-option v-for="item in type" :key="item.tyno" :label="`${item.tyno} - ${item.tyname}`"
                    :value="item.tyno"></el-option>
                </el-select>
              </el-form-item>
        <el-form-item label="单位" prop="unit">
                <el-select v-model="editForm.Tunit" placeholder="请选择">
                  <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
                  </el-option>
                </el-select>
              </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="saveEdit">保存</el-button>
          <el-button @click="cancelEdit">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

    <el-pagination
  v-if="showPagination"
  background
  layout="total, prev, pager, next, jumper"
  @size-change="handleSizeChange"
  @current-change="handleCurrentChange"
  :total="totalCount"
  :page-size="pageSize"
></el-pagination>
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
        Goods_id: "",
        Goods_name: "",
        Purchase_price: "",
        Sale_price: "",
        Eid: "",
        keepdate: "",
        unit: "",
        TYno: "",
      },
      newgoods: {
        goods_id: '',
        goods_name: '',
        purchase_price: '',
        sale_price: '',
        keepdate: "",
        typeid: "",
        unit: "",
      },
      editForm: {
        goods_id: '',
        goods_name: '',
        purchase_price: '',
        sale_price: '',
        keepdate: '',
        typeid:'',
        Tunit:'',
      },
      options: [{
        value: '只',
        label: '只'
      }, {
        value: '件',
        label: '件'
      }, {
        value: '箱',
        label: '箱'
      }],
      type: [],
      totalCount: 0,
      pageSize: 5,
      currentPage: 1,
      confirmDialogVisible: false, // 控制删除确认对话框的显示
      currentDeleteRow: null, // 当前待删除的行数据
      addDialogVisible: false,
      queryResult: [],
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
  axios
    .get('http://localhost:8081/goods', {
      params: {
        keyword: this.keyword, // 查询关键字
        pageSize: this.pageSize, // 每页显示数量
        currentPage: this.currentPage // 当前页码
      }
    })
    .then((result) => {
      // 假设异步请求返回的数据为 result.data.data
      const response = result.data;
      const totalData = response.data;
      // 更新总记录数
      this.totalCount = response.totalCount;
      // 更新表格数据
      this.tableData = totalData;
    })
    .catch((error) => {
      console.error('获取数据失败', error);
      this.$message.error('获取数据失败，请重试！');
    });
},
onSubmit() {
  const { Goods_id, Goods_name } = this.searchForm;
  const params = {
  page: parseInt(this.currentPage),
  pagesize: this.pageSize,
  Goods_id: Goods_id || null,
  Goods_name: Goods_name || "",
};
  axios.get('http://localhost:8081/goods1', { params })
    .then(response => {
      const responseData = response.data;
      this.queryResult = responseData.data.rows;
      this.totalCount = responseData.data.total;
      this.tableData = this.queryResult;
    })
    .catch(error => {
      console.error('查询失败', error);
      // 错误处理代码...
    });
},
    addgoods() {
      // 发送异步请求添加供应商数据
      axios.post('http://localhost:8081/goods', this.newgoods)
        .then(() => {
          // 处理添加成功的逻辑
          console.log('添加成功');
          // 关闭新增供应商对话框
          this.addDialogVisible = false;
          // 清空表单数据
          this.newgoods = {
            goods_id: '',
            goods_name: '',
            purchase_price: '',
            sale_price: '',
            keepdate: "",
            typeid: "",
            unit: "",
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
    showEditDialog(row) {
      // 将员工信息赋值给 editForm 对象
      this.editForm.goods_id = row.goods_id;
      this.editForm.goods_name = row.goods_name;
      this.editForm.purchase_price = row.purchase_price;
      this.editForm.sale_price = row.sale_price;
      this.editForm.keepdate = row.keepdate;
      this.editForm.typeid = row.typeid;
      this.editForm.Tunit = row.unit;

      this.editDialogVisible = true;
    },
    saveEdit() {
      axios
        .post(`http://localhost:8081/goods/${this.editForm.goods_id}/${this.editForm.goods_name}/${this.editForm.purchase_price}/${this.editForm.sale_price}/${this.editForm.keepdate}/${this.editForm.typeid}/${this.editForm.Tunit}`)
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
    deleteRow(row) {
      // 设置当前待删除的行数据
      this.currentDeleteRow = row;
      // 显示删除确认对话框
      this.confirmDialogVisible = true;
    },
    confirmDelete() {
      // 发送异步请求删除供应商数据
      const deleteRow = this.currentDeleteRow;
      axios.delete(`http://localhost:8081/goods/${deleteRow.goods_id}`)
        .then(() => {
          // 处理删除成功的逻辑
          console.log('删除成功');
          // 关闭删除确认对话框
          this.confirmDialogVisible = false;
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
        });
    },
    handlePageChange(currentPage) {
  this.currentPage = currentPage;
  this.onSubmit();
},
handleSizeChange(val) {
  this.pageSize = val;
  this.currentPage = 1; // 重置当前页码为 1
  this.onSubmit();
},
handleCurrentChange(val) {
  this.currentPage = val;
  this.onSubmit();
},
},
  mounted() {
  // 初始化时获取数据
  this.currentPage = 1;
  // 执行初始查询
  this.onSubmit();
},
  created() {
    // 在created生命周期钩子函数中获取商品种类数据
    axios.get('http://localhost:8081/goodstype')
      .then((response) => {
        if (response.data.code === 1) {
          // 将获取的商品种类数据赋值给type数组
          this.type = response.data.data;
        } else {
          console.error('获取商品种类失败');
        }
      })
      .catch((error) => {
        console.error('获取商品种类失败', error);
      });
  },
};
</script>

<style scoped>
/* 在此处添加组件的样式代码 */
</style>