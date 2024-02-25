<template>
    <el-container
        style="display: flex;justify-content: center;align-items: center; font-size: large;font-weight: bolder;margin-top: 2vh; width: 100%; overflow: auto;">
        Open Patent and Innovation Survey: Shanghai     
    </el-container>
    <el-container style="margin-top: 10px;margin-right: 5px; width: 100%;">
        <el-tabs style="width: 100%;" v-model="activeName" tab-position="top" class="demo-tabs" @tab-click="handleClick"
            type="card" stretch="true">
            <el-tab-pane label="Introduction" name="Introduction">
                <introduction/>
            </el-tab-pane>
            <el-tab-pane label="A-Respondent Identification" name="A-Respondent Identification">
                <identification :patent-no="patentNo"/>
            </el-tab-pane>
            <el-tab-pane label="B-Value of the Patent/Patented Technology" name="B-Value of the Patent/Patented Technology">
                <value-vue/>
            </el-tab-pane>
            <el-tab-pane label="C-Evaluate the IP and Innovation Environment" name="C-Evaluate the IP and Innovation Environment">
                <evaluate-vue/>
            </el-tab-pane>
        </el-tabs>
    </el-container>
</template>

<script>
import EvaluateVue from '../../components/Survey/Evaluate.vue'
import Identification from '../../components/Survey/Identification.vue'
import Introduction from '../../components/Survey/Introduction.vue'
import ValueVue from '../../components/Survey/Value.vue'
export default {
    components: {
        Identification,
        Introduction,
        ValueVue,
        EvaluateVue,
    },
    data() {
        return {
            activeName: "Introduction",
            patentNo:"",
        }
    },
    methods: {

    }
}
</script>

<style scoped>
.demo-tabs>.el-tabs__content {
    padding: 32px;
    color: #6b778c;
    font-size: 32px;
    font-weight: 600;

}


/* Style for portrait mode */
@media screen and (orientation: portrait) {}
</style>