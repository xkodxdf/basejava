package com.xkodxdf.webapp;

import com.xkodxdf.webapp.storage.SqlStorage;
import com.xkodxdf.webapp.storage.Storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static final File PROPS = new File("config\\resumes.properties");
    private static final Config INSTANCE = new Config();

    private final File storageDir;
    private final Storage sqlStorage;

    public static Config get() {
        return INSTANCE;
    }

    private Config() {
        try (InputStream is = new FileInputStream(PROPS)) {
            Properties props = new Properties();
            props.load(is);
            storageDir = new File(System.getProperty("user.dir") + props.getProperty("storage.dir"));
            sqlStorage = new SqlStorage(props.getProperty("db.url"), props.getProperty("db.user"),
                    props.getProperty("db.password"));
        } catch (IOException e) {
            throw new IllegalStateException("Invalid config file " + PROPS.getAbsolutePath());
        }
    }

    public Storage getSqlStorage() {
        return sqlStorage;
    }

    public File getStorageDir() {
        return storageDir;
    }
}
