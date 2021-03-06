
package com.shores.fe.starmap.viewer.core.Configuration;

import java.io.File;

public class Configuration {
    public static final String          APPLICATION_NAME        = "SOH_FE_CONVERTER";
    public static final String		FILE_SEPARATOR          = System.getProperty("file.separator");
    public static final String		LINE_SEPARATOR          = System.getProperty("line.separator");

    public static final String		BASE_DIR		= System.getProperty("user.dir") + File.separator;
    public static final String		INSTALL_DIR		= System.getProperty("user.dir") + FILE_SEPARATOR;
    public static final String		TEMP_DIR		= System.getProperty("java.io.tmpdir") + FILE_SEPARATOR + APPLICATION_NAME + FILE_SEPARATOR;
    public static final String		USER_DIR		= System.getProperty("user.home") + FILE_SEPARATOR;
    public static final String		OS_NAME			= System.getProperty("os.name");
}
