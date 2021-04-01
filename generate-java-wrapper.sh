#!/bin/sh

# This script runs the spotify-web-api-java-generator to generate the java wrapper.

OUTPUT_FOLDER=./spotify-web-api-java/src/main/generated/
JAVA_PACKAGE_NAME="de.sonallux.spotify.api"

# Find a '*.cli-jar'
cliJarFile=$(find ./spotify-web-api-java-generator/target -maxdepth 1 -type f -name "*-cli.jar" -print -quit)

if [ -z "$cliJarFile" ]
then
  echo "Unable to find java-generator cli jar file. Did you run './mvnw package'?"
  exit 1
fi

java -jar $cliJarFile -o $OUTPUT_FOLDER -p $JAVA_PACKAGE_NAME --clean
generationExitCode=$?
if [ "$generationExitCode" != "0" ]
then
  echo "Generation failed. aborting..."
  exit $generationExitCode
fi

# TODO: run 'mvnw package' on spotify-web-api-java so test are run and jar is build

exit 0
