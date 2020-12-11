package org.cise.generator.adminlte.generator;

import freemarker.template.TemplateException;
import org.cise.generator.adminlte.models.DBTable;
import org.cise.generator.adminlte.models.FileManager;

import java.io.IOException;
import java.sql.SQLException;

public interface Generator {

    void setDBTable(DBTable table);

    void setFileManager(FileManager fileManager);

    void execute() throws IOException, SQLException, TemplateException;
}
