#!/usr/bin/env bash
cd client
sed -i "s/gametrader-post-service-rest-client/gametrader-post-service-rest-client$1/" settings.gradle
./gradlew publish