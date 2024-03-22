<template>
    <el-card style="border-radius: 15px;width: 100%;">
        <el-form :model="form" size="large" label-position="top">
            <el-form-item style="font-weight: bolder;" label="A01.您与所选专利的关系是">
                <el-checkbox-group v-model="form.pAq01" style="display: flex;flex-wrap: wrap;">
                    <el-checkbox label="专利发明人之一" />
                    <el-checkbox label="参与该专利技术的研发，未列发明人" />
                    <el-checkbox label="参与该相关技术的研发，未列发明人" />
                    <el-checkbox label="参与该专利申请" />
                    <el-checkbox label="参与该专利管理" />
                    <el-checkbox label="以上均无，请说明" />
                </el-checkbox-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" label="A02.您的性别是">
                <el-radio-group v-model="form.pAq02">
                    <el-radio label="女" />
                    <el-radio label="男" />
                </el-radio-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" label="A03.您的学历背景是？">
                <el-table :data="tablePAQ3" style="width: 100%">
                    <el-table-column>
                        <template #default="{ row }">
                            {{ row.name }}
                        </template>
                    </el-table-column>
                    <el-table-column v-for="(column, colIndex) in colPAQ3" :key="colIndex" :label="column.label">
                        <template #default="{ row }">
                            <!-- 在每个单元格内放置一个可选中的组件 -->
                            <el-checkbox v-model="row.selection[colIndex]"
                                @change="handlePAQ3(row, colIndex)"></el-checkbox>
                        </template>
                    </el-table-column>
                </el-table>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" label="A04.您的以下语言能力如何？">
                <el-table :data="tablePAQ4" style="width: 100%">
                    <el-table-column>
                        <template #default="{ row }">
                            {{ row.name }}
                        </template>
                    </el-table-column>
                    <el-table-column v-for="(column, colIndex) in colPAQ4" :key="colIndex" :label="column.label">
                        <template #default="{ row }">
                            <!-- 在每个单元格内放置一个可选中的组件 -->
                            <el-checkbox v-model="row.selection[colIndex]"
                                @change="handlePAQ4(row, colIndex)"></el-checkbox>
                        </template>
                    </el-table-column>
                </el-table>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" label="A05.您是否有境外工作/学习经历？（含疫情期间的在线学习时间）">
                <el-table :data="tablePAQ5" style="width: 100%">
                    <el-table-column>
                        <template #default="{ row }">
                            {{ row.name }}
                        </template>
                    </el-table-column>
                    <el-table-column v-for="(column, colIndex) in colPAQ5" :key="colIndex" :label="column.label">
                        <template #default="{ row }">
                            <!-- 在每个单元格内放置一个可选中的组件 -->
                            <el-checkbox v-model="row.selection[colIndex]"
                                @change="handlePAQ5(row, colIndex)"></el-checkbox>
                        </template>
                    </el-table-column>
                </el-table>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" label="A06.能否提供下您的工作履历？">
                <el-table :data="tablePAQ6" style="width: 100%">
                    <el-table-column>
                        <template #default="{ row }">
                            {{ row.name }}
                        </template>
                    </el-table-column>
                    <el-table-column v-for="(column, colIndex) in colPAQ6" :key="colIndex" :label="column.label">
                        <template #default="{ row }">
                            <!-- 在每个单元格内放置一个可选中的组件 -->
                            <el-checkbox v-model="row.selection[colIndex]"
                                @change="handlePAQ6(row, colIndex)"></el-checkbox>
                        </template>
                    </el-table-column>
                </el-table>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" label="A07. 您（的岗位）过去五年的年收入如何？(单位：人民币)">
                <el-input v-model="form.pAq0701" style="width: 240px" placeholder="2018 年税前年收入" />
            </el-form-item>
            <el-form-item style="font-weight: bolder;" label="">
                <el-input v-model="form.pAq0702" style="width: 240px" placeholder="2023 年税前年收入" />
            </el-form-item>
            <el-form-item style="font-weight: bolder;" label="A08. 如果在同一家公司，您觉得未来三年的收入变化如何？">
                <el-radio-group v-model="form.pAq8">
                    <el-radio label="总体保持不变" />
                    <el-radio label="每年减少 5%左右（幅度仍可接受）" />
                    <el-radio label="每年增长 5%左右（符合个人预期）" />
                    <el-radio label="每年减少 10%以上 （幅度难以接受）" />
                    <el-radio label="每年增长 10% 以上（超过个人预期）" />
                </el-radio-group>
            </el-form-item>
            <el-form-item style="font-weight: bolder;" label="A09.如果成功实施该专利（例如签订许可合同等），您是否能获得以下奖励？">
                <el-checkbox-group v-model="form.pAq09" style="display: flex;flex-wrap: wrap;">
                    <el-checkbox label="没有额外奖励，是必须完成的" />
                    <el-checkbox label="考核指标" />
                    <el-checkbox label="更快的职业晋升" />
                    <el-checkbox label="获得一次性现金奖励" />
                    <el-checkbox label="获得许可费收益的提成" />
                    <el-checkbox label="获得股权激励" />
                    <el-checkbox label="其他（请注明:__________" />
                </el-checkbox-group>
            </el-form-item>
            <el-form-item style="font-weight: bolder;" label="A10.如果有奖励，贵司如何进行计数？">
                <el-radio-group v-model="form.pAq10">
                    <el-radio label="根据所完成的专利商业化合同数量" />
                    <el-radio label="根据所完成的专利商业化合同金额" />
                    <el-radio label="不做区分" />
                </el-radio-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" label="A11.您认为哪一类考核/奖励有利于激励您实施专利商业化？">
                <el-table :data="tablePAQ11" style="width: 100%">
                    <el-table-column>
                        <template #default="{ row }">
                            {{ row.name }}
                        </template>
                    </el-table-column>
                    <el-table-column v-for="(column, colIndex) in colPAQ11" :key="colIndex" :label="column.label">
                        <template #default="{ row }">
                            <!-- 在每个单元格内放置一个可选中的组件 -->
                            <el-checkbox v-model="row.selection[colIndex]"
                                @change="handlePAQ11(row, colIndex)"></el-checkbox>
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
    pAq01: [],
    pAq02: "",
    pAq02: "",
    pAq03: [],
    pAq04: [],
    pAq05: [],
    pAq06: [],
    pAq0701: "",
    pAq0702: "",
    pAq08: "",
    pAq09: [],
    pAq10: "",
    pAq11: [],
});

