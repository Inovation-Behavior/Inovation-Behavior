<template>
    <body>
        <div class="content-box">
            <el-menu class="el-menu-vertical-demo menu">
                <el-menu-item index="1">{{ $t('intelligence.course') }}</el-menu-item>
                <el-menu-item index="2">{{ $t('intelligence.PatentPledge') }}</el-menu-item>
                <el-menu-item index="3">{{ $t('intelligence.Top 2500 R&D') }}</el-menu-item>
            </el-menu>
        </div>
    </body>
</template>

<script setup>

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

.content-box{
    width: 100%;
    max-width: 1200px;
    // border: 1px solid #000;
}
.menu {
    width: 200px;
    // border: 1px solid #000;
}

</style>