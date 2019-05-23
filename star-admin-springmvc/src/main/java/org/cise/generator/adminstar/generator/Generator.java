package org.cise.generator.adminstar.generator;

import freemarker.template.TemplateException;
import org.cise.generator.adminstar.models.DBTable;
import org.cise.generator.adminstar.models.FileManager;

import java.io.IOException;
import java.sql.SQLException;

public interface Generator {

    void setDBTable(DBTable table);

    void setFileManager(FileManager fileManager);

    void execute() throws IOException, SQLException, TemplateException;
}
