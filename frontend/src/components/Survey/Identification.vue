<template>
    <el-card style="border-radius: 15px;width: 100%;">
        <el-form :model="form" size="large" label-position="top">
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P1Q0')">
                <el-input v-model="form.patentPublicationNo" placeholder="eg:CN109547407B" style="max-width: 500px;"
                    @keyup.enter="getPatentByNo(form.patentPublicationNo)"></el-input>
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

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P1Q2')">
                <el-radio-group v-model="form.p1q2">
                    <el-radio :label="$t('survey.P1Q2A1')" />
                    <el-radio :label="$t('survey.P1Q2A2')" />
                </el-radio-group>
            </el-form-item>

            <P>A03</P>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P1Q4')">
                <el-select v-model="form.p1q4" multiple filterable allow-create>
                    <el-option :label="$t('survey.P1Q4A1')" value="P1Q4A1" />
                    <el-option :label="$t('survey.P1Q4A2')" value="P1Q4A2" />
                    <el-option :label="$t('survey.P1Q4A3')" value="P1Q4A3" />
                    <el-option :label="$t('survey.P1Q4A4')" value="P1Q4A4" />
                    <el-option :label="$t('survey.P1Q4A5')" value="P1Q4A5" />
                    <el-option :label="$t('survey.P1Q4A6')" value="P1Q4A6" />
                </el-select>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P1Q5')">
                <el-select v-model="form.p1q5" filterable allow-create @change="handleP1Q5Change">
                    <el-option :label="$t('survey.P1Q5A1')" value="P1Q4A1" />
                    <el-option :label="$t('survey.P1Q5A2')" value="P1Q4A2" />
                    <el-option :label="$t('survey.P1Q5A3')" value="P1Q4A3" />
                    <el-option :label="$t('survey.P1Q5A4')" value="P1Q4A4" />
                    <el-option :label="$t('survey.P1Q5A5')" value="P1Q4A5" />
                    <el-option :label="$t('survey.P1Q5A6')" value="P1Q4A6" />
                    <el-option :label="$t('survey.P1Q5A7')" value="P1Q4A6" />
                    <el-option :label="$t('survey.P1Q5A8')" value="P1Q4A6" />
                    <el-option :label="$t('survey.P1Q5A9')" value="P1Q4A6" />
                </el-select>
            </el-form-item>

            <P v-if="showA06">A06</P>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P1Q7')">
                <el-checkbox-group v-model="form.p1q7" style="display: flex;flex-wrap: wrap;">
                    <el-checkbox :label="$t('survey.P1Q7A1')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q7A2')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q7A3')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q7A4')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q7A5')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q7A6')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q7A7')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q7A8')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q7A9')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q7A10')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q7A11')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q7A12')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q7A13')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q7A14')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q7A15')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q7A16')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q7A17')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q7A18')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q7A19')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q7A20')" name="identify" />
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
                    <el-checkbox :label="$t('survey.P1Q9A1')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q9A2')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q9A3')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q9A4')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q9A5')" name="identify" />
                </el-checkbox-group>
            </el-form-item>

            <el-form-item v-if="showA10" style="font-weight: bolder;" :label="$t('survey.P1Q10')">
                <el-radio-group v-model="form.p1q10">
                    <el-radio :label="$t('survey.P1Q10A1')" />
                    <el-radio :label="$t('survey.P1Q10A2')" />
                    <el-radio :label="$t('survey.P1Q10A3')" />
                </el-radio-group>
            </el-form-item>

            <p>A11</p>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P1Q12')">
                <el-radio-group v-model="form.p1q12">
                    <el-radio :label="$t('survey.P1Q12A1')" />
                    <el-radio :label="$t('survey.P1Q12A2')" />
                    <el-radio :label="$t('survey.P1Q12A3')" />
                </el-radio-group>
            </el-form-item>

            <p>A13</p>

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
                    <el-radio :label="$t('survey.P1Q16A2')" />
                </el-radio-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P1Q17')">
                <el-checkbox-group v-model="form.p1q17" style="display: flex;flex-wrap: wrap;">
                    <el-checkbox :label="$t('survey.P1Q17A1')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q17A2')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q17A3')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q17A4')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q17A5')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q17A6')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q17A7')" name="identify" />
                </el-checkbox-group>
            </el-form-item>

            <p>A18</p>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P1Q19')">
                <el-radio-group v-model="form.p1q19">
                    <el-radio :label="$t('survey.P1Q19A1')" />
                    <el-radio :label="$t('survey.P1Q19A2')" />
                </el-radio-group>
            </el-form-item>


        <!-- <el-form-item style="font-weight: bolder;">
          <el-table :data="tableData" style="width: 100%">
            <el-table-column label="标识">
              <template #default="{ columns, columns }">
                {{ column }}
              </template>
            </el-table-column>
            <el-table-column v-for="(column, colIndex) in columns" :key="colIndex" :prop="column.prop" :label="column.label">
              <template #default="{ row }">
                <el-checkbox v-model="row.selected" @change="handleCellSelection(row, colIndex)"></el-checkbox>
              </template>
            </el-table-column>
          </el-table>
        </el-form-item> -->


        <el-form-item style="font-weight: bolder;">
            <el-table :data="tableData" style="width: 100%">
              <el-table-column label="标识">
                <template #default="{ row }">
                  {{ row.name }}
                </template>
              </el-table-column>
              <el-table-column v-for="(column, colIndex) in columns" :key="colIndex" :prop="column.prop" :label="column.label">
                <template #default="{ row }">
                  <!-- 在每个单元格内放置一个可选中的组件 -->
                  <el-checkbox v-model="row.selected" @change="handleCellSelection(row, colIndex)"></el-checkbox>
                </template>
              </el-table-column>
            </el-table>
          </el-form-item>
        </el-form>
    </el-card>
    <el-button type="primary" @click="submit()" style="margin-top: 1vh;margin-left: 2vw;">submit part 2</el-button>
