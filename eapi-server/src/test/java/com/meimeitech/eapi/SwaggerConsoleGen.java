package com.meimeitech.eapi;

import java.io.File;

/**
 * @author paul
 * @description
 * @date 2019/6/18
 */
public class SwaggerConsoleGen {
    public static String codeGenerateLocation() {
        String property = System.getProperty("user.dir");
        File file = new File(property);
        File parentFile = file.getParentFile();
        if (parentFile.exists()) {
            return parentFile.getPath() + File.separator + "code_gen_temp";
        } else {
            return file.getPath();
        }
    }
    public static void main(String[] args) {

        long l = System.currentTimeMillis();
        String root = codeGenerateLocation() + File.separator + l;
        File swaggerFile = new File("F:\\xiaohu\\udp-server\\src\\test\\resources\\swaggerCMD.json");
        String springBoot = root + File.separator + "SpringBoot";

        String feign = root + File.separator + "Feign";
        String axios = root + File.separator + "Axios"+ File.separator + "gen";

        MyGenerator.builder()
                .swaggerJson("file:///" + swaggerFile.getPath())
                .targetPackage("com.xiaohu.udpserver.cmd")
                .targetProject(springBoot)
                .build().generatorController();

        MyGenerator.builder()
                .swaggerJson("file:///" + swaggerFile.getPath())
                .targetPackage("cn.xxx.business.cmd")
                .targetProject(springBoot)
                .build().generatorController();

        MyGenerator.builder()
                .swaggerJson("file:///" + swaggerFile.getPath())
                .targetPackage("cn.xxx.business.cmd")
                .targetProject(feign)
                .build().generatorFeignClient();

        MyGenerator.builder()
                .swaggerJson("file:///" + swaggerFile.getPath())
                .targetProject(axios)
                .build().generatorAxiosClient();
        System.out.println("生成目录:"+root);
    }
}
