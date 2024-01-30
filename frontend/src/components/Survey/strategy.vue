<template>
    <el-card style="border-radius: 15px;width: 100%;">
        <el-form :model="form" size="large" label-position="top">
            <el-form-item :label="$t('survey.P4Q1')" style="font-weight: bolder;">

            </el-form-item>
            <el-form :model="form.influence">
                <el-text style="font-weight: bolder;">{{ $t('survey.P4Q2') }}</el-text>
                <el-form-item style="margin-left: 1vw;margin-top: 1vh;" :label="$t('survey.P4Q2A1')">
                    <el-radio-group v-model="form.influence.type1">
                        <el-radio :label="$t('survey.High')" />
                        <el-radio :label="$t('survey.Medium')" />
                        <el-radio :label="$t('survey.Low')" />
                        <el-radio :label="$t('survey.NotImportant')" />
                    </el-radio-group>
                </el-form-item>
                <el-form-item style="margin-left: 1vw;" :label="$t('survey.P4Q2A2')">
                    <el-radio-group v-model="form.influence.type2">
                        <el-radio :label="$t('survey.High')" />
                        <el-radio :label="$t('survey.Medium')" />
                        <el-radio :label="$t('survey.Low')" />
                        <el-radio :label="$t('survey.NotImportant')" />
                    </el-radio-group>
                </el-form-item>
                <el-form-item style="margin-left: 1vw;" :label="$t('survey.P4Q2A3')">
                    <el-radio-group v-model="form.influence.type3">
                        <el-radio :label="$t('survey.High')" />
                        <el-radio :label="$t('survey.Medium')" />
                        <el-radio :label="$t('survey.Low')" />
                        <el-radio :label="$t('survey.NotImportant')" />
                    </el-radio-group>
                </el-form-item>
                <el-form-item style="margin-left: 1vw;" :label="$t('survey.P4Q2A4')">
                    <el-radio-group v-model="form.influence.type4">
                        <el-radio :label="$t('survey.High')" />
                        <el-radio :label="$t('survey.Medium')" />
                        <el-radio :label="$t('survey.Low')" />
                        <el-radio :label="$t('survey.NotImportant')" />
                    </el-radio-group>
                </el-form-item>
                <el-form-item style="margin-left: 1vw;" :label="$t('survey.P4Q2A5')">
                    <el-radio-group v-model="form.influence.type5">
                        <el-radio :label="$t('survey.High')" />
                        <el-radio :label="$t('survey.Medium')" />
                        <el-radio :label="$t('survey.Low')" />
                        <el-radio :label="$t('survey.NotImportant')" />
                    </el-radio-group>
                </el-form-item>
                <el-form-item style="margin-left: 1vw;" :label="$t('survey.P4Q2A6')">
                    <el-radio-group v-model="form.influence.type6">
                        <el-radio :label="$t('survey.High')" />
                        <el-radio :label="$t('survey.Medium')" />
                        <el-radio :label="$t('survey.Low')" />
                        <el-radio :label="$t('survey.NotImportant')" />
                    </el-radio-group>
                </el-form-item>
            </el-form>
            <el-form :model="form.importance">
                <el-text style="font-weight: bolder;">{{ $t('survey.P4Q3') }}</el-text>
                <el-form-item style="margin-left: 1vw;" :label="$t('survey.P4Q3A1')">
                    <el-radio-group v-model="form.importance.type1">
                        <el-radio :label="$t('survey.High')" />
                        <el-radio :label="$t('survey.Medium')" />
                        <el-radio :label="$t('survey.Low')" />
                        <el-radio :label="$t('survey.NotImportant')" />
                    </el-radio-group>
                </el-form-item>
                <el-form-item style="margin-left: 1vw;" :label="$t('survey.P4Q3A2')">
                    <el-radio-group v-model="form.importance.type2">
                        <el-radio :label="$t('survey.High')" />
                        <el-radio :label="$t('survey.Medium')" />
                        <el-radio :label="$t('survey.Low')" />
                        <el-radio :label="$t('survey.NotImportant')" />
                    </el-radio-group>
                </el-form-item>
                <el-form-item style="margin-left: 1vw;" :label="$t('survey.P4Q3A3')">
                    <el-radio-group v-model="form.importance.type3">
                        <el-radio :label="$t('survey.High')" />
                        <el-radio :label="$t('survey.Medium')" />
                        <el-radio :label="$t('survey.Low')" />
                        <el-radio :label="$t('survey.NotImportant')" />
                    </el-radio-group>
                </el-form-item>
                <el-form-item style="margin-left: 1vw;" :label="$t('survey.P4Q3A4')">
                    <el-radio-group v-model="form.importance.type4">
                        <el-radio :label="$t('survey.High')" />
                        <el-radio :label="$t('survey.Medium')" />
                        <el-radio :label="$t('survey.Low')" />
                        <el-radio :label="$t('survey.NotImportant')" />
                    </el-radio-group>
                </el-form-item>
            </el-form>
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P4Q4')">
                <el-select v-model="form.update" :placeholder="$t('survey.PleaseChose')" allow-create multiple>
                    <el-option :label="$t('survey.P4Q4A1')" value="1" />
                    <el-option :label="$t('survey.P4Q4A2')" value="2" />
                    <el-option :label="$t('survey.P4Q4A3')" value="3" />
                    <el-option :label="$t('survey.P4Q4A4')" value="4" />
                    <el-option :label="$t('survey.P4Q4A5')" value="5" />
                </el-select>
            </el-form-item>
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P4Q5')">
                <el-radio-group v-model="form.isSuccess">
                    <el-radio :label="$t('survey.P4Q5A1')" />
                    <el-radio :label="$t('survey.P4Q5A2')" />
                    <el-radio :label="$t('survey.P4Q5A3')" />
                </el-radio-group>
            </el-form-item>
            <el-form :model="form.setback">
                <el-text style="font-weight: bolder;">{{ $t('survey.P4Q6') }}</el-text>
                <el-form-item style="margin-left: 1vw;" :label="$t('survey.P4Q6A1')">
                    <el-radio-group v-model="form.setback.type1">
                        <el-radio :label="$t('survey.High')" />
                        <el-radio :label="$t('survey.Medium')" />
                        <el-radio :label="$t('survey.Low')" />
                        <el-radio :label="$t('survey.Notrelevant')" />
                    </el-radio-group>
                </el-form-item>
                <el-form-item style="margin-left: 1vw;" :label="$t('survey.P4Q6A2')">
                    <el-radio-group v-model="form.setback.type2">
                        <el-radio :label="$t('survey.High')" />
                        <el-radio :label="$t('survey.Medium')" />
                        <el-radio :label="$t('survey.Low')" />
                        <el-radio :label="$t('survey.Notrelevant')" />
                    </el-radio-group>
                </el-form-item>
                <el-form-item style="margin-left: 1vw;" :label="$t('survey.P4Q6A3')">
                    <el-radio-group v-model="form.setback.type3">
                        <el-radio :label="$t('survey.High')" />
                        <el-radio :label="$t('survey.Medium')" />
                        <el-radio :label="$t('survey.Low')" />
                        <el-radio :label="$t('survey.Notrelevant')" />
                    </el-radio-group>
                </el-form-item>
                <el-form-item style="margin-left: 1vw;" :label="$t('survey.P4Q6A4')">
                    <el-radio-group v-model="form.setback.type4">
                        <el-radio :label="$t('survey.High')" />
                        <el-radio :label="$t('survey.Medium')" />
                        <el-radio :label="$t('survey.Low')" />
                        <el-radio :label="$t('survey.Notrelevant')" />
                    </el-radio-group>
                </el-form-item>
                <el-form-item style="margin-left: 1vw;" :label="$t('survey.P4Q6A5')">
                    <el-radio-group v-model="form.setback.type5">
                        <el-radio :label="$t('survey.High')" />
                        <el-radio :label="$t('survey.Medium')" />
                        <el-radio :label="$t('survey.Low')" />
                        <el-radio :label="$t('survey.Notrelevant')" />
                    </el-radio-group>
                </el-form-item>
            </el-form>
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P4Q7')">
                <el-select v-model="form.develop" :placeholder="$t('survey.PleaseChose')" allow-create multiple>
                    <!-- <el-option :label="$t('P4Q7A1')" value="1" /> -->
                    <el-option :label="$t('survey.P4Q7A2')" value="2" />
                    <el-option :label="$t('survey.P4Q7A3')" value="3" />
                    <el-option :label="$t('survey.P4Q7A4')" value="4" />
                    <el-option :label="$t('survey.P4Q7A5')" value="5" />
                    <el-option :label="$t('survey.P4Q7A6')" value="6" />
                </el-select>
            </el-form-item>
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P4Q8')">
                <el-select v-model="form.Q8" :placeholder="$t('survey.PleaseChose')" allow-create multiple>
                    <el-option :label="$t('survey.P4Q8A1')" value="1" />
                    <el-option :label="$t('survey.P4Q8A2')" value="2" />
                    <el-option :label="$t('survey.P4Q8A3')" value="3" />
                    <el-option :label="$t('survey.P4Q8A4')" value="4" />
                </el-select>
            </el-form-item>
        </el-form>
    </el-card>
    <el-button type="primary" @click="submit()" style="margin-top: 1vh;margin-left: 2vw;">submit part 4</el-button>
