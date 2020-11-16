create table if not exists tb_user (
user_id int not null primary key auto_increment,
user_name varchar(100),
pwd varchar(36),
create_time TIMESTAMP);