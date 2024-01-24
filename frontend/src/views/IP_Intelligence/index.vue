<template>
    <!-- <body> -->
    <div class="whole-box">
        <el-menu class="menu" @select="handleSelect">
            <el-menu-item index="1">{{ $t('intelligence.course') }}</el-menu-item>
            <el-menu-item index="2">{{ $t('intelligence.PatentPledge') }}</el-menu-item>
            <el-menu-item index="3">{{ $t('intelligence.TOP2500RD') }}</el-menu-item>
        </el-menu>
        <div class="content-box">
            <div>
                {{ $t(ChosedItem) }}
            </div>
            <div class="list-box">
                <div v-for="content in contentList" :key="content">
                    <ContentItem :content="content" @click="contentInfo(content._id)"></ContentItem>
                </div>
            </div>
        </div>
    </div>
    <!-- </body> -->
    <!-- <vue-office-docx :src="docx" style="height: 100vh;" @rendered="renderedHandler" @error="errorHandler" /> -->
</template>

<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'
import { useRouter } from 'vue-router'
const router = useRouter()
import ContentItem from '../../components/public/ContentItem.vue'
const menuList = [
    'intelligence.course',
    'intelligence.PatentPledge',
    'intelligence.TOP2500RD'
]
const urllist = [
    'courses',
    'patentpledge',
    'top2500RD'
]
const BaseUrl = '/api/intelligence'
let contentList = ref([])
let ChosedItem = ref(menuList[0])
let page = ref(1)
const pagesize = 10
onMounted(() => {
    // console.log(menuList.indexOf(ChosedItem.value))
    getContentList(urllist[menuList.indexOf(ChosedItem.value)])
})
const contentInfo = (_id) =>{
    router.push({
        path: `/intelligence/${urllist[menuList.indexOf(ChosedItem.value)]}/${_id}`
    })
}
const getContentList =async (source) => {
    const url = `${BaseUrl}/${source}?page=${page.value}&size=${pagesize}`
    let response =await axios.get(url)
    console.log(response)
    if (response.status == 200) {
        console.log(response.data.data)
        contentList.value = response.data.data.courselist
        console.log(contentList.value)
    }
}
const handleSelect = (index) => {
    ChosedItem.value = menuList[index - 1]

}
const renderedHandler = () => {
    console.log("渲染完成")
}
const errorHandler = () => {
    console.log("渲染失败")
}
</script>

<style lang="scss" scoped>
body {
    // background-color: #f3f3f3;
    margin-top: 10px;
    display: flex;
    justify-content: center;
    align-items: center;
    // border: 1px solid #000;
}

.whole-box {
    width: 100%;
    display: flex;
    justify-content: center;
    // border: 1px solid #000;
}

.content-box {
    width: 100%;
    max-width: 1200px;
    display: flex;
    flex-direction: column;
}

.list-box {
    width: 100%;
    display: flex;
    flex-direction: column;
}

.menu {
    width: 200px;
    border: none;
}

.el-menu-item {
    font-size: large;
}

@media(max-width: 720px) {
    .el-menu-item {
        font-size: medium;
    }

    .menu {
        display: flex;
    }

    .whole-box {
        display: flex;
        flex-direction: column;
    }
}
</style>