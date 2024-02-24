<template>
    <el-card style="border-radius: 15px;width: 100%;">
        <el-form :model="form" size="large" label-position="top">
            
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P1Q0')">
                <el-input v-model="patentNo" placeholder="eg:CN109547407B" style="max-width: 500px;"
                    @keyup.enter="getPatentByNo(patentNo)" @input="updatePatentNo(patentNo)"></el-input>
            </el-form-item>

            <!-- 显示专利信息或错误提示 -->
            <div v-if="patent.no != ''">
                <div v-if="patent.name">
                    <p><strong>{{ $t("survey.patent name") }}:</strong> {{ patent.name }}</p>
                    <p><strong>{{ $t("survey.summary") }}:</strong> {{ patent.summary }}</p>
                    <!-- <p><strong>链接:</strong> <a :href="patent.link">{{ patent.link }}</a></p> -->
                </div>
                <p v-else style="color: red;">{{ $t("survey.NoSuchPatent") }}</p>
            </div>
            <div></div>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P1Q1')">
                <el-radio-group v-model="form.p1q1">
                    <el-radio :label="$t('survey.P1Q1A1')" />
                    <el-radio :label="$t('survey.P1Q1A2')" />
                    <el-radio :label="$t('survey.P1Q1A3')" />
                </el-radio-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P1Q2')">
                <el-radio-group v-model="form.p1q2">
                    <el-radio :label="$t('survey.P1Q2A1')" />
                    <el-radio :label="$t('survey.P1Q2A2')" />
                </el-radio-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P1Q3')">
                <el-table :data="tableP1Q3" style="width: 100%">
                    <el-table-column>
                    <!-- <template #default="{ row }">
                        {{ row.name }}
                    </template> -->
                    <template #default="{ row, $index }">
                        <template v-if="$index !== tableP1Q3.length - 1">
                            {{ row.name }}
                        </template>
                        <template v-else>
                            <el-input type="textarea" :rows="2" v-model="tableP1Q3[$index].name" style="height: auto;" :placeholder="tableP1Q3[$index].name"></el-input>
                        </template>
                    </template>
                    </el-table-column>
                    <el-table-column v-for="(column, colIndex) in colP1Q3" :key="colIndex" :prop="column.prop" :label="column.label">
                        <template #default="{ row }">
                            <el-checkbox v-model="row.selection[colIndex]" @change="handleP1Q3(row, colIndex)"></el-checkbox>
                        </template>
                    </el-table-column>
                </el-table>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P1Q4')">
                <el-select v-model="form.p1q4" multiple filterable allow-create>
                    <el-option :label="$t('survey.P1Q4A1')" :value="$t('survey.P1Q4A1')"/>
                    <el-option :label="$t('survey.P1Q4A2')" :value="$t('survey.P1Q4A2')"/>
                    <el-option :label="$t('survey.P1Q4A3')" :value="$t('survey.P1Q4A3')"/>
                    <el-option :label="$t('survey.P1Q4A4')" :value="$t('survey.P1Q4A4')"/>
                    <el-option :label="$t('survey.P1Q4A5')" :value="$t('survey.P1Q4A5')"/>
                    <el-option :label="$t('survey.P1Q4A6')" :value="$t('survey.P1Q4A6')"></el-option>
                </el-select>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P1Q5')">
                <el-select v-model="form.p1q5" filterable allow-create @change="handleP1Q5Change">
                    <el-option :label="$t('survey.P1Q5A1')" :value="$t('survey.P1Q5A1')" />
                    <el-option :label="$t('survey.P1Q5A2')" :value="$t('survey.P1Q5A2')"/>
                    <el-option :label="$t('survey.P1Q5A3')" :value="$t('survey.P1Q5A3')"/>
                    <el-option :label="$t('survey.P1Q5A4')" :value="$t('survey.P1Q5A4')"/>
                    <el-option :label="$t('survey.P1Q5A5')" :value="$t('survey.P1Q5A5')"/>
                    <el-option :label="$t('survey.P1Q5A6')" :value="$t('survey.P1Q5A6')"/>
                    <el-option :label="$t('survey.P1Q5A7')" :value="$t('survey.P1Q5A7')"/>
                    <el-option :label="$t('survey.P1Q5A8')" :value="$t('survey.P1Q5A8')"/>
                    <el-option :label="$t('survey.P1Q5A9')" :value="$t('survey.P1Q5A9')"/>
                </el-select>
            </el-form-item>

            <el-form-item v-if="showA06" style="font-weight: bolder;" :label="$t('survey.P1Q6')">
                <el-table :data="tableP1Q6" style="width: 100%">
                    <el-table-column>
                    <template #default="{ row }">
                        {{ row.name }}
                    </template>
                    </el-table-column>
                    <el-table-column v-for="(column, colIndex) in colP1Q6" :key="colIndex" :label="column.label">
                    <template #default="{ row }">
                        <!-- 在每个单元格内放置一个可选中的组件 -->
                        <el-checkbox v-model="row.selection[colIndex]" @change="handleP1Q6(row, colIndex)"></el-checkbox>
                    </template>
                    </el-table-column>
                </el-table>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P1Q7')">
                <el-checkbox-group v-model="form.p1q7" style="display: flex;flex-wrap: wrap;">
                    <el-checkbox :label="$t('survey.P1Q7A1')" :name="$t('survey.P1Q7A1')" />
                    <el-checkbox :label="$t('survey.P1Q7A2')" :name="$t('survey.P1Q7A2')"/>
                    <el-checkbox :label="$t('survey.P1Q7A3')" :name="$t('survey.P1Q7A3')"/>
                    <el-checkbox :label="$t('survey.P1Q7A4')" :name="$t('survey.P1Q7A4')"/>
                    <el-checkbox :label="$t('survey.P1Q7A5')" :name="$t('survey.P1Q7A5')"/>
                    <el-checkbox :label="$t('survey.P1Q7A6')" :name="$t('survey.P1Q7A6')"/>
                    <el-checkbox :label="$t('survey.P1Q7A7')" :name="$t('survey.P1Q7A7')"/>
                    <el-checkbox :label="$t('survey.P1Q7A8')" :name="$t('survey.P1Q7A8')"/>
                    <el-checkbox :label="$t('survey.P1Q7A9')" :name="$t('survey.P1Q7A9')"/>
                    <el-checkbox :label="$t('survey.P1Q7A10')" :name="$t('survey.P1Q7A10')"/>
                    <el-checkbox :label="$t('survey.P1Q7A11')" :name="$t('survey.P1Q7A11')"/>
                    <el-checkbox :label="$t('survey.P1Q7A12')" :name="$t('survey.P1Q7A12')"/>
                    <el-checkbox :label="$t('survey.P1Q7A13')" :name="$t('survey.P1Q7A13')"/>
                    <el-checkbox :label="$t('survey.P1Q7A14')" :name="$t('survey.P1Q7A14')"/>
                    <el-checkbox :label="$t('survey.P1Q7A15')" :name="$t('survey.P1Q7A15')"/>
                    <el-checkbox :label="$t('survey.P1Q7A16')" :name="$t('survey.P1Q7A16')"/>
                    <el-checkbox :label="$t('survey.P1Q7A17')" :name="$t('survey.P1Q7A17')"/>
                    <el-checkbox :label="$t('survey.P1Q7A18')" :name="$t('survey.P1Q7A18')"/>
                    <el-checkbox :label="$t('survey.P1Q7A19')" :name="$t('survey.P1Q7A19')"/>
                    <el-checkbox :label="$t('survey.P1Q7A20')" :name="$t('survey.P1Q7A20')"/>
                </el-checkbox-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P1Q8')">
                <el-radio-group v-model="form.p1q8" @change="handleP1Q8Change">
                    <el-radio :label="$t('survey.P1Q8A1')" />
                    <el-radio :label="$t('survey.P1Q8A2')" />
                </el-radio-group>
            </el-form-item>

            <el-form-item v-if="showA09" style="font-weight: bolder;" :label="$t('survey.P1Q9')">
                <el-checkbox-group v-model="form.p1q9" style="display: flex;flex-wrap: wrap;">
                    <el-checkbox :label="$t('survey.P1Q9A1')" />
                    <el-checkbox :label="$t('survey.P1Q9A2')" />
                    <el-checkbox :label="$t('survey.P1Q9A3')" />
                    <el-checkbox :label="$t('survey.P1Q9A4')" />
                    <el-checkbox :label="$t('survey.P1Q9A5')" ><el-input :placeholder="$t('survey.P1Q9A5')"></el-input></el-checkbox>
                </el-checkbox-group>
            </el-form-item>

            <el-form-item v-if="showA10" style="font-weight: bolder;" :label="$t('survey.P1Q10')">
                <el-radio-group v-model="form.p1q10">
                    <el-radio :label="$t('survey.P1Q10A1')" />
                    <el-radio :label="$t('survey.P1Q10A2')" />
                    <el-radio :label="$t('survey.P1Q10A3')" />
                </el-radio-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P1Q11')">
                <el-table :data="tableP1Q11" style="width: 100%">
                    <el-table-column>
                    <template #default="{ row }">
                        {{ row.name }}
                    </template>
                    </el-table-column>
                    <el-table-column v-for="(column, colIndex) in colP1Q11" :key="colIndex" :label="column.label">
                    <template #default="{ row }">
                        <!-- 在每个单元格内放置一个可选中的组件 -->
                        <el-checkbox v-model="row.selection[colIndex]" @change="handleP1Q11(row, colIndex)"></el-checkbox>
                    </template>
                    </el-table-column>
                </el-table>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P1Q12')">
                <el-radio-group v-model="form.p1q12">
                    <el-radio :label="$t('survey.P1Q12A1')" />
                    <el-radio :label="$t('survey.P1Q12A2')" />
                    <el-radio :label="$t('survey.P1Q12A3')" />
                </el-radio-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P1Q13')">
                <el-table :data="tableP1Q13" style="width: 100%">
                    <el-table-column>
                    <template #default="{ row }">
                        {{ row.name }}
                    </template>
                    </el-table-column>
                    <el-table-column v-for="(column, colIndex) in colP1Q13" :key="colIndex" :label="column.label">
                    <template #default="{ row }">
                        <!-- 在每个单元格内放置一个可选中的组件 -->
                        <el-checkbox v-model="row.selection[colIndex]" @change="handleP1Q13(row, colIndex)"></el-checkbox>
                    </template>
                    </el-table-column>
                </el-table>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P1Q14')">
                <el-radio-group v-model="form.p1q14">
                    <el-radio :label="$t('survey.P1Q14A1')" />
                    <el-radio :label="$t('survey.P1Q14A2')" />
                    <el-radio :label="$t('survey.P1Q14A3')" />
                    <el-radio :label="$t('survey.P1Q14A4')" />
                    <el-radio :label="$t('survey.P1Q14A5')" />
                </el-radio-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P1Q15')">
                <el-radio-group v-model="form.p1q15">
                    <el-radio :label="$t('survey.P1Q15A1')" />
                    <el-radio :label="$t('survey.P1Q15A2')" />
                    <el-radio :label="$t('survey.P1Q15A3')" />
                    <el-radio :label="$t('survey.P1Q15A4')" />
                    <el-radio :label="$t('survey.P1Q15A5')" />
                </el-radio-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P1Q16')">
                <el-radio-group v-model="form.p1q16">
                    <el-radio :label="$t('survey.P1Q16A1')" />
                    <el-radio :label="$t('survey.P1Q16A2')" ></el-radio>
                </el-radio-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P1Q17')">
                <el-checkbox-group v-model="form.p1q17" style="display: flex;flex-wrap: wrap;">
                    <el-checkbox :label="$t('survey.P1Q17A1')" />
                    <el-checkbox :label="$t('survey.P1Q17A2')" />
                    <el-checkbox :label="$t('survey.P1Q17A3')" />
                    <el-checkbox :label="$t('survey.P1Q17A4')" />
                    <el-checkbox :label="$t('survey.P1Q17A5')" />
                    <el-checkbox :label="$t('survey.P1Q17A6')" />
                    <el-checkbox :label="$t('survey.P1Q17A7')" ><el-input :placeholder="$t('survey.P1Q17A7')"></el-input></el-checkbox>
                </el-checkbox-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P1Q18')">
                <el-table :data="tableP1Q18" style="width: 100%">
                    <el-table-column>
                    <!-- <template #default="{ row }">
                        {{ row.name }}
                    </template> -->
                    <template #default="{ row, $index }">
                        <template v-if="$index !== tableP1Q18.length - 1">
                            {{ row.name }}
                        </template>
                        <template v-else>
                            <el-input type="textarea" :rows="2" v-model="tableP1Q18[$index].name" style="height: auto;" :placeholder="tableP1Q18[$index].name"></el-input>
                        </template>
                    </template>
                    </el-table-column>
                    <el-table-column v-for="(column, colIndex) in colP1Q18" :key="colIndex" :label="column.label">
                    <template #default="{ row }">
                        <!-- 在每个单元格内放置一个可选中的组件 -->
                        <el-checkbox v-model="row.selection[colIndex]" @change="handleP1Q18(row, colIndex)"></el-checkbox>
                    </template>
                    </el-table-column>
                </el-table>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P1Q19')">
                <el-radio-group v-model="form.p1q19">
                    <el-radio :label="$t('survey.P1Q19A1')" />
                    <el-radio :label="$t('survey.P1Q19A2')" />
                </el-radio-group>
            </el-form-item>

        </el-form>
    </el-card>
    <el-button type="primary" @click="submit()" style="margin-top: 1vh;margin-left: 2vw;">submit part A</el-button>
