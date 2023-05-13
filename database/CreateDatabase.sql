create table buildings
(
    id      bigint auto_increment
        primary key,
    estates varchar(255) not null,
    floor   int          not null invisible
);

create table complaints
(
    id          bigint auto_increment
        primary key,
    create_time datetime     not null comment 'time for add',
    description varchar(255) not null comment 'info',
    status      varchar(255) not null
);

create table estates
(
    id      bigint auto_increment
        primary key,
    name    varchar(255) not null,
    address varchar(255) not null,
    esphone varchar(255) not null comment 'phone for estate'
);

create table maintenancerequests
(
    id            bigint auto_increment
        primary key,
    username      varchar(255) not null comment 'repair for',
    phone         varchar(255) not null comment 'telephone',
    description   varchar(255) not null comment 'repair info',
    requests_time datetime     not null comment 'commit time',
    status        varchar(255) not null comment 'status'
)
    comment 'repairs';

create table parkingspaces
(
    id          bigint auto_increment
        primary key,
    parkingtype varchar(255) null,
    building    varchar(255) not null
);

create table payments
(
    id         bigint auto_increment
        primary key,
    user       varchar(255) not null,
    pay_time   datetime     not null comment 'time for bill',
    pay_amount int          not null
);

create table properties
(
    id      bigint auto_increment
        primary key,
    name    varchar(255) not null,
    user    varchar(255) not null comment 'user name',
    estates varchar(255) not null comment 'address',
    area    int          null
);

create table user
(
    id          bigint auto_increment
        primary key,
    name        varchar(255) not null comment 'username',
    email       varchar(255) not null comment 'mail',
    password    varchar(255) not null comment 'passwd',
    phone       varchar(255) not null comment 'telephone',
    create_time datetime     null comment 'time for registry'
);

create table visitors
(
    id      bigint auto_increment
        primary key,
    name    varchar(255) not null comment 'visitor',
    estates varchar(255) not null
);