// 以下处理所有表格
const tablePAQ3 = ref([
    { name: "法学", selection: [false, false, false] },
    { name: "经济学、管理学", selection: [false, false, false] },
    { name: "其他人文社会科学（文学、历史学或教育学等）", index: 2, selection: [false, false, false] },
    { name: "工学", selection: [false, false, false] },
    { name: "理学", selection: [false, false, false] },
    { name: "医学",  selection: [false, false, false] },
    { name: "农学",  selection: [false, false, false] },
    { name: "无",  selection: [false, false, false] },
]);

const colPAQ3 = [
    { label: "本科或同等学历学位" },
    { label: "硕士或同等学历学位" },
    { label: "博士或同等学历学位" },
];

// 处理单元格选中状态变化
const handlePAQ3 = (row, colIndex) => {
    // 取消当前行其他单元格的选中状态
    form.pAq03 = tablePAQ3
};


const tablePAQ4 = ref([
    { name: "普通话",  selection: [false, false, false, false, false] },
    { name: "上海话",  selection: [false, false, false, false, false] },
    { name: "粤语",  selection: [false, false, false, false, false] },
    { name: "英文",  selection: [false, false, false, false, false] },
    { name: "德语、日语等第二外语", selection: [false, false, false, false, false] },
]);

const colPAQ4 = [
    { label: "没有掌握" },
    { label: "能基础听说读写" },
    { label: "能交流日常事务" },
    { label: "能交流专业事务" },
    { label: "母语水平" },
];

// 处理单元格选中状态变化
const handlePAQ4 = (row, colIndex) => {
    // 取消当前行其他单元格的选中状态
    form.pAq04 = tablePAQ4
};


const tablePAQ5 = ref([
    { name: "少于三个月的学习经历",  selection: [false, false, false] },
    { name: "少于三个月的实习/工作经历", selection: [false, false, false] },
    { name: "多于三个月的学习经历", selection: [false, false, false] },
    { name: "多于三个月的实习/工作经历", selection: [false, false, false] },
    { name: "无", selection: [false, false, false] },
]);

const colPAQ5 = [
    { label: "港澳台" },
    { label: "日本、韩国等其他亚洲国家" },
    { label: "欧美等其他国家" },
];

// 处理单元格选中状态变化
const handlePAQ5 = (row, colIndex) => {
    // 取消当前行其他单元格的选中状态
    form.pAq05 = tablePAQ5
};


const tablePAQ6 = ref([
    { name: "在读学生", selection: [false, false, false, false] },
    { name: "同一家企业，相近岗位", selection: [false, false, false, false] },
    { name: "同一家企业，研发岗", selection: [false, false, false, false] },
    { name: "其他企业，相近岗位", selection: [false, false, false, false] },
    { name: "其他企业，研发岗", selection: [false, false, false, false] },
    { name: "专利审查员", selection: [false, false, false, false] },
    { name: "医护人员", selection: [false, false, false, false] },
    { name: "其他，请说明：", selection: [false, false, false, false] },
]);

const colPAQ6 = [
    { label: "2010" },
    { label: "2015" },
    { label: "2018" },
    { label: "2023" },
];

// 处理单元格选中状态变化
const handlePAQ6 = (row, colIndex) => {
    // 取消当前行其他单元格的选中状态
    form.pAq06 = tablePAQ6
};


const tablePAQ11 = ref([
    { name: "作为必须完成的硬性指标", selection: [false, false, false, false] },
    { name: "作为晋升的附加项", selection: [false, false, false, false] },
    { name: "签订合同后的一次性现金奖励", selection: [false, false, false, false] },
    { name: "基于合同许可费收益的提成", selection: [false, false, false, false] },
    { name: "股权激励", selection: [false, false, false, false] },
    { name: "增加人手、扩大部门规模", selection: [false, false, false, false] },
    { name: "提高部门的受重视程度", selection: [false, false, false, false] },
    { name: "其他，请说明：", selection: [false, false, false, false] },
]);

const colPAQ11 = [
    { label: "不重要" },
    { label: "较低" },
    { label: "比较重要" },
    { label: "重要" },
];

// 处理单元格选中状态变化
const handlePAQ11 = (row, colIndex) => {
    // 取消当前行其他单元格的选中状态
    form.pAq11 = tablePAQ11
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
