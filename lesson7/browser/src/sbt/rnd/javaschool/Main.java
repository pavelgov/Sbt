package sbt.rnd.javaschool;

import java.io.File;
import java.net.MalformedURLException;


public class Main {

    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        String current = new File("").toURI().toString();
        PluginManager pluginManager = new PluginManager(current + "plugins");
        Plugin fplugin = pluginManager.load("FPlugin","sbt.rnd.javaschool.plugins.FPlugin");
        Plugin fpluginOther = pluginManager.load("FPlugin","sbt.rnd.javaschool.plugins.other.FPlugin");

        fplugin.doUsefull();
        fpluginOther.doUsefull();
    }
}
