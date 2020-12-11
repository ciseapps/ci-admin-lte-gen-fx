package org.cise.generator.adminstar;

import freemarker.template.TemplateException;
import org.cise.generator.adminstar.generator.Generator;
import org.cise.generator.adminstar.generator.GeneratorImpl;
import org.cise.generator.adminstar.models.DBTable;
import org.cise.generator.adminstar.models.FileManager;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class FileTest {

    String dbUsername = "root";
    String dbPassword = "root";
    String database = "spring_cms";
    String baseProject = "/Users/zuliadin/Documents/Workspace/Spring/spring-web-mvc/src/main";
    String baseTemplate = System.getProperty("user.dir") + File.separator + "template";

    @Test
    public void generatorFileTest() throws IOException, TemplateException, SQLException {
        generate("department", "prc_department");
        generate("jabatan", "prc_jabatan");
        generate("product", "prc_product");
        generate("vendor", "prc_vendor");
//        System.out.println(baseProject);
//        System.out.println(baseTemplate);
//        generate("app","constant", "app_constant");
//        generate("app","menu", "app_menu");
//        generate("app","resource", "app_resource");
//        generate("app","role", "app_role");
//        generate("app","role_menu", "app_role_menu");
//        generate("app","table_sequence", "app_table_sequence");
    }

    private void generate(String module, String tableName) throws SQLException, IOException, TemplateException {
        Generator generator = new GeneratorImpl();
        generator.setFileManager(new FileManager(baseProject, baseTemplate, "", module));
        generator.setDBTable(new DBTable(dbUsername, dbPassword, database, tableName));
        generator.execute();
    }

}
