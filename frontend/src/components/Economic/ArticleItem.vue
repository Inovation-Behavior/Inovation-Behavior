<template>
    <div class="item-box">
        <el-icon><ArrowRight /></el-icon>
        <p style="white-space: nowrap;" v-for="author in authors">{{ author }}&nbsp;&nbsp;</p>
        <div v-if="authors.length > 0" class="vertical-line"><p>&nbsp;&nbsp;</p></div>
        <p>{{ title }}</p>
    </div>
</template>

<script setup>
import {ref, onMounted,getCurrentInstance,watch} from 'vue'
import { useGeneralStore } from '../../stores/general';
const store = useGeneralStore()
let { ctx } = getCurrentInstance()
let authors = ref([])
const props = defineProps({
    content: Object,
});

let title = ref('')
watch(() => store.changeLanguage, () => {
    updateContent(ctx.$i18n.locale);
});

const updateContent = (locale) => {
    authors.value = [];
    if (locale === 'en') {
        props.content.authors.forEach(lecturer => authors.value.push(lecturer.name_en));
        title.value = props.content.title_en;
    } else if (locale === 'zn') {
        props.content.authors.forEach(lecturer => authors.value.push(lecturer.name_zn));
        title.value = props.content.title_zn;
    } else if (locale === 'de') {
        props.content.authors.forEach(lecturer => authors.value.push(lecturer.name_de));
        title.value = props.content.title_de;
    }
};

onMounted(() =>{
    authors.value = []
    title.value = ''
    updateContent(ctx.$i18n.locale);
})
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
@media (max-width: 720px) {
    body, p {
        font-size: 12px;
    }
}
</style>