#!/bin/bash
echo "starting run script"
find . -name "*.class" -type f -delete
javac runner.java
echo "Compiled"