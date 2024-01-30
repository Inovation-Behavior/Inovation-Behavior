<template>
    <el-card style="border-radius: 15px;width: 100%;">
        <el-form :model="form" size="large" label-position="top">
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P3Q1')">
                <el-radio-group v-model="form.stage">
                    <el-radio :label="$t('survey.P3Q1A1')" />
                    <el-radio :label="$t('survey.P3Q1A2')" />
                    <el-radio :label="$t('survey.P3Q1A3')"/>
                </el-radio-group>
            </el-form-item>
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P3Q2')">
                <el-radio-group v-model="form.charac">
                    <el-radio :label="$t('survey.P3Q2A1')" />
                    <el-radio :label="$t('survey.P3Q2A2')" />
                </el-radio-group>
            </el-form-item>
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P3Q3')">
                <el-radio-group v-model="form.user">
                    <el-radio :label="$t('survey.P3Q3A1')" />
                    <el-radio :label="$t('survey.P3Q3A2')" />
                    <el-radio :label="$t('survey.P3Q3A3')" />
                    <el-radio :label="$t('survey.P3Q3A4')" />
                </el-radio-group>
            </el-form-item>
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P3Q4')">
                <el-select v-model="form.area" :placeholder="$t('PleaseChose')" allow-create style="max-width: 500px;"> 
                    <el-option :label="$t('survey.P3Q4A1')" value="医疗保健和生命科学" />
                    <el-option :label="$t('survey.P3Q4A2')" value="环境和能源" />
                    <el-option :label="$t('survey.P3Q4A3')" value="信息和通信技术" />
                    <el-option :label="$t('survey.P3Q4A4')" value="其他（请直接输入）" />
                </el-select>
            </el-form-item>
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P3Q5')">
                <el-radio-group v-model="form.inventor">
                    <el-radio :label="$t('survey.P3Q5A1')" />
                    <el-radio :label="$t('survey.P3Q5A2')" />
                    <el-radio :label="$t('survey.P3Q5A3')" />
                    <el-radio :label="$t('survey.P3Q5A4')" />
                </el-radio-group>
            </el-form-item>
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P3Q6')">
                <el-select v-model="form.count" :placeholder="$t('survey.PleaseChose')" style="max-width: 500px;">
                    <el-option label="0%-1%(0%<&<=1%)" value="0%-1%(0%<&<=1%)" />
                    <el-option label="1%-5%" value="1%-5%" />
                    <el-option label="5%-10%" value="5%-10%" />
                    <el-option label="10%-25%" value="10%-25%" />
                    <el-option label="25%-50%" value="25%-50%" />
                    <el-option label="50%-75%" value="50%-75%" />
                    <el-option label="75%-100%" value="75%-100%" />
                    <el-option :label="$t('survey.Dontknow')" value="不知道" />
                </el-select>
            </el-form-item>
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P3Q7')">
                <el-radio-group v-model="form.continue">
                    <el-radio :label="$t('survey.Yes')" />
                    <el-radio :label="$t('survey.P3Q7A1')" />
                    <el-radio :label="$t('survey.No')" />
                </el-radio-group>
            </el-form-item>
            <el-form-item style="font-weight: bolder;" v-if="showQ8()" key="decrease" :label="$t('survey.P3Q8')">
                <!-- <el-radio-group v-model="form.continue">
                    <el-radio label="会" />
                    <el-radio label="会，但会减少相关投入" />
                    <el-radio label="不会" />
                </el-radio-group> -->
            </el-form-item>
            <el-form :model="form.influence">
                <el-text style="font-weight: bolder;">{{$t('survey.P3Q9') }}</el-text>
                <el-form-item style="margin-left: 1vw;" :label="$t('survey.P3Q9A1')">
                    <el-radio-group v-model="form.influence.type1">
                        <el-radio :label="$t('survey.High')" />
                        <el-radio :label="$t('survey.Medium')" />
                        <el-radio :label="$t('survey.Low')" />
                        <el-radio :label="$t('survey.Notrelevant')" />
                    </el-radio-group>
                </el-form-item>
                <el-form-item style="margin-left: 1vw;" :label="$t('survey.P3Q9A2')">
                    <el-radio-group v-model="form.influence.type2">
                        <el-radio :label="$t('survey.High')" />
                        <el-radio :label="$t('survey.Medium')" />
                        <el-radio :label="$t('survey.Low')" />
                        <el-radio :label="$t('survey.Notrelevant')" />
                    </el-radio-group>
                </el-form-item>
                <el-form-item style="margin-left: 1vw;" :label="$t('survey.P3Q9A3')">
                    <el-radio-group v-model="form.influence.type3">
                        <el-radio :label="$t('survey.High')" />
                        <el-radio :label="$t('survey.Medium')" />
                        <el-radio :label="$t('survey.Low')" />
                        <el-radio :label="$t('survey.Notrelevant')" />
                    </el-radio-group>
                </el-form-item>
                <el-form-item style="margin-left: 1vw;" :label="$t('survey.P3Q9A4')">
                    <el-radio-group v-model="form.influence.type4">
                        <el-radio :label="$t('survey.High')" />
                        <el-radio :label="$t('survey.Medium')" />
                        <el-radio :label="$t('survey.Low')" />
                        <el-radio :label="$t('survey.Notrelevant')" />
                    </el-radio-group>
                </el-form-item>
                <el-form-item style="margin-left: 1vw;" :label="$t('survey.P3Q9A5')">
                    <el-radio-group v-model="form.influence.type5">
                        <el-radio :label="$t('survey.High')" />
                        <el-radio :label="$t('survey.Medium')" />
                        <el-radio :label="$t('survey.Low')" />
                        <el-radio :label="$t('survey.Notrelevant')" />
                    </el-radio-group>
                </el-form-item>
                <el-form-item style="margin-left: 1vw;" :label="$t('survey.P3Q9A6')">
                    <el-radio-group v-model="form.influence.type6">
                        <el-radio :label="$t('survey.High')" />
                        <el-radio :label="$t('survey.Medium')" />
                        <el-radio :label="$t('survey.Low')" />
                        <el-radio :label="$t('survey.Notrelevant')" />
                    </el-radio-group>
                </el-form-item>
                <el-form-item style="margin-left: 1vw;" :label="$t('survey.P3Q9A7')">
                    <el-radio-group v-model="form.influence.type7">
                        <el-radio :label="$t('survey.High')" />
                        <el-radio :label="$t('survey.Medium')" />
                        <el-radio :label="$t('survey.Low')" />
                        <el-radio :label="$t('survey.Notrelevant')" />
                    </el-radio-group>
                </el-form-item>
                <el-form-item style="margin-left: 1vw;" :label="$t('survey.P3Q9A8')">
                    <el-radio-group v-model="form.influence.type8">
                        <el-radio :label="$t('survey.High')" />
                        <el-radio :label="$t('survey.Medium')" />
                        <el-radio :label="$t('survey.Low')" />
                        <el-radio :label="$t('survey.Notrelevant')" />
                    </el-radio-group>
                </el-form-item>
            </el-form>
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P3Q10')">
                <el-radio-group v-model="form.buy">
                    <el-radio :label="$t('survey.Yes')" />
                    <el-radio :label="$t('survey.No')" />
                </el-radio-group>
            </el-form-item>
            <el-form-item style="font-weight: bolder;" v-if="showQ11()" :label="$t('survey.P3Q11')">
                <el-select v-model="form.setback" :placeholder="$t('PleaseChose')">
                    <el-option :label="$t('survey.P3Q11A1')" value="我们不需要外部专利" />
                    <el-option :label="$t('survey.P3Q11A2')" value="缺乏关于外部专利供应商的信息" />
                    <el-option :label="$t('survey.P3Q11A3')" value="没有合适的供应商" />
                    <el-option :label="$t('survey.P3Q11A4')" value="缺乏进行许可证谈判的合格人员" />
                    <el-option :label="$t('survey.P3Q11A5')" value="难以获得许可方的技术援助" />
                </el-select>
            </el-form-item>
        </el-form>
    </el-card>
    <el-button type="primary" @click="submit()" style="margin-top: 1vh;margin-left: 2vw;">submit part 3</el-button>
