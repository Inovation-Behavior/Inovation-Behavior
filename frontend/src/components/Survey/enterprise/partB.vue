<template>
    <el-card style="border-radius: 15px;width: 100%;">
        <p style="font-family: STKaiti;color: blue;font-weight: bold;">
            （在B部分，我们想了解下您所在机构/公司的经营与研发情况，部分信息需要您提供2018年与2023年的历史信息，谢谢支持！）
        </p>
        <el-form :model="form" size="large" label-position="top">
            <el-form-item class="question" style="font-weight: bolder;" label="B01.贵司是否属于一个企业集团？">
                <el-radio-group v-model="form.pBq01">
                    <el-radio class="answer" label="是的，我们属于一个企业集团" />
                    <el-radio class="answer" label="不，我们不属于任何企业集团" />
                </el-radio-group>
            </el-form-item>
            <el-form-item class="question" style="font-weight: bolder;" label="B02.贵司成立于哪一年？">
                <el-date-picker style="margin-left: 2vw;" size="small" v-model="form.pBq0201" type="year"
                    placeholder="Pick a year" />
                <!-- <el-text class="answer">成立于<el-input style="width: 5vw;" size="small" v-model="form.pBq02" />年</el-text> -->
            </el-form-item>
            <el-form-item style="font-family: Kaiti;font-weight: 100;text-indent: 2em;" label="如果属于一个企业集团，总部成立于">
                <el-date-picker style="margin-left: 2vw;" size="small" v-model="form.pBq02" type="year"
                    placeholder="Pick a year" />
            </el-form-item>
            <el-form-item style="font-family: Kaiti;font-weight: 100;text-indent: 2em;" label="上海地区子公司/分公司成立于">
                <el-date-picker style="margin-left: 2vw;" size="small" v-model="form.pBq0203" type="year"
                    placeholder="Pick a year" />
            </el-form-item>

            <el-form-item class="question" style="font-weight: bolder;" label="B03.贵司在上海地区大约有多少全职员工？">
                <el-text class="answer" style="font-family: Kaiti;font-weight: 100;text-indent: 2em;">2018年，大约<el-input
                        size="small" v-model="form.pBq0301" style="width: 5vw;margin-left: 0.5vw"
                        placeholder="2018 年" /></el-text>
            </el-form-item>
            <el-form-item class="question" style="font-weight: bolder;" label="">
                <el-text class="answer" style="font-family: Kaiti;font-weight: 100;text-indent: 2em;">2023年，大约<el-input
                        size="small" v-model="form.pBq0302" style="width: 5vw;margin-left: 0.5vw;"
                        placeholder="2023 年" /></el-text>
            </el-form-item>

            <el-form-item class="question" style="font-weight: bolder;" label="B04. 贵司（含所在集团）是否对内部控制以下业务？">
                <el-table :data="tablePBQ4" style="width: 100%" :row-style="{ height: '10px' }"
                    :cell-style="{ padding: '0px' }">
                    <el-table-column class="answer" width="200%">
                        <template #default="{ row }">
                            {{ row.name }}
                        </template>
                    </el-table-column>
                    <el-table-column width="190%" class="answer" header-align="center"
                        v-for="(column, colIndex) in colPBQ4" :key="colIndex" :label="column.label">
                        <template #default="{ row }">
                            <el-checkbox class="table-container1" v-model="row.selection[colIndex]"
                                @change="handlePBQ4(row, colIndex)"></el-checkbox>
                        </template>
                    </el-table-column>
                </el-table>
            </el-form-item>

            <el-form-item class="question" style="font-weight: bolder;" label="B05. 过去 5 年，贵司研发费投入金额大约为多少？（单位：人民币）">
                <el-text class="answer" style="font-family: Kaiti;font-weight: 100;text-indent: 2em;">2018年,大约<el-input
                        size="small" v-model="form.pBq0501" style="width: 5vw;margin-left: 0.5vw;"
                        placeholder="" />万人民币</el-text>
            </el-form-item>
            <el-form-item class="question" style="font-weight: bolder;" label="">
                <el-text class="answer" style="font-family: Kaiti;font-weight: 100;text-indent: 2em;">2023年,大约<el-input
                        size="small" v-model="form.pBq0502" style="width: 5vw;margin-left: 0.5vw;"
                        placeholder="" />万人民币</el-text>
            </el-form-item>

            <el-form-item class="question" style="font-weight: bolder;" label="B06. 过去 5 年，贵司研发费用占营收收入比例大约是多少？">
                <el-text class="answer" style="font-family: Kaiti;font-weight: 100;text-indent: 2em;">2018年，大约<el-input
                        size="small" v-model="form.pBq0601" style="width: 5vw;margin-left: 0.5vw;" placeholder="" />
                    %</el-text>
            </el-form-item>
            <el-form-item class="question" style="font-weight: bolder;" label="">
                <el-text class="answer" style="font-family: Kaiti;font-weight: 100;text-indent: 2em;">2023年，大约<el-input
                        size="small" v-model="form.pBq0602" style="width: 5vw;margin-left: 0.5vw;" placeholder="" />
                    %</el-text>
            </el-form-item>

            <el-form-item class="question" style="font-weight: bolder;" label="B07.贵司是否在高新技术开发区、工业园或产业集聚区内？">
                <el-radio-group v-model="form.pBq07">
                    <el-radio class="answer" label="是" />
                    <el-radio class="answer" label="否" />
                </el-radio-group>
            </el-form-item>

            <el-form-item class="question" style="font-weight: bolder;" label="B08.贵司是在哪一级高新技术开发区、工业园区或产业集聚区内？">
                <el-radio-group v-model="form.pBq08">
                    <el-radio class="answer" label="国家级" />
                    <el-radio class="answer" label="上海市" />
                    <el-radio class="answer" label="所在区级" />
                    <el-radio class="answer" label="其他，请注明"><el-input size="small" placeholder="其他，请注明"
                            v-model="extraInput1"></el-input></el-radio>
                </el-radio-group>
            </el-form-item>

            <el-form-item class="question" style="font-weight: bolder;" label="B09.贵司是否设立了专门的知识产权部门？">
                <el-radio-group v-model="form.pBq09" @change="handlePBQ09Change">
                    <el-radio class="answer" label="是" />
                    <el-radio class="answer" label="否，暂时没有相关设置" />
                </el-radio-group>
            </el-form-item>
            <el-form-item class="question" v-if="showPBQ09" style="font-weight: bolder;"
                label="B0901，如果设立了，请问知识产权部门是如何设置的？">
                <el-radio-group v-model="form.pBq0901">
                    <el-radio class="answer" label="完全独立" />
                    <el-radio class="answer" label="设置在研发部下" />
                    <el-radio class="answer" label="设置在法务部下" />
                    <el-radio class="answer" label="其他，请注明"><el-input size="small"
                            placeholder="其他，请注明"></el-input></el-radio>
                </el-radio-group>
            </el-form-item>
            <el-form-item class="question" v-if="showPBQ09" style="font-weight: bolder;"
                label="B0902, 如果设立了，请问贵司的知识产权部门有多少全职员工？">
                <el-input size="small" class="answer" v-model="form.pBq0902" style="width: 240px"
                    placeholder="大约____人" />
            </el-form-item>

            <el-form-item class="question" style="font-weight: bolder;" label="B10.贵司在专利管理工作中，是否经常使用以下在线数据库/平台？">
                <el-form-item class="question blue-label" style="font-weight: bolder;" label="（请打分，1🌟为不使用，5🌟为经常使用）" />
                <el-table :data="tablePBQ10" style="width: 100%" :row-style="{ height: '10px' }"
                    :cell-style="{ padding: '0px' }">
                    <el-table-column class="answer" width="300%">
                        <template #default="{ row, $index }">
                            <template v-if="$index !== tablePBQ10.length - 1">
                                {{ row.name }}
                            </template>
                            <template v-else>
                                其他互联网资源
                                <el-input v-model="tablePBQ10[$index].name" style="height: 3vh;"
                                    placeholder="其他，请说明"></el-input>
                            </template>
                        </template>
                    </el-table-column>
                    <el-table-column width="250%" class="answer" header-align="center"
                        v-for="(column, colIndex) in colPBQ10" :key="colIndex" :label="column.label">
                        <template #default="{ row }">
                            <el-rate text-color="#ff9900" size="large" v-model="row.rate"
                                :texts="['not', 'so-so', 'relative', 'very', 'super']" show-text class="table-container"
                                @change="handlePBQ10(row, colIndex)" />
                        </template>
                    </el-table-column>
                </el-table>
            </el-form-item>

            <el-form-item class="question" style="font-weight: bolder;" label="B11.过去五年，贵司是否支付/使用过第三方的专利许可或技术许可？">
                <el-radio-group v-model="form.pBq11" @change="handlePBQ11Change">
                    <el-radio class="answer" label="是的，多次" />
                    <el-radio class="answer" label="是的，一次" />
                    <el-radio class="answer" label="没有" />
                </el-radio-group>
            </el-form-item>
            <el-form-item class="question" v-if="showPBQ11" style="font-weight: bolder;" label="B1101，如果有，被许可人为哪种类型企业？">
                <el-checkbox-group v-model="form.pBq1101" style="display: flex;flex-wrap: wrap;">
                    <el-checkbox class="answer" label="国有企业" />
                    <el-checkbox class="answer" label="民营企业" />
                    <el-checkbox class="answer" label="外资企业（含外商独资、中外合资和中外合作）" />
                    <el-checkbox class="answer" label="港澳台资企业" />
                    <el-checkbox class="answer" label="高校科研院所" />
                    <el-checkbox class="answer" label="技术交易中心" />
                    <el-checkbox class="answer" label="不愿披露" />
                </el-checkbox-group>
            </el-form-item>
            <el-form-item class="question" v-if="showPBQ11" style="font-weight: bolder;" label="B1102，如果有，被许可人为哪种规模企业？">
                <el-checkbox-group v-model="form.pBq1102">
                    <el-checkbox class="answer" label="大型企业（>1000 人）" />
                    <el-checkbox class="answer" label="中型企业（100-1000 人）" />
                    <el-checkbox class="answer" label="高校科研院所" />
                    <el-checkbox class="answer" label="不愿披露" />
                </el-checkbox-group>
            </el-form-item>

            <el-form-item class="question" style="font-weight: bolder;" label="B12.过去五年，贵司是否有过以下专利商业化经历？">
                <el-checkbox-group v-model="form.pBq12" style="display: flex;flex-wrap: wrap;"
                    @change="handlePBQ12Change">
                    <el-checkbox class="answer" label="专利转让" />
                    <el-checkbox class="answer" label="集团内部专利许可" />
                    <el-checkbox class="answer" label="与第三方专利许可" />
                    <el-checkbox class="answer" label="交叉许可、专利联盟" />
                    <el-checkbox class="answer" label="专利融资（包括质押、信托、作价入股等）" />
                    <el-checkbox class="answer" label="以专利为基础的技术合作" />
                    <el-checkbox class="answer" label="其他（请注明:__________"><el-input size="small" placeholder="其他，请注明"
                            v-model="extraInput2"></el-input></el-checkbox>
                </el-checkbox-group>
            </el-form-item>

            <el-form-item class="question" v-if="showPBQ12" style="font-weight: bolder;"
                label="B1201.如果有,交易信息是通过什么渠道获得的？">
                <el-checkbox-group v-model="form.pBq1201" style="display: flex;flex-wrap: wrap;">
                    <el-checkbox class="answer" label="有合作的供应商" />
                    <el-checkbox class="answer" label="有合作的生产商" />
                    <el-checkbox class="answer" label="朋友介绍" />
                    <el-checkbox class="answer" label="协会推荐" />
                    <el-checkbox class="answer" label="在线交易平台" />
                    <el-checkbox class="answer" label="技术交易中心" />
                    <el-checkbox class="answer" label="中介服务机构" />
                </el-checkbox-group>
            </el-form-item>

        </el-form>
    </el-card>
