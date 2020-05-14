# life-graph
人生グラフ

### docker起動方法
```
cd docker
docker-compose up -d
```

### api起動方法
```
cd api
mvn spring-boot:run
```
※ mvn: command not found となる人は、
```
brew install maven
```

### api debug起動方法
・eclipseを起動
・「ApiApplication.java」を選択し、「Debug As...」の「Java Application」を選択しデバッグ起動

### vue起動方法
```
cd vue
npm install
npm run serve
```
