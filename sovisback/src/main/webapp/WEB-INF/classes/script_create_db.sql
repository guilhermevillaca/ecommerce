/**
 * Author:  Guilherme Villaca <guilherme.villaca>
 * Created: 12/09/2018
 */
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema sovis
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sovis
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sovis` DEFAULT CHARACTER SET utf8 ;
USE `sovis` ;

-- -----------------------------------------------------
-- Table `sovis`.`Categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sovis`.`Categoria` (
  `Ctg_Codigo` INT NOT NULL AUTO_INCREMENT,
  `Ctg_Descricao` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`Ctg_Codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sovis`.`Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sovis`.`Produto` (
  `Prd_Codigo` INT NOT NULL AUTO_INCREMENT,
  `Prd_Descricao` VARCHAR(500) NULL,
  `Prd_Titulo` VARCHAR(200) NULL,
  `Ctg_Codigo` INT NOT NULL,
  `Prd_Valor` DOUBLE NULL,
  PRIMARY KEY (`Prd_Codigo`),
  INDEX `fk_Produto_Categoria_idx` (`Ctg_Codigo` ASC) VISIBLE,
  CONSTRAINT `fk_Produto_Categoria`
    FOREIGN KEY (`Ctg_Codigo`)
    REFERENCES `sovis`.`Categoria` (`Ctg_Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sovis`.`PssFisica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sovis`.`PssFisica` (
  `PssFsc_Codigo` INT NOT NULL AUTO_INCREMENT,
  `PssFsc_Nome` VARCHAR(45) NOT NULL,
  `PssFsc_CPF` VARCHAR(45) NULL,
  `PssFsc_Email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`PssFsc_Codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sovis`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sovis`.`Usuario` (
  `Usr_Codigo` INT NOT NULL AUTO_INCREMENT,
  `Usr_Senha` VARCHAR(64) NOT NULL,
  `Usr_Login` VARCHAR(45) NOT NULL,
  `PssFsc_Codigo` INT NOT NULL,
  PRIMARY KEY (`Usr_Codigo`),
  INDEX `fk_Usuario_PssFisica1_idx` (`PssFsc_Codigo` ASC) VISIBLE,
  CONSTRAINT `fk_Usuario_PssFisica1`
    FOREIGN KEY (`PssFsc_Codigo`)
    REFERENCES `sovis`.`PssFisica` (`PssFsc_Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sovis`.`Carrinho`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sovis`.`Carrinho` (
  `Crr_Codigo` INT NOT NULL AUTO_INCREMENT,
  `Usr_Codigo` INT NOT NULL,
  `Crr_ValorTotal` DOUBLE NULL,
  PRIMARY KEY (`Crr_Codigo`),
  INDEX `fk_Carrinho_Usuario1_idx` (`Usr_Codigo` ASC) VISIBLE,
  CONSTRAINT `fk_Carrinho_Usuario1`
    FOREIGN KEY (`Usr_Codigo`)
    REFERENCES `sovis`.`Usuario` (`Usr_Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sovis`.`CarrinhoItens`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sovis`.`CarrinhoItens` (
  `CrrItn_Codigo` INT NOT NULL AUTO_INCREMENT,
  `Crr_Codigo` INT NOT NULL,
  `Prd_Codigo` INT NOT NULL,
  `CrrItn_Quantidade` INT NULL,
  PRIMARY KEY (`CrrItn_Codigo`),
  INDEX `fk_CarrinhoItens_Carrinho1_idx` (`Crr_Codigo` ASC) VISIBLE,
  INDEX `fk_CarrinhoItens_Produto1_idx` (`Prd_Codigo` ASC) VISIBLE,
  CONSTRAINT `fk_CarrinhoItens_Carrinho1`
    FOREIGN KEY (`Crr_Codigo`)
    REFERENCES `sovis`.`Carrinho` (`Crr_Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CarrinhoItens_Produto1`
    FOREIGN KEY (`Prd_Codigo`)
    REFERENCES `sovis`.`Produto` (`Prd_Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sovis`.`MensagemEmail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sovis`.`MensagemEmail` (
  `MsgEml_Codigo` INT NOT NULL AUTO_INCREMENT,
  `MsgEml_Remetente` VARCHAR(60) NOT NULL,
  `MsgEml_Destinatario` VARCHAR(60) NOT NULL,
  `MsgEml_Assunto` VARCHAR(100) NOT NULL,
  `MsgEml_Corpo` VARCHAR(200) NOT NULL,
  `MsgEml_DtEnvio` DATETIME NOT NULL,
  PRIMARY KEY (`MsgEml_Codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sovis`.`FormaPagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sovis`.`FormaPagamento` (
  `FrmPgt_Codigo` INT NOT NULL AUTO_INCREMENT,
  `FrmPgt_Descricao` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`FrmPgt_Codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sovis`.`Venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sovis`.`Venda` (
  `Vnd_Codigo` INT NOT NULL AUTO_INCREMENT,
  `Vnd_ValorTotal` DOUBLE NULL,
  `Usr_Codigo` INT NOT NULL,
  `FrmPgt_Codigo` INT NOT NULL,
  `Vnd_PgtoConfirmado` VARCHAR(1) NULL,
  PRIMARY KEY (`Vnd_Codigo`),
  INDEX `fk_Venda_Usuario1_idx` (`Usr_Codigo` ASC) VISIBLE,
  INDEX `fk_Venda_FormaPagamento1_idx` (`FrmPgt_Codigo` ASC) VISIBLE,
  CONSTRAINT `fk_Venda_Usuario1`
    FOREIGN KEY (`Usr_Codigo`)
    REFERENCES `sovis`.`Usuario` (`Usr_Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venda_FormaPagamento1`
    FOREIGN KEY (`FrmPgt_Codigo`)
    REFERENCES `sovis`.`FormaPagamento` (`FrmPgt_Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sovis`.`ItensVenda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sovis`.`ItensVenda` (
  `ItnVnd_Codigo` INT NOT NULL AUTO_INCREMENT,
  `Vnd_Codigo` INT NOT NULL,
  `Prd_Codigo` INT NOT NULL,
  `ItnVnd_Quantidade` INT NULL,
  `ItnVnd_Total` DOUBLE NULL,
  PRIMARY KEY (`ItnVnd_Codigo`),
  INDEX `fk_ItensVenda_Venda1_idx` (`Vnd_Codigo` ASC) VISIBLE,
  INDEX `fk_ItensVenda_Produto1_idx` (`Prd_Codigo` ASC) VISIBLE,
  CONSTRAINT `fk_ItensVenda_Venda1`
    FOREIGN KEY (`Vnd_Codigo`)
    REFERENCES `sovis`.`Venda` (`Vnd_Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ItensVenda_Produto1`
    FOREIGN KEY (`Prd_Codigo`)
    REFERENCES `sovis`.`Produto` (`Prd_Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


