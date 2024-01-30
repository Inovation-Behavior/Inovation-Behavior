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
                    <p><strong>{{$t("survey.patent name")}}:</strong> {{ patent.name }}</p>
                    <p><strong>{{$t("survey.summary")}}:</strong> {{ patent.summary }}</p>
                    <!-- <p><strong>链接:</strong> <a :href="patent.link">{{ patent.link }}</a></p> -->
                </div>
                <p v-else style="color: red;">{{$t("survey.NoSuchPatent")}}</p>
            </div>
            <div></div>
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P1Q1')">
                <el-radio-group v-model="form.sex">
                    <el-radio :label="$t('survey.Female')" />
                    <el-radio :label="$t('survey.Male')" />
                    <el-radio :label="$t('survey.Others')" />
                    <el-radio :label="$t('survey.Don’t want to disclose')" />
                </el-radio-group>
            </el-form-item>
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P1Q2')">
                <el-select v-model="form.major" style="max-width: 500px;">
                    <el-option :label="$t('survey.Law')" value="Law" />
                    <el-option :label="$t('survey.Economics/Management')" value="Economics or Management (e.g., Finance, Accounting, ...)" />
                    <el-option :label="$t('survey.OtherSocialSciences')" value="Other Social Sciences" />
                    <el-option :label="$t('survey.MathPhysicsEngineering')" value="Math, Physics or Engineering" />
                    <el-option :label="$t('survey.BiologyMedicineOtherLifeSciences')"  value="Biology, Medicine, and Other Life Sciences" />
                </el-select>
            </el-form-item>
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P1Q3')">
                <el-radio-group v-model="form.status">
                    <el-radio :label="$t('survey.Bachelor')" />
                    <el-radio :label="$t('survey.Master')" />
                    <el-radio :label="$t('survey.Doctorate')" />
                </el-radio-group>
            </el-form-item>
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P1Q4')">
                <el-checkbox-group v-model="form.identify" style="display: flex;flex-wrap: wrap;">
                    <el-checkbox :label="$t('survey.P1Q4A1')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q4A2')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q4A3')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q4A4')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q4A5')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q4A6')" name="identify" />
                </el-checkbox-group>
            </el-form-item>
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P1Q5')">

            </el-form-item>
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P1Q6')">
                <el-checkbox-group v-model="form.exper">
                    <el-checkbox :label="$t('survey.P1Q6A1')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q6A2')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q6A3')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q6A4')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q6A5')" name="identify" />
                    <el-checkbox :label="$t('survey.P1Q6A6')" name="identify" />
                </el-checkbox-group>
            </el-form-item>
        </el-form>
    </el-card>
    <el-button type="primary" @click="submit()" style="margin-top: 1vh;margin-left: 2vw;">submit part 1</el-button>
</template>

<script setup>
import { ref, reactive } from 'vue';
import axios from 'axios';
import { ElMessage } from 'element-plus';
const form = reactive({
    patentPublicationNo: "",
    sex: "",
    major: "",
    status: "",
    identify: [],
    income: "",
    exper: [],
});

let patent = ref({
    no: "",
    name: "",
    summary: "",
    link: "",
})

const getPatentByNo = async (no) => {
    if(no == ''){
        patent.value.no=''
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
    }else {
        patent.value.name = '';
        patent.value.summary = '';
        patent.value.link = '';
    }
}

const submit = async() => {
    // 将数组元素整合为以逗号分隔的字符串
    const identifyString = form.identify.join(",");
    const experString = form.exper.join(",");

    // 创建新的对象，将字符串赋值给 identify 和 exper 属性
    const formData = {
        patentNo:form.patentPublicationNo,
        gender:form.sex,
        major:form.major,
        degree:form.status,
        income:form.income,
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
:deep(.el-radio__label){
	white-space: normal;  /* 换行 */
}

:deep(.el-checkbox__label){
	white-space: normal;  /* 换行 */
}
</style>
