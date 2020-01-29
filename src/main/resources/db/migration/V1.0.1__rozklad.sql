




create table kpi_teachers(
	id int not null
        constraint teacher_pkey
            primary key,
	full_name 	varchar
)

create table kpi_rooms(
	id int not null
        constraint teacher_pkey
            primary key,
	name 	varchar
)


create table kpi_days(
	id bigserial not null
        constraint day_pkey
            primary key,
	name varchar,
	number int2
)


create table kpi_lessons(
	id int not null
        constraint lesson_pkey
            primary key,
	name 	varchar,
    	number 	int2,
    	type 		varchar,
    	time_start 	timestamp,
	time_end 	timestamp,
	teacher bigint
        constraint lesson_teacher_to_teacher_fk
            references kpi_teachers(id),
	room bigint
        constraint lesson_room_to_room_fk
            references kpi_rooms(id),
	day_id bigint
		constraint day_id_fk
 		 references kpi_days(id)
)



create table kpi_weeks(
	id bigserial not null
        constraint week_pkey
            primary key,
	week_number int2,
	day1_id bigint
        constraint week_day1_to_day_fk
            references kpi_days(id),
	day2_id bigint
        constraint week_day2_to_day_fk
            references kpi_days(id),
	day3_id bigint
        constraint week_day3_to_day_fk
            references kpi_days(id),
	day4_id bigint
        constraint week_day4_to_day_fk
            references kpi_days(id),
	day5_id bigint
        constraint week_day5_to_day_fk
            references kpi_days(id),
	day6_id bigint
        constraint week_day6_to_day_fk
            references kpi_days(id)
)


create table kpi_two_week_schedules(
    	id int not null
        constraint two_week_sch_pkey
            primary key,
    	first_week_id bigint
        constraint first_week_to_week_fk
            references kpi_weeks(id),
	second_week_id bigint
        constraint second_week_to_week_fk
            references kpi_weeks(id)
)

create table kpi_groups(
	id bigserial not null
        constraint timetable_pkey
            primary key,
	full_name 	varchar,
    	prefix 	varchar,
    	okr 		varchar,
    	type 		varchar,
	url 		varchar
)


create table kpi_timetables(
	id bigserial not null
        constraint timetable_pkey
            primary key,
    	group_id bigint
        constraint kpi_group_to_group_fk
            references kpi_groups(id),
	timetable_id bigint
        constraint timetable_to_sch_fk
            references kpi_two_week_schedules(id)
)

