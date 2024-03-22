<template>
    <el-card style="border-radius: 15px;width: 100%;">
        <el-form :model="form" size="large" label-position="top">
            <el-form-item style="font-weight: bolder;" label="E02.您是否了解以下专利许可机制？">
                <el-table :data="tablePEQ2" style="width: 100%">
                    <el-table-column>
                        <template #default="{ row }">
                            {{ row.name }}
                        </template>
                    </el-table-column>
                    <el-table-column v-for="(column, colIndex) in colPEQ2" :key="colIndex" :label="column.label">
                        <template #default="{ row }">
                            <!-- 在每个单元格内放置一个可选中的组件 -->
                            <el-checkbox v-model="row.selection[colIndex]"
                                @change="handlePEQ2(row, colIndex)"></el-checkbox>
                        </template>
                    </el-table-column>
                </el-table>
            </el-form-item>
            <el-form-item style="font-weight: bolder;" label="E02.您是否了解以下专利许可机制？">
                <el-table :data="tablePEQ2" style="width: 100%">
                    <el-table-column>
                        <template #default="{ row }">
                            {{ row.name }}
                        </template>
                    </el-table-column>
                    <el-table-column v-for="(column, colIndex) in colPEQ2" :key="colIndex" :label="column.label">
                        <template #default="{ row }">
                            <!-- 在每个单元格内放置一个可选中的组件 -->
                            <el-checkbox v-model="row.selection[colIndex]"
                                @change="handlePEQ2(row, colIndex)"></el-checkbox>
                        </template>
                    </el-table-column>
                </el-table>
            </el-form-item>
            <el-form-item style="font-weight: bolder;" label="E03.贵司是否参加过以下专利运营相关服务？">
                <el-table :data="tablePEQ3" style="width: 100%">
                    <el-table-column>
                        <template #default="{ row }">
                            {{ row.name }}
                        </template>
                    </el-table-column>
                    <el-table-column v-for="(column, colIndex) in colPEQ3" :key="colIndex" :label="column.label">
                        <template #default="{ row }">
                            <!-- 在每个单元格内放置一个可选中的组件 -->
                            <el-checkbox v-model="row.selection[colIndex]"
                                @change="handlePEQ3(row, colIndex)"></el-checkbox>
                        </template>
                    </el-table-column>
                </el-table>
            </el-form-item>
            <el-form-item style="font-weight: bolder;" label="E04.贵司是否获得过以下专利运营相关的政策资助？">
                <el-table :data="tablePEQ4" style="width: 100%">
                    <el-table-column>
                        <template #default="{ row }">
                            {{ row.name }}
                        </template>
                    </el-table-column>
                    <el-table-column v-for="(column, colIndex) in colPEQ4" :key="colIndex" :label="column.label">
                        <template #default="{ row }">
                            <!-- 在每个单元格内放置一个可选中的组件 -->
                            <el-checkbox v-model="row.selection[colIndex]"
                                @change="handlePEQ4(row, colIndex)"></el-checkbox>
                        </template>
                    </el-table-column>
                </el-table>
            </el-form-item>
            <el-form-item style="font-weight: bolder;" label="E05.您认为政府应当提升以下哪几类公共服务的投入？">
                <el-table :data="tablePEQ5" style="width: 100%">
                    <el-table-column>
                        <template #default="{ row }">
                            {{ row.name }}
                        </template>
                    </el-table-column>
                    <el-table-column v-for="(column, colIndex) in colPEQ5" :key="colIndex" :label="column.label">
                        <template #default="{ row }">
                            <!-- 在每个单元格内放置一个可选中的组件 -->
                            <el-checkbox v-model="row.selection[colIndex]"
                                @change="handlePEQ5(row, colIndex)"></el-checkbox>
                        </template>
                    </el-table-column>
                </el-table>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script setup>
import { ref, reactive } from 'vue';
const form = reactive({
    pEq01: [],
    pEq02: [],
    pEq03: [],
    pEq04: [],
    pEq05: [],
});

//以下实现所有表格
const tablePEQ2 = ref([
    { name: "特斯拉的专利开放",selection: [false, false, false] },
    { name: "专利许可备案制度",selection: [false, false, false] },
    { name: "专利豁免",selection: [false, false, false] },
    { name: "专利强制许可制度",selection: [false, false, false] },
    { name: "专利开放许可制度",selection: [false, false, false] },
    { name: "药品专利池 MPP", selection: [false, false, false] },
    { name: "医药专利链接制度", selection: [false, false, false] },
    { name: "标准必要专利", selection: [false, false, false] },
]);

const colPEQ2 = [
    { label: "参与过" },
    { label: "了解，没参与过" },
    { label: "不太了解" },
];

// 处理单元格选中状态变化
const handlePEQ2 = (row, colIndex) => {
    // 取消当前行其他单元格的选中状态
    form.pEq02 = tablePEQ2
};

const tablePEQ3 = ref([
    { name: "参加提升知识产权运营能力的培训/公益讲座",selection: [false, false, false] },
    { name: "参加知识产权运营政策的政策咨询讲座",selection: [false, false, false] },
    { name: "参加专利技术的路演推介活动", selection: [false, false, false] },
    { name: "使用公共部门搭建的专利在线交易平台", selection: [false, false, false] },
    { name: "获得专利许可交易的定价指导", selection: [false, false, false] },
]);

const colPEQ3 = [
    { label: "没有" },
    { label: "一次" },
    { label: "多次" },
];

// 处理单元格选中状态变化
const handlePEQ3 = (row, colIndex) => {
    // 取消当前行其他单元格的选中状态
    form.pEq03 = tablePEQ3
};

const tablePEQ4 = ref([
    { name: "获得高价值专利的奖励", selection: [false, false, false] },
    { name: "获得知识产权试点示范项目奖励", selection: [false, false, false] },
    { name: "获得专利转移成果奖励", selection: [false, false, false] },
    { name: "获得专利续费的减免或补贴", selection: [false, false, false] },
    { name: "享受研发费用的加计扣除", selection: [false, false, false] },
    { name: "获得专利许可收益相关的税收减免", selection: [false, false, false] },
]);

const colPEQ4 = [
    { label: "没有" },
    { label: "一次" },
    { label: "多次" },
];

// 处理单元格选中状态变化
const handlePEQ4 = (row, colIndex) => {
    // 取消当前行其他单元格的选中状态
    form.pEq04 = tablePEQ4
};

const tablePEQ5 = ref([
    { name: "举办知识产权运营能力的培训/公益讲座", selection: [false, false, false] },
    { name: "举办知识产权运营政策的政策咨询讲座", selection: [false, false, false] },
    { name: "发布诸如《专利开放许可使用费估算指引》等指导手册", selection: [false, false, false] },
    { name: "举办专利技术的路演推介活动", selection: [false, false, false] },
    { name: "提供、搭建专利在线交易平台", selection: [false, false, false] },
    { name: "提供专利许可交易的公益性定价指导", selection: [false, false, false] },
    { name: "提供给高价值专利的奖励", selection: [false, false, false] },
    { name: "提供专利转移转化成果奖励", selection: [false, false, false] },
    { name: "获得专利续费的减免或补贴", selection: [false, false, false] },
    { name: "享受研发费用的加计扣除", selection: [false, false, false] },
    { name: "获得专利许可收益相关的税收减免", selection: [false, false, false] },
]);

const colPEQ5 = [
    { label: "没有" },
    { label: "一次" },
    { label: "多次" },
];

// 处理单元格选中状态变化
const handlePEQ5 = (row, colIndex) => {
    // 取消当前行其他单元格的选中状态
    form.pEq05 = tablePEQ5
};
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
