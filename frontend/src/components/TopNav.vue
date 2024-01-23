<template>
    <el-header style="display: flex;">
        <div class="nav-container">
            <div style="display: flex;width: 40%;">
                <img style="width: 50%;" src="../public/img/logo.png">
                <p>占个logo位</p>
            </div>
            <div class="nav-left">
                <el-menu mode="horizontal" :ellipsis="false">
                    <el-menu-item index="1" @click="redirectToPlatform" :class="{ 'blue-text': menutextcolor === 1 }">{{
                        $t('OpenLicensingPlatform') }}</el-menu-item>
                    <el-menu-item index="2" @click="redirectToNews" :class="{ 'blue-text': menutextcolor === 2 }">{{
                        $t('News') }}</el-menu-item>
                    <el-menu-item index="3" @click="redirectToEconomics" :class="{ 'blue-text': menutextcolor === 3 }">{{
                        $t('IP_Economics') }}</el-menu-item>
                    <el-menu-item index="4" @click="redirectToIntelligence" :class="{ 'blue-text': menutextcolor === 4 }">{{
                        $t('IP_Intelligence') }}</el-menu-item>
                    <el-menu-item index="5" @click="redirectToSurvey" :class="{ 'blue-text': menutextcolor === 5 }">{{
                        $t('Patent_Value_Survey') }}</el-menu-item>
                    <el-menu-item index="6" @click="redirectToTeam" :class="{ 'blue-text': menutextcolor === 6 }">{{
                        $t('Team') }}</el-menu-item>
                </el-menu>
            </div>
        </div>
        <div class="nav-right">
            <el-dropdown trgger="hover" @command="handleLanguageChange" style="border: none;box-shadow: none;">
                <span class="el-dropdown-link">
                    {{ $t('language') }}<i class="el-icon-arrow-down el-icon--right"></i>
                </span>
                <template #dropdown>
                    <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item command="en">{{ $t('English') }}</el-dropdown-item>
                        <el-dropdown-item command="zn">{{ $t('Chinese') }}</el-dropdown-item>
                        <el-dropdown-item command="de">{{ $t('German') }}</el-dropdown-item>
                    </el-dropdown-menu>
                </template>
            </el-dropdown>
        </div>
    </el-header>
</template>
    
  
<script setup>
import { ref, computed, getCurrentInstance } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()

let { ctx } = getCurrentInstance()
const handleLanguageChange = (language) => {
    ctx.$i18n.locale = language;
}


const menutextcolor = computed(() => {
    const path = router.currentRoute.value.path;
    switch (path) {
        case '/News': return 2;
        case '/forum': return 3;
        case '/IM': return 4;
        case '/Games': return 5;
        case '/Players': return 6;
        case '/Team': return 7;
        default: return 0;
    }
})

const redirectToPlatform = () => {
    router.push('/');
}
const redirectToNews = () => {
    router.push('/news');
}
const redirectToEconomics = () => {
    router.push('/economics');
}
const redirectToIntelligence = () => {
    router.push('/intelligence');
}
const redirectToSurvey = () => {
    router.push('/survey');
}
const redirectToTeam = () => {
    router.push('/team');
}

</script>

<style scoped>
.nav-container {
    display: flex;
    justify-content: space-between;
    align-items: center;
    width: 100%;
    background-color: #fff;
}

.nav-left {
    display: flex;
    align-items: center;
}

.nav-right {
    border-left: 1px solid #f3f3f3;
    display: flex;
    align-items: center;
}

.el-dropdown-link {
    cursor: pointer;
    display: flex;
    align-items: center;
    word-wrap: nowrap;
    margin-left: 5px;
    text-wrap: nowrap;
    padding: 5px 10px; /* 添加内边距以增加可点击区域 */
    border: 1px solid #ccc; /* 添加边框 */
    border-radius: 4px; /* 圆角边框 */
    background-color: #f9f9f9; /* 背景色 */
    transition: background-color 0.3s, border-color 0.3s; /* 过渡效果 */
}

.el-dropdown-link:hover {
    background-color: #e6e6e6; /* 鼠标悬浮时的背景色 */
    border-color: #b3b3b3; /* 鼠标悬浮时的边框色 */
}

</style>
    