package com.xm.utils;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

public class ResourcesUtils {

    public String readResourceFileAsString(String resourceFileName) {
        try {
            return FileUtils.readFileToString(getResourceFile(resourceFileName), Charset.defaultCharset());
        } catch (IOException e) {
            throw new RuntimeException("Unable to read resource file " + resourceFileName);
        }
    }

    public File getResourceFile(String resourceFileName) {
        URL resource = getClass().getClassLoader().getResource(resourceFileName);
        if (resource == null) throw new RuntimeException("Unable to load resource " + resourceFileName);
        return new File(resource.getFile());
    }
}
