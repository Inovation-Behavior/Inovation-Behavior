<template>
    <el-card>
        <!-- <h3 style="font-family: arial;">{{ url }}</h3>
        <el-container style="font-family: arial;"><div v-html="contains"></div></el-container> -->
        <vue-office-docx :src="news.url" style="height: 85vh; max-width: 1200px;overflow:auto" @rendered="renderedHandler"
            @error="errorHandler" />
        <h4>{{ news.time }}</h4>
    </el-card>
</template>

<script>
import { useRouter, useRoute } from 'vue-router';
import { ref, onMounted, getCurrentInstance, watch } from 'vue'
import axios from 'axios';
import { useGeneralStore } from '../../stores/general';

export default {
    setup() {
        const store = useGeneralStore();
        let news = ref({});
        let url = ref("");
        const route = useRoute()
        let { ctx } = getCurrentInstance()

        const getDetail = async () => {
            try {
                const response = await axios.get('api/ibnews/singleNews/' + route.params.id);
                if (response.status === 200) {
                    news.value = response.data.data;
                    updateLanguageValues();
                }
            } catch (error) {
                console.error('Error fetching news details:', error);
            }
        };

        const updateLanguageValues = () => {
            if (ctx.$i18n.locale == 'zn') {
                url.value = news.value.urlZn;
            } else if (ctx.$i18n.locale == 'en') {
                url.value = news.value.urlEn;
            } else if (ctx.$i18n.locale == 'de') {
                url.value = news.value.urlDn;
            }
        };

        onMounted(() => {
            getDetail();
        });

        watch(() => store.changeLanguage, () => {
            console.log("Language changed");
            updateLanguageValues();
        });

        return {
            news,
            url,
            contains,
        };
    },
};
</script>

<style lang="scss" scoped>
.set-vertical {
    display: flex;
    flex-direction: column;
}

.set-horizonal {
    display: flex;
    flex-direction: row;
}

.el-carousel__item h3 {
    display: flex;
    opacity: 0.75;
    margin: 0;
}

.news-item {
    width: 95vw;
    box-sizing: border-box;
    border: 1px solid #ddd;
    margin-top: 2vh;
    height: 25vh;
}

.news-item:hover {
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    /* 悬浮时的阴影效果 */
}</style>