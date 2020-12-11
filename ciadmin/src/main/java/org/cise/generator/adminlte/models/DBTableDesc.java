package org.cise.generator.adminlte.models;

public class DBTableDesc {

    private String field;
    private String fieldTableHeader;
    private String fieldNameHeader;
    private String type;
    private String nuLL;
    private String key;
    private String Default;
    private String extra;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public void setFieldTableHeader(String fieldTableHeader) {
        StringBuilder sb = new StringBuilder();
        for (char c : fieldTableHeader.toCharArray()) {
            if ('_' == c) {
                sb.append(' ');
            } else {
                sb.append(Character.toUpperCase(c));
            }
        }
        this.fieldTableHeader = sb.toString();
    }

    public String getFieldNameHeader() {
        return fieldNameHeader;
    }

    public void setFieldNameHeader(String fieldNameHeader) {
        StringBuilder sb = new StringBuilder();
        boolean isUpper = true;
        for (char c : fieldNameHeader.toCharArray()) {
            if ('_' == c) {
                sb.append(' ');
                isUpper = true;
            } else {
                if (isUpper) {
                    sb.append(Character.toUpperCase(c));
                    isUpper = false;
                } else {
                    sb.append(Character.toLowerCase(c));
                }
            }
        }
        this.fieldNameHeader = sb.toString();
    }

    public String getFieldTableHeader() {
        return fieldTableHeader;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNuLL() {
        return nuLL;
    }

    public void setNuLL(String nuLL) {
        this.nuLL = nuLL;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDefault() {
        return Default;
    }

    public void setDefault(String Default) {
        this.Default = Default;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}
