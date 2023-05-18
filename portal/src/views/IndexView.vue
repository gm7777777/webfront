<template>

	<Layout>

		<div  style="width: 100%">
			<div class="SwiperBox" ref="SwiperBox" @mouseenter="MouseFun('移入')" @mouseleave="MouseFun('移出')">
				<!-- 图片 -->
				<div class="imgBox" :style="{left:`-${leftVal}px`,transition:`${ition}s`}">
					<img :src="item.imgUrl" v-for="(item,index) in imgList" :key="index" />
					<!-- 复制第一张放到最后,以实现无缝无线循环滚动效果 -->
					<img :src="imgList[0].imgUrl" alt="">
				</div>
				<!-- 左箭头按钮 -->
				<div class="leftBtn" @click="throttle(PrevFun)">&larr;</div>
				<!-- 右箭头按钮 -->
				<div class="rightBtn" @click="throttle(NextFun)">&rarr;</div>
				<!-- 下方指示点容器 -->
				<div class="instBox">
					<div @click="instFun(index)" v-for="(item,index) in imgList.length" :key="index"
						 :class="['inst',index==imgShow?'instActv':'']">
					</div>
				</div>
			</div>
			<!--<el-carousel :height="bannerHeight+'px'" style="margin: 0 auto; width: 100%; border-radius: 4px" indicator-position="outside">-->
				<!--<el-carousel-item v-for="i in imgs" :key="i">-->
					<!--<img :src="i" style="width: 100%" ref="bannerHeight" @load="imgLoad">-->
				<!--</el-carousel-item>-->
			<!--</el-carousel>-->
			<!--<div class="index-page">-->
				<!--<div data-am-widget="tabs" class="am-tabs am-tabs-default">-->
					<!--<div class="am-tabs-bd">-->
						<!--<div-->
							<!--class="am-tab-panel am-active"-->
							<!--v-if="slideshow.length > 0"-->
							<!--:style="{ backgroundImage: `url(${slideshow[tabIndex].imageUrl})`}">-->
							<!--<div class="index-banner">-->
								<!--<div class="index-mask">-->
									<!--<div class="container">-->
										<!--<div class="am-g">-->
											<!--<div class="am-u-md-10 am-u-sm-centered" style="text-align: center">-->
												<!--<h1 class="slide_simple&#45;&#45;title">企业移动化，首选云适配</h1>-->
												<!--<p class="slide_simple&#45;&#45;text am-text-left" style="display: flex;justify-content: center">-->
													<!--全球领先的HTML5企业移动化解决方案供应商，安全高效的帮助您的企业移动化。云适配企业浏览器Enterploer,让企业安全迈进移动办公时代！-->
												<!--</p>-->
											<!--</div>-->
										<!--</div>-->
									<!--</div>-->
								<!--</div>-->
							<!--</div>-->
						<!--</div>-->
					<!--</div>-->

					<!--<ul class="am-tabs-nav am-cf index-tab">-->
						<!--<li v-for="(tab,index) in tabList" :key="index" :class="tabIndex === index ? 'am-active':''" >-->
							<!--<a href="#" @click.prevent="changeTab(index)">-->
								<!--<div class="am-u-md-3 am-u-sm-3 am-padding-right-0">-->
									<!--<i :class="tab.icon"></i>-->
								<!--</div>-->
								<!--<div class="school-item-right am-u-md-9 am-u-sm-9 am-text-left">-->
									<!--<strong class="promo_slider_nav&#45;&#45;item_title">{{tab.name}}</strong>-->
									<!--<p class="promo_slider_nav&#45;&#45;item_description">{{tab.desc}}</p>-->
								<!--</div>-->
							<!--</a>-->
						<!--</li>-->
					<!--</ul>-->
				<!--</div>-->
			<!--</div>-->
			<!--<VideoSwiper/>-->

		</div>
		
		<div class="section">
			<div class="container" style="max-width: 1160px;">
				<div class="section--header">
					<h2 class="section--title">核心优势</h2>
					<p class="section--description">
						全球领先HTML5企业移动化解决方案供应商，由前微软美国总部IE浏览器核心研发团队成员及移动互联网行业专家在美国西雅图创立,获得了微软创投的扶持以及晨兴资本、IDG资本、天创资本等国际顶级风投机构的投资。
					</p>
				</div>
				
				<div class="index-container">
					<div class="am-g">
						<div class="am-u-md-3" v-for="(advantage,index) in advantageList" :key="index">
							<div class="features_item">
								<img :src="advantage.cover" alt="">
								<h3 class="features_item--title">{{advantage.title}}</h3>
								<p class="features_item--text">{{advantage.desc}}</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="section" style="border-bottom: 1px solid #e9e9e9; padding-top: 0">
			<div class="container" style="max-width: 1160px;">
				<div class="section--header">
					<h2 class="section--title">我们的服务</h2>
					<p class="section--description">
						全球领先HTML5企业移动化解决方案供应商，由前微软美国总部IE浏览器核心研发团队成员及移动互联网行业专家在美国西雅图创立
						<br>获得了微软创投的扶持以及晨兴资本、IDG资本、天创资本等国际顶级风投机构的投资。
					</p>
				</div>
				
				<div class="index-container">
					<div class="am-g">
						<div class="am-u-md-3" v-for="(service,index) in serviceList" :key="index">
							<div class="service_item">
								<i class="service_item--icon" :class="service.icon"></i>
								<h3 class="service_item--title">{{ service.title }}</h3>
								<div class="service_item--text"><p>{{service.desc}}</p></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</Layout>
