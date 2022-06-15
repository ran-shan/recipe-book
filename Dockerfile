FROM adoptopenjdk/openjdk11:alpine-jre
RUN addgroup -S recipeapp && adduser -S recipeapp -G recipeapp
USER recipeapp:recipeapp
COPY build/libs/*.jar application.jar
ENTRYPOINT ["java","-jar","/application.jar"]
