<template>
    <el-carousel :interval="4000" height="400px" ref="carousel" @click.native="linkTo">
        <el-carousel-item v-for="item in imgs" :key="item.url" >
        <img :src="item.url" class="img_con"/>
        </el-carousel-item>
    </el-carousel>
</template>
<script>
export default {
     methods: {
        linkTo () {
            let activeIndex = this.$refs.carousel.activeIndex
            window.open(this.imgs[activeIndex].link,"_blank")
        }
    },
    data:function(){
        return{
            imgs:[
                {url:require('../assets/img/bilibili.jpg'),link:'https://space.bilibili.com/231824541'},
                {url:require('../assets/img/csdn.png'),link:'https://blog.csdn.net/weixin_43719616?spm=1001.2101.3001.5343'}
            ]
        }
    }
}
</script>
<style>
  .img_con{
        border-radius: 0px!important;
        width: 78%!important;
        height: 100%;
    }
  .el-carousel__item h3 {
    color: #475669;
    font-size: 18px;
    opacity: 0.75;
    line-height: 300px;
    margin: 0;
  }
  
  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }
  
  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }
</style>