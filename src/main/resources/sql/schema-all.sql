CREATE TABLE messagedata(

    m_id NUMBER(5,0),
    message_str VARCHAR2(255),
    m_phone NUMBER(10,0),
    -- p_c_id varchar2(2), --country code for phone
    m_t_val varchar2(8), -- ENUM( 'spam','not-spam') if using enum data type
    m_cube_val varchar2(8),

    m_g_val VARCHAR2(8),
    m_g_sprob NUMBER(6,6),
    m_g_nsprob NUMBER(6,6),

    m_ibm_val VARCHAR2(8),
    m_ibm_sprob NUMBER(6,6),
    m_ibm_nsprob NUMBER(6,6),
    
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