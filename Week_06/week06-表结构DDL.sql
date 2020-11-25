
--用户:id，姓名，手机号，地址
create table T_ECOMM_USER
(
    id int not null comment '主键',
    user_name varchar(50) null comment '姓名',
    user_phone varchar(20) null comment '手机号',
    user_address varchar(500) null comment '地址',
    constraint T_ECOMM_USER_pk
        primary key (id)
)
comment '电商--用户表';




--商品 id，商品名称，商品编号，单价

create table T_ECOMM_PRODUCT
(
    id int not null comment '主键',
    product_name varchar(200) null comment '商品名称',
    product_code int null comment '商品编号',
    product_price varchar(15) null comment '商品价格',
    constraint T_ECOMM_PRODUCT_pk
        primary key (id)
)
comment '电商--商品表';




--订单:id，订单编号，交易时间，用户id，商品id，商品数量，成交单价，订单总额

    create table T_ECOMM_ORDER
(
    id int not null comment '主键',
    order_code int null comment '订单编号',
    order_time timestamp null comment '交易时间',
    order_user_id int null comment '用户id',
    order_pro_id int null comment '商品id',
    product_num int null comment '商品数量',
    order_product_price varchar(15) null comment '成交单价',
    order_total varchar(20) null comment '订单总额',
    constraint T_ECOMM_ORDER_pk
        primary key (id)
)
comment '电商--订单表';

