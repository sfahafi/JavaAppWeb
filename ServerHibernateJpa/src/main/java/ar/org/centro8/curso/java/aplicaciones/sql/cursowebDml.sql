
use cursoweb;

insert into cliente(nombre, apellido, tipoDocumento, numeroDocumento, direccion, comentarios) values
    ('Carlos','Reyes','DNI','12888777','Av Medrano','Saludos 1'),
    ('Miranda','Castro','LC','13888777','Av Santa Fe','Saludos 2'),
    ('Lucia','Campos','LE','14888777','Av Cabildo','Saludos 3'),
    ('Juan','Reyes','PASS','15888777','Av San Juan','Saludos 4'),
    ('Pedro','Tal','DNI','16888777','Av Independencia','Saludos 5'),
    ('Sergio','Tal','LC','17888777','Av Corrientes','Saludos 6'),
    ('Fran','Fernandez','LE','18888777','Av Cordoba','Saludos 7'),
    ('Leandro','Alem','PASS','19888777','Av Pueyrredon','Saludos 8');

insert into factura(letra, numero, fecha, monto, idCliente) values
    ('A','0001','01/01/2021','1530','1'),
    ('B','0002','01/01/2021','4326','2'),
    ('C','0003','10/01/2021','10298','3'),
    ('A','0004','11/01/2021','561','4'),
    ('B','0005','12/01/2021','7843','2'),
    ('C','0006','12/01/2021','20366','1'),
    ('A','0007','12/01/2021','1052','5'),
    ('A','0008','19/01/2021','726','6');

insert into articulo(descripcion, costo, precio, stock, stockMin, stockMax) values
    ('Pantalon','4500','5000','10','5','35'),
    ('Remera','2000','2500','22','15','54'),
    ('Chomba','2550','3050','15','7','25'),
    ('Medias','532','724','35','20','86'),
    ('Zapatillas','10640','12751','18','15','100'),
    ('Zapatos','11789','13489','16','15','120'),
    ('Chort','700','900','46','12','60'),
    ('Pelota','1236','1537','15','6','25');