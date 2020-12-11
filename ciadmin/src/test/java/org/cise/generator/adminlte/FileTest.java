package org.cise.generator.adminlte;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;
import org.cise.generator.adminlte.commons.FileUtils;
import org.cise.generator.adminlte.commons.NameUtils;
import org.cise.generator.adminlte.generator.Generator;
import org.cise.generator.adminlte.generator.GeneratorImpl;
import org.cise.generator.adminlte.models.DBTable;
import org.cise.generator.adminlte.models.FileManager;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.*;

import static jdk.nashorn.internal.objects.NativeDebug.map;


public class FileTest {

    String dbUsername = "root";
    String dbPassword = "root";
    String database = "web_base_codeigniter";
    String baseProject = "C:\\xampp\\htdocs\\web_base_codeigniter";
    String baseTemplate = "C:\\Users\\demOn\\Downloads\\Documents\\TestGenerator\\template";

    @Test
    public void generatorFileTest() throws IOException, TemplateException, SQLException {
        generate("app","config", "app_config");
        generate("app","constant", "app_constant");
        generate("app","menu", "app_menu");
        generate("app","resource", "app_resource");
        generate("app","role", "app_role");
        generate("app","role_menu", "app_role_menu");
        generate("app","table_sequence", "app_table_sequence");
    }

    private void generate(String prefix, String module, String tableName) throws SQLException, IOException, TemplateException {
        Generator generator = new GeneratorImpl();
        generator.setFileManager(new FileManager(baseProject, baseTemplate, prefix, module));
        generator.setDBTable(new DBTable(dbUsername, dbPassword, database, tableName));
        generator.execute();
    }
}
