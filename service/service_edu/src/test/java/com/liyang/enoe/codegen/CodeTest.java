package com.liyang.enoe.codegen;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liyang.commonutils.Result;
import com.liyang.eduservice.EduApplication;
import com.liyang.eduservice.entity.EduTeacher;
import com.liyang.eduservice.service.EduTeacherService;
import com.liyang.eduservice.service.EduVideoService;
import com.liyang.eduservice.service.impl.EduTeacherServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = EduApplication.class)
//@Transactional
//@Rollback
public class CodeTest {

    @Autowired
    private EduVideoService eduVideoService;

    @Autowired
    private EduTeacherService eduTeacherService;

    @Test
    public void result() {
        Result ok = Result.ok();
//        ok.code().data().data();
    }

    @Test
    public void pageTest() {
        Page<EduTeacher> page = new Page<>(1L,3L);
        IPage<EduTeacher> teacherPage = eduTeacherService.page(page, null);
        System.out.println(Result.ok().data("page", page));
    }

}