</template>

<script>
import axios from 'axios';
import { ElMessage } from 'element-plus';
export default {
    data() {
        return {
            form: {
                stage:"",
                charac:"",
                user:"",
                area:"",
                inventor:"",
                count:"",
                continue:"",
                influence:{
                    type1:"",
                    type2: "",
                    type3: "",
                    type4: "",
                    type5: "",
                    type6: "",
                    type7: "",
                    type8: "",
                },
                buy:"",
                setback:"",
            },
        }
    },
    methods: {
        getItem(){
            console.log(this.form.buy)
        },
        showQ11(){
            return this.form.buy === 'No'
        },
        showQ8(){
            return this.form.continue === 'Yes' || this.form.continue === 'Yes, but will reduce related investment'
        },
        async submit(){
            // 获取对象的所有值，并用逗号连接起来
            const influenceString = Object.values(this.form.influence).join(",");

            // 创建新的对象，将字符串赋值给 identify 和 exper 属性
            const formData = {
                patentNo: "patentNo",
                stage:this.form.stage,
                charac:this.form.charac,
                users:this.form.user,
                sector:this.form.area,
                inventor:this.form.inventor,
                revenue:this.form.count,
                continueDevelop:this.form.continue,
                importance:" ",
                marketConditions:influenceString,
                patent:this.form.buy,
                majorHurdles:this.form.setback
            };

            console.log(formData);
            try {
                let response = await axios.post('api/questionnaire/businessActivity', formData);
                console.log(response);
                // 根据需要处理来自服务器的响应
                if(response.data.code==1){
                    ElMessage.success("successfully submit part 3")
                }
            } catch (error) {
                console.error(error);
                // 处理请求失败的错误
            }
        }
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