</template>

<script setup>
import { ref, reactive } from 'vue';
import { useGeneralStore } from '../../stores/general';
const store = useGeneralStore()
// 存储 patentNo 的 ref
const patentNo = ref("");

// 监听用户输入的 patentNo 并更新 Pinia 存储
const updatePatentNo = (value) => {
    patentNo.value = value;
    store.patentNo = value; // 将 patentNo 存储到 Pinia 中
};

import axios from 'axios';
import { ElMessage } from 'element-plus';

const form = reactive({
    p1q1: "",
    p1q2: "",
    p1q3: [],
    p1q4: "",
    p1q5: "",
    p1q6: [],
    p1q7: [],
    p1q8: "",
    p1q9: [],
    p1q10: "",
    p1q11: [],
    p1q12: "",
    p1q13: [],
    p1q14: "",
    p1q15: "",
    p1q16: "",
    p1q17: [],
    p1q18: [],
    p1q19: "",
});

const showA06 = ref(false);

const showA09 = ref(false);

const showA10 = ref(false);


import enLocale from '../../locales/en.json';


const tableP1Q3 = ref([
    { name: enLocale.survey.P1Q3Col[0], selection: [false, false, false] },
    { name: enLocale.survey.P1Q3Col[1], selection: [false, false, false] },
    { name: enLocale.survey.P1Q3Col[2], selection: [false, false, false] },
    { name: enLocale.survey.P1Q3Col[3], selection: [false, false, false] },
    { name: enLocale.survey.P1Q3Col[4], selection: [false, false, false] },
    { name: enLocale.survey.P1Q3Col[5], selection: [false, false, false] }
]);

