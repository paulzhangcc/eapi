package com.meimeitech.generator.tools.swagger.vo;

import java.io.Serializable;

public class SwaggerConfigVO implements Serializable {

    private String lang;

    private String targetProject;

    private String targetProjectId;

    private String apiPackage;

    private String modelPackage;

    private String library;

    private boolean generateSupportingFiles;

    public boolean isGenerateSupportingFiles() {
        return generateSupportingFiles;
    }

    public void setGenerateSupportingFiles(boolean generateSupportingFiles) {
        this.generateSupportingFiles = generateSupportingFiles;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getTargetProject() {
        return targetProject;
    }

    public void setTargetProject(String targetProject) {
        this.targetProject = targetProject;
    }

    public String getTargetProjectId() {
        return targetProjectId;
    }

    public void setTargetProjectId(String targetProjectId) {
        this.targetProjectId = targetProjectId;
    }

    public String getApiPackage() {
        return apiPackage;
    }

    public void setApiPackage(String apiPackage) {
        this.apiPackage = apiPackage;
    }

    public String getModelPackage() {
        return modelPackage;
    }

    public void setModelPackage(String modelPackage) {
        this.modelPackage = modelPackage;
    }

    public String getLibrary() {
        return library;
    }

    public void setLibrary(String library) {
        this.library = library;
    }
}
