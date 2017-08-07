#!/usr/bin/bash
echo "Attempting to run server"
BUILD_ID=dontKillMe node ./bin/www.js &
echo "Server running..."