const colP1Q3 = [
    { label:  enLocale.survey.P1Q3Row[0] },
    { label: enLocale.survey.P1Q3Row[1] },
    { label: enLocale.survey.P1Q3Row[2] },
];

// 处理单元格选中状态变化
const handleP1Q3 = (row, colIndex) => {
    // 取消当前行其他单元格的选中状态
    row.selection.forEach((selected, index) => {
        if (index !== colIndex) {
            row.selection[index] = false;
        }
    });
    //row.selected = !row.selected;
    form.p1q3[colIndex]= row.name
    console.log(form.p1q3)
    console.log(`Selected: ${row.name}, Column: ${colP1Q3[colIndex].label}`);
};

const tableP1Q6 = ref([
    { name: enLocale.survey.P1Q6Col[0], selection: [false, false] },
    { name: enLocale.survey.P1Q6Col[1], selection: [false, false] },
    { name: enLocale.survey.P1Q6Col[2], selection: [false, false] },
    { name: enLocale.survey.P1Q6Col[3], selection: [false, false] },
    { name: enLocale.survey.P1Q6Col[4], selection: [false, false] },
    { name: enLocale.survey.P1Q6Col[5], selection: [false, false] }
]);

const colP1Q6 = [
    { label: enLocale.survey.P1Q6Row[0] },
    { label: enLocale.survey.P1Q6Row[1] },
];

