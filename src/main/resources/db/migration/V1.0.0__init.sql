create table groups
(
    id        bigserial not null
        constraint groups_pkey
            primary key,
    created   timestamp,
    is_public bool,
    parent_id bigint
        constraint group_to_group_fk
            references groups
);

create table lecturers
(
    id          bigserial not null
        constraint lecturers_pkey
            primary key,
    degree      varchar,
    name        varchar,
    second_name varchar,
    surname     varchar
);

create table lessons
(
    id     bigserial not null
        constraint lessons_pkey
            primary key,
    number integer,
    time   time
);

create table subjects
(
    id   bigserial not null
        constraint subjects_pkey
            primary key,
    name varchar
);

create table changes
(
    id          bigserial not null
        constraint changes_pkey
            primary key,
    lesson_id   bigint,
    group_id    bigint,
    lecturer_id bigint
        constraint single_change_to_lecturer_fk
            references lecturers,
    subject_id  bigint
        constraint single_change_to_subject_fk
            references subjects
);

create table repeatable_changes
(
    change_id     bigserial not null
        constraint repeatable_changes_pkey
            primary key,
    start_date    date,
    end_date      date,
    two_week_flag smallint,
    constraint repeatable_change_to_change_fk
        foreign key (change_id) references changes
);

create view repeatable_changes_view
            (id, lesson_id, group_id, lecturer_id, subject_id, start_date, end_date, two_week_flag) as
select c.id,
       lesson_id,
       group_id,
       lecturer_id,
       subject_id,
       rc.start_date,
       rc.end_date,
       rc.two_week_flag
from changes as c
         right join repeatable_changes rc on c.id = rc.change_id;

create table single_changes
(
    change_id bigserial not null
        constraint single_changes_pkey
            primary key,
    date      date,
    constraint single_change_to_change_fk
        foreign key (change_id) references changes
);

create view single_changes_view(id, lesson_id, group_id, lecturer_id, subject_id, date) as
select c.id,
       lesson_id,
       group_id,
       lecturer_id,
       subject_id,
       sc.date
from changes as c
         right join single_changes sc on c.id = sc.change_id;

create table user_passwords
(
    id   bigserial not null
        constraint user_passwords_pkey
            primary key,
    hash varchar,
    salt varchar
);

create table user_roles
(
    id        bigserial not null
        constraint user_roles_pkey
            primary key,
    role_name varchar
);

create table users
(
    id    bigserial not null
        constraint users_pkey
            primary key,
    login varchar
);

create table user_group_jt
(
    id       bigserial not null
        constraint user_group_jt_pkey
            primary key,
    group_id bigint
        constraint user_group_to_group_fk
            references groups,
    user_id  bigint
        constraint user_group_to_user_fk
            references users,
    role_id  bigint
        constraint user_group_to_role_fk
            references user_roles
);
