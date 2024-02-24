<template>
    <el-card style="border-radius: 15px;width: 100%;">
        <el-form :model="form" size="large" label-position="top">
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P3Q1')">
                <el-table :data="tableP3Q1" style="width: 100%">
                    <el-table-column>
                    <template #default="{ row }">
                        {{ row.name }}
                    </template>
                    </el-table-column>
                    <el-table-column v-for="(column, colIndex) in colP3Q1" :key="colIndex" :label="column.label">
                    <template #default="{ row }">
                        <!-- 在每个单元格内放置一个可选中的组件 -->
                        <el-checkbox v-model="row.selection[colIndex]" @change="handleP3Q1(row, colIndex)"></el-checkbox>
                    </template>
                    </el-table-column>
                </el-table>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P3Q2')">
                <el-table :data="tableP3Q2" style="width: 100%">
                    <el-table-column>
                    <template #default="{ row }">
                        {{ row.name }}
                    </template>
                    </el-table-column>
                    <el-table-column v-for="(column, colIndex) in colP3Q2" :key="colIndex" :label="column.label">
                    <template #default="{ row }">
                        <!-- 在每个单元格内放置一个可选中的组件 -->
                        <el-checkbox v-model="row.selection[colIndex]" @change="handleP3Q2(row, colIndex)"></el-checkbox>
                    </template>
                    </el-table-column>
                </el-table>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P3Q3')">
                <el-table :data="tableP3Q3" style="width: 100%">
                    <el-table-column>
                    <template #default="{ row }">
                        {{ row.name }}
                    </template>
                    </el-table-column>
                    <el-table-column v-for="(column, colIndex) in colP3Q3" :key="colIndex" :label="column.label">
                    <template #default="{ row }">
                        <!-- 在每个单元格内放置一个可选中的组件 -->
                        <el-checkbox v-model="row.selection[colIndex]" @change="handleP3Q3(row, colIndex)"></el-checkbox>
                    </template>
                    </el-table-column>
                </el-table>
            </el-form-item>
                        
        </el-form>
    </el-card>
    <el-button type="primary" @click="submit()" style="margin-top: 1vh;margin-left: 2vw;">submit part C</el-button>
</template>

<script setup>
import enLocale from '../../locales/en.json';
import { useGeneralStore } from '../../stores/general';
import axios from 'axios';
import { ElMessage } from 'element-plus';
const store = useGeneralStore();
const submit = async () => {
    // 将表单数据转换为对象数组
    const formDataArray = Object.entries(form).map(([key, value]) => ({ [key]: value }));

    // 将对象数组字符串化
    const formDataString = JSON.stringify(formDataArray);

    const patentNo = store.patentNo

    console.log(patentNo)
    console.log(formDataString);

    // 假设需要发送的数据为 patentNo 和 identification
    const data = {
        patentNo: patentNo,
        evaluate: formDataString
    };
    let response = await axios.post('/api/survey/evaluate', data);
    if (response.status == 200) {
        if (response.data.code == 1) {
            ElMessage.success("submit successfully")
        }
    }
}
import { ref, reactive } from 'vue';

const form = reactive({
    p3q1: [],
    p3q2: [],
    p3q3: [],
});
//以下处理所有表格
const tableP3Q1 = ref([
    { name: enLocale.survey.P3Q1Row[0], index: 0, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P3Q1Row[1], index: 1, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P3Q1Row[2], index: 2, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P3Q1Row[3], index: 3, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P3Q1Row[4], index: 4, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P3Q1Row[5], index: 5, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P3Q1Row[6], index: 6, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P3Q1Row[7], index: 7, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P3Q1Row[8], index: 8, selection: [false, false, false, false, false] },
]);

const colP3Q1 = [
    { label: enLocale.survey.P3Q1Col[0] },
    { label: enLocale.survey.P3Q1Col[1] },
    { label: enLocale.survey.P3Q1Col[2] },
    { label: enLocale.survey.P3Q1Col[3] },
    { label: enLocale.survey.P3Q1Col[4] },
];

// 处理单元格选中状态变化
const handleP3Q1 = (row, colIndex) => {
    // 取消当前行其他单元格的选中状态
    row.selection.forEach((selected, index) => {
        if (index !== colIndex) {
            row.selection[index] = false;
        }
    });
    form.p3q1[parseInt(row.index)] = colP3Q1[colIndex].label
    console.log(form.p3q1)
};

const tableP3Q2 = ref([
    { name: enLocale.survey.P3Q2Row[0], index: 0, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P3Q2Row[1], index: 1, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P3Q2Row[2], index: 2, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P3Q2Row[3], index: 3, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P3Q2Row[4], index: 4, selection: [false, false, false, false, false] },
]);

const colP3Q2 = [
    { label: enLocale.survey.P3Q2Col[0] },
    { label: enLocale.survey.P3Q2Col[1] },
    { label: enLocale.survey.P3Q2Col[2] },
    { label: enLocale.survey.P3Q2Col[3] },
    { label: enLocale.survey.P3Q2Col[4] },
];

// 处理单元格选中状态变化
const handleP3Q2 = (row, colIndex) => {
    // 取消当前行其他单元格的选中状态
    row.selection.forEach((selected, index) => {
        if (index !== colIndex) {
            row.selection[index] = false;
        }
    });
    form.p3q2[parseInt(row.index)] = colP3Q2[colIndex].label
    console.log(form.p3q2)
};

const tableP3Q3 = ref([
    { name: enLocale.survey.P3Q3Row[0], index: 0, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P3Q3Row[1], index: 1, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P3Q3Row[2], index: 2, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P3Q3Row[3], index: 3, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P3Q3Row[4], index: 4, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P3Q3Row[5], index: 5, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P3Q3Row[6], index: 6, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P3Q3Row[7], index: 7, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P3Q3Row[8], index: 8, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P3Q3Row[9], index: 9, selection: [false, false, false, false, false] },
]);

const colP3Q3 = [
    { label: enLocale.survey.P3Q3Col[0] },
    { label: enLocale.survey.P3Q3Col[1] },
    { label: enLocale.survey.P3Q3Col[2] },
    { label: enLocale.survey.P3Q3Col[3] },
    { label: enLocale.survey.P3Q3Col[4] },
];

// 处理单元格选中状态变化
const handleP3Q3 = (row, colIndex) => {
    // 取消当前行其他单元格的选中状态
    row.selection.forEach((selected, index) => {
        if (index !== colIndex) {
            row.selection[index] = false;
        }
    });
    form.p3q3[parseInt(row.index)] = colP3Q3[colIndex].label
    console.log(form.p3q3)
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
