<template>
    <el-card style="border-radius: 15px;width: 100%;">
        <el-form :model="form" size="large" label-position="top">
            <el-form-item style="font-weight: bolder;" label="D01.贵司为什么申请该专利？">
                <el-checkbox-group v-model="form.p2q5" style="display: flex;flex-wrap: wrap;">
                    <el-checkbox label="防止他人使用相关技术" />
                    <el-checkbox label="获得高新技术企业认定" />
                    <el-checkbox label="专利奖项申报以及商业宣传" />
                    <el-checkbox label="希望有专利许可转让收入" />
                    <el-checkbox label="构建技术标准" />
                    <el-checkbox label="更好获得融资" />
                    <el-checkbox label="其他，请注明" />
                </el-checkbox-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" label="D02.过去三年，贵司是否为该专利技术进行过以下宣传推广？">
                <el-checkbox-group v-model="form.p2q5" style="display: flex;flex-wrap: wrap;">
                    <el-checkbox label="报纸、杂志等广告宣传" />
                    <el-checkbox label="线下展会、技术交易中心" />
                    <el-checkbox label="企业官方网站" />
                    <el-checkbox label="投放搜索引擎广告" />
                    <el-checkbox label="国家、地区网站相关推荐页面" />
                    <el-checkbox label="官方（含相关协会）在线交易平台/许可平台" />
                    <el-checkbox label="商业性在线交易平台/许可平台" />
                    <el-checkbox label="其他，请注明" />
                    <el-checkbox label="没有" />
                </el-checkbox-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" label="D03.贵司对于该专利，是否已经达成了许可交易？">
                <el-radio-group v-model="form.pAq1">
                    <el-radio label="是的，已达成多个许可交易。" />
                    <el-radio label="是的，已达成一个许可交易。" />
                    <el-radio label="还没有" />
                </el-radio-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" label="D0301 如果已经达成许可交易，该交易发生在哪一年？">
                <el-input v-model="input" style="width: 240px" placeholder="年份" />
            </el-form-item>

            <el-form-item style="font-weight: bolder;" label="D0302.贵司对外许可该专利的目的是什么？">
                <el-checkbox-group v-model="form.p2q5" style="display: flex;flex-wrap: wrap;">
                    <el-checkbox label="高新技术企业的考核要求" />
                    <el-checkbox label="获得许可收入" />
                    <el-checkbox label="扩大产品市场" />
                    <el-checkbox label="授权生产" />
                    <el-checkbox label="合作创新" />
                    <el-checkbox label="解决侵权纠纷" />
                    <el-checkbox label="获得市场地位" />
                    <el-checkbox label="提高企业形象、商业宣传" />
                    <el-checkbox label="其他，请注明" />
                </el-checkbox-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" label="D0303，贵司对外许可的企业类型是？">
                <el-checkbox-group v-model="form.p2q5" style="display: flex;flex-wrap: wrap;">
                    <el-checkbox label="国有企业" />
                    <el-checkbox label="民营企业" />
                    <el-checkbox label="外资企业（含外商独资、中外合资和中外合作）" />
                    <el-checkbox label="港澳台资企业" />
                    <el-checkbox label="高校科研院所" />
                    <el-checkbox label="不愿披露" />
                </el-checkbox-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" label="D0304，贵司对外许可的企业规模是？">
                <el-checkbox-group v-model="form.p2q5" style="display: flex;flex-wrap: wrap;">
                    <el-checkbox label="大型企业（>1000 人）" />
                    <el-checkbox label="中型企业（100-1000 人）" />
                    <el-checkbox label="高校科研院所" />
                    <el-checkbox label="不愿披露" />
                </el-checkbox-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" label="D0305. 该交易的许可类型是？">
                <el-checkbox-group v-model="form.p2q5" style="display: flex;flex-wrap: wrap;">
                    <el-checkbox label="独占许可" />
                    <el-checkbox label="排他许可" />
                    <el-checkbox label="普通许可" />
                    <el-checkbox label="交叉许可" />
                    <el-checkbox label="不方便透露" />
                    <el-checkbox label="不清楚" />
                </el-checkbox-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" label="D0306. 该交易的许可定价是？">
                <el-checkbox-group v-model="form.p2q5" style="display: flex;flex-wrap: wrap;">
                    <el-checkbox label="完全免费" />
                    <el-checkbox label="一次性总付" />
                    <el-checkbox label="协议使用费率" />
                    <el-checkbox label="部分预付+使用费率" />
                    <el-checkbox label="不方便透露" />
                    <el-checkbox label="不清楚" />
                </el-checkbox-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" label="D04.如果尚未达成许可交易，阻碍是什么？">
                <el-checkbox-group v-model="form.p2q5" style="display: flex;flex-wrap: wrap;">
                    <el-checkbox label="专利技术仍在开发中，没办法许可" />
                    <el-checkbox label="没有发现市场需求" />
                    <el-checkbox label="有市场需求，但是没有渠道联系到被许可人" />
                    <el-checkbox label="有潜在许可对象，但是许可价格谈不拢" />
                    <el-checkbox label="不相信许可对象的合同履行能力" />
                    <el-checkbox label="担心技术泄露" />
                    <el-checkbox label="担心市场占有率收到损失" />
                    <el-checkbox label="不愿意许可" />
                </el-checkbox-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" label="D05.未来三年，贵司是尝试对外许可该专利？">
                <el-radio-group v-model="form.pAq1">
                    <el-radio label="是的，我们希望能对外许可" />
                    <el-radio label="否" />
                </el-radio-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" label="D0501. 如果有计划许可，目的是什么？">
                <el-checkbox-group v-model="form.p2q5" style="display: flex;flex-wrap: wrap;">
                    <el-checkbox label="高新技术企业的专利商业化" />
                    <el-checkbox label="考核要求" />
                    <el-checkbox label="获得许可收入" />
                    <el-checkbox label="扩大产品市场" />
                    <el-checkbox label="合作创新" />
                    <el-checkbox label="授权生产" />
                    <el-checkbox label="解决侵权纠纷" />
                    <el-checkbox label="提高企业形象，商业宣传" />
                    <el-checkbox label="其他（请注明______）" />
                </el-checkbox-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" label="D0502，如果有计划许可，对外许可的可能企业类型是？">
                <el-checkbox-group v-model="form.p2q5" style="display: flex;flex-wrap: wrap;">
                    <el-checkbox label="国有企业" />
                    <el-checkbox label="民营企业" />
                    <el-checkbox label="港澳台资企业" />
                    <el-checkbox label="高校科研院所" />
                    <el-checkbox label="外资企业（含外商独资、中外合资和中外合作）" />
                    <el-checkbox label="不愿披露" />
                </el-checkbox-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" label="D0503，如果有计划许可，对外许可的可能企业类型是？">
                <el-checkbox-group v-model="form.p2q5" style="display: flex;flex-wrap: wrap;">
                    <el-checkbox label="大型企业（>1000 人）" />
                    <el-checkbox label="中型企业（100-1000 人）" />
                    <el-checkbox label="高校科研院所" />
                    <el-checkbox label="不愿披露" />
                </el-checkbox-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" label="D0504. 对外许可的可能许可类型是？">
                <el-checkbox-group v-model="form.p2q5" style="display: flex;flex-wrap: wrap;">
                    <el-checkbox label="独占许可" />
                    <el-checkbox label="排他许可" />
                    <el-checkbox label="普通许可" />
                    <el-checkbox label="交叉许可" />
                    <el-checkbox label="不方便透露" />
                </el-checkbox-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" label="D0505. 对外许可的可能许可定价是？">
                <el-checkbox-group v-model="form.p2q5" style="display: flex;flex-wrap: wrap;">
                    <el-checkbox label="完全免费" />
                    <el-checkbox label="一次性总付" />
                    <el-checkbox label="协议使用费率" />
                    <el-checkbox label="部分预付+使用费率" />
                    <el-checkbox label="不方便透露" />
                </el-checkbox-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" label="D06.未来三年，贵司对该专利是否有其他商业化计划？">
                <el-checkbox-group v-model="form.p2q5" style="display: flex;flex-wrap: wrap;">
                    <el-checkbox label="专利转让" />
                    <el-checkbox label="集团内部专利许可" />
                    <el-checkbox label="与第三方专利许可" />
                    <el-checkbox label="交叉许可、专利联盟" />
                    <el-checkbox label="专利融资（包括质押、信托、作价入股等）" />
                    <el-checkbox label="以专利为基础的技术合作" />
                    <el-checkbox label="其他，请注明" />
                </el-checkbox-group>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script setup>
import { ref, reactive } from 'vue';
const form = reactive({
    pAq1: "",
});
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
