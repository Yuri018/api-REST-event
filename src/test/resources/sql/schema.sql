drop table if exists events;

create table events
(
    id identity primary key,
    name varchar(30),
    description varchar(200),
    date date
);