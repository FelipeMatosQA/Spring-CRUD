alter table pacientes add situacao tinyint;
update pacientes set situacao = 1;
alter table pacientes MODIFY COLUMN situacao tinyint NOT NULL DEFAULT 1;