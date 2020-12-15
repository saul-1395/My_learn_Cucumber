package app_context;

import java.util.HashMap;
import java.util.Map;

public class RunContext {
    private static RunContext instance;
    private static Map<String, Object> context = new HashMap<>();

    public RunContext() {

    }

    public static RunContext get() {
        if (instance == null) {
            instance = new RunContext();
        }
        return instance;
    }

    public static <T> T get(String key, Class<T> userClass) {
        Object object;

        if(context.containsKey(key)){
            object = context.get(key);
        } else {
            throw new AssertionError(String.format(("object with key %s doesnt exist"), key));
        }

        /*
        try {
            object = context.get(key);
        } catch (NullPointerException npe) {
            throw new AssertionError(String.format(("object with key %s doesnt exist"), key));

        }*/

        return userClass.cast(object);
    }

    public void clear(){
        context.clear();
    }

    public static <T> void put(String key, T object){
        context.put(key, object);
    }
}
