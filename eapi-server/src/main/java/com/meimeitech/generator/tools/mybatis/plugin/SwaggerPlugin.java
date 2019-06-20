package com.meimeitech.generator.tools.mybatis.plugin;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.Plugin;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;
import java.util.Properties;

/**
 * @author paul
 * @description
 * @date 2019/5/5
 */
public class SwaggerPlugin extends PluginAdapter {

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
    }

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass,
                                                 IntrospectedTable introspectedTable) {
        if (isMybatisGenSwagger()) {

            String remarks = introspectedTable.getRemarks();
            topLevelClass.addImportedType("io.swagger.annotations.*");

            String fullyQualifiedName = topLevelClass.getType().getFullyQualifiedName();
            topLevelClass.addJavaDocLine("@ApiModel(value = \"" + fullyQualifiedName + "\", description = \"" + remarks + "\")");
        }
        return true;
    }

    @Override
    public boolean modelFieldGenerated(Field field,
                                       TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn,
                                       IntrospectedTable introspectedTable,
                                       Plugin.ModelClassType modelClassType) {
        if (isMybatisGenSwagger()) {
            if (modelClassType == Plugin.ModelClassType.BASE_RECORD) {
                String remarks = introspectedColumn.getRemarks();
                if (remarks == null || remarks.length() == 0) {
                    remarks = field.getName();
                }
                field.addJavaDocLine("@ApiModelProperty(value = \"" + remarks + "\")");
            }
        }
        return true;
    }

    public static boolean isMybatisGenSwagger() {
        String property = System.getProperty("mybatis.gen.swagger");
        if ("true".equals(property)) {
            return true;
        }
        return false;
    }
}
