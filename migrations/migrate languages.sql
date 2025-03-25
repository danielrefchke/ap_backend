CREATE TABLE IF NOT EXISTS `ap-portfolio`.`lenguaje` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `abrev` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `ap-portfolio`.`traduccion_contenido` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `elemento` INT(11) NOT NULL,
  `lenguaje` INT NOT NULL,
  `nombre` VARCHAR(150) NULL,
  `titulo` VARCHAR(150) NULL,
  `descripcion` TEXT NULL,
  INDEX `elemento_id` (`elemento` ASC) ,
  INDEX `lenguaje1_id` (`lenguaje` ASC) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_elemento`
    FOREIGN KEY (`elemento`)
    REFERENCES `ap-portfolio`.`elemento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_lenguaje`
    FOREIGN KEY (`lenguaje`)
    REFERENCES `ap-portfolio`.`lenguaje` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `ap-portfolio`.`traduccion_seccion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `seccion` INT(11) NOT NULL,
  `lenguaje` INT NOT NULL,
  `nombre` VARCHAR(150) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_traduccion_seccion_seccion1_idx` (`seccion` ASC) ,
  INDEX `fk_traduccion_seccion_lenguaje1_idx` (`lenguaje` ASC) ,
  CONSTRAINT `fk_traduccion_seccion_seccion1`
    FOREIGN KEY (`seccion`)
    REFERENCES `ap-portfolio`.`seccion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_traduccion_seccion_lenguaje1`
    FOREIGN KEY (`lenguaje`)
    REFERENCES `ap-portfolio`.`lenguaje` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `ap-portfolio`.`descripcion_persona` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `lenguaje` INT NOT NULL,
  `persona` INT(11) NOT NULL,
  `titulo` TEXT NULL,
  `descripcion` TEXT NULL,
  INDEX `fk_table1_lenguaje1_idx` (`lenguaje` ASC) ,
  INDEX `fk_table1_persona1_idx` (`persona` ASC) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_table1_lenguaje1`
    FOREIGN KEY (`lenguaje`)
    REFERENCES `ap-portfolio`.`lenguaje` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_table1_persona1`
    FOREIGN KEY (`persona`)
    REFERENCES `ap-portfolio`.`persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `ap-portfolio`.`lenguaje` (`nombre`,`abrev`) VALUES ("Español","ESP");

INSERT INTO `ap-portfolio`.`traduccion_contenido` ( `elemento`, `lenguaje`, `nombre`, `titulo`, `descripcion`) 
  select id as elemento,1 as lenguaje, nombre, titulo , descripcion from elemento;

INSERT INTO `ap-portfolio`.`descripcion_persona` ( `lenguaje`, `persona`, `titulo`, `descripcion`) 
   SELECT 1 AS LENGUAJE, ID AS PERSONA,titulo,DESCRIPCION FROM persona;
   
INSERT INTO `ap-portfolio`.`traduccion_seccion` ( `seccion`, `lenguaje`, `nombre`) 
SELECT ID AS SECCION,1 AS LENGUAJE, NOMBRE FROM seccion;

ALTER TABLE `ap-portfolio`.`elemento` 
DROP COLUMN `descripcion`,
DROP COLUMN `titulo`,
DROP COLUMN `nombre`;

ALTER TABLE `ap-portfolio`.`persona` 
DROP COLUMN `descripcion`,
DROP COLUMN `titulo`;