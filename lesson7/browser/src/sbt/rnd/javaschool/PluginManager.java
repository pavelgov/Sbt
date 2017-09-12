package sbt.rnd.javaschool;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by User on 12.09.2017.
 */
public class PluginManager {
    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(String pluginName, String pluginClassName) throws IllegalAccessException, InstantiationException, ClassNotFoundException, MalformedURLException {

        URL path = new URL(pluginRootDirectory+"/");
        URLClassLoader pluginLoader = new URLClassLoader(new URL[]{path});

        Class<?> claz = pluginLoader.loadClass(pluginClassName);
        return  (Plugin) claz.newInstance();
    }

}
