<template>
    <el-card style="border-radius: 15px;width: 100%;">
        <el-form :model="form" size="large" label-position="top">
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q1')">
                <!-- <el-date-picker
                    v-model="form.year"
                    type="year"
                    placeholder="Pick a year"
                /> -->
                <el-table ref="table"  height="340"  :data="tableDatas">
                <!-- :render-header="renderColumn1Header"  定义该列 render-header 方法，该方法返回 增加选择框  -->
                <el-table-column :render-header="renderColumn1Header" label="Column1" >
                        <template slot-scope="scope" >
                            <!--  定义选中事件，以及是否选中，Column1CheckedAll 控制全选，  -->
                            <el-checkbox  @change="checked => Column1CheckboxChange(checked, scope.row)"
                                    :checked="Column1CheckedAll != null ? Column1CheckedAll : scope.row.Column1Value != null">
                            </el-checkbox>
                            <span> {{ scope.row.Column1Value }}</span>
                        </template>
                    </el-table-column>
                    ... 
                    <!-- 省略其他列  -->
                </el-table>
            </el-form-item>
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q2')">
                
            </el-form-item>
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q3')">
                
            </el-form-item>
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q4')">
                <el-select v-model="form.area" filterable allow-create>
                    <el-option :label="$t('survey.P2Q4A1')" value="上海本地为主" />
                    <el-option :label="$t('survey.P2Q4A2')" value="全国" />
                    <el-option :label="$t('survey.P2Q4A3')" value="北美" />
                    <el-option :label="$t('survey.P2Q4A4')" value="欧洲" />
                    <el-option :label="$t('survey.P2Q4A5')" value="其他（请直接输入）" />
                </el-select>
            </el-form-item>
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q5')">

            </el-form-item>
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q6')">
                
            </el-form-item>
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q7')">
                <el-select v-model="form.Q7" :placeholder="$t('survey.PleaseChose')" allow-create multiple>
                    <el-option :label="$t('survey.P2Q7A1')" value="1" />
                    <el-option :label="$t('survey.P2Q7A2')" value="2" />
                    <el-option :label="$t('survey.No')" value="No" />
                </el-select>
            </el-form-item>
            <el-form-item v-if="showQ7_1()" style="font-weight: bolder;" :label="$t('survey.P2Q7_1')">
                <el-select v-model="form.Q7_1" :placeholder="$t('survey.PleaseChose')" allow-create multiple>
                    <el-option :label="$t('survey.P2Q7_1A1')" value="1" />
                    <el-option :label="$t('survey.P2Q7_1A2')" value="2" />
                    <el-option :label="$t('survey.P2Q7_1A3')" value="3" />
                    <el-option :label="$t('survey.P2Q7_1A4')" value="4" />
                    <el-option :label="$t('survey.P2Q7_1A5')" value="5" />
        
                </el-select>
            </el-form-item>
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q8')">
                <el-select v-model="form.update" :placeholder="$t('survey.PleaseChose')" allow-create multiple>
                    <el-option :label="$t('survey.P2Q8A1')" value="开发或管理专利的方法" />
                    <el-option :label="$t('survey.P2Q8A2')" value="信息处理或通信方法（如在线会议工具）" />
                    <el-option :label="$t('survey.P2Q8A3')" value="会计或其他行政操作方法" />
                    <el-option :label="$t('survey.P2Q8A4')" value="其他（请直接输入）" />
                </el-select>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>
export default {
    data() {
        return {
            form: {
                year: "",
                area:"",
                update:[],
                Q7: [],
                Q7_1: [],
                tableDatas: [1,2,2,2,2,2],
                Column1CheckedAll: null,
            },
        }
    },
    methods: {
        showQ7_1(){
            return this.form.Q7.length > 0 && !this.form.Q7.includes('No') ;
        },
         renderSO2Header(h, { column }) {
            return h(
                'div',
                [
                    //加入选择框，同时绑定事件
                    h('el-checkbox', {
                        on: {
                            // event为当前checkbox选中状态值（true/false）
                            change: ($event, column) => this.selectColumn1($event, column),
                        }
                    }),
                    // 加入label，值为 el-table-column 标签定义的 label="Column1"  及 Column1
                    h('span', column.label),
                ],
            )
        },
        selectColumn1(val, column) {
            //改变 Column1CheckAll 变量值 同时对表格进行 初始化 重新赋值
            this.Column1CheckAll = val;
            this.initTableData();
        },
    }
}
</script>


<style scoped>
:deep(.el-radio__label){
	white-space: normal;  /* 换行 */
}

:deep(.el-checkbox__label){
	white-space: normal;  /* 换行 */
}
</style>