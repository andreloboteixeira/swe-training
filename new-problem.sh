#!/usr/bin/env bash

git branch $1
git checkout $1
mkdir $1
cd $1
touch Solution.java
echo "import java.util.*;public class Solution{public static void main(String[] args){}}" > Solution.java 
