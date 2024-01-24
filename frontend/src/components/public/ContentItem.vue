<template>
    <div class="item-box">
        <el-icon><ArrowRight /></el-icon>
        <p v-for="lecturer in props.content.lecturers">{{ lecturer.name_zn }}&nbsp;&nbsp;</p>
        <div class="vertical-line"></div>
        <p>&nbsp;&nbsp;{{ props.content.title_zn }}</p>
    </div>
</template>

<script setup>
const props = defineProps({
    content: Object,
});

// "courselist": [
//     {
//         "_id": 1,
//         "title_en": "Patent data and technological innovation",
//         "title_zn": "专利数据与科技创新",
//         "title_de": null,
//         "url_en": "https://inovation-behavior-1316860845.cos.ap-shanghai.myqcloud.com/intelligence/course/1Patent%20data%20and%20technological%20innovation.docx",
//         "url_zn": "https://inovation-behavior-1316860845.cos.ap-shanghai.myqcloud.com/intelligence/course/1%E4%B8%93%E5%88%A9%E6%95%B0%E6%8D%AE%E4%B8%8E%E7%A7%91%E6%8A%80%E5%88%9B%E6%96%B0.docx",
//         "url_de": null,
//         "lecturers": [
//             {
//                 "_id": 1,
//                 "name_en": "Liu Xia",
//                 "name_zn": "刘夏",
//                 "name_de": "Liu Xia",
//                 "course_id": 1
//             }
//         ]
//     }
// ],
//     "count": 2

</script>

<style lang="scss" scoped>
.item-box{
    width: 100%;
    height: auto;
    display: flex;
    align-items: center;
    gap:10px;
    // border: 1px solid black;
}
.vertical-line {
  height: 10px; /* 竖线的高度 */
  width: 2px; /* 竖线的宽度 */
  background-color: rgba(0, 0, 0, 0.342); /* 竖线的颜色 */
}
</style>