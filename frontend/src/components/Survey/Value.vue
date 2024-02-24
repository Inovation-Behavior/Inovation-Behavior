<template>
    <el-card style="border-radius: 15px;width: 100%;">
        <el-form :model="form" size="large" label-position="top">
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q1')">
                <el-radio-group v-model="form.p2q1">
                    <el-radio :label="$t('survey.P2Q1A1')" />
                    <el-radio :label="$t('survey.P2Q1A2')" />
                </el-radio-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q2')">
                <el-radio-group v-model="form.p2q2" @change="handleB02Change">
                    <el-radio :label="$t('survey.P2Q2A1')" />
                    <el-radio :label="$t('survey.P2Q2A2')" />
                    <el-radio :label="$t('survey.P2Q2A3')" />
                    <el-radio :label="$t('survey.P2Q2A4')" />
                    <el-radio :label="$t('survey.P2Q2A5')" />
                </el-radio-group>
            </el-form-item>

            <el-form-item v-if="showB03" style="font-weight: bolder;" :label="$t('survey.P2Q3')">
                <el-radio-group v-model="form.p2q3">
                    <el-radio :label="$t('survey.P2Q3A1')" />
                    <el-radio :label="$t('survey.P2Q3A2')" />
                    <el-radio :label="$t('survey.P2Q3A3')" />
                    <el-radio :label="$t('survey.P2Q3A4')" />
                </el-radio-group>
            </el-form-item>

            <el-form-item v-if="showB04" style="font-weight: bolder;" :label="$t('survey.P2Q4')">
                <el-radio-group v-model="form.p2q4">
                    <el-radio :label="$t('survey.P2Q4A1')" />
                    <el-radio :label="$t('survey.P2Q4A2')" />
                    <el-radio :label="$t('survey.P2Q4A3')" />
                    <el-radio :label="$t('survey.P2Q4A4')" />
                </el-radio-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q5')">
                <el-checkbox-group v-model="form.p2q5" style="display: flex;flex-wrap: wrap;">
                    <el-checkbox :label="$t('survey.P2Q5A1')"/>
                    <el-checkbox :label="$t('survey.P2Q5A2')"/>
                    <el-checkbox :label="$t('survey.P2Q5A3')"/>
                    <el-checkbox :label="$t('survey.P2Q5A4')"/>
                    <el-checkbox :label="$t('survey.P2Q5A5')"/>
                    <el-checkbox :label="$t('survey.P2Q5A6')"/>
                    <el-checkbox :label="$t('survey.P2Q5A7')"/>
                    <el-checkbox :label="$t('survey.P2Q5A8')"/>
                    <el-checkbox :label="$t('survey.P2Q5A9')"/>
                </el-checkbox-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q6')">
                <el-radio-group v-model="form.p2q6" @change="handleB06Change">
                    <el-radio :label="$t('survey.P2Q6A1')" />
                    <el-radio :label="$t('survey.P2Q6A2')" />
                    <el-radio :label="$t('survey.P2Q6A3')" />
                </el-radio-group>
            </el-form-item>

            <el-form-item v-if="showB07" style="font-weight: bolder;" :label="$t('survey.P2Q7')">
                <el-table :data="tableP2Q7" style="width: 100%">
                    <el-table-column>
                    <template #default="{ row }">
                        {{ row.name }}
                    </template>
                    </el-table-column>
                    <el-table-column v-for="(column, colIndex) in colP2Q7" :key="colIndex" :label="column.label">
                    <template #default="{ row }">
                        <!-- 在每个单元格内放置一个可选中的组件 -->
                        <el-checkbox v-model="row.selection[colIndex]" @change="handleP2Q7(row, colIndex)"></el-checkbox>
                    </template>
                    </el-table-column>
                </el-table>
            </el-form-item>

            <el-form-item v-if="showB08" style="font-weight: bolder;" :label="$t('survey.P2Q8')">
                <el-table :data="tableP2Q8" style="width: 100%">
                    <el-table-column>
                    <template #default="{ row }">
                        {{ row.name }}
                    </template>
                    </el-table-column>
                    <el-table-column v-for="(column, colIndex) in colP2Q8" :key="colIndex" :label="column.label">
                    <template #default="{ row }">
                        <!-- 在每个单元格内放置一个可选中的组件 -->
                        <el-checkbox v-model="row.selection[colIndex]" @change="handleP2Q8(row, colIndex)"></el-checkbox>
                    </template>
                    </el-table-column>
                </el-table>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q9')">
                <el-radio-group v-model="form.p2q9">
                    <el-radio :label="$t('survey.P2Q9A1')" />
                    <el-radio :label="$t('survey.P2Q9A2')" />
                    <el-radio :label="$t('survey.P2Q9A3')" />
                    <el-radio :label="$t('survey.P2Q9A4')" />
                    <el-radio :label="$t('survey.P2Q9A5')" />
                </el-radio-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q10')">
                <el-radio-group v-model="form.p2q10">
                    <el-radio :label="$t('survey.P2Q10A1')" />
                    <el-radio :label="$t('survey.P2Q10A2')" />
                    <el-radio :label="$t('survey.P2Q10A3')" />
                    <el-radio :label="$t('survey.P2Q10A4')" />
                </el-radio-group>
            </el-form-item>

             <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q11')">
                <el-radio-group v-model="form.p2q11">
                    <el-radio :label="$t('survey.P2Q11A1')" />
                    <el-radio :label="$t('survey.P2Q11A2')" />
                    <el-radio :label="$t('survey.P2Q11A3')" />
                    <el-radio :label="$t('survey.P2Q11A4')" />
                    <el-radio :label="$t('survey.P2Q11A5')" />
                    <el-radio :label="$t('survey.P2Q11A6')" />
                </el-radio-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q12')">
                <el-table :data="tableP2Q12" style="width: 100%">
                    <el-table-column>
                    <template #default="{ row }">
                        {{ row.name }}
                    </template>
                    </el-table-column>
                    <el-table-column v-for="(column, colIndex) in colP2Q12" :key="colIndex" :label="column.label">
                    <template #default="{ row }">
                        <!-- 在每个单元格内放置一个可选中的组件 -->
                        <el-checkbox v-model="row.selection[colIndex]" @change="handleP2Q12(row, colIndex)"></el-checkbox>
                    </template>
                    </el-table-column>
                </el-table>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q13')">
                <el-radio-group v-model="form.p2q13">
                    <el-radio :label="$t('survey.P2Q13A1')" />
                    <el-radio :label="$t('survey.P2Q13A2')" />
                    <el-radio :label="$t('survey.P2Q13A3')" />
                </el-radio-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q14')">
                <el-radio-group v-model="form.p2q14">
                    <el-radio :label="$t('survey.P2Q14A1')" />
                    <el-radio :label="$t('survey.P2Q14A2')" />
                    <el-radio :label="$t('survey.P2Q14A3')" />
                    <el-radio :label="$t('survey.P2Q14A4')" />
                    <el-radio :label="$t('survey.P2Q14A5')" />
                </el-radio-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q15')">
                <el-table :data="tableP2Q15" style="width: 100%">
                    <el-table-column>
                    <template #default="{ row }">
                        {{ row.name }}
                    </template>
                    </el-table-column>
                    <el-table-column v-for="(column, colIndex) in colP2Q15" :key="colIndex" :label="column.label">
                    <template #default="{ row }">
                        <!-- 在每个单元格内放置一个可选中的组件 -->
                        <el-checkbox v-model="row.selection[colIndex]" @change="handleP2Q15(row, colIndex)"></el-checkbox>
                    </template>
                    </el-table-column>
                </el-table>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q16')">
                    <el-table :data="tableP2Q16" style="width: 100%">
                        <el-table-column>
                        <template #default="{ row }">
                            {{ row.name }}
                        </template>
                        </el-table-column>
                        <el-table-column v-for="(column, colIndex) in colP2Q16" :key="colIndex" :label="column.label">
                        <template #default="{ row }">
                            <!-- 在每个单元格内放置一个可选中的组件 -->
                            <el-checkbox v-model="row.selection[colIndex]" @change="handleP2Q16(row, colIndex)"></el-checkbox>
                        </template>
                        </el-table-column>
                    </el-table>
                </el-form-item>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q17')">
                    <el-table :data="tableP2Q17" style="width: 100%">
                        <el-table-column>
                        <template #default="{ row }">
                            {{ row.name }}
                        </template>
                        </el-table-column>
                        <el-table-column v-for="(column, colIndex) in colP2Q17" :key="colIndex" :label="column.label">
                        <template #default="{ row }">
                            <!-- 在每个单元格内放置一个可选中的组件 -->
                            <el-checkbox v-model="row.selection[colIndex]" @change="handleP2Q17(row, colIndex)"></el-checkbox>
                        </template>
                        </el-table-column>
                    </el-table>
                </el-form-item>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q18')">
                    <el-table :data="tableP2Q18" style="width: 100%">
                        <el-table-column>
                        <template #default="{ row }">
                            {{ row.name }}
                        </template>
                        </el-table-column>
                        <el-table-column v-for="(column, colIndex) in colP2Q18" :key="colIndex" :label="column.label">
                        <template #default="{ row }">
                            <!-- 在每个单元格内放置一个可选中的组件 -->
                            <el-checkbox v-model="row.selection[colIndex]" @change="handleP2Q18(row, colIndex)"></el-checkbox>
                        </template>
                        </el-table-column>
                    </el-table>
                </el-form-item>
        </el-form>
    </el-card>
    <el-button type="primary" @click="submit()" style="margin-top: 1vh;margin-left: 2vw;">submit part 1</el-button>
