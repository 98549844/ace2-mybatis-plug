package com.ace2.mybatisplug.aspect;

import com.ace2.mybatisplug.models.Users;
import com.ace2.mybatisplug.util.RandomUtil;
import com.ace2.mybatisplug.util.TypeUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Classname: MapperAspect
 * @Date: 2022/9/26 下午 12:06
 * @Author: kalam_au
 * @Description:
 */

@Aspect
@Component
public class MapperAspect {
    private static final Logger log = LogManager.getLogger(MapperAspect.class.getName());

    @Pointcut("@annotation(org.apache.ibatis.annotations.Mapper)")
    public void mapperAspect() {
    }



    @Before(value = "execution(* com.ace2.mybatisplug.mapper.*.*(..))&&args(record)", argNames = "record")
    public void beforeUpdate(Users record) {
        String type = TypeUtil.getType(record);
        String mobile = RandomUtil.getRangeInt(1, 9999).toString();
        record.setMobile(mobile);
        System.out.println("com.ace2.mybatisplug.mapper => beforeUpdate ... mobile: " + mobile);
        System.out.println("com.ace2.mybatisplug.mapper => beforeUpdate ..." + type);
        System.out.println("com.ace2.mybatisplug.mapper => beforeUpdate ..." + record.getUserAccount());
        System.out.println("com.ace2.mybatisplug.mapper => beforeUpdate ..." + record.getVersion());
        System.out.println("com.ace2.mybatisplug.mapper => beforeUpdate ..." + record.getLastUpdateDate());
        System.out.println("com.ace2.mybatisplug.mapper => beforeUpdate ..." + record.getLastUpdatedBy());
    }


    @After("execution(* com.ace2.mybatisplug.mapper.*.*(..))")
    public void afterUpdate() {
        System.out.println("com.ace2.mybatisplug.mapper => afterUpdate ...");
    }


}

