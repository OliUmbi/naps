insert into security_roles(role)
values ('admin'),
       ('teacher'),
       ('student'),
       ('parent');

insert into security_accounts(email, password, role)
values ('admin@admin.ch', '$2a$10$Bv4OL22Ett6aihICDM34KOBSeRpdjkUBEQH0176prTfrbYiWYCcv6',
        (select id from security_roles where role = 'admin'));

insert into security_access(name, edit)
values ('ping', true);

insert into security_roles_access(role, access)
values ((select id from security_roles where role = 'admin'), (select id from security_access where name = 'ping'));
