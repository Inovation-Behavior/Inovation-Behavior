<template>
    <el-card style="border-radius: 15px;width: 100%;">
        <el-form :model="form" size="large" label-position="top">
            <p>C01</p>
            <p>C02</p>
            <p>C03</p>
        </el-form>
    </el-card>
    <el-button type="primary" @click="submit()" style="margin-top: 1vh;margin-left: 2vw;">submit part 3</el-button>
</template>

<script>
export default {
    data() {
        return {
            form: {
                
            },
        }
    },
    methods: {
        showQ7_1() {
            return this.form.Q7.length > 0 && !this.form.Q7.includes('No');
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
:deep(.el-radio__label) {
    white-space: normal;
    /* 换行 */
}

:deep(.el-checkbox__label) {
    white-space: normal;
    /* 换行 */
}
</style>
