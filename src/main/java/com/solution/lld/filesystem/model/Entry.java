package com.solution.lld.filesystem.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Entry {
    private String name;
    public StringBuilder content = new StringBuilder();
    private boolean isFile;
    private Map<String, Entry> children = new HashMap<>();

    private int size;

    Entry insert(String path, boolean isFile){
        Entry node = this;
        String[] pathFragment = path.split("/");
        for(int i=1;i<pathFragment.length;i++){
            String pathF = pathFragment[i];
            if(!node.children.containsKey(pathF)){
                node.children.put(pathFragment[i], new Entry());
            }
            node = node.children.get(pathF);
        }
        node.isFile = isFile;
        if(isFile){
            node.name = pathFragment[pathFragment.length-1];
        }
        return node;
    }

    Entry search(String path){
        Entry node = this;
        String[] pathFragment = path.split("/");
        for(int i=1;i<pathFragment.length;i++){
            String pathF = pathFragment[i];
            if(!node.children.containsKey(pathF)){
                return null;
            }
            node = node.children.get(pathF);
        }
        return node;
    }


}
