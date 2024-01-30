<template>
    <el-container
        style="display: flex;justify-content: center;align-items: center; font-size: large;font-weight: bolder;margin-top: 2vh; width: 100%; overflow: auto;">Patent
        Value Survey (2024, Shanghai)</el-container>
    <el-container style="margin-top: 10px;margin-right: 5px; width: 100%;">
        <el-tabs style="width: 100%;" v-model="activeName" tab-position="top" class="demo-tabs" @tab-click="handleClick"
            type="card" stretch="true">
            <el-tab-pane :label="$t('survey.RespondentsIdentification')" name="identify">
                <identify-vue />
            </el-tab-pane>
            <el-tab-pane :label="$t('survey.BusinessActivities')" name="activity">
                <activity-vue />
            </el-tab-pane>
            <el-tab-pane :label="$t('survey.PatentedTechnology')" name="technique">
                <technique-vue />
            </el-tab-pane>
            <el-tab-pane :label="$t('survey.PatentStrategy')" name="strategy">
                <strategy-vue />
            </el-tab-pane>
        </el-tabs>
    </el-container>
</template>

<script>
import IdentifyVue from '../../components/Survey/Identify.vue'
import activityVue from '../../components/Survey/activity.vue'
import strategyVue from '../../components/Survey/strategy.vue'
import techniqueVue from '../../components/Survey/technique.vue'
export default {
    components: {
        IdentifyVue,
        activityVue,
        techniqueVue,
        strategyVue,
    },
    data() {
        return {
            activeName: "identify",
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