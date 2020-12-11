package com.neta.spring.api.models;

public class DBTableDesc {

    private String field;
    private String fieldJavaSetGet;
    private String fieldTableHeader;
    private String fieldNameHeader;
    private String type;
    private String typeForJava;
    private String nuLL;
    private String key;
    private String Default;
    private String extra;

    public String getFieldJavaSetGet() {
        return fieldJavaSetGet;
    }

    public void setFieldJavaSetGet(String fieldJavaSetGet) {
        this.fieldJavaSetGet = fieldJavaSetGet;
    }

    public void setTypeForJava(String typeForJava) {
        this.typeForJava = typeForJava;
    }

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
        System.out.println(type);
        if (type.contains("int")) {
            this.typeForJava = "Long";
        } else if (type.contains("varchar")) {
            this.typeForJava = "String";
        } else if (type.contains("text")) {
            this.typeForJava = "String";
        } else if (type.contains("date")) {
            this.typeForJava = "Date";
        } else if (type.contains("datetime")) {
            this.typeForJava = "Date";
        } else if (type.contains("double")) {
            this.typeForJava = "double";
        } else if (type.contains("bigint")) {
            this.typeForJava = "BigInt";
        } else {
            this.typeForJava = "String";
        }
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

    public String getTypeForJava() {
        return typeForJava;
    }
}
