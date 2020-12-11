package org.cise.generator.adminstar.generator;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;
import org.cise.generator.adminstar.commons.FileUtils;
import org.cise.generator.adminstar.commons.NameUtils;
import org.cise.generator.adminstar.models.DBTable;
import org.cise.generator.adminstar.models.FileManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class GeneratorImpl implements Generator {

    private Configuration config = new Configuration(Configuration.VERSION_2_3_26);
    private DBTable dbTable;
    private FileManager fm;

    @Override
    public void setDBTable(DBTable table) {
        this.dbTable = table;
    }

    @Override
    public void setFileManager(FileManager fileManager) {
        this.fm = fileManager;
    }

    @Override
    public void execute() throws IOException, SQLException, TemplateException {
        List<String> structures = fm.getStructure();
        for (String s : structures) {
            FileUtils.createIfNotExistFolder(s);
        }
        List<String> files = fm.getFiles();
        for (String s : files) {
            FileUtils.createIfNotExistFile(s);
        }
        Configuration cnfg = new Configuration(Configuration.VERSION_2_3_26);
        // freemaker
        cnfg.setIncompatibleImprovements(new Version(2, 3, 20));
        cnfg.setDefaultEncoding("UTF-8");
        cnfg.setLocale(Locale.US);
        cnfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cnfg.setDirectoryForTemplateLoading(new File(fm.getBaseTemplate()));
        Map<?, ?> map = getParam(fm);
        write(files.get(0), fm.getTmpController(), map, cnfg, fm);
        write(files.get(1), fm.getTmpModel(), map, cnfg, fm);
        write(files.get(2), fm.getTmpRepo(), map, cnfg, fm);
        write(files.get(3), fm.getTmpService(), map, cnfg, fm);
        write(files.get(4), fm.getTmpServiceImpl(), map, cnfg, fm);
        write(files.get(5), fm.getTmpViewConten(), map, cnfg, fm);
        write(files.get(6), fm.getTmpViewForm(), map, cnfg, fm);
    }

    public void structureFileTest() throws IOException, TemplateException, SQLException {

    }

    private void write(String destination, String template, Map<?, ?> map, Configuration cnfg, FileManager fm) throws IOException, SQLException, TemplateException {
        File destinationFile = new File(destination);
        if (destinationFile.exists()) {
            Writer writer = new FileWriter(destinationFile);
            cnfg.getTemplate(template).process(map, writer);
            writer.close();
        }
    }

    private Map<?, ?> getParam(FileManager fm) throws SQLException {
        Map<String, Object> map = new HashMap<>();
        // controller
        map.put("package", NameUtils.getNameForPackage(fm.getPrefix(), fm.getModule()));
        map.put("path", NameUtils.getNameForPackage(fm.getPrefix(), fm.getModule()));
        map.put("module", NameUtils.getNameForModel(fm.getModule()));
        map.put("model", NameUtils.getNameForModel(fm.getModule()));
        map.put("controllerFileName", NameUtils.getNameForFileController(fm.getPrefix(), fm.getModule()));
        map.put("controllerModel", NameUtils.getNameForModel(fm.getModule()));
        map.put("controllerModelAlias", NameUtils.getNameForModelAliasController(fm.getModule()));
        // model
        map.put("modelFileName", NameUtils.getNameForFileModel(fm.getModule()));
        map.put("table", dbTable.getTableName());
        map.put("pk", dbTable.getTablePK());
        // view content
        map.put("title", NameUtils.getNameForTitle(fm.getModule()));
        map.put("titleLower", NameUtils.getNameForId(fm.getModule()));
        map.put("titleForId", NameUtils.getNameForId(fm.getModule()));
        map.put("titleUnder", NameUtils.getNameForLink(fm.getModule()));
        map.put("titleForLink", NameUtils.getNameForLink(fm.getPrefix().toLowerCase() + "_" + fm.getModule()));
        map.put("titleForSession", NameUtils.getNameForSession(fm.getModule()));
//        map.put("pathContentJS", fm.getPathJSContent());
        // view form
        map.put("viewFormModel", dbTable.getListTableDescForm());
//        map.put("pathFormJS", fm.getPathJSForm());
        // js content
        map.put("viewTableModel", dbTable.getListTableDesc());
        return map;
    }
}
