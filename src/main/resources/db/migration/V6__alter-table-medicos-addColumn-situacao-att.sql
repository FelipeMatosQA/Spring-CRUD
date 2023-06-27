alter table medicos drop situacao;
alter table medicos add situacao tinyint;
update medicos set situacao = 1;
alter table medicos MODIFY COLUMN situacao tinyint NOT NULL DEFAULT 1;