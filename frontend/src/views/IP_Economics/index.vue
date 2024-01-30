<template>
    <body>
        <div class="whole-box">
            <el-menu class="menu" default-active="1" @select="handleSelect">
                <el-menu-item index="1">{{ $t('economic.Top5List') }}</el-menu-item>
                <el-menu-item index="2">{{ $t('economic.Courses') }}</el-menu-item>
                <el-menu-item index="3">{{ $t('economic.IPBox') }}</el-menu-item>
                <el-menu-item index="4">{{ $t('economic.OpenPatentLicensing') }}</el-menu-item>
                <el-menu-item index="5">{{ $t('economic.PatentOpposition') }}</el-menu-item>
            </el-menu>
            <div class="content-box">
                <el-dropdown class="menu-flex" trgger="hover" @command="handleSelect" style="border: none;box-shadow: none;">
                    <span>
                        {{ $t(ChosedItem) }}
                        <el-icon>
                        <arrow-down />
                    </el-icon>
                    </span>
                    <template #dropdown>
                        <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item command="1">{{ $t('economic.Top5List') }}</el-dropdown-item>
                            <el-dropdown-item command="2">{{ $t('economic.Courses') }}</el-dropdown-item>
                            <el-dropdown-item command="3">{{ $t('economic.IPBox') }}</el-dropdown-item>
                            <el-dropdown-item command="4">{{ $t('economic.OpenPatentLicensing') }}</el-dropdown-item>
                            <el-dropdown-item command="5">{{ $t('economic.PatentOpposition') }}</el-dropdown-item>
                        </el-dropdown-menu>
                    </template>
                </el-dropdown>
                <!-- <div style="margin-bottom: 20px;margin-left:8px">
                {{ $t(ChosedItem) }}
            </div> -->
                <div class="list-box">
                    <div v-if="ChosedItem!='economic.Courses' && ChosedItem != 'economic.Top5List' ">
                        <div v-for="content in contentList" :key="content">
                            <ArticleItem :content="content" @click="contentInfo(content._id)"></ArticleItem>
                        </div>
                    </div>
                    <div v-else>
                        <div v-for="content in contentList" :key="content">
                            <ContentItem :content="content" @click="contentInfo(content._id)"></ContentItem>
                        </div>
                    </div>
                    <div style="display: flex;justify-content: center;align-items: flex-end;  margin: 20px;">
                        <el-pagination @current-change="handleCurrentChange" background layout="prev, pager, next"
                            :total=totalElements :current-page="store.chosedPage" />
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
import ArticleItem from '../../components/Economic/ArticleItem.vue'
import ContentItem from '../../components/public/ContentItem.vue';
import { useGeneralStore } from '../../stores/general.js'
import { ElMessage } from 'element-plus'
const store = useGeneralStore()
const menuList = [
    'economic.Top5List',
    'economic.Courses',
    'economic.IPBox',
    'economic.OpenPatentLicensing',
    'economic.PatentOpposition'
]
const typeList = [
    'Top 5 List',
    'economic', //为避免与Intelligence冲突
    'IP Box',
    'Open Patent Licensing',
    'Patent Opposition'
]
const urlList = [
    'courses',
    'courses',
    'articles',
    'articles',
    'articles'
]
const BaseUrl = '/api/economic'
let contentList = ref([])
let totalElements = ref(contentList.value.length)
let ChosedItem = ref(menuList[0])
const pagesize = 10
onMounted(() => {
    store.chosedPage = 1
    getContentList(menuList.indexOf(ChosedItem.value))
})
//处理换页
const handleCurrentChange = async (newPage) => {
    store.chosedPage = newPage
    getContentList(menuList.indexOf(ChosedItem.value))
}
//跳转详情页
const contentInfo = (_id) => {
    console.log(`/economic/${urlList[menuList.indexOf(ChosedItem.value)]}/${_id}`)
    router.push({
        path: `/economic/${urlList[menuList.indexOf(ChosedItem.value)]}/${_id}`
    })
}
//获取内容
const getContentList = async (index) => {
    contentList.value = []
    console.log('index:', index, '  urlList[index]:', urlList[index])
    const url = `${BaseUrl}/${urlList[index]}?page=${store.chosedPage}&size=${pagesize}&type=${typeList[index]}`
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
    getContentList(menuList.indexOf(ChosedItem.value))
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
    justify-content: center;
    align-items: center;
    flex-direction: column;
    padding-left: 30px;
}

.list-box {
    width: 100%;
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
    width: 250px;
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

.menu-flex {
    display: none;
}

/* 响应式设计调整 */
@media(max-width: 720px) {
    .el-menu-item {
        font-size: medium;
    }

    .menu {
        display: none;
        width: 100%;
        border-right: none;
    }

    .menu-flex {
        // border: 1px solid black;
        // width: 100%;
        margin-bottom: 10px;
        display: flex;
        background-color: #ffffff00;
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