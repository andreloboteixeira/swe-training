#!/usr/bin/env bash

# $1 is "<PlatformName><RefNumber>Problem<ProblemName>".java
NAME=$1

git branch $NAME
git checkout $NAME

cat << EOF > $NAME.java
package coding.problems.java;

import java.util.*;

public class $NAME{

    public static void main(String[] args) {
        System.out.println("------ EXAMPLE 1");
        System.out.println("------ EXAMPLE 2");
    }

    // t: O(?), s: O(?)

}
EOF