package org.cise.generator.adminlte.commons;

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
            } else if (i-1 > 0 && Character.isWhitespace(chars[i - 1])) {
                sb.append(Character.toUpperCase(c));
            } else sb.append(c);

        }
        return sb.toString();
    }

    public static String getNameForFileController(String pref, String module) {
        String name = pref + "_" + module.replaceAll(" ", "_").replaceAll("-", "_");
        return upperFirst(name.toLowerCase());
    }

    public static String getNameForModelController(String module) {
        String name = module.replaceAll(" ", "_").replaceAll("-", "_") + "_model";
        return name.toLowerCase();
    }

    public static String getNameForModelAliasController(String module) {
        String name = module.replaceAll(" ", "_").replaceAll("-", "_");
        return name.toLowerCase();
    }

    public static String getNameForFileModel(String module) {
        String name = module.replaceAll(" ", "_").replaceAll("-", "_") + "_model";
        return upperFirst(name.toLowerCase());
    }

    public static String getNameForTitle(String module) {
        return camel(module.replaceAll("_", " ").replaceAll("-", " "));
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
}
