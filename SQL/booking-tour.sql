-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema booking_tour
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema booking_tour
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `booking_tour` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `booking_tour` ;

-- -----------------------------------------------------
-- Table `booking_tour`.`tbl_account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking_tour`.`tbl_account` (
  `account_id` INT NOT NULL,
  `username` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `image` VARCHAR(200) NULL DEFAULT NULL,
  `state` INT NULL DEFAULT NULL,
  `role` INT NULL DEFAULT NULL,
  PRIMARY KEY (`account_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `booking_tour`.`tbl_customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking_tour`.`tbl_customer` (
  `customer_id` INT NOT NULL AUTO_INCREMENT,
  `account_id` INT NULL DEFAULT NULL,
  `customer_name` VARCHAR(45) NULL DEFAULT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  `phone_number` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `gender` VARCHAR(45) NULL DEFAULT NULL,
  `birthday` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  INDEX `fk_account_idx` (`account_id` ASC) VISIBLE,
  CONSTRAINT `fk_account`
    FOREIGN KEY (`account_id`)
    REFERENCES `booking_tour`.`tbl_account` (`account_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `booking_tour`.`tbl_booking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking_tour`.`tbl_booking` (
  `booking_id` INT NOT NULL AUTO_INCREMENT,
  `customers_id` INT NULL DEFAULT NULL,
  `booking_name` VARCHAR(45) NULL DEFAULT NULL,
  `booking_date` DATETIME NULL DEFAULT NULL,
  `state` TINYINT NULL DEFAULT NULL,
  `payment` VARCHAR(45) NULL DEFAULT NULL,
  `number_of_people` INT NULL DEFAULT NULL,
  PRIMARY KEY (`booking_id`),
  INDEX `fk_customer_idx` (`customers_id` ASC) VISIBLE,
  CONSTRAINT `fk_customer`
    FOREIGN KEY (`customers_id`)
    REFERENCES `booking_tour`.`tbl_customer` (`customer_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `booking_tour`.`tbl_comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking_tour`.`tbl_comment` (
  `comment_id` INT NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(45) NULL DEFAULT NULL,
  `state` INT NULL DEFAULT NULL,
  `comment_date` DATETIME NULL DEFAULT NULL,
  `account_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  INDEX `fk_account_2_idx` (`account_id` ASC) VISIBLE,
  CONSTRAINT `fk_account_2`
    FOREIGN KEY (`account_id`)
    REFERENCES `booking_tour`.`tbl_account` (`account_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `booking_tour`.`tbl_hotels`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking_tour`.`tbl_hotels` (
  `hotels_id` INT NOT NULL AUTO_INCREMENT,
  `hotels_name` VARCHAR(45) NULL DEFAULT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  `hotline` VARCHAR(45) NULL DEFAULT NULL,
  `standard` INT NULL DEFAULT NULL,
  `website` VARCHAR(45) NULL DEFAULT NULL,
  `note` VARCHAR(45) NULL DEFAULT NULL,
  `comment_id` INT NULL DEFAULT NULL,
  `available_room` INT NULL DEFAULT NULL,
  PRIMARY KEY (`hotels_id`),
  INDEX `fk_comment_idx` (`comment_id` ASC) VISIBLE,
  CONSTRAINT `fk_comment`
    FOREIGN KEY (`comment_id`)
    REFERENCES `booking_tour`.`tbl_comment` (`comment_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `booking_tour`.`tbl_scenic_spots`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking_tour`.`tbl_scenic_spots` (
  `scenic_spots_id` INT NOT NULL AUTO_INCREMENT,
  `scenic_spots_name` VARCHAR(45) NULL DEFAULT NULL,
  `contents` VARCHAR(45) NULL DEFAULT NULL,
  `image` VARCHAR(45) NULL DEFAULT NULL,
  `state` INT NULL DEFAULT NULL,
  `visitor_io_number` VARCHAR(45) NULL DEFAULT NULL,
  `ticket_price` DOUBLE NULL DEFAULT NULL,
  `note` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`scenic_spots_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `booking_tour`.`tbl_places`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking_tour`.`tbl_places` (
  `places_id` INT NOT NULL AUTO_INCREMENT,
  `places_name` VARCHAR(45) NULL DEFAULT NULL,
  `contents` VARCHAR(45) NULL DEFAULT NULL,
  `images` VARCHAR(45) NULL DEFAULT NULL,
  `scenic_spots_id` INT NULL DEFAULT NULL,
  `note` VARCHAR(45) NULL DEFAULT NULL,
  `hotels_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`places_id`),
  INDEX `fk_hotel_idx` (`hotels_id` ASC) VISIBLE,
  INDEX `fk_scen_spots_idx` (`scenic_spots_id` ASC) VISIBLE,
  CONSTRAINT `fk_hotel`
    FOREIGN KEY (`hotels_id`)
    REFERENCES `booking_tour`.`tbl_hotels` (`hotels_id`),
  CONSTRAINT `fk_scen_spots`
    FOREIGN KEY (`scenic_spots_id`)
    REFERENCES `booking_tour`.`tbl_scenic_spots` (`scenic_spots_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `booking_tour`.`tbl_tour_guide`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking_tour`.`tbl_tour_guide` (
  `tour_guide_id` INT NOT NULL AUTO_INCREMENT,
  `tour_guide_name` VARCHAR(45) NULL DEFAULT NULL,
  `birthday` DATETIME NULL DEFAULT NULL,
  `phone_number` VARCHAR(45) NULL DEFAULT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `gender` INT NULL DEFAULT NULL,
  `image` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`tour_guide_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `booking_tour`.`tbl_tours`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking_tour`.`tbl_tours` (
  `tours_id` INT NOT NULL,
  `tours_name` VARCHAR(45) NULL DEFAULT NULL,
  `contents` VARCHAR(45) NULL DEFAULT NULL,
  `date_go` DATETIME NULL DEFAULT NULL,
  `date_back` DATETIME NULL DEFAULT NULL,
  `places_id` INT NULL DEFAULT NULL,
  `state` TINYINT NULL DEFAULT NULL,
  `timeline` VARCHAR(45) NULL DEFAULT NULL,
  `note` VARCHAR(45) NULL DEFAULT NULL,
  `comment_id` INT NULL DEFAULT NULL,
  `price_tour` DOUBLE NULL DEFAULT NULL,
  `image` VARCHAR(45) NULL DEFAULT NULL,
  `tour_guide_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`tours_id`),
  INDEX `fk_places_idx` (`places_id` ASC) VISIBLE,
  INDEX `fk_tour_guide_idx` (`tour_guide_id` ASC) VISIBLE,
  INDEX `fk_comment_2_idx` (`comment_id` ASC) VISIBLE,
  CONSTRAINT `fk_comment_2`
    FOREIGN KEY (`comment_id`)
    REFERENCES `booking_tour`.`tbl_comment` (`comment_id`),
  CONSTRAINT `fk_places`
    FOREIGN KEY (`places_id`)
    REFERENCES `booking_tour`.`tbl_places` (`places_id`),
  CONSTRAINT `fk_tour_guide`
    FOREIGN KEY (`tour_guide_id`)
    REFERENCES `booking_tour`.`tbl_tour_guide` (`tour_guide_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `booking_tour`.`tbl_customer_tour`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking_tour`.`tbl_customer_tour` (
  `customers_tours_id` INT NOT NULL AUTO_INCREMENT,
  `tours_id` INT NULL DEFAULT NULL,
  `customers_id` INT NULL DEFAULT NULL,
  `state` INT NULL DEFAULT NULL,
  PRIMARY KEY (`customers_tours_id`),
  INDEX `fk_tours_3_idx` (`tours_id` ASC) VISIBLE,
  INDEX `fk_customer_idx` (`customers_id` ASC) VISIBLE,
  CONSTRAINT `fk_customer_2`
    FOREIGN KEY (`customers_id`)
    REFERENCES `booking_tour`.`tbl_customer` (`customer_id`),
  CONSTRAINT `fk_tours_5`
    FOREIGN KEY (`tours_id`)
    REFERENCES `booking_tour`.`tbl_tours` (`tours_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `booking_tour`.`tbl_news`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking_tour`.`tbl_news` (
  `news_id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL DEFAULT NULL,
  `content` VARCHAR(45) NULL DEFAULT NULL,
  `post_date` DATETIME NULL DEFAULT NULL,
  `state` INT NULL DEFAULT NULL,
  `note` VARCHAR(45) NULL DEFAULT NULL,
  `places_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`news_id`),
  INDEX `fk_places_idx` (`places_id` ASC) VISIBLE,
  CONSTRAINT `fk_places_3`
    FOREIGN KEY (`places_id`)
    REFERENCES `booking_tour`.`tbl_places` (`places_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `booking_tour`.`tbl_tours_booking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking_tour`.`tbl_tours_booking` (
  `tours_booking_id` INT NOT NULL AUTO_INCREMENT,
  `tours_id` INT NULL DEFAULT NULL,
  `booking_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`tours_booking_id`),
  INDEX `fk_tours_idx` (`tours_id` ASC) VISIBLE,
  INDEX `fk_booking_idx` (`booking_id` ASC) VISIBLE,
  CONSTRAINT `fk_booking`
    FOREIGN KEY (`booking_id`)
    REFERENCES `booking_tour`.`tbl_booking` (`booking_id`),
  CONSTRAINT `fk_tours`
    FOREIGN KEY (`tours_id`)
    REFERENCES `booking_tour`.`tbl_tours` (`tours_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `booking_tour`.`tbl_tours_places`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking_tour`.`tbl_tours_places` (
  `tours_places_id` INT NOT NULL AUTO_INCREMENT,
  `tours_id` INT NULL DEFAULT NULL,
  `places_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`tours_places_id`),
  INDEX `fk_tours_2_idx` (`tours_id` ASC) VISIBLE,
  INDEX `fk_places_2_idx` (`places_id` ASC) VISIBLE,
  CONSTRAINT `fk_places_2`
    FOREIGN KEY (`places_id`)
    REFERENCES `booking_tour`.`tbl_places` (`places_id`),
  CONSTRAINT `fk_tours_2`
    FOREIGN KEY (`tours_id`)
    REFERENCES `booking_tour`.`tbl_tours` (`tours_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `booking_tour`.`tbl_tours_scenic_spots`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking_tour`.`tbl_tours_scenic_spots` (
  `tours_scenic_spots_id` INT NOT NULL AUTO_INCREMENT,
  `tours_id` INT NULL DEFAULT NULL,
  `scenic_spots_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`tours_scenic_spots_id`),
  INDEX `fk_tours_3_idx` (`tours_id` ASC) VISIBLE,
  INDEX `fk_scen_spots_idx` (`scenic_spots_id` ASC) VISIBLE,
  CONSTRAINT `fk_scen_spots_2`
    FOREIGN KEY (`scenic_spots_id`)
    REFERENCES `booking_tour`.`tbl_scenic_spots` (`scenic_spots_id`),
  CONSTRAINT `fk_tours_3`
    FOREIGN KEY (`tours_id`)
    REFERENCES `booking_tour`.`tbl_tours` (`tours_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
