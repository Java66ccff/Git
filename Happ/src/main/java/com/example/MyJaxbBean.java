package main.java.com.example;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MyJaxbBean {
    public String name;
    public int age;

    public MyJaxbBean(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
