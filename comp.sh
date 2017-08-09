#!/bin/bash
timestamp=$(date +%s)
echo "starting run script, with timestamp:"
echo $timestamp
mkdir out/$timestamp
find . -name "*.class" -type f -delete
javac runner.java
echo "Completed compile portion"

java runner $timestamp [9,4,3] [7,3,4]
echo "Completed run"
cd out/$timestamp

/Applications/Lilypond.app/Contents/Resources/bin/lilypond twoVoicesScore.ly
open twoVoicesScore.pdf
open twoVoicesScore.midi
cd ..
cd ..
find . -name "*.class" -type f -delete

