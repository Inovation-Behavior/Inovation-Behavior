<template>
    <el-card style="border-radius: 15px;width: 100%;">
        <el-form :model="form" size="large" label-position="top">
            <el-form-item class="question" style="font-weight: bolder;" label="C01.该专利属于哪一类创新？">
                <el-radio-group v-model="form.pCq01" @change="handlePCQ01Change">
                    <el-radio class="answer" label="产品创新" />
                    <el-radio class="answer" label="流程创新" />
                    <el-radio class="answer" label="都相关" />
                </el-radio-group>
            </el-form-item>
            <el-form-item class="question" v-if="showPCQ01" style="font-weight: bolder;"
                label="C0101.如果属于产品创新，相关技术产品在哪个市场阶段？">
                <el-radio-group v-model="form.pCq0101">
                    <el-radio class="answer" label="已进入市场" />
                    <el-radio class="answer" label="为引入市场做准备" />
                    <el-radio class="answer" label="远未进入市场" />
                    <el-radio class="answer" label="已退出市场" />
                </el-radio-group>
            </el-form-item>
            <el-form-item class="question" v-if="showPCQ01" style="font-weight: bolder;" label="C0102，贵公司是否生产该产品？">
                <el-radio-group v-model="form.pCq0102">
                    <el-radio class="answer" label="是" />
                    <el-radio class="answer" label="否" />
                </el-radio-group>
            </el-form-item>

            <el-form-item class="question" v-if="showPCQ01" style="font-weight: bolder;" label="C0103，如何评价该产品市场的竞争程度？">
                <el-table :data="tablePCQ0103" style="width: 100%">
                    <el-table-column class="answer" width="200%">
                        <template #default="{ row }">
                            {{ row.name }}
                        </template>
                    </el-table-column>
                    <el-table-column width="150%" class="answer" v-for="(column, colIndex) in colPCQ0103"
                        :key="colIndex" :label="column.label">
                        <template #default="{ row }">
                            <!-- 在每个单元格内放置一个可选中的组件 -->
                            <el-checkbox v-model="row.selection[colIndex]"
                                @change="handlePCQ0103(row, colIndex)"></el-checkbox>
                        </template>
                    </el-table-column>
                </el-table>
            </el-form-item>

            <el-form-item class="question" v-if="showPCQ01" style="font-weight: bolder;"
                label="C0104.如果形容贵公司的专利产品的市场份额？">
                <el-radio-group v-model="form.pCq0104">
                    <el-radio class="answer" label="占同类产品市场销售额 5%以下" />
                    <el-radio class="answer" label="占同类产品市场销售额 20%-50%" />
                    <el-radio class="answer" label="占同类产品市场销售额 5%-20%" />
                    <el-radio class="answer" label="占同类产品市场销售额 50%以上" />
                    <el-radio class="answer" label="不清楚" />
                </el-radio-group>
            </el-form-item>

            <el-form-item class="question" style="font-weight: bolder;" label="C02.作为流程创新，该专利技术能降低多少生产成本？">
                <el-radio-group v-model="form.pCq02">
                    <el-radio class="answer" label="少于 5%" />
                    <el-radio class="answer" label="20%-50%" />
                    <el-radio class="answer" label="5%-20%" />
                    <el-radio class="answer" label="超过 50%" />
                </el-radio-group>
            </el-form-item>

            <el-form-item class="question" style="font-weight: bolder;" label="C03.如何形容该专利技术的研发成本？请估计下已经耗费的人工年？（1 人工年指 1 个人
