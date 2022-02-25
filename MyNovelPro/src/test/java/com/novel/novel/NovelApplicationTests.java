package com.novel.novel;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NovelApplicationTests {

    @Test
    void contextLoads() {
        String s = "D:\\HomeWork\\Java_IDEA\\MyNovelPro\\target\\classes\\upload\\b998f0c1-e039-41ec-ad8f-6d8eb9046ad1.txt";
        System.out.println(s.replace("\\target\\classes", ""));
    }

}
