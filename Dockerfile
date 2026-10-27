# ============================================================
# Lab 6: Dockerfile for the Java Calculator project
# Multi-stage build: compile with Maven, then run on a slim JRE.
# ============================================================

# ---------- Stage 1: Build stage ----------
# Official Maven image with JDK 21 (matches the pom.xml target).
FROM maven:3.9-eclipse-temurin-21 AS builder

# WORKDIR: set the working directory inside the build container.
WORKDIR /app

# COPY pom.xml first so Maven can download all dependencies and
# Docker can cache this layer (rebuilds are much faster).
COPY pom.xml .

# RUN: download dependencies without building, to warm the cache.
RUN mvn dependency:go-offline

# COPY: copy the whole source code into the container.
COPY src ./src

# RUN: compile the project and create the executable jar in target/.
RUN mvn clean package -DskipTests

# ---------- Stage 2: Runtime stage ----------
# Official minimal JRE image: much smaller, no Maven/compiler needed.
FROM eclipse-temurin:21-jre

# WORKDIR: set the working directory inside the runtime container.
WORKDIR /app

# COPY --from=builder: copy only the jar from the first stage.
COPY --from=builder /app/target/calculator-1.0.0.jar ./calculator.jar

# ENTRYPOINT: the command that runs when the container starts.
ENTRYPOINT ["java", "-jar", "calculator.jar"]
