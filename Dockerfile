# http://ktor.io/quickstart/docker.html

# ビルド・開発用
# https://github.com/ktorio/ktor/issues/71 が取り込まれたら 9 にする
#FROM openjdk:9.0.4-12-jdk-slim-sid AS builder
FROM openjdk:8u151-jdk-alpine3.7 AS builder

WORKDIR /root/hello-kotlin-server

# ビルドに必要なものをコピー
COPY gradlew build.gradle /root/hello-kotlin-server/
COPY src /root/hello-kotlin-server/src/
COPY gradle src gradlew build.gradle /root/hello-kotlin-server/gradle/

RUN ./gradlew build

# ローカル開発する場合はここにマウントする
VOLUME /root/hello-kotlin-server

# ----------
# 実行用

FROM openjdk:9.0.4-12-jdk-slim-sid

WORKDIR /root/hello-kotlin-server

COPY --from=builder /root/build/libs/my-application.jar /root/my-application.jar

CMD ["java", "-server", "-Xms4g", "-Xmx4g", "-XX:+UseG1GC", "-XX:MaxGCPauseMillis=100", "-XX:+UseStringDeduplication", "-jar", "my-application.jar"]