</template>

<script setup>
import { ref, reactive } from 'vue';
const form = reactive({
    pBq01: "",
    pBq0201: "",
    pBq0202: "",
    pBq0203: "",
    pBq0301: "",
    pBq0302: "",
    pBq04: [],
    pBq0501: "",
    pBq0502: "",
    pBq0601: "",
    pBq0502: "",
    pBq07: "",
    pBq08: "",
    pBq09: "",
    pBq0901: "",
    pBq0902: "",
    pBq10: [],
    pBq11: "",
    pBq1101: [],
    pBq1102: [],
    pBq12: [],
    pBq1201: [],
});

const extraInput1 = ref('')
const extraInput2 = ref('')


const showPBQ09 = ref(false);
const handlePBQ09Change = (value) => {
    // 根据选择的 A05 选项来决定是否显示 A06
    showPBQ09.value = value === "是";
};

const showPBQ11 = ref(false);
const handlePBQ11Change = (value) => {
    // 根据选择的 A05 选项来决定是否显示 A06
    showPBQ11.value = value === "是的，多次" || value === "是的，一次";
};

const showPBQ12 = ref(false);
const handlePBQ12Change = (value) => {
    // 根据选择的 A05 选项来决定是否显示 A06
    showPBQ12.value = !!value;
};

