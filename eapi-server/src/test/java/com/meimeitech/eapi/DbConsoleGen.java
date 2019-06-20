package com.meimeitech.eapi;

import com.alibaba.fastjson.JSON;
import com.meimeitech.generator.tools.mybatis.util.MyBatisGeneratorUtil;
import com.meimeitech.generator.tools.mybatis.util.MybatisGeneratorConfigModel;
import org.apache.commons.io.FileUtils;

import java.io.File;

import static com.meimeitech.generator.controller.GeneratorController.codeGenerateLocation;

/**
 * @author paul
 * @description
 * @date 2019/6/13
 */
public class DbConsoleGen {
    public static void main(String[] args) {

        String json2 = "{\"dbConnectionURL\":\"jdbc:mysql://127.0.0.1:3306/yu_admin?useUnicode=true&characterEncoding=utf-8&useSSL=false&useInformationSchema=true\",\"dbUsername\":\"root\",\"dbPassword\":\"paul6329170!@#\",\"dbDriverClass\":\"com.mysql.jdbc.Driver\",\"targetPackage\":\"com.xiaohu.udpserver\",\"javaVoGeneratorFlag\":\"false\",\"tableList\":" +
                "[" +
                "{\"tableName\":\"yu_ebox_command_record\",\"domainObjectName\":\"EboxCommandRecord\"}," +
                "]" +
                "}";

        String json1 = "{\"dbConnectionURL\":\"jdbc:mysql://127.0.0.1:3306/ecapi_admin?useUnicode=true&characterEncoding=utf-8&useSSL=false&useInformationSchema=true\",\"dbUsername\":\"root\",\"dbPassword\":\"paul6329170!@#\",\"dbDriverClass\":\"com.mysql.jdbc.Driver\",\"targetPackage\":\"com.xiaohu.udpserver\",\"javaVoGeneratorFlag\":\"false\",\"tableList\":" +
                "[" +
                "{\"tableName\":\"yu_data_acm_day\",\"domainObjectName\":\"DataAcmDay\"}," +
                "{\"tableName\":\"yu_data_acm_day_def\",\"domainObjectName\":\"DataAcmDayDef\"}," +
                "{\"tableName\":\"yu_data_acm_hour\",\"domainObjectName\":\"DataAcmHour\"}," +
                "{\"tableName\":\"yu_data_acm_hour_def\",\"domainObjectName\":\"DataAcmHourDef\"}," +
                "{\"tableName\":\"yu_data_net_config\",\"domainObjectName\":\"DataNetConfig\"}," +
                "{\"tableName\":\"yu_data_status_report\",\"domainObjectName\":\"DataStatusReport\"}," +
                "{\"tableName\":\"yu_data_sw_config\",\"domainObjectName\":\"DataSwConfig\"}," +
                "{\"tableName\":\"yu_data_push_event\",\"domainObjectName\":\"DataPushEvent\"}," +
                "{\"tableName\":\"yu_data_register\",\"domainObjectName\":\"DataRegister\"}," +
                "]" +
                "}";

                
        String json = "{\"dbConnectionURL\":\"jdbc:mysql://127.0.0.1:3306/yu_admin?useUnicode=true&characterEncoding=utf-8&useSSL=false&useInformationSchema=true\",\"dbUsername\":\"root\",\"dbPassword\":\"paul6329170!@#\",\"dbDriverClass\":\"com.mysql.jdbc.Driver\",\"targetPackage\":\"cn.xxx.business\",\"javaVoGeneratorFlag\":\"false\",\"tableList\":" +
                "[" +
                "{\"tableName\":\"yu_ebox_command_record\",\"domainObjectName\":\"EboxCommandRecord\"}," +
                "{\"tableName\":\"yu_ebox_department\",\"domainObjectName\":\"EboxDepartment\"}," +
                "{\"tableName\":\"yu_ebox_info\",\"domainObjectName\":\"EboxInfo\"}," +
                "{\"tableName\":\"yu_ebox_machine_check\",\"domainObjectName\":\"EboxMachineCheck\"}," +
                "{\"tableName\":\"yu_ebox_operations\",\"domainObjectName\":\"EboxOperations\"}," +
                "{\"tableName\":\"yu_ebox_person_check\",\"domainObjectName\":\"EboxPersonCheck\"}," +
                "{\"tableName\":\"yu_ebox_person_check_result\",\"domainObjectName\":\"EboxPersonCheckResult\"}," +
                "{\"tableName\":\"yu_ebox_scene\",\"domainObjectName\":\"EboxScene\"}," +
                "{\"tableName\":\"yu_ebox_warning\",\"domainObjectName\":\"EboxWarning\"}," +
                "{\"tableName\":\"yu_data_acm_day\",\"domainObjectName\":\"DataAcmDay\"}," +
                "{\"tableName\":\"yu_data_acm_day_def\",\"domainObjectName\":\"DataAcmDayDef\"}," +
                "{\"tableName\":\"yu_data_acm_hour\",\"domainObjectName\":\"DataAcmHour\"}," +
                "{\"tableName\":\"yu_data_acm_hour_def\",\"domainObjectName\":\"DataAcmHourDef\"}," +
                "{\"tableName\":\"yu_data_net_config\",\"domainObjectName\":\"DataNetConfig\"}," +
                "{\"tableName\":\"yu_data_status_report\",\"domainObjectName\":\"DataStatusReport\"}," +
                "{\"tableName\":\"yu_data_sw_config\",\"domainObjectName\":\"DataSwConfig\"}," +
                "{\"tableName\":\"yu_data_push_event\",\"domainObjectName\":\"DataPushEvent\"}," +
                "{\"tableName\":\"yu_data_register\",\"domainObjectName\":\"DataRegister\"}," +
                "]" +
                "}";
        MybatisGeneratorConfigModel mysqlGeneratorModel = JSON.parseObject(json, MybatisGeneratorConfigModel.class);

        try {
            long l = System.currentTimeMillis();
            mysqlGeneratorModel.setTargetProject(codeGenerateLocation() + File.separator + l);
            FileUtils.forceMkdir(new File(mysqlGeneratorModel.getTargetProject()));

            MyBatisGeneratorUtil.generator(mysqlGeneratorModel);
            System.out.println("生成的目录:" + mysqlGeneratorModel.getTargetProject());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
