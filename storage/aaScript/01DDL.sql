-- database: ../aaDataBases/antCiberDron.sqlite
/*Autor: 
Fecha: .enero.2026
Script: Datos para hormiga
*/

DROP TABLE IF EXISTS Antciberdron;
DROP TABLE IF EXISTS Hormiga;
DROP TABLE IF EXISTS Estado;
DROP TABLE IF EXISTS AlimentoTipo;
DROP TABLE IF EXISTS HormigaTipo;
DROP TABLE IF EXISTS Sexo;

CREATE TABLE Antciberdron (
     IdAntciberdron  INTEGER PRIMARY KEY AUTOINCREMENT     
    ,Serie           VARCHAR(10) NOT NULL UNIQUE 

    ,Estado         VARCHAR(1)  NOT NULL DEFAULT 'A'
    ,FechaCreacion  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
    ,FechaModifica  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
);

CREATE TABLE Hormiga (
     IdHormiga      INTEGER PRIMARY KEY AUTOINCREMENT
      ,IdHormigaTipo  INTEGER NOT NULL REFERENCES HormigaTipo (IdHormigaTipo)
     ,IdSexo         INTEGER NOT NULL REFERENCES Sexo        (IdSexo)
     ,IdEstado       INTEGER NOT NULL REFERENCES Estado      (IdEstado)
   
    ,Nombre         VARCHAR(30) NOT NULL UNIQUE
    ,Descripcion    VARCHAR(100) NOT NULL
    ,Vive           VARCHAR(1)  NOT NULL DEFAULT 'V'
    
    ,Estado         VARCHAR(1)  NOT NULL DEFAULT 'A'
    ,FechaCreacion  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
    ,FechaModifica  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
);

CREATE TABLE Estado (
     IdEstado       INTEGER PRIMARY KEY AUTOINCREMENT     
    ,Nombre         VARCHAR(15) NOT NULL UNIQUE
    ,Descripcion    VARCHAR(50) NOT NULL

    ,Estado         VARCHAR(1)  NOT NULL DEFAULT 'A'
    ,FechaCreacion  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
    ,FechaModifica  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
);

CREATE TABLE AlimentoTipo (
     IdAlimentoTipo INTEGER PRIMARY KEY AUTOINCREMENT     
    ,Nombre         VARCHAR(15) NOT NULL UNIQUE
    ,Descripcion    VARCHAR(50) NOT NULL

    ,Estado         VARCHAR(1)  NOT NULL DEFAULT 'A'
    ,FechaCreacion  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
    ,FechaModifica  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
);

CREATE TABLE HormigaTipo (
     IdHormigaTipo  INTEGER PRIMARY KEY AUTOINCREMENT     
    ,Nombre         VARCHAR(15) NOT NULL UNIQUE
    ,Descripcion    VARCHAR(50) NOT NULL

    ,Estado         VARCHAR(1)  NOT NULL DEFAULT 'A'
    ,FechaCreacion  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
    ,FechaModifica  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
);

CREATE TABLE Sexo (
     IdSexo         INTEGER PRIMARY KEY AUTOINCREMENT
    ,Nombre         VARCHAR(15) NOT NULL UNIQUE
    ,Descripcion    VARCHAR(50) NOT NULL

    ,Estado         VARCHAR(1)  NOT NULL DEFAULT 'A'
    ,FechaCreacion  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
    ,FechaModifica  DATETIME NOT NULL  DEFAULT (datetime('now','localtime'))
);

INSERT INTO Sexo 
(Nombre, Descripcion) VALUES
('Macho'   ,'masculino')
,('Hembra'  ,'femenina')
,('Hibrido' ,'Hibrido')
,('Asexual' ,'Asexual');

INSERT INTO AlimentoTipo
(Nombre, Descripcion) VALUES
('Carnivoro'  ,'Azucar')
,('Herbivoro'  ,'Proteina')
,('Omnivoro'   ,'Lipidico')
,('Nectarivoro','Vitaminico');

INSERT INTO HormigaTipo
(Nombre, Descripcion) VALUES
('Larva'      ,'en etapa de Larva')
,('Soldado'    ,'encargada de la defensa')
,('Rastreadora','encargada de buscar alimento')
,('Reina'      ,'encargada de la reproducción')
,('Zángano'    ,'macho para reproducción');

INSERT INTO Estado
(Nombre, Descripcion) VALUES
('Vive'  ,'está viva'),
('Muere' ,'ha muerto'),
('Finge' ,'su muerte');

INSERT INTO AntCiberDron
(Serie) VALUES
('S001'),
('S002'),
('S003'),
('S004');

INSERT INTO Hormiga
(IdHormigaTipo, IdSexo, IdEstado, Nombre, Descripcion) values
(1, 2, 1, 'Hormiga1', 'Primera hormiga'),
(2, 1, 1, 'Hormiga2', 'Segunda hormiga'),
(3, 2, 1, 'Hormiga3', 'Tercera hormiga'),
(4, 1, 1, 'Hormiga4', 'Cuarta hormiga');

select * FROM Sexo;
select * FROM HormigaTipo;
select * FROM Estado;
select * FROM AlimentoTipo;
SELECT * FROM Hormiga;

DROP VIEW IF EXISTS Hormiga;

CREATE VIEW Hormiga AS
SELECT
     H.IdHormiga
    ,HT.Nombre AS TipoHormiga
    ,S.Nombre  AS SexoHormiga
    ,E.Nombre  AS EstadoHormiga
    ,H.Nombre  AS NombreHormiga
    ,H.Descripcion
    ,H.Estado
    ,H.FechaCreacion
    ,H.FechaModifica FROM Hormiga H
JOIN HormigaTipo HT ON H.IdHormigaTipo = HT.IdHormigaTipo
JOIN Sexo S        ON H.IdSexo        = S.IdSexo
JOIN Estado E      ON H.IdEstado      = E.IdEstado
WHERE H.Estado = 'A';