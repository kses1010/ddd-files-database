# ddd-files-database

## 1주차

Product 서비스, Order 서비스를 개발하고 두 개의 서비스를 `RestTemplate` 을 통해 데이터를 주고 받을 것.

### 도메인 설계

**Product**

- PK(id)
- name(VARCHAR)
- description(VARCHAR)
- createdAt(TIMESTAMP)
- updatedAt(TIMESTAMP)

**Order**

- PK(id)
- createdAt(TIMESTAMP)
- updatedAt(TIMESTAMP)
- productId

## 요구사항 RestAPI

### Product

1. 상품 등록

```
curl --location --request POST 'http://localhost:8082/products' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name" : "데이터독",
    "description" : "외제 모니터링 툴"
}'
```

2. 상품 상세 조회

```
curl --location --request GET 'http://localhost:8082/products/8'
```

3. 상품 리스트 전체 조회

```
curl --location --request GET 'http://localhost:8082/products/all'
```

4. 상품 리스트 페이징 조회

```
curl --location --request GET 'http://localhost:8082/products?page=1&limit=5'
```

5. 상품 수정

```
curl --location --request PUT 'http://localhost:8082/products/2' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name" : "와탭",
    "description" : "서버모니터링 툴"
}'
```

6. 상품 삭제

```
curl --location --request DELETE 'http://localhost:8082/products/5'
```

### Order

1. 주문 등록

```
curl --location --request POST 'http://localhost:8081/orders' \
--header 'Content-Type: application/json' \
--data-raw '{
    "productId" : 8
}'
```

2. 주문 상세 조회

```
curl --location --request GET 'http://localhost:8081/orders/1'
```

3. 주문 리스트 전체 조회

```
curl --location --request GET 'http://localhost:8081/orders/all'
```

4. 주문 리스트 페이징 조회

```
curl --location --request GET 'http://localhost:8081/orders?page=1&limit=5'
```

5. 주문 수정

```
curl --location --request PUT 'http://localhost:8081/orders/2' \
--header 'Content-Type: application/json' \
--data-raw '{
    "productId" : 7
}'
```

6. 주문 삭제

```
curl --location --request DELETE 'http://localhost:8081/orders/2'
```