</template>

<script setup>
import enLocale from '../../locales/en.json';
import { ref, reactive } from 'vue';
const form = reactive({
    p2q1:"",
    p2q2: "",
    p2q3: "",
    p2q4: "",
    p2q5: [],
    p2q6: "",
    p2q7: [],
    p2q8: [],
    p2q9: "",
    p2q10: "",
    p2q11: "",
    p2q12: [],
    p2q13: "",
    p2q14: "",
    p2q15: [],
    p2q16: [],
    p2q17: [],
    p2q18: [],
});
const showB03 = ref(false);
const showB04 = ref(false);
const showB07 = ref(false);
const showB08 = ref(false);

const handleB02Change = (value) => {
    //this.showB03 = value === "(a) Has entered the market";
    showB03.value = value === enLocale.survey.P2Q2A1;
    showB04.value = value === enLocale.survey.P2Q2A5;
};
const handleB06Change = (value) => {
    showB07.value = value === enLocale.survey.P2Q6A1;
    showB08.value = value == enLocale.survey.P2Q6A2 || value == enLocale.survey.P2Q6A3;
};

//以下处理所有表格
const tableP2Q7 = ref([
    { name: enLocale.survey.P2Q7Row[0], index: 0, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P2Q7Row[1], index: 1, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P2Q7Row[2], index: 2, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P2Q7Row[3], index: 3, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P2Q7Row[4], index: 4, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P2Q7Row[5], index: 5, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P2Q7Row[6], index: 6, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P2Q7Row[7], index: 7, selection: [false, false, false, false, false] },
]);

