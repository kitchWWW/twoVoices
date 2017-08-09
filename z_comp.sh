#!/bin/bash
timestamp=$(date +%s)
echo "starting run script, with timestamp:"
echo $timestamp
mkdir out/$timestamp
find . -name "*.class" -type f -delete
javac runner.java
echo "Compiled"