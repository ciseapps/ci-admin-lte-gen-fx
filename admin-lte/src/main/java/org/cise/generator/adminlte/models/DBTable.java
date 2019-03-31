package org.cise.generator.adminlte.models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBTable {

    private String tableName;
    private List<DBTableDesc> listTableDesc = new ArrayList<>();

    public DBTable(String username, String password, String database, String table) throws SQLException {
        this.tableName = table;
        Connection conn = getConnection(database, username, password);
        String sql = "DESC " + table;
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet res = ps.executeQuery();
        while (res.next()) {
            DBTableDesc td = new DBTableDesc();
            td.setField(res.getString(1));
            td.setFieldTableHeader(res.getString(1));
            td.setFieldNameHeader(res.getString(1));
            td.setType(res.getString(2));
            td.setNuLL(res.getString(3));
            td.setKey(res.getString(4));
            td.setDefault(res.getString(5));
            td.setExtra(res.getString(5));
            listTableDesc.add(td);
        }
        res.close();
        ps.close();
        conn.close();
    }

    public String getTableName() {
        return tableName;
    }

    public String getTablePK() {
        String key = "";
        for (DBTableDesc td : listTableDesc) {
            if ("PRI".equalsIgnoreCase(td.getKey())) {
                key = td.getField();
                break;
            }
        }
        return key;
    }

    public DBTableDesc getTableDescPK() {
        for (DBTableDesc td : listTableDesc) {
            if ("PRI".equalsIgnoreCase(td.getKey())) {
                return td;
            }
        }
        return listTableDesc.get(0);
    }

    public List<DBTableDesc> getListTableDescForm() {
        List<DBTableDesc> list = new ArrayList<>();
        for (DBTableDesc td : listTableDesc) {
            if ("status".equalsIgnoreCase(td.getField())
                    || "created_by".equalsIgnoreCase(td.getField())
                    || "created_date".equalsIgnoreCase(td.getField())
                    || "modified_by".equalsIgnoreCase(td.getField())
                    || "modified_date".equalsIgnoreCase(td.getField())) {
            } else {
                list.add(td);
            }
        }
        return list;
    }

    public List<DBTableDesc> getListTableDesc() {
        return listTableDesc;
    }

    private Connection getConnection(String database, String username, String password) throws SQLException {
        return DriverManager.getConnection("jdbc:mariadb://localhost:3306/" + database + "?user=" + username + "&password=" + password);
    }
}