一年，请将人数和年数相乘填写，例如，2 个人三年：2×3=6 个人工年）">
                <el-radio-group v-model="form.pCq03">
                    <el-radio class="answer" label="少于 1 个人工年" />
                    <el-radio class="answer" label="2-4 个人工年" />
                    <el-radio class="answer" label="5-10 个人工年" />
                    <el-radio class="answer" label="10-20 个人工年" />
                    <el-radio class="answer" label="超过 20 个人工年" />
                </el-radio-group>
            </el-form-item>

            <el-form-item class="question" style="font-weight: bolder;" label="C04.该专利技术是否有研发合作？如果有，是与哪类机构/企业进行合作？">
                <el-checkbox-group v-model="form.pCq04" style="display: flex;flex-wrap: wrap;">
                    <el-checkbox class="answer" label="没有，完全由本单位研发" />
                    <el-checkbox class="answer" label="有，同一企业集团的公司之间合作" />
                    <el-checkbox class="answer" label="有，与来自私营部门的客户合作" />
                    <el-checkbox class="answer" label="有，与来自公共机构（医院等）的客户合作" />
                    <el-checkbox class="answer" label="有，与大学科研院所合作" />
                    <el-checkbox class="answer" label="有，与软件、设备等供应商合作" />
                    <el-checkbox class="answer" label="有，与同行业其他企业合作" />
                    <el-checkbox class="answer" label="有，与科技孵化企业合作" />
                </el-checkbox-group>
            </el-form-item>

            <el-form-item class="question" style="font-weight: bolder;" label="C05.该专利技术的研发经费来自以下哪些渠道？">
                <el-checkbox-group v-model="form.pCq05" style="display: flex;flex-wrap: wrap;">
                    <el-checkbox class="answer" label="企业营收" />
                    <el-checkbox class="answer" label="银行商业贷款" />
                    <el-checkbox class="answer" label="风险投资" />
                    <el-checkbox class="answer" label="政府资助" />
                    <el-checkbox class="answer" label="其他，请注明" />
                </el-checkbox-group>
            </el-form-item>

            <el-form-item class="question" style="font-weight: bolder;" label="C06.您认为该技术是否解决了行业内的技术瓶颈？">
                <el-radio-group v-model="form.pCq06">
                    <el-radio class="answer" label="是" />
                    <el-radio class="answer" label="不了解" />
                    <el-radio class="answer" label="不确定" />
                </el-radio-group>
            </el-form-item>

            <el-form-item class="question" style="font-weight: bolder;" label="C07.该专利技术是否遭受过侵权？">
                <el-radio-group v-model="form.pCq07">
                    <el-radio class="answer" label="是，经常" />
                    <el-radio class="answer" label="是，偶尔" />
                    <el-radio class="answer" label="没有" />
                    <el-radio class="answer" label="不了解" />
                </el-radio-group>
            </el-form-item>

            <el-form-item class="question" style="font-weight: bolder;" label="C08. 如何评价其他知识产权保护对该专利技术产品的重要性？">
                <el-table :data="tablePCQ8" style="width: 100%">
                    <el-table-column class="answer" width="250%">
                        <template #default="{ row }">
                            {{ row.name }}
                        </template>
                    </el-table-column>
                    <el-table-column width="150%" class="answer" v-for="(column, colIndex) in colPCQ8" :key="colIndex"
                        :label="column.label">
                        <template #default="{ row }">
                            <!-- 在每个单元格内放置一个可选中的组件 -->
                            <el-checkbox v-model="row.selection[colIndex]"
                                @change="handlePCQ8(row, colIndex)"></el-checkbox>
                        </template>
                    </el-table-column>
                </el-table>
            </el-form-item>

            <el-form-item class="question" style="font-weight: bolder;" label="C09.在未来三年内，贵司是否会继续开发该专利技术？">
                <el-radio-group v-model="form.pCq09">
                    <el-radio class="answer" label="是 ，会增加相关投入" />
                    <el-radio class="answer" label="是，但要减少相关研发投入" />
                    <el-radio class="answer" label="是，投入不变" />
                    <el-radio class="answer" label="否" />
                </el-radio-group>
            </el-form-item>

            <el-form-item class="question" style="font-weight: bolder;" label="C10.如果减少或者不再开发，以下原因的影响有多大？">
                <el-table :data="tablePCQ10" style="width: 100%">
                    <el-table-column class="answer" width="250%">
                        <template #default="{ row }">
                            {{ row.name }}
                        </template>
                    </el-table-column>
                    <el-table-column width="150%" class="answer" v-for="(column, colIndex) in colPCQ10" :key="colIndex"
                        :label="column.label">
                        <template #default="{ row }">
                            <!-- 在每个单元格内放置一个可选中的组件 -->
                            <el-checkbox v-model="row.selection[colIndex]"
                                @change="handlePCQ10(row, colIndex)"></el-checkbox>
                        </template>
                    </el-table-column>
                </el-table>
            </el-form-item>

            <el-form-item class="question" style="font-weight: bolder;"
                label="C11.我们将 ' 专利组合 ' 定义为在价值上或技术上相互依赖的一组专利。该专利是否属于专利组合的一部分？">
                <el-radio-group v-model="form.pCq11">
                    <el-radio class="answer" label="是的，包括 2-3 项专利" />
                    <el-radio class="answer" label="是的，包括 4-6 项专利" />
                    <el-radio class="answer" label="是的，包括 7-10 项专利" />
                    <el-radio class="answer" label="是的，包括 10-20 项专利" />
                    <el-radio class="answer" label="是的，包括 20 项以上的专利" />
                    <el-radio class="answer" label="否" />
                </el-radio-group>
            </el-form-item>

            <el-form-item class="question" style="font-weight: bolder;" label="C12.假设有第三方购买该专利（专利组合），您预计最低价格是多少？">
                <el-radio-group v-model="form.pCq12">
                    <el-radio class="answer" label="<3 万 人民币" />
                    <el-radio class="answer" label="3 万-10 万 人民币" />
                    <el-radio class="answer" label="10 万-30 万 人民币" />
                    <el-radio class="answer" label="30 万-100 万 人民币" />
                    <el-radio class="answer" label="100 万-300 万 人民币" />
                    <el-radio class="answer" label="300 万-1000 万 人民币" />
                    <el-radio class="answer" label="1000 万-3000 万 人民币" />
                    <el-radio class="answer" label="3000 万-1 亿 人民币" />
                    <el-radio class="answer" label="> 1 亿人民币" />
                </el-radio-group>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script setup>
