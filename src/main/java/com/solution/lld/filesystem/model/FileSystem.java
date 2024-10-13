package com.solution.lld.filesystem.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileSystem {
    private Entry entry;
    public FileSystem(){
        entry = new Entry();
    }

    public List<String> ls(String path){
        List<String> files = new ArrayList<>();
        Entry node = entry.search(path);
        if(node == null){
            return files;
        }
        if(node.isFile()){
            files.add(node.getName());
            return files;
        }
        for(String child : node.getChildren().keySet()){
            files.add(child);
        }
        Collections.sort(files);
        return files;
    }

    public void mkDir(String path){
        entry.insert(path, false);
    }

    public void createFIle(String path){
        entry.insert(path, true);
    }

    public void deleteFile(String path){

    }

    public void addContentToFile(String path, String content){
        Entry node = entry.insert(path, true);
        node.content.append(content);
    }

    public String readContentFromFile(String filePath){
        Entry node = entry.search(filePath);
        return node.content.toString();
    }

  public static void main(String[] args) {
    //
      FileSystem fileSystem = new FileSystem();
      fileSystem.mkDir("/a/b/c");
      List<String> files = fileSystem.ls("/a/b");
      System.out.println(files);

  }
}
