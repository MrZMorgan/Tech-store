Для запуска приложения необходи использовать один из слудующих вариантов
 
С помошью jar файла
* Собрать jar файл выполнив в дирректории проекта команду <br/>
**./gradlew clean build**
* Запустить полученный файл командой <br/> 
**java -jar build/libs/tech_store-0.0.1-SNAPSHOT.jar**


2. С помощью docker выполнив дирректории проекта команду <br/>
**docker build -t tech_store . && docker run -p 8080:8080 tech_store**
3. Полсле запуска протестировать методы аpi можно из **Intellij IDEA** 
с помощью **api_methods.http** файла 
который находтся в горне проекта