//以下实现所有表格
const tablePBQ4 = ref([
    { name: "原材料生产", selection: [false, false, false, false, false, false] },
    { name: "研发", selection: [false, false, false, false, false, false] },
    { name: "IP 管理", selection: [false, false, false, false, false, false] },
    { name: "信息系统", selection: [false, false, false, false, false, false] },
    { name: "产品生产或服务", selection: [false, false, false, false, false, false] },
    { name: "分发/运输", selection: [false, false, false, false, false, false] },
    { name: "零售", selection: [false, false, false, false, false, false] },
]);

const colPBQ4 = [
    { label: "2018年 完全自主" },
    { label: "2018年 部分外部采购/ 分包" },
    { label: "2018年 全部外部采购/ 分包" },
    { label: "2023年 完全自主" },
    { label: "2023年 部分外部采购/ 分包" },
    { label: "2023年 全部外部采购/ 分包" },
];

// 处理单元格选中状态变化
const handlePBQ4 = (row, colIndex) => {
    // 取消当前行其他单元格的选中状态
    form.pBq04 = tablePBQ4
};


const tablePBQ10 = ref([
    { name: "中国专利信息网", rate:0 },
    { name: "世界知识产权组织专利数据库", rate: 0 },
    { name: "USPTO、EPO 等其他域外专利管理机构公开数据平台", rate: 0 },
    { name: "商业性专利信息数据库（例如智慧芽、Incopat 等）", rate: 0 },
    { name: "上海市知识产权信息平台", rate: 0 },
    { name: "裁判文书网等法律文书公开平台", rate: 0 },
    { name: "商业性法律信息数据库（例如 lexis 等）", rate: 0 },
    { name: "", rate: 0 },
]);

const colPBQ10 = [
    { label: "不使用-->经常使用" },
];

// 处理单元格选中状态变化
const handlePBQ10 = (row, colIndex) => {
    // 取消当前行其他单元格的选中状态
    form.pBq10 = tablePBQ10
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
.question {
    font-weight: bolder;
    font-family: SimSun;
}

.answer {
    font-family: KaiTi;
    margin-left: 2em;
}
.el-table {
    margin-left: 2.5em;
    margin-top: 1vh;
}
::v-deep .el-form-item__label {
    font-size: 17px;

}

::v-deep.el-table th {
    border: 1px solid rgb(105, 102, 102) !important;
    border-right: none !important;
    border-bottom: none !important;
    border-top: none !important;
    /* border-left: none !important; */
}

::v-deep.el-table td {
    border: 1px solid rgb(105, 102, 102);
    border-right: none !important;
    border-bottom: none !important;
    /* border-left: none !important; */
}

::v-deep .el-table {
    border-collapse: separate;
    border: none !important;
}
.table-container {
    display: flex;
    margin-left: 2vw;
}
.table-container1 {
    display: flex;
    justify-content: center;

    align-items: center;

}
</style>
