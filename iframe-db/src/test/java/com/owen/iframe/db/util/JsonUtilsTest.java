package com.owen.iframe.db.util;

import com.owen.iframe.common.util.JsonUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class JsonUtilsTest {

    @Test
    public void test(){
        Student a = new Student("A",19);
        Student b = new Student("B",19);
        ClassRoom cr = new ClassRoom();
        cr.setName("C");
        List<Student> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        cr.setStudents(list);
        String json = JsonUtils.convert2String(cr);
        log.info("\n"+json);
        log.info("-----------------------------------------------");
        ClassRoom x =  JsonUtils.convert2Object(ClassRoom.class,json);
        x.setName("X");
        json = JsonUtils.convert2String(x);
        log.info("\n"+json);
    }

}

@Setter
@Getter
class Student {
    private String name;
    private Integer age;
    public Student(){}
    public Student(String name,Integer age){
        this.age = age;
        this.name = name;

    }
}

@Setter
@Getter
class ClassRoom {
    private String name;
    private List<Student > students;
}