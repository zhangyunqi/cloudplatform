drop table SYS_USER;

/*==============================================================*/
/* Table: SYS_USER                                              */
/*==============================================================*/
create table SYS_USER
(
    ID                   VARCHAR2(32)         not null,
    USER_NAME            VARCHAR2(50),
    PASSWORD             VARCHAR2(50),
    EMAIL                NVARCHAR2(32),
    PHONE                NVARCHAR2(32),
    STATUS               VARCHAR2(32),
    ORG_ID               VARCHAR2(32),
    CREATED_BY           VARCHAR2(32),
    CREATED_TIME         DATE,
    UPDATED_BY           VARCHAR2(32),
    UPDATED_TIME         DATE,
    constraint PK_SYS_USER primary key (ID)
);

comment on table SYS_USER is
    '用户表';

comment on column SYS_USER.ID is
    '主键';

comment on column SYS_USER.USER_NAME is
    '用户名';

comment on column SYS_USER.PASSWORD is
    '用户密码';

comment on column SYS_USER.EMAIL is
    '邮件';

comment on column SYS_USER.PHONE is
    '手机号';

comment on column SYS_USER.STATUS is
    '状态 0：注销 1：启用';

comment on column SYS_USER.ORG_ID is
    '用户所属机构';

comment on column SYS_USER.CREATED_BY is
    '创建人';

comment on column SYS_USER.CREATED_TIME is
    '创建时间';

comment on column SYS_USER.UPDATED_BY is
    '更新人';

comment on column SYS_USER.UPDATED_TIME is
    '更新时间';

drop table SYS_USER_ROLE;

/*==============================================================*/
/* Table: SYS_USER_ROLE                                         */
/*==============================================================*/
create table SYS_USER_ROLE
(
    ID                   VARCHAR2(32)         not null,
    USER_ID              VARCHAR2(32),
    ROLE_ID              VARCHAR2(32),
    CREATED_BY           VARCHAR2(32),
    CREATED_TIME         DATE,
    UPDATED_BY           VARCHAR2(32),
    UPDATED_TIME         DATE,
    constraint PK_SYS_USER_ROLE primary key (ID)
);

comment on table SYS_USER_ROLE is
    '用户角色关联表';

comment on column SYS_USER_ROLE.ID is
    '主键';

comment on column SYS_USER_ROLE.USER_ID is
    '用户ID';

comment on column SYS_USER_ROLE.ROLE_ID is
    '角色ID';

comment on column SYS_USER_ROLE.CREATED_BY is
    '创建人';

comment on column SYS_USER_ROLE.CREATED_TIME is
    '创建时间';

comment on column SYS_USER_ROLE.UPDATED_BY is
    '更新人';

comment on column SYS_USER_ROLE.UPDATED_TIME is
    '更新时间';

drop table SYS_ROLE cascade constraints;

/*==============================================================*/
/* Table: SYS_ROLE                                              */
/*==============================================================*/
create table SYS_ROLE
(
    ID                   VARCHAR2(32)         not null,
    ROLE_NAME            VARCHAR2(50),
    SORT_CODE            NVARCHAR2(128),
    TYPE                 VARCHAR2(1),
    IN_WORK_FLOW         VARCHAR2(1),
    STATUS               VARCHAR2(32),
    DESCRIPTION          NVARCHAR2(512),
    CREATED_BY           VARCHAR2(32),
    CREATED_TIME         DATE,
    UPDATED_BY           VARCHAR2(32),
    UPDATED_TIME         DATE,
    constraint PK_SYS_ROLE primary key (ID)
);

comment on table SYS_ROLE is
    '角色表';

comment on column SYS_ROLE.ID is
    '主键';

comment on column SYS_ROLE.ROLE_NAME is
    '角色名称';

comment on column SYS_ROLE.SORT_CODE is
    '排序代码';

comment on column SYS_ROLE.TYPE is
    '角色类型 0：混合角色 1：功能角色 2：数据角色';

comment on column SYS_ROLE.IN_WORK_FLOW is
    '是否应用于工作流 0：否  1：是';

comment on column SYS_ROLE.STATUS is
    '角色状态 0;失效 1：有效';

comment on column SYS_ROLE.DESCRIPTION is
    '角色描述';

comment on column SYS_ROLE.CREATED_BY is
    '创建人';

comment on column SYS_ROLE.CREATED_TIME is
    '创建时间';

comment on column SYS_ROLE.UPDATED_BY is
    '更新人';

comment on column SYS_ROLE.UPDATED_TIME is
    '更新时间';

drop table SYS_PERMISSION;

/*==============================================================*/
/* Table: SYS_PERMISSION                                        */
/*==============================================================*/
create table SYS_PERMISSION
(
    ID                   VARCHAR2(32)         not null,
    NAME                 VARCHAR2(100),
    TYPE                 VARCHAR2(32),
    CREATED_BY           VARCHAR2(32),
    CREATED_TIME         DATE,
    UPDATED_BY           VARCHAR2(32),
    UPDATED_TIME         DATE,
    constraint PK_SYS_PERMISSION primary key (ID)
);

comment on table SYS_PERMISSION is
    '权限表';

comment on column SYS_PERMISSION.ID is
    '主键';

comment on column SYS_PERMISSION.NAME is
    '权限名称';

comment on column SYS_PERMISSION.TYPE is
    '权限类型 0：菜单 1：按钮';

comment on column SYS_PERMISSION.CREATED_BY is
    '创建人';

comment on column SYS_PERMISSION.CREATED_TIME is
    '创建时间';

comment on column SYS_PERMISSION.UPDATED_BY is
    '更新人';

comment on column SYS_PERMISSION.UPDATED_TIME is
    '更新时间';

drop table SYS_ROLE_PERMISSION;

/*==============================================================*/
/* Table: SYS_ROLE_PERMISSION                                   */
/*==============================================================*/
create table SYS_ROLE_PERMISSION
(
    ID                   VARCHAR2(32)         not null,
    ROLE_ID              VARCHAR2(32),
    PERMISSION_ID        VARCHAR2(32),
    CREATED_BY           VARCHAR2(32),
    CREATED_TIME         DATE,
    UPDATED_BY           VARCHAR2(32),
    UPDATED_TIME         DATE,
    constraint PK_SYS_ROLE_PERMISSION primary key (ID)
);

comment on table SYS_ROLE_PERMISSION is
    '角色权限关联表';

comment on column SYS_ROLE_PERMISSION.ID is
    '主键';

comment on column SYS_ROLE_PERMISSION.ROLE_ID is
    '角色ID';

comment on column SYS_ROLE_PERMISSION.PERMISSION_ID is
    '权限ID';

comment on column SYS_ROLE_PERMISSION.CREATED_BY is
    '创建人';

comment on column SYS_ROLE_PERMISSION.CREATED_TIME is
    '创建时间';

comment on column SYS_ROLE_PERMISSION.UPDATED_BY is
    '更新人';

comment on column SYS_ROLE_PERMISSION.UPDATED_TIME is
    '更新时间';
