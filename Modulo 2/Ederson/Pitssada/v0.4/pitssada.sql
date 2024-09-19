-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 14/09/2024 às 02:39
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `pitssada`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `bebida`
--

CREATE TABLE `bebida` (
  `id_bebida` int(11) NOT NULL,
  `bebida` varchar(255) DEFAULT NULL,
  `qntBebida` int(11) NOT NULL,
  `precoBebida` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Despejando dados para a tabela `bebida`
--

INSERT INTO `bebida` (`id_bebida`, `bebida`, `qntBebida`, `precoBebida`) VALUES
(1, NULL, 0, 0);

-- --------------------------------------------------------

--
-- Estrutura para tabela `pedido`
--

CREATE TABLE `pedido` (
  `id_pedido` int(11) NOT NULL,
  `id_sabor` int(11) DEFAULT NULL,
  `id_tamanho` int(11) DEFAULT NULL,
  `id_bebida` int(11) DEFAULT NULL,
  `nomeCliente` varchar(255) DEFAULT NULL,
  `rua` varchar(255) DEFAULT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `numero` double DEFAULT NULL,
  `hora` varchar(255) DEFAULT NULL,
  `precoFinal` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `sabor`
--

CREATE TABLE `sabor` (
  `id_sabor` int(11) NOT NULL,
  `sabor` varchar(255) DEFAULT NULL,
  `precoSabor` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Despejando dados para a tabela `sabor`
--

INSERT INTO `sabor` (`id_sabor`, `sabor`, `precoSabor`) VALUES
(1, 'couro', 123412412);

-- --------------------------------------------------------

--
-- Estrutura para tabela `tamanho`
--

CREATE TABLE `tamanho` (
  `id_tamanho` int(11) NOT NULL,
  `tamanho` varchar(255) DEFAULT NULL,
  `precoTamanho` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Despejando dados para a tabela `tamanho`
--

INSERT INTO `tamanho` (`id_tamanho`, `tamanho`, `precoTamanho`) VALUES
(1, 'sim', 15),
(2, 'segh', 235),
(3, 'sim', 16.78);

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `bebida`
--
ALTER TABLE `bebida`
  ADD PRIMARY KEY (`id_bebida`);

--
-- Índices de tabela `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id_pedido`),
  ADD KEY `id_sabor` (`id_sabor`),
  ADD KEY `id_tamanho` (`id_tamanho`),
  ADD KEY `id_bebida` (`id_bebida`);

--
-- Índices de tabela `sabor`
--
ALTER TABLE `sabor`
  ADD PRIMARY KEY (`id_sabor`);

--
-- Índices de tabela `tamanho`
--
ALTER TABLE `tamanho`
  ADD PRIMARY KEY (`id_tamanho`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `bebida`
--
ALTER TABLE `bebida`
  MODIFY `id_bebida` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id_pedido` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `sabor`
--
ALTER TABLE `sabor`
  MODIFY `id_sabor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `tamanho`
--
ALTER TABLE `tamanho`
  MODIFY `id_tamanho` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`id_sabor`) REFERENCES `sabor` (`id_sabor`),
  ADD CONSTRAINT `pedido_ibfk_2` FOREIGN KEY (`id_tamanho`) REFERENCES `tamanho` (`id_tamanho`),
  ADD CONSTRAINT `pedido_ibfk_3` FOREIGN KEY (`id_bebida`) REFERENCES `bebida` (`id_bebida`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
