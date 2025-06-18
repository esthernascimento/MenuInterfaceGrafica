-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 11-Jun-2025 às 22:40
-- Versão do servidor: 10.4.32-MariaDB
-- versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `menuinterfacegrafica`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbcategoria`
--

CREATE TABLE `tbcategoria` (
  `idCategoria` int(11) NOT NULL,
  `nomeCategoria` varchar(50) DEFAULT NULL,
  `descricaoCategoria` varchar(120) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `tbcategoria`
--

INSERT INTO `tbcategoria` (`idCategoria`, `nomeCategoria`, `descricaoCategoria`) VALUES
(1, 'Fone de ouvido', 'Com fio'),
(2, 'Mouse', 'Periféricos'),
(3, 'Pendrive', 'Acessórios'),
(4, 'Notebook', 'Computador'),
(5, 'Música', 'Rock'),
(6, 'Celular', 'Iphone');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbcliente`
--

CREATE TABLE `tbcliente` (
  `idCliente` int(11) NOT NULL,
  `nomeCliente` varchar(50) DEFAULT NULL,
  `generoCliente` varchar(15) DEFAULT NULL,
  `estadoCivilCliente` varchar(20) DEFAULT NULL,
  `dataNascCliente` date DEFAULT NULL,
  `telefoneCliente` varchar(20) DEFAULT NULL,
  `emailCliente` varchar(50) DEFAULT NULL,
  `rgCliente` varchar(20) DEFAULT NULL,
  `cpfCliente` varchar(20) DEFAULT NULL,
  `ruaCliente` varchar(100) DEFAULT NULL,
  `numeroCliente` varchar(10) DEFAULT NULL,
  `complementoCliente` varchar(50) DEFAULT NULL,
  `bairroCliente` varchar(50) DEFAULT NULL,
  `cidadeCliente` varchar(50) DEFAULT NULL,
  `estadoCliente` varchar(30) DEFAULT NULL,
  `paisCliente` varchar(30) DEFAULT NULL,
  `cepCliente` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `tbcliente`
--

INSERT INTO `tbcliente` (`idCliente`, `nomeCliente`, `generoCliente`, `estadoCivilCliente`, `dataNascCliente`, `telefoneCliente`, `emailCliente`, `rgCliente`, `cpfCliente`, `ruaCliente`, `numeroCliente`, `complementoCliente`, `bairroCliente`, `cidadeCliente`, `estadoCliente`, `paisCliente`, `cepCliente`) VALUES
(1, 'GIsele', 'Feminino', 'Casado', '1995-08-09', '11986469433', 'gi@gmail.com', '54354365345', '5435453', 'Etec', '85', 'A', 'Guaianases', 'São Paulo', 'SP', 'Brasil', '08460367'),
(2, 'Allan', 'Masculino', 'Casado', '1995-02-10', '11987667898', 'allan@gmail.com', '90897656754', '22345676545', 'Rua Java Forever', '66', 'J', 'Guaianases', 'Sâo Paulo', 'SP', 'Brasil', '086788765'),
(3, 'Esther', 'Feminino', 'Solteiro', '2007-12-06', '11967885868', 'esther@gmail.com', '654356445', '3432543', 'Rua Alegria', '66', 'A', 'Guaianases', 'São Paulo', 'esther@gmail.com', 'Brasil', '08567654'),
(4, 'Bárbara', 'Feminino', 'Solteiro', '2007-10-20', '11959199249', 'babi@gmail.com', '325245235', '5436524626', 'Rua Comandante Carlos Ruhl ', '128', 'B', 'Guaianases', 'São Paulo', 'SP', 'Brasil', '08410130'),
(5, 'Eduardo', 'Masculino', 'Casado', '2025-06-10', '543654364', 'edu@gmail.com', '543643', '66566436', 'Rua Grazi', '12', 'A', 'Guaianases', 'São Paulo', 'SP', 'Brasil', '76545y54');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbitenspedido`
--

CREATE TABLE `tbitenspedido` (
  `idItemPedido` int(11) NOT NULL,
  `idPedido` int(11) DEFAULT NULL,
  `idProduto` int(11) DEFAULT NULL,
  `quantidadeItem` int(11) DEFAULT NULL,
  `valorItem` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbpedido`
--

CREATE TABLE `tbpedido` (
  `idPedido` int(11) NOT NULL,
  `idCliente` int(11) DEFAULT NULL,
  `dataPedido` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `tbpedido`
--

INSERT INTO `tbpedido` (`idPedido`, `idCliente`, `dataPedido`) VALUES
(1, 1, '2025-06-11'),
(2, 2, '2025-02-10'),
(3, 3, '2025-06-14');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbproduto`
--

CREATE TABLE `tbproduto` (
  `idProduto` int(11) NOT NULL,
  `nomeProduto` varchar(100) DEFAULT NULL,
  `valorProduto` decimal(10,2) DEFAULT NULL,
  `quantidadeProduto` int(11) DEFAULT NULL,
  `idCategoria` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tbcategoria`
--
ALTER TABLE `tbcategoria`
  ADD PRIMARY KEY (`idCategoria`);

--
-- Índices para tabela `tbcliente`
--
ALTER TABLE `tbcliente`
  ADD PRIMARY KEY (`idCliente`);

--
-- Índices para tabela `tbitenspedido`
--
ALTER TABLE `tbitenspedido`
  ADD PRIMARY KEY (`idItemPedido`),
  ADD KEY `idPedido` (`idPedido`),
  ADD KEY `idProduto` (`idProduto`);

--
-- Índices para tabela `tbpedido`
--
ALTER TABLE `tbpedido`
  ADD PRIMARY KEY (`idPedido`),
  ADD KEY `idCliente` (`idCliente`);

--
-- Índices para tabela `tbproduto`
--
ALTER TABLE `tbproduto`
  ADD PRIMARY KEY (`idProduto`),
  ADD KEY `idCategoria` (`idCategoria`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tbcategoria`
--
ALTER TABLE `tbcategoria`
  MODIFY `idCategoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `tbcliente`
--
ALTER TABLE `tbcliente`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `tbitenspedido`
--
ALTER TABLE `tbitenspedido`
  MODIFY `idItemPedido` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tbpedido`
--
ALTER TABLE `tbpedido`
  MODIFY `idPedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `tbproduto`
--
ALTER TABLE `tbproduto`
  MODIFY `idProduto` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `tbitenspedido`
--
ALTER TABLE `tbitenspedido`
  ADD CONSTRAINT `tbitenspedido_ibfk_1` FOREIGN KEY (`idPedido`) REFERENCES `tbpedido` (`idPedido`),
  ADD CONSTRAINT `tbitenspedido_ibfk_2` FOREIGN KEY (`idProduto`) REFERENCES `tbproduto` (`idProduto`);

--
-- Limitadores para a tabela `tbpedido`
--
ALTER TABLE `tbpedido`
  ADD CONSTRAINT `tbpedido_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `tbcliente` (`idCliente`);

--
-- Limitadores para a tabela `tbproduto`
--
ALTER TABLE `tbproduto`
  ADD CONSTRAINT `tbproduto_ibfk_1` FOREIGN KEY (`idCategoria`) REFERENCES `tbcategoria` (`idCategoria`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
