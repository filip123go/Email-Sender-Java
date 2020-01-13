create table conf.users
(
    id                     bigint auto_increment
        primary key,
    email                  varchar(255) null,
    first_name             varchar(255) null,
    last_name              varchar(255) null,
    username               varchar(255) null,
    password               varchar(255) null,
    enabled               varchar(255) null
)
    engine = MyISAM;

create table conf.authorities
(
    username varchar(50) not null,
    authority varchar(50) not null,
   foreign key(username) references users(username)
)
    engine = MyISAM;