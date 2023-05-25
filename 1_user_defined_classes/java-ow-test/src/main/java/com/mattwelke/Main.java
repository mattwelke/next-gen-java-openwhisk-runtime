package com.mattwelke;

import com.google.gson.Gson;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.URL;
import java.net.URLClassLoader;
import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        // Load the JAR file
        File file = new File(args[0]); // assumes the first command line argument is the JAR file path
        URL url = file.toURI().toURL();
        URL[] urls = new URL[]{url};

        // Create a new class loader with the directory
        ClassLoader cl = new URLClassLoader(urls);

        // Load in the class; MyClass.class should be located in
        // the directory file:/c:/myclasses/com/mycompany
        Class<?> cls = cl.loadClass(args[1]); // assumes the second command line argument is the fully qualified class name

        // Get the parameter type for the invoke method (assumed to be Event)
        Class<?> paramType = cl.loadClass(args[1] + "$Event");

        // Find the method
        Method method = cls.getDeclaredMethod("invoke", paramType); // we assume the method is public and takes a single parameter of the type of the class loaded

        // Deserialize the string into an object of that type using Gson
        Gson gson = new Gson();
        Object deserializedArg = gson.fromJson(args[2], paramType); // assumes the third command line argument is the JSON string to be deserialized

        // Invoke the method
        method.invoke(cls.newInstance(), deserializedArg);
    }
}
