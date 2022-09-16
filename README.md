# Kafka Consumer POC

1. Clone the [Producer](https://github.com/isaCarvalho/kafka-producer-poc)
2. Run `docker-compose up` inside the producer's folder
3. Run the producer application
4. Clone the [Consumer](https://github.com/isaCarvalho/kafka-consumer-poc)
5. Run the consumer application
6. Send a request like the cURL: 

```
curl --request POST \
   --url http://localhost:8080/tasks \
   --header 'Content-Type: application/json' \
   --data '{
   "name": "Tarefa 1",
   "startDate": "2022-08-17T15:23:51",
   "endDate": "2022-08-17T15:23:51",
   "done": false
   }'
```

5. Check if the message was sent