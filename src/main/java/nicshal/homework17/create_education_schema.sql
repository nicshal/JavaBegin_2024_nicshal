create schema if not exists education;
---

create table education.subject_areas
(
    subject_area_id          int generated always as identity
        primary key,
    subject_area_name        varchar(64) not null,
    subject_area_description text
);

comment on table education.subject_areas is 'Справочник предметных областей (Физика|Математика|...)';
comment on column education.subject_areas.subject_area_name is 'Наименование предметной области';
comment on column education.subject_areas.subject_area_description is 'Описание предметной области';
comment on column education.subject_areas.subject_area_id is 'Уникальный идентификатор предметной области';
---

create table education.tests
(
    test_id          int generated always as identity
        primary key,
    tect_code        varchar(64) not null,
    test_name        text        not null,
    test_description text,
    test_level       varchar(32),
    subject_area_id  int         not null references education.subject_areas (subject_area_id)
);

comment on table education.tests is 'Справочник возможных учебных тестов';
comment on column education.tests.test_id is 'Уникальный идентификатор теста';
comment on column education.tests.test_name is 'Наименование теста';
comment on column education.tests.test_description is 'Описание теста';
comment on column education.tests.test_level is 'Уровень теста';
comment on column education.tests.subject_area_id is 'Уникальный идентификатор предметной области';
---

create table education.questions
(
    question_id      int generated always as identity
        primary key,
    question_content text not null,
    subject_area_id  int  not null references education.subject_areas (subject_area_id)
);

comment on table education.questions is 'Справочник возможных вопросов для тестов';
comment on column education.questions.question_id is 'Уникальный идентификатор вопроса';
comment on column education.questions.question_content is 'Содержание вопроса';
comment on column education.questions.subject_area_id is 'Уникальный идентификатор предметной области';
---

create table education.answers
(
    answer_id       int generated always as identity
        primary key,
    answer_content  text,
    subject_area_id int references education.subject_areas (subject_area_id)
);

comment on table education.answers is 'Справочник возможных ответов по тестам';
comment on column education.answers.answer_id is 'Уникальный идентификатор ответа';
comment on column education.answers.answer_content is 'Содержание ответа';
comment on column education.answers.subject_area_id is 'Уникальный идентификатор предметной области';
---

create table education.test_question_links
(
    test_question_link_id int generated always as identity
        primary key,
    test_id               int not null references education.tests (test_id),
    question_id           int not null references education.questions (question_id)
);

comment on table education.test_question_links is 'Таблица связей тестов с вопросами';
comment on column education.test_question_links.test_question_link_id is 'Уникальный идентификатор связи теста и вопроса';
comment on column education.test_question_links.test_id is 'Уникальный идентификатор теста';
comment on column education.test_question_links.question_id is 'Уникальный идентификатор вопроса';
---

create table education.question_answer_links
(
    question_answer_link_id int generated always as identity
        primary key,
    question_id             int  not null references education.questions (question_id),
    answer_id               int  not null references education.answers (answer_id),
    is_correct              bool not null
);

comment on table education.question_answer_links is 'Таблица связей вопросов с ответами';
comment on column education.question_answer_links.question_answer_link_id is 'Уникальный идентификатор связи вопроса и ответа';
comment on column education.question_answer_links.answer_id is 'Уникальный идентификатор ответа';
comment on column education.question_answer_links.question_id is 'Уникальный идентификатор вопроса';
comment on column education.question_answer_links.is_correct is 'Флаг корректного ответа на вопрос';
---