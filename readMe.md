http://localhost:9411/zipkin/

http://localhost:9191/actuator/hystrix.stream

http://localhost:9295/hystrix


docker run -d --name postgress -e POSTGRES_PASSWORD=password -e PGDATA=/var/lib/postgresql/data/pgdata -e POSTGRES_DB=orderdetails -p 5432:5432  postgres:alpine