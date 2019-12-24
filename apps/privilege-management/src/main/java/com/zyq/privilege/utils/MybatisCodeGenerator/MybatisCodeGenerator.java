package com.zyq.privilege.utils.MybatisCodeGenerator;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Mybatis代码自动生成工具
 *
 * @author zhangyunqi
 * @CreateDate 2019/12/7 15:07
 */
public class MybatisCodeGenerator {
    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }


    /**
     * 自动生成代码
     * @param args
     */
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = "E:\\IdeaProjects\\cloudplatform\\apps\\privilege-management";
        //user.dir不能用于maven子项目
        //String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("zhangyunqi");
        gc.setOpen(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:h2:file:D:\\H2\\database\\privilege");
        dsc.setSchemaName("public");
        dsc.setDriverName("org.h2.Driver");
        dsc.setUsername("sa");
        dsc.setPassword("sa");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        //父包
        pc.setParent("com.zyq.privilege");
        //自定义业务模块名，entity和mapper类将写入模块包里
        // pc.setModuleName(scanner("业务模块名"));
        // 设置自定义输出类路径
        // 自定义实体路径。父包+自定义包路径
        pc.setEntity("entity");
        // 自定义Mapper接口路径。父包+自定义包路径
        pc.setMapper("dao");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/"
//                        + pc.getModuleName() + "/"
                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // 用自定义的模板替换系统自带的模板
        templateConfig.setEntity("templates/myentity.java");
        templateConfig.setMapper("templates/mymapper.java");

        // XML文件已经在自定义配置中已经配置了，关闭自带的XML文件生成
        templateConfig.setXml(null);
        // 关闭Controller文件生成
        templateConfig.setController(null);
        // 关闭Service接口文件生成
        templateConfig.setService(null);
        // 关闭ServiceImpl实现文件生成
        templateConfig.setServiceImpl(null);
        mpg.setTemplate(templateConfig);

        // 数据库表和策略配置
        StrategyConfig strategy = new StrategyConfig();
        //表名：下划线转驼峰命名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //列名：下划线转驼峰命名
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //
        //strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");

        // 公共父类
        //strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
        // 写于父类中的公共字段
        //strategy.setSuperEntityColumns("id");
        //需要生成的表,可以在这里直接定义
        strategy.setInclude(scanner("大写表名，多个英文逗号分割").split(","));
        // 生成controller时配置URL驼峰转连字符
        //strategy.setControllerMappingHyphenStyle(true);
        //加入表前缀
        //strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        //使用的模板引擎
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
