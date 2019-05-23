package org.cise.generator.adminstar.commons;

import java.io.File;

public class NameUtils {

    private final String sp = File.separator;

    public static String upperFirst(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (i == 0) {
                sb.append(Character.toUpperCase(c));
            } else sb.append(c);

        }
        return sb.toString();
    }

    public static String camel(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (i == 0) {
                sb.append(Character.toUpperCase(c));
            } else if (i - 1 > 0 && Character.isWhitespace(chars[i - 1])) {
                sb.append(Character.toUpperCase(c));
            } else sb.append(c);

        }
        return sb.toString();
    }

    public static String camelForField(String value) {
        String s = value.replaceAll("_", " ");
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (i == 0) {
                sb.append(Character.toLowerCase(c));
            } else if (i - 1 > 0 && Character.isWhitespace(chars[i - 1])) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(c);
            }

        }
        return sb.toString().replaceAll(" ","");
    }

    public static String getNameForPackage(String pref, String module) {
        String name = module.replaceAll(" ", "").replaceAll("-", "");
        return name.toLowerCase();
    }

    public static String getNameForFileController(String pref, String module) {
        String name = module.replaceAll(" ", "").replaceAll("-", "") + "Controller";
        return camel(name);
    }

    public static String getNameForModel(String module) {
        String name = module.replaceAll(" ", "").replaceAll("-", "");
        return camel(name);
    }

    public static String getNameForService(String module) {
        String name = module.replaceAll(" ", "").replaceAll("-", "") + "Service";
        return camel(name);
    }

    public static String getNameForServiceImpl(String module) {
        String name = module.replaceAll(" ", "").replaceAll("-", "") + "ServiceImpl";
        return camel(name);
    }

    public static String getNameForRepo(String module) {
        String name = module.replaceAll(" ", "").replaceAll("-", "") + "Repository";
        return camel(name);
    }

    public static String getNameForModelAliasController(String module) {
        String name = module.replaceAll(" ", "_").replaceAll("-", "_");
        return camel(name);
    }

    public static String getNameForFileModel(String module) {
        String name = module.replaceAll(" ", "").replaceAll("-", "");
        return camel(name);
    }

    public static String getNameForTitle(String module) {
        return camel(module.replaceAll(" ", "").replaceAll("-", ""));
    }

    public static String getNameForId(String module) {
        String name = module.replaceAll(" ", "-").replaceAll("_", "-");
        return name.toLowerCase();
    }

    public static String getNameForLink(String module) {
        String name = module.replaceAll(" ", "_").replaceAll("-", "_");
        return name.toLowerCase();
    }

    public static String getNameForSession(String module) {
        String name = module.replaceAll(" ", ".").replaceAll("-", ".").replaceAll("_", ".");
        return name.toLowerCase();
    }

    public static String camelForFieldJavaSetGet(String value) {
        String s = value.replaceAll("_", " ");
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (i == 0) {
                sb.append(Character.toUpperCase(c));
            } else if (i - 1 > 0 && Character.isWhitespace(chars[i - 1])) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(c);
            }

        }
        return sb.toString().replaceAll(" ","");
    }
}
