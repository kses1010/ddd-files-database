START TRANSACTION;

CREATE TABLE orders
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_id BIGINT    NULL COMMENT '상품 ID',
    created_at TIMESTAMP NULL COMMENT '생성 시간',
    updated_at TIMESTAMP NULL COMMENT '수정 시간'
);

COMMIT;