const colP2Q7 = [
    { label: enLocale.survey.P2Q7Col[0] },
    { label: enLocale.survey.P2Q7Col[1] },
    { label: enLocale.survey.P2Q7Col[2] },
    { label: enLocale.survey.P2Q7Col[3] },
    { label: enLocale.survey.P2Q7Col[4] },
];

// 处理单元格选中状态变化
const handleP2Q7 = (row, colIndex) => {
    // 取消当前行其他单元格的选中状态
    row.selection.forEach((selected, index) => {
        if (index !== colIndex) {
            row.selection[index] = false;
        }
    });
    form.p2q7[parseInt(row.index)] = colP2Q7[colIndex].label
    console.log(form.p2q7)
    console.log(`Selected: ${row.name}, Column: ${colP2Q7[colIndex].label}`);
};

const tableP2Q8 = ref([
    { name: enLocale.survey.P2Q8Row[0], index: 0, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P2Q8Row[1], index: 1, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P2Q8Row[2], index: 2, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P2Q8Row[3], index: 3, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P2Q8Row[4], index: 4, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P2Q8Row[5], index: 5, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P2Q8Row[6], index: 6, selection: [false, false, false, false, false] },    
]);

const colP2Q8 = [
    { label: enLocale.survey.P2Q8Col[0] },
    { label: enLocale.survey.P2Q8Col[1] },
    { label: enLocale.survey.P2Q8Col[2] },
    { label: enLocale.survey.P2Q8Col[3] },
    { label: enLocale.survey.P2Q8Col[4] },
];

// 处理单元格选中状态变化
const handleP2Q8 = (row, colIndex) => {
    // 取消当前行其他单元格的选中状态
    row.selection.forEach((selected, index) => {
        if (index !== colIndex) {
            row.selection[index] = false;
        }
    });
    form.p2q8[parseInt(row.index)] = colP2Q8[colIndex].label
    console.log(form.p2q8)
    console.log(`Selected: ${row.name}, Column: ${colP2Q8[colIndex].label}`);
};

const tableP2Q15 = ref([
    { name: enLocale.survey.P2Q15Row[0], index: 0, selection: [false, false, false] },
    { name: enLocale.survey.P2Q15Row[1], index: 1, selection: [false, false, false] },
    { name: enLocale.survey.P2Q15Row[2], index: 2, selection: [false, false, false] },
    { name: enLocale.survey.P2Q15Row[3], index: 3, selection: [false, false, false] },
    { name: enLocale.survey.P2Q15Row[4], index: 4, selection: [false, false, false] },
    { name: enLocale.survey.P2Q15Row[5], index: 5, selection: [false, false, false] },
]);

const colP2Q15 = [
    { label: enLocale.survey.P2Q15Col[0] },
    { label: enLocale.survey.P2Q15Col[1] },
    { label: enLocale.survey.P2Q15Col[2] },
];

