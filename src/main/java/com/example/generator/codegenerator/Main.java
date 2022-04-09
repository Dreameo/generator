package com.example.generator.codegenerator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:13306/seckill", "root", "root")
                .globalConfig(builder -> {
                    builder.author("steve") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("E://Projects//my_seckill//src//main//java//"); // 指定输出目录
                })
//        E:\Projects\my_seckill\src\main\java\com\example\my_seckill
                .packageConfig(builder -> {
                    builder.parent("com.example.my_seckill") // 设置父包名
//                            .moduleName("generator") // 设置父包模块名
//                    E:\Projects\generator\src\main\resources
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "E://Projects//my_seckill//src//main//resources//mapper//")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_goods","t_order", "t_seckill_goods", "t_seckill_order" , "t_user") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }
}