</template>

<script>
import Layout from "@/components/common/Layout";
import VideoSwiper  from "@/components/videoswiper/VideoSwiper"
export default {
	name: "IndexView",
	components: {Layout},
	data(){
		return{
			tabList:[
				{name:'家用电梯', desc:'一句话概括特点', icon:'am-icon-cog'},
				{name:'别墅电梯', desc:'一句话概括特点', icon:'am-icon-lightbulb-o'},
				{name:'观光电梯', desc:'一句话概括特点', icon:'am-icon-line-chart'},
				{name:'关于我们', desc:'一句话概括特点', icon:'am-icon-hourglass-end'},
			],
			tabIndex: 0,
			slideshow:[],
			
			advantageList:[
				{id:1,cover:require('../assets/images/index/f01.jpg'),title:'简单的适配过程',desc:'用户可快速学习适配开发，通过丰富的组件库完成页面功能的移动化适配。'},
				{id:2,cover:require('../assets/images/index/f01.jpg'),title:'简单的适配过程',desc:'用户可快速学习适配开发，通过丰富的组件库完成页面功能的移动化适配。'},
				{id:3,cover:require('../assets/images/index/f01.jpg'),title:'简单的适配过程',desc:'用户可快速学习适配开发，通过丰富的组件库完成页面功能的移动化适配。'},
				{id:4,cover:require('../assets/images/index/f01.jpg'),title:'简单的适配过程',desc:'用户可快速学习适配开发，通过丰富的组件库完成页面功能的移动化适配。'},
			],
			serviceList:[
				{id:1,icon:'am-icon-diamond',title:'多页面工作',desc:'标签栏可切换，不必为了新内容而被迫跳转界面，多项工作内容并行处理'},
				{id:2,icon:'am-icon-user',title:'多页面工作',desc:'标签栏可切换，不必为了新内容而被迫跳转界面，多项工作内容并行处理'},
				{id:3,icon:'am-icon-umbrella',title:'多页面工作',desc:'标签栏可切换，不必为了新内容而被迫跳转界面，多项工作内容并行处理'},
				{id:4,icon:'am-icon-briefcase',title:'多页面工作',desc:'标签栏可切换，不必为了新内容而被迫跳转界面，多项工作内容并行处理'}
			],
            bannerHeight: "",
			imgs:[
			    "src/assets/images/index/b1.webp",
                "src/assets/images/index/b2.webp",
                "src/assets/images/index/b3.webp",
                "src/assets/images/index/b4.webp",
			],
            imgList: [
                {imgUrl: "https://img14.360buyimg.com/pop/s590x470_jfs/t1/107362/20/24177/90602/6233decdE5627d944/b7194e538e3c8c7a.jpg"},
                {imgUrl: "https://img12.360buyimg.com/pop/s590x470_jfs/t1/204028/36/25480/101429/62f507a7Ec62b0cd3/db5984ae24ce0212.jpg"},
                {imgUrl: "https://imgcps.jd.com/ling4/100022552927/5Lqs6YCJ5aW96LSn/5L2g5YC85b6X5oul5pyJ/p-5f3a47329785549f6bc7a6e6/075268d0/cr/s/q.jpg"},
                {imgUrl: "https://imgcps.jd.com/ling4/100026667910/5Lqs6YCJ5aW96LSn/5L2g5YC85b6X5oul5pyJ/p-5f3a47329785549f6bc7a6e3/d7b3695b/cr/s/q.jpg"},
                {imgUrl: "https://img30.360buyimg.com/pop/s590x470_jfs/t1/201288/25/23710/64955/62f070fdE95cb4f47/22b916d938a43bb5.jpg"},
            ],
            leftVal: 0,  // 轮播图盒子的偏移值
            flag: true, // 用来节流防止重复点击
            start: null, // 自动执行下一张定的时器
            imgWidth: 500,  // 在这里填写你需要的图片宽度
            ition: 0.8, // 设置轮播图过度时间
            imgShow: 0, // 表示当前显示的图片索引

		}
	},
	mounted() {
		this.getSlideshow();
        this.imgLoad();
        window.addEventListener('resize',() => {
            this.bannerHeight=this.$refs.bannerHeight[0].height;
        this.imgLoad();
    },false);
        this.initswiper();
	},
	methods:{
		changeTab(index){
			this.tabIndex = index
		},
		getSlideshow(){
			this.getRequest("/findAllSlideshow").then(resp =>{
				if (resp){
					this.slideshow = resp.data.data
					//console.log(this.slideshow)
				}
			})
		},
        imgLoad(){
            this.$nextTick(()=>{
                this.bannerHeight=this.$refs.bannerHeight[0].height;
            // console.log(this.$refs.bannerHeight[0].height);
        })
        },
        MouseFun(type){// 停止定时器            // 重新执行定时器
            type=='移入'?clearTimeout(this.start):this.奥力给()
        },
        // 此为自动轮播定时器
        initswiper(){
            this.start = setInterval(()=>{
                this.NextFun()
        },1500)
        },
        // 这里通过额外封装的节流函数触发 PrevFun() 和 NextFun(),以达到防止重复点击的效果
        throttle(fun) {
            if (this.flag) {
                this.flag = false;
                fun(); // 此为模板中传递进来的PrevFun()或NextFun()函数
                setTimeout(() => {
                    this.flag = true;
            }, 1200); // 节流间隔时间
            }
        },
        // 上一张
        PrevFun(){
            if(this.leftVal==0){ // 判断显示的图片 是 第一张时执行
                // this.imgList.length是指循环图片数组的图片个数
                this.ition=0 // 将过渡时间变成0，瞬间位移到最后一张图
                this.imgShow=this.imgList.length-1 // 将高亮小点改为最后一张图
                this.leftVal=(this.imgList.length)*this.imgWidth // 瞬间移动
                setTimeout(()=>{  // 通过延时障眼法,归原过渡时间,执行真正的“上一张”函数
                    this.ition=0.8
                this.leftVal -= this.imgWidth
            },this.ition*1000)
            }else{ // 判断显示的图片 不是 第一张时执行
                this.ition=0.8
                this.leftVal -= this.imgWidth
                this.imgShow--
            }
        },
        // 下一张
        NextFun(){
            if(this.leftVal==(this.imgList.length-1)*this.imgWidth){ // 判断显示的图片 是 最后一张时执行
                this.ition=0.8
                this.leftVal+=this.imgWidth
                this.imgShow=0
                setTimeout(()=>{
                    this.ition=0
                this.leftVal=0
            },this.ition*1000)
            }else{ // 判断显示的图片 不是 最后一张时执行
                this.ition=0.8
                this.leftVal+=this.imgWidth
                this.imgShow++
            }
        },
        // 点击小圆点
        instFun(index){
            this.ition=0.8
            this.leftVal=index*this.imgWidth
            this.imgShow=index
        },
    }
	}

</script>

<style scoped>

</style>
