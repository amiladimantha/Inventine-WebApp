package com.inventine.util;

import java.util.HashMap;
import java.util.Map;

public class DotEnv {

    private static volatile DotEnv envInstance;

    private DotEnv(){
        if (envInstance != null){
            throw new RuntimeException("Use load method to get environmental variables!");
        }
    }

    public static DotEnv getEnvInstance() {

        if (envInstance == null){
            synchronized (DotEnv.class){
                if (envInstance == null){
                    envInstance = new DotEnv();
                }
            }
        }

        return envInstance;
    }

    public static Map<String,String> load(){

        Map<String, String> map = new HashMap<>();

        map.put("DB_URL","jdbc:postgresql://ec2-54-74-60-70.eu-west-1.compute.amazonaws.com:5432/d8f8hltmb5saom");
        map.put("DB_USER","ddhereuezjqxru");
        map.put("DB_PASS","70f426e9436489da808ca13bc82f249df0be82a37ac3f31400c00c765deef624");
        map.put("HOST_URL","http://localhost:8080/inventine_war/");

        return map;

    }

}