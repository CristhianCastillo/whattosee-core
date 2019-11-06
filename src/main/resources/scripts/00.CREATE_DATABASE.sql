-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema whattosee_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema whattosee_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `whattosee_db` DEFAULT CHARACTER SET latin1 ;
USE `whattosee_db` ;

-- -----------------------------------------------------
-- Table `whattosee_db`.`classification`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `whattosee_db`.`classification` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `status` BIT(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `whattosee_db`.`rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `whattosee_db`.`rol` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `status` BIT(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `whattosee_db`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `whattosee_db`.`user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `user_name` VARCHAR(255) NOT NULL,
  `rol_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_ob8kqyqqgmefl0aco34akdtpe` (`email` ASC),
  UNIQUE INDEX `UK_lqjrcobrh9jc8wpcar64q1bfh` (`user_name` ASC),
  INDEX `FKpikdt34c2nqt413csrypwhe69` (`rol_id` ASC),
  CONSTRAINT `FKpikdt34c2nqt413csrypwhe69`
    FOREIGN KEY (`rol_id`)
    REFERENCES `whattosee_db`.`rol` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `whattosee_db`.`movie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `whattosee_db`.`movie` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `score` BIGINT(20) NOT NULL,
  `score_counter` BIGINT(20) NOT NULL,
  `classification_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKn9wxsh6s14m5e3rvm0cojeu3u` (`classification_id` ASC),
  CONSTRAINT `FKn9wxsh6s14m5e3rvm0cojeu3u`
    FOREIGN KEY (`classification_id`)
    REFERENCES `whattosee_db`.`classification` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `whattosee_db`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `whattosee_db`.`comment` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `creation` DATETIME NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `movie_id` BIGINT(20) NOT NULL,
  `user_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKj6owqni09n6r5rspfx1xtfu23` (`movie_id` ASC),
  INDEX `FK8kcum44fvpupyw6f5baccx25c` (`user_id` ASC),
  CONSTRAINT `FK8kcum44fvpupyw6f5baccx25c`
    FOREIGN KEY (`user_id`)
    REFERENCES `whattosee_db`.`user` (`id`),
  CONSTRAINT `FKj6owqni09n6r5rspfx1xtfu23`
    FOREIGN KEY (`movie_id`)
    REFERENCES `whattosee_db`.`movie` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `whattosee_db`.`discussion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `whattosee_db`.`discussion` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `creation` DATETIME NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `movie_id` BIGINT(20) NOT NULL,
  `user_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKp4qcy6wyfuka82809yywpc80k` (`movie_id` ASC),
  INDEX `FK2t0n9y82hsec0vpyll58gu4ph` (`user_id` ASC),
  CONSTRAINT `FK2t0n9y82hsec0vpyll58gu4ph`
    FOREIGN KEY (`user_id`)
    REFERENCES `whattosee_db`.`user` (`id`),
  CONSTRAINT `FKp4qcy6wyfuka82809yywpc80k`
    FOREIGN KEY (`movie_id`)
    REFERENCES `whattosee_db`.`movie` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `whattosee_db`.`comment_discussion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `whattosee_db`.`comment_discussion` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `creation` DATETIME NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `discussion_id` BIGINT(20) NOT NULL,
  `user_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKgb3wsptn7dqicripuerfsj6st` (`discussion_id` ASC),
  INDEX `FK7rrqi2rj1rxlxqtp1kspgpkhc` (`user_id` ASC),
  CONSTRAINT `FK7rrqi2rj1rxlxqtp1kspgpkhc`
    FOREIGN KEY (`user_id`)
    REFERENCES `whattosee_db`.`user` (`id`),
  CONSTRAINT `FKgb3wsptn7dqicripuerfsj6st`
    FOREIGN KEY (`discussion_id`)
    REFERENCES `whattosee_db`.`discussion` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `whattosee_db`.`gender`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `whattosee_db`.`gender` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `status` BIT(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `whattosee_db`.`person_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `whattosee_db`.`person_type` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `status` BIT(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `whattosee_db`.`person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `whattosee_db`.`person` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `birth` DATETIME NULL DEFAULT NULL,
  `country` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NOT NULL,
  `person_type_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKrv80qoye1tq4e4130myn7nsqd` (`person_type_id` ASC),
  CONSTRAINT `FKrv80qoye1tq4e4130myn7nsqd`
    FOREIGN KEY (`person_type_id`)
    REFERENCES `whattosee_db`.`person_type` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `whattosee_db`.`movie_actor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `whattosee_db`.`movie_actor` (
  `id_movie` BIGINT(20) NOT NULL,
  `id_actor` BIGINT(20) NOT NULL,
  INDEX `FKs20vv4faaqa8arqdfcjncayp2` (`id_actor` ASC),
  INDEX `FKd0gf6todt6rgvn1bqaxvhx5m6` (`id_movie` ASC),
  CONSTRAINT `FKd0gf6todt6rgvn1bqaxvhx5m6`
    FOREIGN KEY (`id_movie`)
    REFERENCES `whattosee_db`.`movie` (`id`),
  CONSTRAINT `FKs20vv4faaqa8arqdfcjncayp2`
    FOREIGN KEY (`id_actor`)
    REFERENCES `whattosee_db`.`person` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `whattosee_db`.`movie_gender`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `whattosee_db`.`movie_gender` (
  `id_movie` BIGINT(20) NOT NULL,
  `id_gender` BIGINT(20) NOT NULL,
  INDEX `FKm02omnwn51uv246e4ejmndd02` (`id_gender` ASC),
  INDEX `FKh3ajkjs5kyny4h6bdrsriecf6` (`id_movie` ASC),
  CONSTRAINT `FKh3ajkjs5kyny4h6bdrsriecf6`
    FOREIGN KEY (`id_movie`)
    REFERENCES `whattosee_db`.`movie` (`id`),
  CONSTRAINT `FKm02omnwn51uv246e4ejmndd02`
    FOREIGN KEY (`id_gender`)
    REFERENCES `whattosee_db`.`gender` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `whattosee_db`.`movie_productor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `whattosee_db`.`movie_productor` (
  `id_movie` BIGINT(20) NOT NULL,
  `id_productor` BIGINT(20) NOT NULL,
  INDEX `FKs28ip8rybpbjn1kh74ms8rfra` (`id_productor` ASC),
  INDEX `FKqyiosdq2fhp19qcxetbcm713w` (`id_movie` ASC),
  CONSTRAINT `FKqyiosdq2fhp19qcxetbcm713w`
    FOREIGN KEY (`id_movie`)
    REFERENCES `whattosee_db`.`movie` (`id`),
  CONSTRAINT `FKs28ip8rybpbjn1kh74ms8rfra`
    FOREIGN KEY (`id_productor`)
    REFERENCES `whattosee_db`.`person` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
