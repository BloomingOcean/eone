package com.liyang.eduservice.controller;


import com.liyang.commonutils.Result;
import com.liyang.eduservice.entity.EduVideo;
import com.liyang.eduservice.service.EduVideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author liyang
 * @since 2021-04-28
 */
@Api("课程视频")
@RestController
@RequestMapping("/eduservice/edu-video")
public class EduVideoController {

    @Autowired
    private EduVideoService eduVideoService;

    @ApiOperation("获得视频")
    @RequestMapping(value = "/getEduVideos",method = RequestMethod.GET)
    public Result getEduVideos() {
        List<EduVideo> eduVideoList = eduVideoService.list(null);
        return Result.ok().data("eduVideoList",eduVideoList);
    }

}