import { ref, reactive } from 'vue';
const form = reactive({
    pCq01: "",
    pCq0101: "",
    pCq0102: "",
    pCq0103: [],
    pCq0104: "",
    pCq02: "",
    pCq03: "",
    pCq04: [],
    pCq05: [],
    pCq06: "",
    pCq07: "",
    pCq08: [],
    pCq09: "",
    pCq10: [],
    pCq11: "",
    pCq12: "",
});

const showPCQ01 = ref(false);
const handlePCQ01Change = (value) => {
    // 根据选择的 A05 选项来决定是否显示 A06
    showPCQ01.value = value === "产品创新";
};

// 以下实现所有表格
const tablePCQ0103 = ref([
    { name: "已经有 2-3 家垄断企业", selection: [false, false, false] },
    { name: "产品价格稳定", selection: [false, false, false] },
    { name: "不断有新企业进入", selection: [false, false, false] },
    { name: "产品更新换代较快", selection: [false, false, false] },
    { name: "市场需求还在不断扩大", selection: [false, false, false] },
    { name: "市场利润较高", selection: [false, false, false] },
]);

const colPCQ0103 = [
    { label: "不重要" },
    { label: "比较重要" },
    { label: "非常重要" },
];

// 处理单元格选中状态变化
const handlePCQ0103 = (row, colIndex) => {
    // 取消当前行其他单元格的选中状态
    form.pCq0103 = tablePCQ0103
};

const tablePCQ8 = ref([
    { name: "商业秘密", selection: [false, false, false] },
    { name: "Know-How", selection: [false, false, false] },
    { name: "著作权", selection: [false, false, false] },
    { name: "商标", selection: [false, false, false] },
    { name: "地理标志", selection: [false, false, false] },
    { name: "数据保护（反不正当竞争）", selection: [false, false, false] },
    { name: "集成电路布图设计权", selection: [false, false, false] },
    { name: "其他，请注明", selection: [false, false, false] },
]);

const colPCQ8 = [
    { label: "不重要" },
    { label: "比较重要" },
    { label: "非常重要" },
];

// 处理单元格选中状态变化
const handlePCQ8 = (row, colIndex) => {
    // 取消当前行其他单元格的选中状态
    form.pCq08 = tablePCQ8
};

const tablePCQ10 = ref([
    { name: "生产/材料成本增加", selection: [false, false, false] },
    { name: "缺乏有技能的员工", selection: [false, false, false] },
    { name: "现金流出现问题", selection: [false, false, false] },
    { name: "未来产品市场需求的不确定性", selection: [false, false, false] },
    { name: "偏离研究所/公司的核心战略", selection: [false, false, false] },
    { name: "科技、税收、产业政策有变化，不能继续获得相应资助", selection: [false, false, false] },
]);

const colPCQ10 = [
    { label: "不太影响" },
    { label: "比较影响" },
    { label: "影响" },
];

// 处理单元格选中状态变化
const handlePCQ10 = (row, colIndex) => {
    // 取消当前行其他单元格的选中状态
    form.pCq10 = tablePCQ10
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
    font-weight: bold;
    margin-left: 2em;
}
.el-table {
    margin-left: 2.5em;
    margin-top: 1vh;
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
</style>
