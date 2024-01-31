<template>
    <div class="set-vertical">
        <el-container>
            <el-carousel style="width: 95vw;" indicator-position="outside">
                <el-carousel-item class="set-vertical" style="cursor: pointer;" v-for="item in news" :key="item">
                    <el-container style="height: 20vh;background-color: #99a9bf;" @click="getNewsDetail(item.id)">
                        <img src="../../public/img/newsImg.jpg" style="width: 100%; height: 100%; object-fit: cover;">
                    </el-container>
                    <el-card style="margin-top: 0;margin-bottom: 1vh;" @click="getNewsDetail(item.id)">
                        <h5 style="font-family: arial;">{{item.titleEn}}</h5>
                    </el-card>
                </el-carousel-item>
            </el-carousel>
        </el-container>
        <el-container style="margin-top: 5vh;" class="set-vertical">
            <div v-for="item in news" :key="item.id" class="news-item set-horizonal" style="border-radius: 20px;cursor: pointer;" @click="getNewsDetail(item.id)">
                <el-container style="width: 30vw;background-color:#99a9bf; ;">
                    <img src="../../public/img/newsImg.jpg" style="width: 100%; height: 100%; object-fit: cover;">
                </el-container>
                <el-card style="width: 70vw;">
                    <h5 style="font-family: arial;">{{ item.titleEn }}</h5>
                    <p>{{ item.time }}</p>
                </el-card>    
            </div>
        </el-container>
    </div>
</template>

<script>
import axios from 'axios'
export default {
    data() {
        return {
            news: [],
        }
    },
    methods: {
        getNewsDetail(id){
            this.$router.push({
                path: `/news/${id}`
            })
        },
        async init() {
            this.getNews();
        },
        async getNews() {
            let response = await axios.get('api/news');
            console.log(response)
            if (response.status == 200) {
                this.news = response.data.data
            }
        }
    },
    mounted(){
        this.init();
    },
    computed: {
    
    },
}
</script>

<style lang="scss" scoped>
.set-vertical{
    display: flex;
    flex-direction: column;
}
.set-horizonal{
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
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* 悬浮时的阴影效果 */
}
</style>