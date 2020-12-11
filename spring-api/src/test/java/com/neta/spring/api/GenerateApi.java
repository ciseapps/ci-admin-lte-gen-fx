package com.neta.spring.api;

import com.neta.spring.api.generator.Generator;
import com.neta.spring.api.generator.GeneratorImpl;
import com.neta.spring.api.models.DBTable;
import com.neta.spring.api.models.FileManager;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class GenerateApi {

    String dbUsername = "root";
    String dbPassword = "root";
    String database = "adm_lte";
    //    String baseProject = "/Users/zuliadin/Documents/Workspace/Spring/spring-web-mvc/src/main";
    String baseProject = "C:\\Users\\Lenovo\\Documents\\Workspace\\ZULIADIN\\spring-api\\src\\main";
    String baseTemplate = System.getProperty("user.dir") + File.separator + "template";

    @Test
    public void generatorFileTest() throws IOException, TemplateException, SQLException {
        generate("role", "app_roles");
    }

    private void generate(String module, String tableName) throws SQLException, IOException, TemplateException {
        Generator generator = new GeneratorImpl();
        generator.setFileManager(new FileManager(baseProject, baseTemplate, "", module));
        generator.setDBTable(new DBTable(dbUsername, dbPassword, database, tableName));
        generator.execute();
    }
}
