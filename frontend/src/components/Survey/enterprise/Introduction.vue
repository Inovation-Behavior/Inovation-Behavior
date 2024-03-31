<template>
    <el-card style="border-radius: 15px;width: 100%;font-size: 1rem;font-family: SimSun;">
        <p>尊敬的专家：</p>

        <p style="text-indent: 2em;">
            您好！我们是同济大学上海国际知识产权学院师生。本次问卷是“开放专利与创新”研究的一部分，探索我国专利的经济价值、专利许可影响因素、政策需求问题，获得国家社会科学基金项目（21&ZD65）、国家自然科学基金（72304209、72072129、72074169）支持。
        </p>

        <p style="text-indent: 2em;">我们共向上海地区超过 7000 名持有近 2 万个高价值专利的管理者（包括发明人、企业 IP 管理者、专利代理人）等发放调查问卷。问卷会耗时 15-20
            分钟。您可以填写纸质版问卷，也可登录<a href="www.opi-shanghai.com"> www.opi-shanghai.com</a> 填写在线问卷。我们后续也将在网站上公布调查研究成果。
        </p>

        <p style="text-indent: 2em;">您的意见对知识产权研究非常重要！我们不会以任何方式直接披露您的问卷填写信息。衷心感谢您的支持与协助！
        </p>
        <el-container style="width: 100%;display: flex; justify-content: flex-end; align-items: center;">
            <img src="../../../public/img/survey_logo.png" style="height: 20vh;margin-right: 10vw;" />
            <p style="text-align: right;margin-right: 5vw;">
                同济大学上海国际知识产权学院
            </p>
        </el-container>
        <p style="text-align: right;margin-right: 5vw;">
            2024 年 3 月 15 日
        </p>

        <el-card style="border: 1px solid black;">
            <p style="margin-top: 2vh;">
                在回答问卷前，请确认您所在单位持有附件发明专利
            </p>
            <p style="text-indent: 2em;">
                （专利申请号为：
                <el-input size="small" style="width: 7vw;" v-model="form.patentNo" @input="updatePatentNo"
                    @keyup.enter="getPatentByNo(form.patentNo)"></el-input>
                ）。如果与该专利无关，请提供您所在单位的名称：
                <el-input size="small" style="width: 7vw;" v-model="form.companyName" @input="updateCompanyName"
                    @keyup.enter="getPatentNoByCompany(form.companyName)"></el-input>
                ，我们将为您推荐其他专利。
            </p>
            <template v-if="patentDetail.no!=''">
                <div v-if="patentDetail.name">
                    <p><strong>专利名称:</strong> {{ patentDetail.name }}</p>
                    <p><strong>专利概述:</strong> {{ patentDetail.summary }}</p>
                    <p><strong>专利链接:</strong> <a :href="patentDetail.pdfs[0]" target="blank">{{ patentDetail.pdfs[0]
                            }}</a></p>
                </div>
            </template>
            <template v-if="searchPatents.length!=0">
                <el-table :data="searchPatents" style="width: 100%">
                    <el-table-column prop="no" label="no" width="180" />
                    <el-table-column prop="application" label="application" width="200" />
                    <el-table-column prop="name" label="name" />
                </el-table>
            </template>
        </el-card>
        <p style="color: rgb(0,112,192)">
            填写形式：
        </p>
        <p style="color: rgb(0,112,192);text-indent: 2em;">
            如果答案前为o，请勾选单一选项；如果答案前为 口，请选择所有相关选项；
        </p>
        <p style="color: rgb(0,112,192);text-indent: 2em;">
            如果答案为矩阵，请每一行勾选相应选项
        </p>
        <p style="color: rgb(0,112,192);text-indent: 2em;">
            如果您已回答过一份问卷，A.个人基本信息与B.企业信息部分可直接跳过
        </p>
    </el-card>
</template>

<script setup>
import { ref, reactive } from 'vue';
import { surveyStore } from '../../../stores/survey';
import axios from 'axios';
import { ElMessage } from 'element-plus';
const surveyInfo = surveyStore().surveyInfo
const updatePatentNo = (value) => {
    surveyInfo.patentNo = value;
};
const updateCompanyName = (value) => {
    surveyInfo.companyName = value;
};
const form = reactive({
    patentNo:"",
    companyName:""
});

const patentDetail = ref({});
const getPatentByNo = async (no) => {
    if (no == '') {
        return;
    }
    let response = await axios.get('api/patents/' + no);
    if(response.data.code == 0){
        ElMessage.error("抱歉，专利号有误或专利不存在")
    }else if(response.data.code ==1){
        patentDetail.value = response.data.data
    }
}

const searchPatents = ref([]);
const getPatentNoByCompany = async (name) => {
    try {
        const no = "";
        const response = await axios.get(`api/patents`, {
            params: {
                company: name,
                no: ""
            }
        });
        if (response.data.code == 0) {
            ElMessage.error("抱歉，搜索失败")
        } else if (response.data.code == 1) {
            searchPatents.value = response.data.data.slice(0, 10)
            console.log(searchPatents.value)
        }
        return;
    } catch (error) {
        // 处理请求失败的情况
        console.error('请求失败:', error);
        throw error; // 可以选择抛出错误以供调用者处理
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
