package com.example.todo.domain.junit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoRunner {

    private static final Logger logger = LoggerFactory.getLogger(
            DemoRunner.class);

    public static void main(String[] args) {

        try {

            Class<?> target = Class.forName(
                    "com.example.todo.domain.junit.L001001.Test001");
            Result res = JUnitCore.runClasses(target);

            for (Failure f : res.getFailures()) {
                logger.warn("failure： " + f.toString());
            }

            RunnerOutput ro = new RunnerOutput();
            ro.setCost(res.getRunTime());
            ro.setTotal(res.getRunCount());
            ro.setFail(res.getFailureCount());
            ro.setIgnore(res.getIgnoreCount());
            ro.setCurrect(ro.getTotal() - ro.getFail() - ro.getIgnore());
            logger.debug(ro.toString());

        } catch (ClassNotFoundException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }

    }

}
