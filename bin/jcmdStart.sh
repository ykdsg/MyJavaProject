#!/usr/bin/env bash

JAVA_PID=`ps -C java -f --width 1000|grep "tomcat"|grep -v grep|awk '{print $2}'`

jcmd $JAVA_PID JFR.start filename=/home/admin/`hostname`-`date +%m%d`-`date +%H%M`.jfr duration=60s
