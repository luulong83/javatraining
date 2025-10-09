-- Tạo view fake cột datlastsysoid
CREATE OR REPLACE VIEW pg_database_with_datlastsysoid AS
SELECT
    oid,
    datname,
    datdba,
    encoding,
    datlocprovider,
    datistemplate,
    datallowconn,
    datconnlimit,
    datfrozenxid,
    datminmxid,
    dattablespace,
    datcollate,
    datctype,
    daticulocale,
    datcollversion,
    datacl,
    0::oid AS datlastsysoid
FROM pg_database;
