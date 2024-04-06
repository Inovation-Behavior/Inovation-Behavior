<template>
    <el-card style="border-radius: 15px;width: 100%;font-size: 1rem;font-family: SimSun;">

        <!-- <el-card style="border: 1px solid black;"> -->
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
        <!-- </el-card> -->
        <!-- <p style="color: rgb(0,112,192)">
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
        </p> -->
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
        if (response.data.data.length == 0) {
            ElMessage.error("抱歉，公司名有误或专利不存在，请确保输入公司全名")
        } else if (response.data.code == 1) {
            searchPatents.value = response.data.data.slice(0, 10)
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
p {
    margin-bottom: 20px;
    /* 设置段落下方的外边距 */
    line-height: 40px
}
:deep(.el-radio__label) {
    white-space: normal;
    /* 换行 */
}

:deep(.el-checkbox__label) {
    white-space: normal;
    /* 换行 */
}
</style>
