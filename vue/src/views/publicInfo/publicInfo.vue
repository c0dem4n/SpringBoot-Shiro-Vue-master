<template>
  <div class="app-container">
    <div class="filter-container">
      <el-form>
        <el-form-item>
          <el-button type="primary" icon="plus" @click="showCreate" v-if="hasPerm('role:add')">添加
          </el-button>
        </el-form-item>
      </el-form>
    </div>
    <el-table :data="list" border style="width: 100%" v-loading.body="listLoading" element-loading-text="拼命加载中" border fit
              highlight-current-row>
      <el-table-column align="center" label="序号" width="80">
        <template slot-scope="scope">
          <span v-text="getIndex(scope.$index)"> </span>
        </template>
      </el-table-column>
      <el-table-column align="center" prop="title" label="主题" width="120"></el-table-column>
      <el-table-column align="center" prop="content" label="内容" width="600"></el-table-column>
      <el-table-column align="center" prop="nickName" label="创建者" width="100"></el-table-column>
      <el-table-column align="center" label="创建时间" width="100">
        <template slot-scope="scope">
          <span>{{scope.row.createTime}}</span>
        </template>
      </el-table-column>
      <el-table-column align="center" label="管理" width="200" v-if="hasPerm('role:update')">
        <template slot-scope="scope">

          <el-button type="text" icon="delete" @click="removeInfo(scope.$index)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="listQuery.pageNum"
      :page-size="listQuery.pageRow"
      :total="totalCount"
      :page-sizes="[10, 20, 50, 100]"
      layout="total, sizes, prev, pager, next, jumper">
    </el-pagination>
    <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible" width="70%" >
      <el-form class="small-space" :model="tempInfo" label-position="left" label-width="80px"
               style='width: 300px; margin-left: 100px;'>
        <el-form-item>

      <el-input type="text" v-model="tempInfo.title" placeholder="请输入主题" style="width: 120%;margin-left: 30px">
        <template slot="prepend">通知</template>
      </el-input>
        </el-form-item>
        <el-input type="textarea" :rows="5" v-model="tempInfo.content" text-align="right"placeholder="请输入内容" style="width: 700px">
        </el-input>
        <el-row>
        <el-col :span="12">
        <el-form-item label="身份" style="width: 16em;">
          <el-select  v-model="tempInfo.roleId" placeholder="请选择">
          <el-option v-for="item in options"
                     :key="item.value"
                     :label="item.label"
                     :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        </el-col>
          <el-col span="12">
          <el-form-item label="创建者" style="width: 16em;margin-left: 320px" text-align="right">
          <el-input type="text" v-model="tempInfo.nickName">
          </el-input>
        </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button v-if="dialogStatus=='create'" type="success" @click="createInfo">创 建</el-button>
        <el-button type="primary" v-else @click="updateInfo">修 改</el-button>
      </div>
    </el-dialog>
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
        dialogStatus: 'create',
        dialogFormVisible: false,
        textMap: {
          update: '编辑',
          create: '创建公共信息通知'
        },
        tempInfo: {
          id: "",
          roleId:"",
          nickName:"",
          title:"",
          content: ""
        },
        options: [{
          value: '1',
          label: '超级管理员'
        }, {
          value: '2',
          label: '物业'
        }, {
          value: '3',
          label: '运维'
        }, {
          value: '4',
          label: '街道政府'
        }],
        value: ''

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
          url: "/publicInfo/getListInfo",
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
      },
      showCreate() {
        //显示新增对话框
        this.tempInfo.content = "";
        this.dialogStatus = "create"
        this.dialogFormVisible = true
      },
      createInfo() {
        //保存新文章
        this.api({
          url: "/publicInfo/addInfo",
          method: "post",
          data: this.tempInfo
        }).then(() => {
          this.getList();
          this.dialogFormVisible = false
        })
      },

      removeInfo($index) {
        let _vue = this;
        this.$confirm('确定删除此通知?', '提示', {
          confirmButtonText: '确定',
          showCancelButton: false,
          type: 'warning'
        }).then(() => {
          let id = _vue.list[$index];
          _vue.api({
            url: "/publicInfo/deleteInfo",
            method: "post",
            data: id
          }).then(() => {
            _vue.getList()
          }).catch(() => {
            _vue.$message.error("删除失败")
          })
        })
      },
    }
  }
</script>
