<template>
    <el-card>
        <h3 style="font-family: arial;">{{ news.titleEn }}</h3>
        <el-container style="font-family: arial;"><div v-html="news.containsEn"></div></el-container>
        <h4>{{ news.time }}</h4>
    </el-card>
</template>

<script>
import axios from 'axios'
export default {
    data() {
        return {
            news:{},
        }
    },
    methods: {
        async init(){
            this.getDetail();
        },
        async getDetail(){
            let response = await axios.get('api/news/singleNews/' + this.$route.params.id);
            console.log(response)
            if (response.status == 200) {
                this.news=response.data.data
            }
        }
    },
    mounted(){
        this.init()
    },
    computed: {

    },
}
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