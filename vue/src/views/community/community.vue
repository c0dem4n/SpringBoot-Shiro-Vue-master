<template>
  <div class="app-container">

    <el-table :data="list" border style="width: 100%" height="500">
      <el-table-column align="center" label="序号" width="80">
        <template slot-scope="scope">
          <span v-text="getIndex(scope.$index)"> </span>
        </template>
      </el-table-column>
      <el-table-column algin="center" prop="communityName" label="小区" width="120">
      </el-table-column>
      <el-table-column prop="communityId" label="编号" width="120"></el-table-column>
      <el-table-column prop="mianji" label="面积" width="120"></el-table-column>
      <el-table-column prop="rongjilv" label="容积率" width="120"></el-table-column>
      <el-table-column prop="lvhualv" label="绿化率" width="120"></el-table-column>
      <el-table-column prop="house" label="房屋数量" width="120"></el-table-column>
      <el-table-column prop="wuyetel" label="物业电话" width="120"></el-table-column>
      <el-table-column prop="wuyeName" label="物业公司" width="120"></el-table-column>
      <el-table-column fixed="right" label="操作" width="100">
        <template slot-scope="scope">
          <el-button @click="dialogVisible=true" type="text" >查看</el-button>
        </template>

      </el-table-column>

    </el-table>
    <el-dialog :title="提示" :visible.sync="dialogVisible" width="30%">
      <el-table :data="list" border style="width: 40%" height="300">
        <el-table-column prop="detail" label="详细信息" width="100%"></el-table-column>
      </el-table>
    </el-dialog>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="listQuery.pageNum"
      :page-size="listQuery.pageRow"
      :total="totalCount"
      :page-sizes="[10, 20, 50, 100]"
      layout="total, sizes, prev, pager, next, jumper">
    </el-pagination>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        totalCount: 0, //分页组件--数据总条数
        list: [],//表格的数据
        listLoading: false,//数据加载等待动画
        listQuery: {
          pageNum: 1,//页码
          pageRow: 50,//每页条数
          name: ''
        },

        dialogVisible: false,

        tempArticle: {
          id: "",
          content: ""
        }
      }
    },
    created() {
      this.getList();
    },
    methods: {
        getList() {
          //查询列表
          if (!this.hasPerm('user:list')) {
            return
          }
          this.listLoading = true;
          this.api({
            url: "/community/listInfo",
            method: "get",
            params: this.listQuery
          }).then(data => {
            this.listLoading = false;
            this.list = data.list;
            this.totalCount = data.totalCount;
          })
        },
        handleSizeChange(val) {
          //改变每页数量
          this.listQuery.pageRow = val
          this.handleFilter();
        },
        handleCurrentChange(val) {
          //改变页码
          this.listQuery.pageNum = val
          this.getList();
        },
        getIndex($index) {
          //表格序号
          return (this.listQuery.pageNum - 1) * this.listQuery.pageRow + $index + 1
        }
      }

  }
</script>
