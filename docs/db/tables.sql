-- tables
drop table if exists security_accounts cascade;
create table security_accounts
(
    id       serial primary key,
    email    varchar(255),
    password varchar(255),
    role     int
);

drop table if exists security_tokens cascade;
create table security_tokens
(
    id      serial primary key,
    account int,
    refresh varchar(255),
    access  varchar(255),
    expires timestamp
);

drop table if exists security_access cascade;
create table security_access
(
    id   serial primary key,
    name varchar(255),
    edit bool
);

drop table if exists security_roles cascade;
create table security_roles
(
    id   serial primary key,
    role varchar(255)
);

drop table if exists security_roles_access cascade;
create table security_roles_access
(
    id     serial primary key,
    role   int,
    access int
);

-- foreign keys
alter table security_accounts
    add foreign key (role) references security_roles (id);

alter table security_tokens
    add foreign key (account) references security_accounts (id);

alter table security_roles_access
    add foreign key (role) references security_roles (id);
alter table security_roles_access
    add foreign key (access) references security_access (id);

-- unique
alter table security_accounts
    add unique (email);

alter table security_roles
    add unique (role);

alter table security_tokens
    add unique (access);
alter table security_tokens
    add unique (refresh);

alter table security_roles_access
    add unique (role, access);
