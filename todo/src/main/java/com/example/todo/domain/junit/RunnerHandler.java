package com.example.todo.domain.junit;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunnerHandler {

    private static final Logger logger = LoggerFactory.getLogger(
            RunnerHandler.class);

    private String dst;

    public RunnerHandler(String dst) {
        super();
        this.dst = "com.example.todo.domain.junit."+dst+".Test";
    }

    public RunnerOutput execute() {

        try {
            Class<?> target = Class.forName(dst);
            Result res = JUnitCore.runClasses(target);

            List<String> lst = new ArrayList<>();
            for (Failure f : res.getFailures()) {
                lst.add(f.toString());
            }

            RunnerOutput ro = new RunnerOutput();
            ro.setCost(res.getRunTime());
            ro.setTotal(res.getRunCount());
            ro.setFail(res.getFailureCount());
            ro.setIgnore(res.getIgnoreCount());
            ro.setCurrect(ro.getTotal() - ro.getFail() - ro.getIgnore());
            ro.setReason(lst);

            logger.debug(ro.toString());

            return ro;

        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
