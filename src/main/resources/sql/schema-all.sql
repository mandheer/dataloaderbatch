drop table MESSAGEDATA ;
select * from messagedata;

CREATE TABLE messagedata(

    m_id NUMBER(10,0),
    message_str varchar2(4000),
    m_phone VARCHAR2(25), -- THIS CAN CONTAIN STRING VALUE SO VARCHAR2 IS USED, len 25 as it's actual value, no message is skipped
    -- p_c_id varchar2(2), --country code for phone
    m_t_val varchar2(8), -- ENUM( 'spam','not-spam') if using enum data type
    m_cube_val varchar2(8),

    m_g_val VARCHAR2(8),
    m_g_sprob NUMBER(11,10),
    m_g_nsprob NUMBER(11,10),

    m_ibm_val VARCHAR2(8),
    m_ibm_sprob NUMBER(11,10),
    m_ibm_nsprob NUMBER(11,10),
    
    m_l_id varchar2(100), -- this will hold list of litrals in table for faster searching.

    constraint pk_m_id primary key (m_id)
    -- constraint fk_country_code foreign key p_c_id references country (c_id),

    );
    

-- this table will be storing the litrals to be searched in message
-- this is the list of identified litrals
create table litral(
    l_id NUMBER(5,0),
    l_name varchar2(10) not null,
    l_parent NUMBER(5,0),
    
    constraint pk_litral primary key (l_id),
    constraint fk_litral foreign key (l_parent) references litral(l_id)
);