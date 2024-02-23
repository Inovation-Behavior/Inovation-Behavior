<template>
    <el-card style="border-radius: 15px;width: 100%;">
        <el-form :model="form" size="large" label-position="top">
            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q1')">
                <el-radio-group v-model="form.p2q1">
                    <el-radio :label="$t('survey.P2Q1A1')" />
                    <el-radio :label="$t('survey.P2Q1A2')" />
                </el-radio-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q2')">
                <el-radio-group v-model="form.p2q2" @change="handleB02Change">
                    <el-radio :label="$t('survey.P2Q2A1')" />
                    <el-radio :label="$t('survey.P2Q2A2')" />
                    <el-radio :label="$t('survey.P2Q2A3')" />
                    <el-radio :label="$t('survey.P2Q2A4')" />
                    <el-radio :label="$t('survey.P2Q2A5')" />
                </el-radio-group>
            </el-form-item>

            <el-form-item v-if="showB03" style="font-weight: bolder;" :label="$t('survey.P2Q3')">
                <el-radio-group v-model="form.p2q3">
                    <el-radio :label="$t('survey.P2Q3A1')" />
                    <el-radio :label="$t('survey.P2Q3A2')" />
                    <el-radio :label="$t('survey.P2Q3A3')" />
                    <el-radio :label="$t('survey.P2Q3A4')" />
                </el-radio-group>
            </el-form-item>

            <el-form-item v-if="showB04" style="font-weight: bolder;" :label="$t('survey.P2Q4')">
                <el-radio-group v-model="form.p2q4">
                    <el-radio :label="$t('survey.P2Q4A1')" />
                    <el-radio :label="$t('survey.P2Q4A2')" />
                    <el-radio :label="$t('survey.P2Q4A3')" />
                    <el-radio :label="$t('survey.P2Q4A4')" />
                </el-radio-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q5')">
                <el-checkbox-group v-model="form.p2q5" style="display: flex;flex-wrap: wrap;">
                    <el-checkbox :label="$t('survey.P2Q5A1')"/>
                    <el-checkbox :label="$t('survey.P2Q5A2')"/>
                    <el-checkbox :label="$t('survey.P2Q5A3')"/>
                    <el-checkbox :label="$t('survey.P2Q5A4')"/>
                    <el-checkbox :label="$t('survey.P2Q5A5')"/>
                    <el-checkbox :label="$t('survey.P2Q5A6')"/>
                    <el-checkbox :label="$t('survey.P2Q5A7')"/>
                    <el-checkbox :label="$t('survey.P2Q5A8')"/>
                    <el-checkbox :label="$t('survey.P2Q5A9')"/>
                </el-checkbox-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q6')">
                <el-radio-group v-model="form.p2q6" @change="handleB06Change">
                    <el-radio :label="$t('survey.P2Q6A1')" />
                    <el-radio :label="$t('survey.P2Q6A2')" />
                    <el-radio :label="$t('survey.P2Q6A3')" />
                </el-radio-group>
            </el-form-item>

            <p v-if="showB07">B07</p>

            <p v-if="showB08">B08</p>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q9')">
                <el-radio-group v-model="form.p2q9">
                    <el-radio :label="$t('survey.P2Q9A1')" />
                    <el-radio :label="$t('survey.P2Q9A2')" />
                    <el-radio :label="$t('survey.P2Q9A3')" />
                    <el-radio :label="$t('survey.P2Q9A4')" />
                    <el-radio :label="$t('survey.P2Q9A5')" />
                </el-radio-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q10')">
                <el-radio-group v-model="form.p2q10">
                    <el-radio :label="$t('survey.P2Q10A1')" />
                    <el-radio :label="$t('survey.P2Q10A2')" />
                    <el-radio :label="$t('survey.P2Q10A3')" />
                    <el-radio :label="$t('survey.P2Q10A4')" />
                </el-radio-group>
            </el-form-item>

             <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q11')">
                <el-radio-group v-model="form.p2q11">
                    <el-radio :label="$t('survey.P2Q11A1')" />
                    <el-radio :label="$t('survey.P2Q11A2')" />
                    <el-radio :label="$t('survey.P2Q11A3')" />
                    <el-radio :label="$t('survey.P2Q11A4')" />
                    <el-radio :label="$t('survey.P2Q11A5')" />
                    <el-radio :label="$t('survey.P2Q11A6')" />
                </el-radio-group>
            </el-form-item>

            <p>B12</p>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q13')">
                <el-radio-group v-model="form.p2q13">
                    <el-radio :label="$t('survey.P2Q13A1')" />
                    <el-radio :label="$t('survey.P2Q13A2')" />
                    <el-radio :label="$t('survey.P2Q13A3')" />
                </el-radio-group>
            </el-form-item>

            <el-form-item style="font-weight: bolder;" :label="$t('survey.P2Q14')">
                <el-radio-group v-model="form.p2q14">
                    <el-radio :label="$t('survey.P2Q14A1')" />
                    <el-radio :label="$t('survey.P2Q14A2')" />
                    <el-radio :label="$t('survey.P2Q14A3')" />
                    <el-radio :label="$t('survey.P2Q14A4')" />
                    <el-radio :label="$t('survey.P2Q14A5')" />
                </el-radio-group>
            </el-form-item>

            <p>B15</p>

            <p>B16</p>

            <p>B17</p>

            <p>B18</p>
        </el-form>
    </el-card>
    <el-button type="primary" @click="submit()" style="margin-top: 1vh;margin-left: 2vw;">submit part 1</el-button>
</template>

<script>
import enLocale from '../../locales/en.json';
export default {
    data() {
        return {
            form: {
                p2q1:"",
                p2q2: "",
                p2q3: "",
                p2q4: "",
                p2q5: [],
                p2q6: "",
                p2q7: "",
                p2q8: "",
                p2q9: "",
                p2q10: "",
                p2q11: "",
                p2q12: "",
                p2q13: "",
                p2q14: "",
                p2q15: "",
                p2q16: "",
                p2q17: "",
                p2q18: "",
            },
            showB03:false,
            showB04:false,
            showB07:false,
            showB08:false,
        }
    },
    methods: {
        handleB02Change(value){
            //this.showB03 = value === "(a) Has entered the market";
            this.showB03 = value === enLocale.survey.P2Q2A1;
            this.showB04 = value === enLocale.survey.P2Q2A5;
        },
        handleB06Change(value) {
            this.showB07 = value === enLocale.survey.P2Q6A1;
            this.showB08 = value == enLocale.survey.P2Q6A2 || value == enLocale.survey.P2Q6A3;
        },
        renderSO2Header(h, { column }) {
            return h(
                'div',
                [
                    //加入选择框，同时绑定事件
                    h('el-checkbox', {
                        on: {
                            // event为当前checkbox选中状态值（true/false）
                            change: ($event, column) => this.selectColumn1($event, column),
                        }
                    }),
                    // 加入label，值为 el-table-column 标签定义的 label="Column1"  及 Column1
                    h('span', column.label),
                ],
            )
        },
        selectColumn1(val, column) {
            //改变 Column1CheckAll 变量值 同时对表格进行 初始化 重新赋值
            this.Column1CheckAll = val;
            this.initTableData();
        },
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
