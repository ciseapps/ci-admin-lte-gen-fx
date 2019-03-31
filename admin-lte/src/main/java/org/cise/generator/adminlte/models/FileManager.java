package org.cise.generator.adminlte.models;

import org.cise.generator.adminlte.commons.NameUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private final String sp = File.separator;
    private final String pathJSContent;
    private final String pathJSForm;
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
    private String view;

    // template
    private String tmpController;
    private String tmpModel;
    private String tmpViewConten;
    private String tmpViewForm;
    private String tmpJSForm;
    private String tmpJSContent;

    List<String> structure = new ArrayList<>();
    List<String> files = new ArrayList<>();

    public FileManager(String baseProjectPath, String baseTemplatePath, String prefix, String module) {
        this.prefix = prefix;
        this.module = module;
        this.baseTemplate = baseTemplatePath;
        // codeigniter base folder
        this.baseModules = baseProjectPath + sp + "application" + sp + "modules" + sp + prefix.toLowerCase() + "_" + NameUtils.getNameForLink(module);
        // asset base folder
        this.baseAssets = baseProjectPath + sp + "assets" + sp + "modules" + sp + prefix.toLowerCase() + "_" + NameUtils.getNameForLink(module);
        // base folder
        this.controller = baseModules + sp + "controllers";
        this.models = baseModules + sp + "models";
        this.view = baseModules + sp + "views";
        // template
        this.tmpController = "controller.php.ftl";
        this.tmpModel = "model.php.ftl";
        this.tmpViewConten = "view_content.php.ftl";
        this.tmpViewForm = "view_form.php.ftl";
        this.tmpJSContent = "content.js.ftl";
        this.tmpJSForm = "form.js.flt";

        structure.add(this.controller);
        structure.add(this.models);
        structure.add(this.view);
        structure.add(this.baseAssets);
        // php
        files.add(this.controller + sp + NameUtils.getNameForFileController(prefix, module) + ".php");
        files.add(this.models + sp + NameUtils.getNameForFileModel(module) + ".php");
        files.add(this.view + sp + "content.php");
        files.add(this.view + sp + "form.php");
        // js
        this.pathJSContent = "assets/modules/" + NameUtils.getNameForLink(prefix.toLowerCase() + "_" + module) + "/" + NameUtils.getNameForId(module) + "-content.js";
        this.pathJSForm = "assets/modules/" + NameUtils.getNameForLink(prefix.toLowerCase() + "_" + module) + "/" + NameUtils.getNameForId(module) + "-form.js";

        files.add(this.baseAssets + sp + NameUtils.getNameForId(module) + "-content.js"); // content js
        files.add(this.baseAssets + sp + NameUtils.getNameForId(module) + "-form.js"); // form js
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

    public String getTmpJSForm() {
        return tmpJSForm;
    }

    public void setTmpJSForm(String tmpJSForm) {
        this.tmpJSForm = tmpJSForm;
    }

    public String getTmpJSContent() {
        return tmpJSContent;
    }

    public void setTmpJSContent(String tmpJSContent) {
        this.tmpJSContent = tmpJSContent;
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

    public String getPathJSContent() {
        return pathJSContent;
    }

    public String getPathJSForm() {
        return pathJSForm;
    }
}
