package org.cise.generator.adminstar.models;


import org.cise.generator.adminstar.commons.NameUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private final String sp = File.separator;
    //    private final String pathJSContent;
//    private final String pathJSForm;
    private String prefix;
    private String module;
    // codeigniter base folder
    private String baseTemplate;
    // codeigniter base folder
    private String baseModules;
    // asset base folder
    private String baseAssets;
    // base folder
    private String controller;
    private String models;
    private String repo;
    private String service;
    // base folder
    private String baseView;

    // template
    private String tmpController;
    private String tmpModel;
    private String tmpRepo;
    private String tmpService;
    private String tmpServiceImpl;
    private String tmpViewConten;
    private String tmpViewForm;
//    private String tmpJSForm;
//    private String tmpJSContent;

    List<String> structure = new ArrayList<>();
    List<String> files = new ArrayList<>();

    public FileManager(String baseProjectPath, String baseTemplatePath, String prefix, String module) {
        this.prefix = prefix;
        this.module = module;
        this.baseTemplate = baseTemplatePath;
        // base folder
        this.baseModules = baseProjectPath + sp + "java" + sp + "com" + sp + "cise" + sp + "cms" + sp + "core" + sp + "modules";//
        this.baseAssets = baseProjectPath + sp + "resources" + sp + "templates" + sp + "contents";//
        this.baseView = baseAssets + sp + module;//
        // base folder
        this.controller = baseModules + sp + module + sp + "controllers";
        this.models = baseModules + sp + module + sp + "models";
        this.repo = baseModules + sp + module + sp + "repo";
        this.service = baseModules + sp + module + sp + "service";
        // template
        this.tmpController = "controller.java.ftl";
        this.tmpRepo = "repository.java.ftl";
        this.tmpService = "service.java.ftl";
        this.tmpServiceImpl = "service.impl.java.ftl";
        this.tmpModel = "model.java.ftl";
        this.tmpViewConten = "content.html.ftl";
        this.tmpViewForm = "form.html.ftl";

        structure.add(this.controller);
        structure.add(this.models);
        structure.add(this.repo);
        structure.add(this.service);
        structure.add(this.baseAssets);
        structure.add(this.baseView);
        // php
        files.add(this.controller + sp + NameUtils.getNameForFileController(prefix, module) + ".java");
        files.add(this.models + sp + NameUtils.getNameForFileModel(module) + ".java");
        files.add(this.repo + sp + NameUtils.getNameForRepo(module) + ".java");
        files.add(this.service + sp + NameUtils.getNameForService(module) + ".java");
        files.add(this.service + sp + NameUtils.getNameForServiceImpl(module) + ".java");
        files.add(this.baseView + sp + "content.html");
        files.add(this.baseView + sp + "form.html");
    }

    public List<String> getStructure() {
        return structure;
    }

    public List<String> getFiles() {
        return files;
    }

    public String getTmpController() {
        return tmpController;
    }

    public void setTmpController(String tmpController) {
        this.tmpController = tmpController;
    }

    public String getTmpModel() {
        return tmpModel;
    }

    public void setTmpModel(String tmpModel) {
        this.tmpModel = tmpModel;
    }

    public String getTmpViewConten() {
        return tmpViewConten;
    }

    public void setTmpViewConten(String tmpViewConten) {
        this.tmpViewConten = tmpViewConten;
    }

    public String getTmpViewForm() {
        return tmpViewForm;
    }

    public void setTmpViewForm(String tmpViewForm) {
        this.tmpViewForm = tmpViewForm;
    }

    public String getBaseTemplate() {
        return baseTemplate;
    }

    public void setBaseTemplate(String baseTemplate) {
        this.baseTemplate = baseTemplate;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getModule() {
        return module;
    }

    public String getTmpRepo() {
        return tmpRepo;
    }

    public void setTmpRepo(String tmpRepo) {
        this.tmpRepo = tmpRepo;
    }

    public String getTmpService() {
        return tmpService;
    }

    public void setTmpService(String tmpService) {
        this.tmpService = tmpService;
    }

    public String getTmpServiceImpl() {
        return tmpServiceImpl;
    }

    public void setTmpServiceImpl(String tmpServiceImpl) {
        this.tmpServiceImpl = tmpServiceImpl;
    }

    //    public String getPathJSContent() {
//        return pathJSContent;
//    }

//    public String getPathJSForm() {
//        return pathJSForm;
//    }
}
