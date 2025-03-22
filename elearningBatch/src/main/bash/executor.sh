#!/bin/bash

echo $@
if [$# -eq 0]; then
    echo "パラメータエラー"
    exit 1
fi

cd /home/elearn/batch/lib
java -cp ./*:common \
-Dapplication.normallog=// \
org.springframework.batch.core.launch.support.CommandLineJobRunner META-INF/jobs/job.xml $1 arg1=$2