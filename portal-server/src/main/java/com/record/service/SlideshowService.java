package com.record.service;

import com.record.entity.Slideshow;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 京茶吉鹿
 * @since 2023-03-07
 */
public interface SlideshowService extends IService<Slideshow> {


    /**
     * 获取轮播图
     * @return
     */
    List<Slideshow> selectAllSlideshow();
}
