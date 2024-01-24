<template>
    <div class="whole-box">
        <vue-office-docx :src="docx" style="height: 80vh; max-width: 1200px;" @rendered="renderedHandler" @error="errorHandler" />
    </div>
</template>

<script setup>
import { useRouter, useRoute } from 'vue-router';
import { ref, onMounted } from 'vue'
import axios from 'axios'
import { ElMessage } from 'element-plus'

const router = useRouter();
const route = useRoute()

//引入VueOfficeDocx组件
import VueOfficeDocx from '@vue-office/docx'
//引入相关样式
import '@vue-office/docx/lib/index.css'

let docx = ref('')


const _id = route.params._id;
let type = ref('')

onMounted(() => {
    const pathSegments = route.path.split('/');
    type.value = pathSegments[pathSegments.length - 2];
    getInfo()
    
})
const getInfo =async ()=>{
    const response = await axios.get('/api/intelligence/'+ type.value + '/'+ _id)
    // console.log(response)
    docx.value = response.data.data.url_zn
}
</script>

<style lang="scss" scoped>
.whole-box{
    margin-top: 20px;
    width: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

:deep(.docx-wrapper) {
    background-color: #fff;
    padding: 0;
}

:deep(.docx-wrapper > section.docx) {
    width: 100% !important;
    padding: 20px !important;
    min-height: auto !important;
    box-shadow: none;
    margin-bottom: 20px;
}
</style>