package com.liyang.eduservice.mapper;

import com.liyang.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liyang.eduservice.entity.frontvo.CourseWebVo;
import com.liyang.eduservice.entity.vo.CoursePublishVo;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author liyang
 * @since 2021-04-28
 */
public interface EduCourseMapper extends BaseMapper<EduCourse> {
    // 根据课程id查询 课程确认信息
    CoursePublishVo getPublishCourseInfo(String courseId);

    // 根据课程id查询 课程基本信息(用于用户前台展示)
    CourseWebVo getBaseCourseInfo(String courseId);
}
