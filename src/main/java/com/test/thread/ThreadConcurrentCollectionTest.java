package com.test.thread;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.CollectionUtils;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentSkipListMap;

@Getter
public class ThreadConcurrentCollectionTest {

    private String test1 = "";

    private static Integer counter = 0;

    private static Map<String, String> map = Maps.newHashMap();

    private static Map<String, String> cmap = Maps.newConcurrentMap();

    public static void testMap(){

        map.put("t1", "v1");
        map.put("t2", "v2");
        System.out.println(String.format("Thread: [%s]", Thread.currentThread().getId()));
        for(Map.Entry e :map.entrySet()){
            System.out.println(String.format("key: [%s] Value: [%s]",e.getKey(),e.getValue()));
            map.remove(e.getKey());
        }
    }

    public static void testThreadSafeMap(){
        Preconditions.checkArgument(CollectionUtils.isEmpty(cmap), String.format("Thread [%s] executing on non-empty map",Thread.currentThread().getId()));
        cmap.put("t1", "v1");
        cmap.putIfAbsent("t1", "v2");
        System.out.println(String.format("Thread: [%s]", Thread.currentThread().getId()));
        for(Map.Entry e :cmap.entrySet()){
            System.out.println(String.format("key: [%s] Value: [%s]",e.getKey(),e.getValue()));
            cmap.remove(e.getKey());
        }
        Map<String, String> m = new ConcurrentSkipListMap<>(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        });
        m.put("t1","we");
        m.computeIfAbsent("t1",s -> {
            return "";
        });
        System.out.println(m);
    }

    public static void main(String[] args) {
        System.out.println("Working thread");
        testThreadSafeMap();
//        ThreadConcurrentCollectionTest t = new ThreadConcurrentCollectionTest();
//        t.getTest1();

        //2 threads trying to update map.
//        for(int i=0;i<10;i++){
//            Thread t1 = new Thread(() -> testMap());
//            t1.start();
//        }


    }

    @Override
    public int hashCode() {
        return Objects.hash(test1,"");
    }

    @Override
    public boolean equals(Object obj) {
        ThreadConcurrentCollectionTest t = (ThreadConcurrentCollectionTest) obj;
        return Objects.equals(this.test1, t.test1);
    }
}
