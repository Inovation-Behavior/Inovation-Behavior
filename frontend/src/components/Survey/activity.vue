<template>
    <el-card style="border-radius: 15px;width: 100%;">
        <el-form :model="form" size="large" label-position="top">
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q1')">
                <el-date-picker
                    v-model="form.year"
                    type="year"
                    placeholder="Pick a year"
                />
            </el-form-item>
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q2')">
                
            </el-form-item>
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q3')">
                
            </el-form-item>
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q4')">
                <el-select v-model="form.area" filterable allow-create>
                    <el-option :label="$t('survey.P2Q4A1')" value="上海本地为主" />
                    <el-option :label="$t('survey.P2Q4A2')" value="全国" />
                    <el-option :label="$t('survey.P2Q4A3')" value="北美" />
                    <el-option :label="$t('survey.P2Q4A4')" value="欧洲" />
                    <el-option :label="$t('survey.P2Q4A5')" value="其他（请直接输入）" />
                </el-select>
            </el-form-item>
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q5')">

            </el-form-item>
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q6')">
                
            </el-form-item>
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q7')">
                <el-select v-model="form.Q7" :placeholder="$t('survey.PleaseChose')" allow-create multiple>
                    <el-option :label="$t('survey.P2Q7A1')" value="1" />
                    <el-option :label="$t('survey.P2Q7A2')" value="2" />
                    <el-option :label="$t('survey.No')" value="No" />
                </el-select>
            </el-form-item>
            <el-form-item v-if="showQ7_1()" style="font-weight: bolder;" :label="$t('survey.P2Q7_1')">
                <el-select v-model="form.Q7_1" :placeholder="$t('survey.PleaseChose')" allow-create multiple>
                    <el-option :label="$t('survey.P2Q7_1A1')" value="1" />
                    <el-option :label="$t('survey.P2Q7_1A2')" value="2" />
                    <el-option :label="$t('survey.P2Q7_1A3')" value="3" />
                    <el-option :label="$t('survey.P2Q7_1A4')" value="4" />
                    <el-option :label="$t('survey.P2Q7_1A5')" value="5" />
        
                </el-select>
            </el-form-item>
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q8')">
                <el-select v-model="form.update" :placeholder="$t('survey.PleaseChose')" allow-create multiple>
                    <el-option :label="$t('survey.P2Q8A1')" value="开发或管理专利的方法" />
                    <el-option :label="$t('survey.P2Q8A2')" value="信息处理或通信方法（如在线会议工具）" />
                    <el-option :label="$t('survey.P2Q8A3')" value="会计或其他行政操作方法" />
                    <el-option :label="$t('survey.P2Q8A4')" value="其他（请直接输入）" />
                </el-select>
            </el-form-item>
        </el-form>
    </el-card>
</template>

<script>
export default {
    data() {
        return {
            form: {
                year: "",
                area:"",
                update:[],
                Q7: [],
                Q7_1: [],
            },
        }
    },
    methods: {
        showQ7_1(){
            return this.form.Q7.length > 0 && !this.form.Q7.includes('No') ;
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