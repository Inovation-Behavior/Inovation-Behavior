<template>
    <el-card>
        <h3 style="font-family: arial;">{{ title }}</h3>
        <el-container style="font-family: arial;"><div v-html="contains"></div></el-container>
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
        let title = ref("");
        let contains = ref("");
        const route = useRoute()
        let { ctx } = getCurrentInstance()

        const getDetail = async () => {
            try {
                const response = await axios.get('api/news/singleNews/' + route.params.id);
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
                title.value = news.value.titleZn;
                contains.value = news.value.containsZn;
            } else if (ctx.$i18n.locale == 'en') {
                title.value = news.value.titleEn;
                contains.value = news.value.containsEn;
            } else if (ctx.$i18n.locale == 'de') {
                title.value = news.value.titleDn;
                contains.value = news.value.containsDn;
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
            title,
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