// 处理单元格选中状态变化
const handleP2Q15 = (row, colIndex) => {
    // 取消当前行其他单元格的选中状态
    row.selection.forEach((selected, index) => {
        if (index !== colIndex) {
            row.selection[index] = false;
        }
    });
    form.p2q15[parseInt(row.index)] = colP2Q15[colIndex].label
    console.log(form.p2q15)
};

const tableP2Q16 = ref([
    { name: enLocale.survey.P2Q16Row[0], index: 0, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P2Q16Row[1], index: 1, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P2Q16Row[2], index: 2, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P2Q16Row[3], index: 3, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P2Q16Row[4], index: 4, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P2Q16Row[5], index: 5, selection: [false, false, false, false, false] },
]);

const colP2Q16 = [
    { label: enLocale.survey.P2Q16Col[0] },
    { label: enLocale.survey.P2Q16Col[1] },
    { label: enLocale.survey.P2Q16Col[2] },
    { label: enLocale.survey.P2Q16Col[3] },
    { label: enLocale.survey.P2Q16Col[4] },
];

// 处理单元格选中状态变化
const handleP2Q16 = (row, colIndex) => {
    // 取消当前行其他单元格的选中状态
    row.selection.forEach((selected, index) => {
        if (index !== colIndex) {
            row.selection[index] = false;
        }
    });
    form.p2q16[parseInt(row.index)] = colP2Q16[colIndex].label
    console.log(form.p2q16)
};

const tableP2Q17 = ref([
    { name: enLocale.survey.P2Q17Row[0], index: 0, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P2Q17Row[1], index: 1, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P2Q17Row[2], index: 2, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P2Q17Row[3], index: 3, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P2Q17Row[4], index: 4, selection: [false, false, false, false, false] },
]);

const colP2Q17 = [
    { label: enLocale.survey.P2Q17Col[0] },
    { label: enLocale.survey.P2Q17Col[1] },
    { label: enLocale.survey.P2Q17Col[2] },
    { label: enLocale.survey.P2Q17Col[3] },
    { label: enLocale.survey.P2Q17Col[4] },
];

// 处理单元格选中状态变化
const handleP2Q17 = (row, colIndex) => {
    // 取消当前行其他单元格的选中状态
    row.selection.forEach((selected, index) => {
        if (index !== colIndex) {
            row.selection[index] = false;
        }
    });
    form.p2q17[parseInt(row.index)] = colP2Q17[colIndex].label
    console.log(form.p2q17)
};

const tableP2Q18 = ref([
    { name: enLocale.survey.P2Q18Row[0], index: 0, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P2Q18Row[1], index: 1, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P2Q18Row[2], index: 2, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P2Q18Row[3], index: 3, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P2Q18Row[4], index: 4, selection: [false, false, false, false, false] },
]);

const colP2Q18 = [
    { label: enLocale.survey.P2Q18Col[0] },
    { label: enLocale.survey.P2Q18Col[1] },
    { label: enLocale.survey.P2Q18Col[2] },
    { label: enLocale.survey.P2Q18Col[3] },
    { label: enLocale.survey.P2Q18Col[4] },
];

// 处理单元格选中状态变化
const handleP2Q18 = (row, colIndex) => {
    // 取消当前行其他单元格的选中状态
    row.selection.forEach((selected, index) => {
        if (index !== colIndex) {
            row.selection[index] = false;
        }
    });
    form.p2q18[parseInt(row.index)] = colP2Q18[colIndex].label
    console.log(form.p2q18)
};

const tableP2Q12 = ref([
    { name: enLocale.survey.P2Q12Row[0], index: 0, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P2Q12Row[1], index: 1, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P2Q12Row[2], index: 2, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P2Q12Row[3], index: 3, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P2Q12Row[4], index: 4, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P2Q12Row[5], index: 5, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P2Q12Row[6], index: 6, selection: [false, false, false, false, false] },
]);

const colP2Q12 = [
    { label: enLocale.survey.P2Q12Col[0] },
    { label: enLocale.survey.P2Q12Col[1] },
    { label: enLocale.survey.P2Q12Col[2] },
    { label: enLocale.survey.P2Q12Col[3] },
    { label: enLocale.survey.P2Q12Col[4] },
];

// 处理单元格选中状态变化
const handleP2Q12 = (row, colIndex) => {
    // 取消当前行其他单元格的选中状态
    row.selection.forEach((selected, index) => {
        if (index !== colIndex) {
            row.selection[index] = false;
        }
    });
    form.p2q12[parseInt(row.index)] = colP2Q12[colIndex].label
    console.log(form.p2q12)
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