// 处理单元格选中状态变化
const handleP1Q6 = (row, colIndex) => {
    // 取消当前行其他单元格的选中状态
    row.selection.forEach((selected, index) => {
        if (index !== colIndex) {
            row.selection[index] = false;
        }
    });
    //row.selected = !row.selected;
    form.p1q6[colIndex] = row.name
    console.log(form.p1q6)
    console.log(`Selected: ${row.name}, Column: ${colP1Q3[colIndex].label}`);
};

const tableP1Q11 = ref([
    { name: enLocale.survey.P1Q11Col[0],index:0, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P1Q11Col[1], index: 1, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P1Q11Col[2], index: 2, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P1Q11Col[3], index: 3, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P1Q11Col[4], index: 4, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P1Q11Col[5], index: 5, selection: [false, false, false, false, false] },
    { name: enLocale.survey.P1Q11Col[6], index: 6, selection: [false, false, false, false, false] },
]);

const colP1Q11 = [
    { label: enLocale.survey.P1Q11Row[0] },
    { label: enLocale.survey.P1Q11Row[1] },
    { label: enLocale.survey.P1Q11Row[2] },
    { label: enLocale.survey.P1Q11Row[3] },
    { label: enLocale.survey.P1Q11Row[4] },
];

// 处理单元格选中状态变化
const handleP1Q11 = (row, colIndex) => {
    // 取消当前行其他单元格的选中状态
    row.selection.forEach((selected, index) => {
        if (index !== colIndex) {
            row.selection[index] = false;
        }
    });
    form.p1q11[row.index] = colP1Q11[colIndex].label
    console.log(form.p1q11)
    console.log(`Selected: ${row.name}, Column: ${colP1Q11[colIndex].label}`);
};

