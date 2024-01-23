<template>
    <el-header style="display: flex; height: 180px;width: 100%;">
        <div class="nav-container">
            <div class="nav-logo">
                <img style="width: 250px" src="../public/img/logo.png">
                <!-- <p>占个logo位</p> -->
            </div>
            <div class="nav-box">
                <div class="nav-search">
                    <!-- <div class="search-box"> -->
                        <el-input style="max-width: 200px;" v-model="store.searchQuery" :prefix-icon="Search" @keyup.enter="handleSearch">
                        </el-input>
                    <!-- </div> -->

                    <el-dropdown trgger="hover" @command="handleLanguageChange" style="border: none;box-shadow: none;">
                        <span class="el-dropdown-link">
                            {{ $t('language') }}<i class="el-icon-arrow-down el-icon--right"></i>
                        </span>
                        <template #dropdown>
                            <el-dropdown-menu slot="dropdown">
                                <el-dropdown-item command="en">{{ $t('topnav.English') }}</el-dropdown-item>
                                <el-dropdown-item command="zn">{{ $t('topnav.Chinese') }}</el-dropdown-item>
                                <el-dropdown-item command="de">{{ $t('topnav.German') }}</el-dropdown-item>
                            </el-dropdown-menu>
                        </template>
                    </el-dropdown>
                </div>
                <div class="nav-menu">
                    <el-menu mode="horizontal" :ellipsis="false">
                        <el-menu-item index="1" @click="redirectToPlatform" :class="{ 'blue-text': menutextcolor === 1 }">{{
                            $t('topnav.OpenLicensingPlatform') }}</el-menu-item>
                        <el-menu-item index="2" @click="redirectToNews" :class="{ 'blue-text': menutextcolor === 2 }">{{
                            $t('topnav.News') }}</el-menu-item>
                        <el-menu-item index="3" @click="redirectToEconomics"
                            :class="{ 'blue-text': menutextcolor === 3 }">{{
                                $t('topnav.IP_Economics') }}</el-menu-item>
                        <el-menu-item index="4" @click="redirectToIntelligence"
                            :class="{ 'blue-text': menutextcolor === 4 }">{{
                                $t('topnav.IP_Intelligence') }}</el-menu-item>
                        <el-menu-item index="5" @click="redirectToSurvey" :class="{ 'blue-text': menutextcolor === 5 }">{{
                            $t('topnav.Patent_Value_Survey') }}</el-menu-item>
                        <el-menu-item index="6" @click="redirectToTeam" :class="{ 'blue-text': menutextcolor === 6 }">{{
                            $t('topnav.Team') }}</el-menu-item>
                    </el-menu>
                </div>
            </div>
        </div>
    </el-header>
</template>
    
  
<script setup>
import { ref, computed, getCurrentInstance } from 'vue'
import { useRouter } from 'vue-router'
import { useGeneralStore } from '../stores/general.js'
import { Search } from '@element-plus/icons-vue'

const store = useGeneralStore()
const router = useRouter()

//切换语言
let { ctx } = getCurrentInstance()
const handleLanguageChange = (language) => {
    ctx.$i18n.locale = language;
}

const handleSearch = () => {
    // 执行搜索逻辑
    console.log('Searching for:', store.searchQuery)
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
.nav-logo {
    display: flex;
}

.nav-container {
    width: 100%;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding-top: 20px;
    width: 100%;
    background-color: #fff;
}

.nav-box {
    width: 100%;
    display: flex;
    flex-direction: column;
    gap: 10px;
    align-items: flex-end;
    /* justify-content: center; */
    /* border: 1px solid #000; */
}

.nav-menu {
    /* border: 1px solid #000; */
    /* width: 100%; */
    display: flex;
    align-items: center;
}

.nav-search {
    /* width: 100%; */
    /* border-left: 1px solid #f3f3f3; */
    display: flex;
    justify-content: end;
    align-items: center;
}

.el-dropdown-link {
    cursor: pointer;
    display: flex;
    align-items: center;
    word-wrap: nowrap;
    margin-left: 5px;
    text-wrap: nowrap;
    padding: 5px 10px;
    color: #449cf4f9;
    border-radius: 4px;
    background-color: #f9f9f9;
    transition: background-color 0.3s, border-color 0.3s;
}

.el-dropdown-link:hover {
    background-color: #e6e6e6;
    /* 鼠标悬浮时的背景色 */
    border-color: #b3b3b3;
    /* 鼠标悬浮时的边框色 */
}



@media (max-width: 1060px) {
    .nav-logo {
        display: block;
        /* 在小屏幕上显示logo */
        width: 100%;
        /* 调整宽度 */
        justify-content: center;
        /* 居中对齐 */
    }

    .nav-container {
        flex-direction: column;
        /* 将导航容器设置为垂直布局 */
    }

    .nav-box {
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .nav-search,
    .nav-menu 
    .el-menu{
        width: 100%;
        /* border: 1px solid black; */
        justify-content: center;
        /* 调整搜索框和菜单的宽度 */
    }
    .el-menu-item {
        font-size: 10px;
        padding: 10px;
    }
}
</style>
    