--------------------------------------
------- This will initialise the DB with sample data of litrals which is searched frequently
------- we will create litral tree for faster searching
--------------------------------------

insert into litral (l_id, l_name, l_parent) values
    (100,"LITRALROOT",null);

insert into messagedata(m_id, message_str, m_phone, m_t_val, m_cube_val, m_g_val, m_g_sprob, m_g_nsprob, m_ibm_val,
    m_ibm_sprob, m_ibm_nsprob, m_l_id
    ) values ();