const tableP1Q13 = ref([
    { name: enLocale.survey.P1Q13Col[0], index: 0, selection: [false, false, false] },
    { name: enLocale.survey.P1Q13Col[1], index: 1, selection: [false, false, false] },
    { name: enLocale.survey.P1Q13Col[2], index: 2, selection: [false, false, false] },
    { name: enLocale.survey.P1Q13Col[3], index: 3, selection: [false, false, false] },
    { name: enLocale.survey.P1Q13Col[4], index: 4, selection: [false, false, false] },
]);

const colP1Q13 = [
    { label: enLocale.survey.P1Q13Row[0] },
    { label: enLocale.survey.P1Q13Row[1] },
    { label: enLocale.survey.P1Q13Row[2] },
];

// 处理单元格选中状态变化
const handleP1Q13 = (row, colIndex) => {
    // 取消当前行其他单元格的选中状态
    row.selection.forEach((selected, index) => {
        if (index !== colIndex) {
            row.selection[index] = false;
        }
    });
    form.p1q13[parseInt(row.index)] = colP1Q13[colIndex].label
    console.log(form.p1q13)
    console.log(`Selected: ${row.name}, Column: ${colP1Q13[colIndex].label}`);
};

const tableP1Q18 = ref([
    { name: enLocale.survey.P1Q18Col[0], index: 0, selection: [false, false, false, false] },
    { name: enLocale.survey.P1Q18Col[1], index: 1, selection: [false, false, false, false] },
    { name: enLocale.survey.P1Q18Col[2], index: 2, selection: [false, false, false, false] },
    { name: enLocale.survey.P1Q18Col[3], index: 3, selection: [false, false, false, false] },
    { name: enLocale.survey.P1Q18Col[4], index: 4, selection: [false, false, false, false] },
    { name: enLocale.survey.P1Q18Col[5], index: 5, selection: [false, false, false, false] },
    { name: enLocale.survey.P1Q18Col[6], index: 6, selection: [false, false, false, false] },
]);

const colP1Q18 = [
    { label: enLocale.survey.P1Q18Row[0] },
    { label: enLocale.survey.P1Q18Row[1] },
    { label: enLocale.survey.P1Q18Row[2] },
    { label: enLocale.survey.P1Q18Row[3] },
];

// 处理单元格选中状态变化
const handleP1Q18 = (row, colIndex) => {
    // 取消当前行其他单元格的选中状态
    row.selection.forEach((selected, index) => {
        if (index !== colIndex) {
            row.selection[index] = false;
        }
    });
    form.p1q18[parseInt(row.index)] = colP1Q18[colIndex].label
    console.log(form.p1q18)
    console.log(`Selected: ${row.name}, Column: ${colP1Q18[colIndex].label}`);
};


const handleP1Q5Change = (value) => {
    // 根据选择的 A05 选项来决定是否显示 A06
    showA06.value = value === 'P1Q4A3' || value === 'P1Q4A4' || value === 'P1Q4A6' || value === 'P1Q4A7' || value === 'P1Q4A8';
};

const handleP1Q8Change = (value) => {
    //showA09.value = value === "Yes, we produced goods";
    showA09.value = value === enLocale.survey.P1Q8A1;
    showA10.value = value === enLocale.survey.P1Q8A2;
};

let patent = ref({
    no: "",
    name: "",
    summary: "",
    link: "",
})

const getPatentByNo = async (no) => {
    if (no == '') {
        patent.value.no = ''
        patent.value.name = '';
        patent.value.summary = '';
        patent.value.link = '';
        return;
    }
    console.log('api/patents/' + no);
    let response = await axios.get('api/patents/' + no);
    patent.value.no = no;
    console.log(response)
    if (response.status == 200) {
        if (response.data.code == 1) {
            patent.value.name = response.data.data.name;
            patent.value.summary = response.data.data.summary;
            patent.value.link = response.data.data.link;
        } else {
            patent.value.name = '';
            patent.value.summary = '';
            patent.value.link = '';
        }
    } else {
        patent.value.name = '';
        patent.value.summary = '';
        patent.value.link = '';
    }
}

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
        identification: formDataString
    };
    let response = await axios.post('/api/survey/identification', data);
    if (response.status == 200) {
        if (response.data.code == 1) {
            ElMessage.success("submit successfully")
        }
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
}</style>
