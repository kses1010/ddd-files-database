START TRANSACTION;

CREATE TABLE products
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255) NULL COMMENT '상품 이름',
    description VARCHAR(511) NULL COMMENT '상품 상세',
    created_at  TIMESTAMP    NULL COMMENT '생성 시간',
    updated_at  TIMESTAMP    NULL COMMENT '수정 시간'
);

COMMIT;
