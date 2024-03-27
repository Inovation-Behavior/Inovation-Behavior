<template>
    <el-container
        style="font-family:SimHei;font-size: 2rem;font-weight: bolder;display: flex;justify-content: center;align-items: center; margin-top: 2vh; width: 100%; overflow: auto;margin-bottom: 2vh;">
        开放专利与创新调查：上海2024
    </el-container>
    <el-dialog center :close-on-click-modal="false" :close-on-press-escape="false"
        style="font-family: SimSun;width: 40vw;align-items: center;justify-content: center;" title="欢迎参加问卷调研，请输入邀请码"
        v-model="dialogVisible" :before-close="handleClose">
        <el-card style="gap: 6px;border: none;align-items: center;justify-content: center;display: flex;"
            shadow="never">
            <el-container style="font-family: KaiTi">请填入预先告知您的邀请码，或询问工作人员</el-container>
            <el-input v-model="invitationCode" style="width: 15vw;margin-top: 2vh;" placeholder="请输入邀请码"></el-input>
            <el-container>
                <span slot="footer" style="margin-top: 2vh;">
                    <el-button type="primary" @click="checkInvitationCode">确认</el-button>
                </span>
            </el-container>
        </el-card>
    </el-dialog>
    <el-container style="margin-top: 10px;margin-right: 5px; width: 100%;">
        <el-tabs style="width: 100%;" v-model="activeName" tab-position="top" class="demo-tabs" @tab-click="handleClick"
            type="card" stretch="true">
            <el-tab-pane label="项目介绍" name="项目介绍">
                <introduction />
            </el-tab-pane>
            <el-tab-pane label="A. 个人基本信息" name="A. 个人基本信息">
                <part-a />
            </el-tab-pane>
            <el-tab-pane label="B. 企业研发与知识产权管理" name="B. 企业研发与知识产权管理">
                <part-b />
            </el-tab-pane>
            <el-tab-pane label="C. 专利技术价值" name="C. 专利技术价值">
                <part-c />
            </el-tab-pane>
            <el-tab-pane label="D. 专利的许可运用" name="D. 专利的许可运用">
                <part-d />
            </el-tab-pane>
            <el-tab-pane label="E. 知识产权政策" name="E. 知识产权政策">
                <part-e />
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
import introduction from '../../components/Survey/enterprise/Introduction.vue'
import { Text } from 'vue'
export default {
    components: {
        partA,
        partB,
        partC,
        partD,
        partE,
        introduction
    },
    data() {
        return {
            activeName: "项目介绍",
            patentNo:"",
            dialogVisible: false, // 控制对话框显示的属性
            invitationCode: '' // 存储输入的邀请码
        }
    },
    mounted() {
        this.dialogVisible = true;
    },
    methods: {
        handleClose(done) {
            // 可以在这里添加关闭对话框前的操作，比如确认用户是否真的想关闭对话框
            done(); // 这会实际关闭对话框
        },
        checkInvitationCode() {
            // 这里实现邀请码的检查逻辑
            if (this.invitationCode === '043398') {
                this.dialogVisible = false; // 如果邀请码正确，关闭对话框
            } else {
                // 如果邀请码错误，给出提示，不关闭对话框
                this.$message.error('邀请码错误，请重试');
            }
        }
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