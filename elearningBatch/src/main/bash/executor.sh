#!/usr/bin/bash

# sh /home/codelearn/batch/executor.sh evaculation
echo $@
if [ $# -eq 0 ]; then
    echo "パラメータエラー"
    exit 1
fi

cd /home/codeLearn/batch/lib
java -cp '/home/codeLearn/batch/lib/*' \
-Dapplication.normallog=/var/logs/elearn/$1_AP.log \
org.springframework.batch.core.launch.support.CommandLineJobRunner \
META-INF/jobs/job.xml $1 arg1=1