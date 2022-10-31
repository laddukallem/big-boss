-- MySQL Script generated by MySQL Workbench
-- 03/02/16 17:09:18
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema examination
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema examination
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `examination` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `examination` ;

-- -----------------------------------------------------
-- Table `examination`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `examination`.`users` (
  `idusers` VARCHAR(120) NOT NULL COMMENT '',
  `name` VARCHAR(225) NOT NULL COMMENT '',
  `password` VARCHAR(225) NOT NULL COMMENT '',
  `designation` VARCHAR(100) NOT NULL COMMENT '',
  `year` VARCHAR(50) NOT NULL COMMENT '',
  `section` VARCHAR(45) NOT NULL COMMENT '',
  `active` VARCHAR(45) NOT NULL DEFAULT 'inactive' COMMENT '',
  PRIMARY KEY (`idusers`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `examination`.`subject`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `examination`.`subject` (
  `idsubject` VARCHAR(50) NOT NULL COMMENT '',
  `subject_name` VARCHAR(45) NOT NULL COMMENT '',
  `year` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`idsubject`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `examination`.`absent`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `examination`.`absent` (
  `idabsent` INT NOT NULL COMMENT '',
  `exam` VARCHAR(50) NOT NULL COMMENT '',
  `users_idusers` VARCHAR(120) NOT NULL COMMENT '',
  `subject_idsubject` VARCHAR(50) NOT NULL COMMENT '',
  PRIMARY KEY (`idabsent`)  COMMENT '',
  INDEX `fk_absent_users_idx` (`users_idusers` ASC)  COMMENT '',
  INDEX `fk_absent_subject1_idx` (`subject_idsubject` ASC)  COMMENT '',
  CONSTRAINT `fk_absent_users`
    FOREIGN KEY (`users_idusers`)
    REFERENCES `examination`.`users` (`idusers`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_absent_subject1`
    FOREIGN KEY (`subject_idsubject`)
    REFERENCES `examination`.`subject` (`idsubject`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `examination`.`schedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `examination`.`schedule` (
  `idschedule` INT NOT NULL COMMENT '',
  `time` VARCHAR(50) NOT NULL COMMENT '',
  `day` VARCHAR(45) NOT NULL COMMENT '',
  `subject_idsubject` VARCHAR(50) NOT NULL COMMENT '',
  `section` VARCHAR(45) NOT NULL COMMENT '',
  `users_idusers` VARCHAR(120) NOT NULL COMMENT '',
  PRIMARY KEY (`idschedule`)  COMMENT '',
  INDEX `fk_schedule_subject1_idx` (`subject_idsubject` ASC)  COMMENT '',
  INDEX `fk_schedule_users1_idx` (`users_idusers` ASC)  COMMENT '',
  CONSTRAINT `fk_schedule_subject1`
    FOREIGN KEY (`subject_idsubject`)
    REFERENCES `examination`.`subject` (`idsubject`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_schedule_users1`
    FOREIGN KEY (`users_idusers`)
    REFERENCES `examination`.`users` (`idusers`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `examination`.`expaper`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `examination`.`expaper` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `exam_type` VARCHAR(60) NOT NULL COMMENT '',
  `path` VARCHAR(45) NOT NULL COMMENT '',
  `setcode` VARCHAR(45) NOT NULL COMMENT '',
  `subject_idsubject` VARCHAR(50) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `fk_expaper_subject1_idx` (`subject_idsubject` ASC)  COMMENT '',
  CONSTRAINT `fk_expaper_subject1`
    FOREIGN KEY (`subject_idsubject`)
    REFERENCES `examination`.`subject` (`idsubject`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `examination`.`rooms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `examination`.`rooms` (
  `room_no` VARCHAR(50) NOT NULL COMMENT '',
  `capacity` INT NOT NULL COMMENT '',
  PRIMARY KEY (`room_no`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `examination`.`sitting`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `examination`.`sitting` (
  `users_idusers` VARCHAR(120) NOT NULL COMMENT '',
  `rooms_room_no` VARCHAR(50) NOT NULL COMMENT '',
  `starting_date` DATE NOT NULL COMMENT '',
  `ending_date` DATE NOT NULL COMMENT '',
  INDEX `fk_sitting_users1_idx` (`users_idusers` ASC)  COMMENT '',
  INDEX `fk_sitting_rooms1_idx` (`rooms_room_no` ASC)  COMMENT '',
  CONSTRAINT `fk_sitting_users1`
    FOREIGN KEY (`users_idusers`)
    REFERENCES `examination`.`users` (`idusers`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sitting_rooms1`
    FOREIGN KEY (`rooms_room_no`)
    REFERENCES `examination`.`rooms` (`room_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;