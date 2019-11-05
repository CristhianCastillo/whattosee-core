-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema whattoseeDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema whattoseeDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `whattoseeDB` DEFAULT CHARACTER SET latin1 ;
USE `whattoseeDB` ;

-- -----------------------------------------------------
-- Table `whattoseeDB`.`classification`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `whattoseeDB`.`classification` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `status` BIT(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `whattoseeDB`.`rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `whattoseeDB`.`rol` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `status` BIT(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `whattoseeDB`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `whattoseeDB`.`user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `user_name` VARCHAR(255) NOT NULL,
  `rol_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKpikdt34c2nqt413csrypwhe69` (`rol_id` ASC),
  CONSTRAINT `FKpikdt34c2nqt413csrypwhe69`
    FOREIGN KEY (`rol_id`)
    REFERENCES `whattoseeDB`.`rol` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `whattoseeDB`.`movie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `whattoseeDB`.`movie` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `classification_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKn9wxsh6s14m5e3rvm0cojeu3u` (`classification_id` ASC),
  CONSTRAINT `FKn9wxsh6s14m5e3rvm0cojeu3u`
    FOREIGN KEY (`classification_id`)
    REFERENCES `whattoseeDB`.`classification` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `whattoseeDB`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `whattoseeDB`.`comment` (
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
    REFERENCES `whattoseeDB`.`user` (`id`),
  CONSTRAINT `FKj6owqni09n6r5rspfx1xtfu23`
    FOREIGN KEY (`movie_id`)
    REFERENCES `whattoseeDB`.`movie` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `whattoseeDB`.`discussion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `whattoseeDB`.`discussion` (
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
    REFERENCES `whattoseeDB`.`user` (`id`),
  CONSTRAINT `FKp4qcy6wyfuka82809yywpc80k`
    FOREIGN KEY (`movie_id`)
    REFERENCES `whattoseeDB`.`movie` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `whattoseeDB`.`comment_discussion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `whattoseeDB`.`comment_discussion` (
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
    REFERENCES `whattoseeDB`.`user` (`id`),
  CONSTRAINT `FKgb3wsptn7dqicripuerfsj6st`
    FOREIGN KEY (`discussion_id`)
    REFERENCES `whattoseeDB`.`discussion` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `whattoseeDB`.`gender`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `whattoseeDB`.`gender` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `status` BIT(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `whattoseeDB`.`person_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `whattoseeDB`.`person_type` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `status` BIT(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `whattoseeDB`.`person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `whattoseeDB`.`person` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `birth` DATETIME NULL DEFAULT NULL,
  `country` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NOT NULL,
  `person_type_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKrv80qoye1tq4e4130myn7nsqd` (`person_type_id` ASC),
  CONSTRAINT `FKrv80qoye1tq4e4130myn7nsqd`
    FOREIGN KEY (`person_type_id`)
    REFERENCES `whattoseeDB`.`person_type` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `whattoseeDB`.`movie_actor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `whattoseeDB`.`movie_actor` (
  `id_movie` BIGINT(20) NOT NULL,
  `id_actor` BIGINT(20) NOT NULL,
  INDEX `FKs20vv4faaqa8arqdfcjncayp2` (`id_actor` ASC),
  INDEX `FKd0gf6todt6rgvn1bqaxvhx5m6` (`id_movie` ASC),
  CONSTRAINT `FKd0gf6todt6rgvn1bqaxvhx5m6`
    FOREIGN KEY (`id_movie`)
    REFERENCES `whattoseeDB`.`movie` (`id`),
  CONSTRAINT `FKs20vv4faaqa8arqdfcjncayp2`
    FOREIGN KEY (`id_actor`)
    REFERENCES `whattoseeDB`.`person` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `whattoseeDB`.`movie_gender`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `whattoseeDB`.`movie_gender` (
  `id_movie` BIGINT(20) NOT NULL,
  `id_gender` BIGINT(20) NOT NULL,
  INDEX `FKm02omnwn51uv246e4ejmndd02` (`id_gender` ASC),
  INDEX `FKh3ajkjs5kyny4h6bdrsriecf6` (`id_movie` ASC),
  CONSTRAINT `FKh3ajkjs5kyny4h6bdrsriecf6`
    FOREIGN KEY (`id_movie`)
    REFERENCES `whattoseeDB`.`movie` (`id`),
  CONSTRAINT `FKm02omnwn51uv246e4ejmndd02`
    FOREIGN KEY (`id_gender`)
    REFERENCES `whattoseeDB`.`gender` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `whattoseeDB`.`movie_productor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `whattoseeDB`.`movie_productor` (
  `id_movie` BIGINT(20) NOT NULL,
  `id_productor` BIGINT(20) NOT NULL,
  INDEX `FKs28ip8rybpbjn1kh74ms8rfra` (`id_productor` ASC),
  INDEX `FKqyiosdq2fhp19qcxetbcm713w` (`id_movie` ASC),
  CONSTRAINT `FKqyiosdq2fhp19qcxetbcm713w`
    FOREIGN KEY (`id_movie`)
    REFERENCES `whattoseeDB`.`movie` (`id`),
  CONSTRAINT `FKs28ip8rybpbjn1kh74ms8rfra`
    FOREIGN KEY (`id_productor`)
    REFERENCES `whattoseeDB`.`person` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
