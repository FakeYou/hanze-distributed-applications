-- MySQL Script generated by MySQL Workbench
-- 12/03/15 10:30:05
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema JavaBank
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema JavaBank
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `JavaBank` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `JavaBank` ;

-- -----------------------------------------------------
-- Table `JavaBank`.`accounts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `JavaBank`.`accounts` ;

CREATE TABLE IF NOT EXISTS `JavaBank`.`accounts` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `balance_amount` FLOAT NOT NULL COMMENT '',
  `account_number` VARCHAR(45) NULL COMMENT '',
  `name` VARCHAR(45) NULL COMMENT '',
  `address` VARCHAR(45) NULL COMMENT '',
  `city` VARCHAR(45) NULL COMMENT '',
  `limit_amount` FLOAT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  UNIQUE INDEX `account_number_UNIQUE` (`account_number` ASC)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `JavaBank`.`transactions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `JavaBank`.`transactions` ;

CREATE TABLE IF NOT EXISTS `JavaBank`.`transactions` (
  `id` BIGINT NOT NULL COMMENT '',
  `sender_account_number` VARCHAR(45) NULL COMMENT '',
  `receiver_account_number` VARCHAR(45) NULL COMMENT '',
  `date` DATE NULL COMMENT '',
  `amount` FLOAT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `accounts` (`balance_amount`,`account_number`,`name`,`address`,`city`,`limit_amount`) VALUES (967,"CY60979006261151065725792620","Quinlan Bailey","964-2275 Arcu St.","Bludenz",-1000),(675,"IS441552425328519418046062","Lamar Griffith","523-9952 Eu St.","Dilbeek",-1000),(333,"TR204462629183112678416120","Colorado Hoffman","443 Commodo Street","Monghidoro",-1000),(849,"PK2911552680717413414670","Armand Mendez","Ap #666-525 Mauris Road","Whitehorse",-1000),(899,"TN2854634633871565807838","Erasmus Stanton","Ap #319-4219 Proin St.","Wakefield",-1000),(742,"BA738954050563062856","Kenyon Sheppard","612-2873 A St.","Pemberton",-1000),(85,"MK28461563713343737","Steel Estes","P.O. Box 875, 1467 Sed St.","Sivry",-1000),(463,"IL243099131696595130581","Cameron Camacho","1550 Lacus. Road","Halifax",-1000),(815,"CZ7461913047485683490923","Nathaniel Hall","1232 Ac St.","Freising",-1000),(547,"IS379855227378154218115298","Garth Benson","4553 Arcu. Ave","Stirling",-1000);