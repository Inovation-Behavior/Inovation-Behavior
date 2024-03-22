<template>
    <el-container
        style="display: flex;justify-content: center;align-items: center; font-size: large;font-weight: bolder;margin-top: 2vh; width: 100%; overflow: auto;">
        Open Patent and Innovation Survey: Shanghai
    </el-container>
    <el-container style="margin-top: 10px;margin-right: 5px; width: 100%;">
        <el-tabs style="width: 100%;" v-model="activeName" tab-position="top" class="demo-tabs" @tab-click="handleClick"
            type="card" stretch="true">
            <el-tab-pane label="Introduction" name="Introduction">
                <introduction />
            </el-tab-pane>
            <el-tab-pane label="A. 个人基本信息" name="A. 个人基本信息">
                <part-a />
            </el-tab-pane>
            <el-tab-pane label="B. 企业研发与知识产权管理" name="B. 企业研发与知识产权管理">
                <part-b />
            </el-tab-pane>
            <el-tab-pane label="C. 专利技术价值" name="C. 专利技术价值">
                <part-c/>
            </el-tab-pane>
            <el-tab-pane label="D. 专利的许可运用" name="D. 专利的许可运用">
                <part-d/>
            </el-tab-pane>
            <el-tab-pane label="E. 知识产权政策" name="E. 知识产权政策">
                <part-e/>
            </el-tab-pane>
        </el-tabs>
    </el-container>
</template>

<script>
import partA from '../../components/Survey/enterprise/partA.vue'
import partB from '../../components/Survey/enterprise/partB.vue'
import partC from '../../components/Survey/enterprise/partC.vue'
import partD from '../../components/Survey/enterprise/partD.vue'
import partE from '../../components/Survey/enterprise/partE.vue'
export default {
    components: {
        partA,
        partB,
        partC,
        partD,
        partE,
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