</template>

<script>
import axios from 'axios';
import { ElMessage } from 'element-plus';
export default {
    data() {
        return {
            form: {
                financialValue:"",
                influence: {
                    type1: "",
                    type2: "",
                    type3: "",
                    type4: "",
                    type5: "",
                    type6: "",
                },
                importance: {
                    type1: "",
                    type2: "",
                    type3: "",
                    type4: "",
                },
                update:[],
                isSuccess:"",
                setback: {
                    type1: "",
                    type2: "",
                    type3: "",
                    type4: "",
                    type5: "",
                },
                develop: [],
                Q8: [],
            },
        }
    },
    methods: {
        async submit() {
            // 获取对象的所有值，并用逗号连接起来
            const influenceString = Object.values(this.form.influence).join(",");
            const importanceString = Object.values(this.form.importance).join(",");
            const setbackString = Object.values(this.form.setback).join(",");
            const updateString = this.form.update.join(",");
            const developString = this.form.develop.join(",");
            const Q8String = this.form.Q8.join(",");


            // 创建新的对象，将字符串赋值给 identify 和 exper 属性
            const formData = {
                patentNo: "patentNo",
                financialValue:this.form.financialValue,
                holdReason:influenceString,
                importance:importanceString,
                commercializeMethods:updateString,
                isSuccessful:this.form.isSuccess,
                obstaclesExtent:setbackString,
                facilitateOptions:developString,
                publicSupport:Q8String,
            };

            console.log(formData);
            try {
                let response = await axios.post('api/questionnaire/patentStrategy', formData);
                console.log(response);
                // 根据需要处理来自服务器的响应
                if (response.data.code == 1) {
                    ElMessage.success("successfully submit part 4")
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