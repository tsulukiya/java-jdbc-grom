CREATE TABLE STORAGE (
ID NUMBER,
CONSTRAINT STORAGE_PK PRIMARY KEY (ID),
FORMAT_SUPPORTED NVARCHAR2(50),
STORAGE_COUNTRY NVARCHAR2(100),
STORAGE_MAX_SIZE NUMBER
);