</template>

<script setup>
import { ref, reactive } from 'vue';
import axios from 'axios';
import { ElMessage } from 'element-plus';
const form = reactive({
    p1q1:"",
    p1q2: "",
    p1q3: "",
    p1q4: "",
    p1q5: "",
    p1q6: "",
    p1q7: [],
    p1q8: "",
    p1q9: [],
    p1q10: "",
    p1q11: "",
    p1q12: "",
    p1q13: "",
    p1q14: "",
    p1q15: "",
    p1q16: "",
    p1q17: [],
    p1q18: "",
    p1q19: "",
});

const showA06 = ref(false);

const showA09 = ref(false);

const showA10 = ref(false);

const checktable=ref([[]]);

const tableData = ref([
    // { name: '张三', age: 30, address: '上海市', selected: false },
    // { name: '李四', age: 25, address: '北京市', selected: false },
    // { name: '王五', age: 28, address: '广州市', selected: false }
    { name: '王五'},
    { name: '王五'},
    { name: '王五'},
]);

const columns = [
    { prop: 'name', label: '姓名' },
    { prop: 'age', label: '年龄' },
    { prop: 'address', label: '地址' }
];

// 处理单元格选中状态变化
const handleCellSelection = (row, colIndex) => {
    // row.selected = !row.selected;
    //console.log(`Selected: ${row.name}, Column: ${columns[colIndex].label}`);
    // 遍历表格数据，将除了当前点击的单元格外，其他单元格的选中状态设置为 false
    tableData.value.forEach((rowData) => {
        // 如果不是当前行，将该行对应列的选中状态设置为 false
        if (rowData !== row) {
            rowData.selected = false;
        } else {
            // 如果是当前行，遍历列，将除了当前点击的列外，其他列的选中状态设置为 false
            for (let i = 0; i < columns.length; i++) {
                if (i !== colIndex) {
                    row[columns[i].prop].selected = false;
                }
            }
        }
    });

    // 设置当前点击的单元格选中状态为 true
    row[columns[colIndex].prop].selected = !row[columns[colIndex].prop].selected;
};

import enLocale from '../../locales/en.json';

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
    // 将数组元素整合为以逗号分隔的字符串
    const identifyString = form.identify.join(",");
    const experString = form.exper.join(",");

    // 创建新的对象，将字符串赋值给 identify 和 exper 属性
    const formData = {
        patentNo: form.patentPublicationNo,
        gender: form.sex,
        major: form.major,
        degree: form.status,
        income: form.income,
        role: identifyString,
        experience: experString
    };

    console.log(formData);
    try {
        let response = await axios.post('api/questionnaire/respondents', formData);
        console.log(response);
        // 根据需要处理来自服务器的响应
        if (response.data.code == 1) {
            ElMessage.success("successfully submit part 1")
        }
    } catch (error) {
        console.error(error);
        // 处理请求失败的错误
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
