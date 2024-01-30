<template>
    <body>
        <div class="whole-box">
            <el-menu class="menu" default-active="1" @select="handleSelect">
                <el-menu-item index="1">{{ $t('intelligence.course') }}</el-menu-item>
                <el-menu-item index="2">{{ $t('intelligence.PatentPledge') }}</el-menu-item>
                <el-menu-item index="3">{{ $t('intelligence.TOP2500RD') }}</el-menu-item>
            </el-menu>
            <div class="content-box">
                <!-- <div style="margin-bottom: 20px;margin-left:8px">
                {{ $t(ChosedItem) }}
            </div> -->
                <div class="list-box">
                    <div class="item-box">
                        <div v-for="content in contentList" :key="content">
                            <ContentItem :content="content" @click="contentInfo(content._id)"></ContentItem>
                        </div>
                    </div>
                    <div style="display: flex;justify-content: center;align-items: flex-end;  margin: 20px;">
                        <el-pagination @current-change="handleCurrentChange" background layout="prev, pager, next"
                            :total=totalElements :current-page="intelligenceStore.chosedPage" />
                    </div>
                </div>
            </div>
        </div>
    </body>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'
import { useRouter } from 'vue-router'
const router = useRouter()
import ContentItem from '../../components/public/ContentItem.vue'
import { useIntelligenceStore } from '../../stores/Intelligence.js'
import { ElMessage } from 'element-plus'
const intelligenceStore = useIntelligenceStore()
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
let totalElements = ref(contentList.value.length)
let ChosedItem = ref(menuList[0])
const pagesize = 10
onMounted(() => {
    intelligenceStore.chosedPage = 1
    getContentList(urllist[menuList.indexOf(ChosedItem.value)])
})
//处理换页
const handleCurrentChange = async (newPage) => {
    intelligenceStore.chosedPage = newPage
    getContentList(urllist[menuList.indexOf(ChosedItem.value)])
}
//跳转详情页
const contentInfo = (_id) => {
    router.push({
        path: `/intelligence/${urllist[menuList.indexOf(ChosedItem.value)]}/${_id}`
    })
}
//获取内容
const getContentList = async (source) => {
    contentList.value = []
    const url = `${BaseUrl}/${source}?page=${intelligenceStore.chosedPage}&size=${pagesize}`
    let response = await axios.get(url)
    console.log(response)
    if (response.status == 200) {
        console.log(response.data.data)
        contentList.value = response.data.data.lists
        totalElements.value = response.data.data.count
        console.log(contentList.value)
    }
}
const handleSelect = (index) => {
    ChosedItem.value = menuList[index - 1]
    getContentList(urllist[menuList.indexOf(ChosedItem.value)])
}
const renderedHandler = () => {
    console.log("渲染完成")
}
const errorHandler = () => {
    console.log("渲染失败")
}
</script>

<style lang="scss" scoped>
/* 在此处定义你的颜色方案 */
$primary-color: #4a90e2;
$secondary-color: #f3f3f3;
$text-color: #333;
$shadow-color: rgba(0, 0, 0, 0.1);

body {
    // background-color: $secondary-color;
    margin-top: 10px;
    display: flex;
    justify-content: center;
    align-items: center;
}

.whole-box {
    width: 100%;
    display: flex;
    max-width: 1400px;
    // justify-content: center;
    // box-shadow: 0 4px 8px $shadow-color;
    background-color: white;
    padding: 20px;
    // border-radius: 8px;
}

.content-box {
    width: 100%;
    max-width: 1400px;
    display: flex;
    flex-direction: column;
    // justify-content: center;
    // align-items: center;
    // border: 1px solid #000;
    padding-left: 30px;
}

.list-box {
    // border: 1px solid #000;
    // width: 80%;
    min-height: 80vh;
    display: flex;
    flex-direction: column;
    gap: 10px;

    // 添加 flex-grow 使内容部分填充空间
    >div:first-child {
        flex-grow: 1;
        overflow-y: auto; // 如果内容很多，可以滚动
    }

    // 分页器的容器
    >div:last-child {
        // 保持在底部
    }
}


.menu {
    width: 300px;
    // border-right: 1px solid $shadow-color;
}

.el-menu-item {
    font-size: large;
    color: $text-color;

    &:hover,
    &.is-active {
        background-color: $primary-color;
        color: white;
    }
}

/* 响应式设计调整 */
@media(max-width: 720px) {
    .el-menu-item {
        font-size: medium;
    }

    .menu {
        display: flex;
        width: 100%;
        border-right: none;
        margin-bottom: 10px;
    }

    .el-menu-item {
        /*width: 33%;*/
        /*border: 1px solid black;*/
        font-size: 14px;
    }

    .whole-box {
        flex-direction: column;
        padding: 5px;
    }

    .content-box {
        padding-left: 5px;
    }

}
</style>