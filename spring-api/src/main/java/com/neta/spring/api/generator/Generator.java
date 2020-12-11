package com.neta.spring.api.generator;

import com.neta.spring.api.models.DBTable;
import com.neta.spring.api.models.FileManager;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.sql.SQLException;

public interface Generator {

    void setDBTable(DBTable table);

    void setFileManager(FileManager fileManager);

    void execute() throws IOException, SQLException, TemplateException;
}
