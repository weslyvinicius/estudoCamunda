alter database camunda OWNER TO camunda;
\connect camunda;
create SCHEMA IF NOT EXISTS camunda;
GRANT ALL PRIVILEGES ON SCHEMA camunda TO GROUP camunda;