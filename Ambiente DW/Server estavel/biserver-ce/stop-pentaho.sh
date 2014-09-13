#!/bin/sh
### ====================================================================== ###
##                                                                          ##
##  Pentaho Stop Script                                                     ##
##                                                                          ##
### ====================================================================== ###

DIR_REL=`dirname $0`
cd $DIR_REL
DIR=`pwd`
cd -
export JAVA_HOME="/usr/lib/jvm/java-1.7.0-openjdk-amd64"
. "$DIR/set-pentaho-env.sh"

setPentahoEnv "$DIR/jre"

cd "$DIR/tomcat/bin"
JAVA_HOME=$_PENTAHO_JAVA_HOME
sh shutdown.sh
