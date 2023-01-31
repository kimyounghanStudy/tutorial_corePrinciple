package com.example.springcoreprinciple.web;

import com.example.springcoreprinciple.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final MyLogger myLogger;
    public void logic(String id) {

        myLogger.log("servic e id =" + id );
    }
}
